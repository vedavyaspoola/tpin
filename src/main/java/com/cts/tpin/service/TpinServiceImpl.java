package com.cts.tpin.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.tpin.dbo.TpinDbo;
import com.cts.tpin.repository.TpinRepository;
import com.cts.tpin.transport.Tpin;

@Service
public class TpinServiceImpl implements TpinService {

	@Autowired
	private TpinRepository tpinRepository;

	@Override
	public String createTpinInfo(Tpin tpinRequest) {

		TpinDbo tpinBo = new TpinDbo();
		TpinDbo result = null;
		
		TpinDbo pinDbo=tpinRepository.findBymobileNumber(tpinRequest.getMobileNumber());
		if(pinDbo!=null)
			return "";
		
		if (tpinRequest != null) {
			tpinBo.setMobileNumber(tpinRequest.getMobileNumber());

			tpinBo.setEmail(tpinRequest.getEmail());

			tpinBo.setTpin(tpinRequest.getTpin());

			tpinBo.setComments(tpinRequest.getComments());
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			tpinBo.setStartDate(timestamp);

			result = tpinRepository.save(tpinBo);

		}
		if (result != null) {
			return "";
		} else {
			return null;
		}
	}

	@Override
	public Boolean validateTpin(String tpin) {
		TpinDbo pinDbo=tpinRepository.findBytpin(tpin);
		if(pinDbo!=null)
			return true;
		else
			return false;
	
	}

	@Override
	public Boolean updateTpin(String tpin) {
		// TODO Auto-generated method stub
		return null;
	}

}
