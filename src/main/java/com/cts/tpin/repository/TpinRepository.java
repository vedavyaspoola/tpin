package com.cts.tpin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.tpin.dbo.TpinDbo;

@Repository
public interface TpinRepository extends CrudRepository<TpinDbo ,Long>{

	TpinDbo findBymobileNumber(String mobileNumber);

	TpinDbo findBytpin(String tpin);
	
	

}
