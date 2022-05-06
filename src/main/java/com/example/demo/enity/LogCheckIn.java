package com.example.demo.enity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "log_check_in")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LogCheckIn {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	private long maNV;
	
	private String name;
	
	@Column(name = "last_check_in")
	private  Timestamp lastCheckIn;
	
	@Column(name = "device_id")
	private String deviceId;
	
    private String location;

}
