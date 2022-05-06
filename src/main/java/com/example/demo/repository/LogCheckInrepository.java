package com.example.demo.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.enity.LogCheckIn;

public interface LogCheckInrepository extends JpaRepository<LogCheckIn, Long> {
	
    @Query(value = "Select count(*) from log_check_in where maNV = :maNV and last_check_in >:lastCheckIn", nativeQuery = true)
    public int countCheckIn(long maNV, Timestamp lastCheckIn);
    
    @Query(value =  "Select * from log_check_in where maNV = :maNV and device_id = :deviceId and  last_check_in >:lastCheckIn", nativeQuery = true )
    public List<LogCheckIn> findLogCheckInWithDeviceId(long maNV, String deviceId, Timestamp lastCheckIn);

}
