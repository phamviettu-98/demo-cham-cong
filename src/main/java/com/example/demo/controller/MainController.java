package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.constant.Constant;
import com.example.demo.constant.HttpResponseCode;
import com.example.demo.dto.CheckInReQuest;
import com.example.demo.dto.HttpApiResponse;
import com.example.demo.service.QRCodeGenerator;
import com.google.zxing.WriterException;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import static org.springframework.http.ResponseEntity.ok;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/api/v1.0")
public class MainController {

	private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/static/img/QRCode.png";

	@GetMapping("/qrcode")
	public String getQRCode(Model model) {
		String medium = "https://rahul26021999.medium.com/";
		String github = "https://github.com/rahul26021999";

		byte[] image = new byte[0];
		try {

			// Generate and Return Qr Code in Byte Array
			image = QRCodeGenerator.getQRCodeImage(medium, 250, 250);

			// Generate and Save Qr Code Image in static/image folder
			// QRCodeGenerator.generateQRCodeImage(github,250,250,QR_CODE_IMAGE_PATH);

		} catch (WriterException | IOException e) {
			e.printStackTrace();
		}
		// Convert Byte Array into Base64 Encode String
//        String qrcode = Base64.getEncoder().encodeToString(image);
//
//        model.addAttribute("medium",medium);
//        model.addAttribute("github",github);
//        model.addAttribute("qrcode",qrcode);

		return "qrcode";
	}

	@GetMapping(value = "/qrcodev2", produces = MediaType.IMAGE_PNG_VALUE)
	public @ResponseBody byte[] getQRCodev2(Model model) throws IOException {
		String medium = "phamviettu";
		byte[] image = new byte[0];
		try {

			// Generate and Return Qr Code in Byte Array
			image = QRCodeGenerator.getQRCodeImage(medium, 250, 250);

			// Generate and Save Qr Code Image in static/image folder
			// QRCodeGenerator.generateQRCodeImage(github,250,250,QR_CODE_IMAGE_PATH);
			// InputStream inputstream = new FileInputStream(QR_CODE_IMAGE_PATH);
			InputStream inputstream = new ByteArrayInputStream(image);
			return IOUtils.toByteArray(inputstream);

		} catch (WriterException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/employee/checkin", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<HttpApiResponse> updateUserProfile(@RequestBody CheckInReQuest checkInRequest,
			@RequestHeader(name = Constant.HEADER_DEVICE_ID, defaultValue = "") String deviceId) {
		try {
			HttpApiResponse response =null;
			return ok(response);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			return (ResponseEntity<HttpApiResponse>) ResponseEntity.status(HttpResponseCode.SERVER_ERROR);
		}
	}
	
	
	
}
