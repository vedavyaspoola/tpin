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
	public Boolean createTpinInfo(Tpin tpinRequest) {

		TpinDbo tpinBo = new TpinDbo();
		TpinDbo result = null;
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
			return true;
		} else {
			return false;
		}
	}

}
