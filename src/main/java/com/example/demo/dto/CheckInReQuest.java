package com.example.demo.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckInReQuest {

	private long maNV;
	private String name;
	private Timestamp lastCheckIn;

}
