package com.cts.tpin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.tpin.service.TpinService;
import com.cts.tpin.transport.Tpin;



@RestController
@RequestMapping("/tpin")
public class TpinController {
	
	@Autowired
	private TpinService tpinService;
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public Boolean create(@RequestBody Tpin tpinRequest )
	{
    	
		Boolean status=tpinService.createTpinInfo(tpinRequest);
		
		
		return status;
		
	}
    

}
