package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import com.example.demo.dto.HttpApiResponse;

public class BaseController {
	protected ResponseEntity<HttpApiResponse> error(int httpResponseCode) {
		return ResponseEntity.ok(new HttpApiResponse(httpResponseCode,
				"Đọc báo 24h cám ơn bạn đã quan tâm. Vui lòng liên hệ the.ffff.studio@gmail.com nếu bạn có nhu cầu.",
				null));
	}
}
