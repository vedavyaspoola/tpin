package com.cts.tpin.service;

import com.cts.tpin.transport.Tpin;

public interface TpinService {
	
	Boolean createTpinInfo(Tpin tpinRequest);

	Boolean validateTpin(String tpin);

	Boolean updateTpin(String mobileNo,Tpin tpin);
}
