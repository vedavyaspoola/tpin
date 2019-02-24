package com.cts.tpin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.tpin.dbo.TpinDbo;

@Repository
public interface TpinRepository extends JpaRepository<TpinDbo ,String>{

	TpinDbo findBymobileNumber(String mobileNumber);

	TpinDbo findBytpin(String tpin);
	
	

}
