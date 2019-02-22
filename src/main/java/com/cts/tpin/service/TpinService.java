package com.cts.tpin.service;

import com.cts.tpin.transport.Tpin;

public interface TpinService {
	
	String createTpinInfo(Tpin tpinRequest);

	Boolean validateTpin(String tpin);

	Boolean updateTpin(String tpin);
}
