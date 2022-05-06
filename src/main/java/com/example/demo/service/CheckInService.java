package com.example.demo.service;

import java.sql.Timestamp;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.constant.HttpResponseCode;
import com.example.demo.dto.CheckInReQuest;
import com.example.demo.dto.HttpApiResponse;
import com.example.demo.enity.LogCheckIn;
import com.example.demo.repository.LogCheckInrepository;

public class CheckInService {

	@Autowired
	private LogCheckInrepository logCheckInRepository;

	public HttpApiResponse checkIn(CheckInReQuest checkInRequest) {
		// check count login
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		Timestamp startDay = new Timestamp(cal.getTime().getTime());
		int count = logCheckInRepository.countCheckIn(checkInRequest.getMaNV(), startDay);
		if (count > 2) {
			return new HttpApiResponse(HttpResponseCode.BAD_REQUEST, "ChechIn > 2", null);
		}
		LogCheckIn logcheckIn = LogCheckIn.builder().maNV(checkInRequest.getMaNV()).name(checkInRequest.getName())
				.build();
		logCheckInRepository.save(logcheckIn);

		return new HttpApiResponse(200, "CheckIn success", null);
	}

}
