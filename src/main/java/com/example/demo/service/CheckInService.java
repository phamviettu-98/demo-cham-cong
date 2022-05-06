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
	
	///20.99661819507934, 105.79335911389619 fun

	public static double distanceBetween2Points(double la1, double lo1, double la2, double lo2) {
		double R = 6371;
		double dLat = (la2 - la1) * (Math.PI / 180);
		double dLon = (lo2 - lo1) * (Math.PI / 180);
		double la1ToRad = la1 * (Math.PI / 180);
		double la2ToRad = la2 * (Math.PI / 180);
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
				+ Math.cos(la1ToRad) * Math.cos(la2ToRad) * Math.sin(dLon / 2) * Math.sin(dLon / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double d = R * c;
		return d;
	}

}
