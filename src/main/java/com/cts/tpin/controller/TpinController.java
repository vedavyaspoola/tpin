package com.cts.tpin.controller;

import javax.validation.executable.ValidateOnExecution;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.tpin.dbo.TpinDbo;
import com.cts.tpin.repository.TpinRepository;
import com.cts.tpin.service.TpinService;
import com.cts.tpin.transport.Tpin;

@RestController
@RequestMapping("/tpin")
public class TpinController {

	@Autowired
	private TpinService tpinService;
	
	@Autowired
	private TpinRepository tpinRepository;
	

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ValidateOnExecution 
	public String create(@RequestBody Tpin tpinRequest) {

		StringBuffer sb = new StringBuffer();
		String status = null;
		if(tpinRequest != null && tpinRequest.getEmail() != null) {

		}else {
			sb.append("Email is Empty..");
		}
		//check for tpin 


		/*if(tpinRequest.getMobileNumber() != null) {
			tpinRequest.setComments(sb.toString());
			status = tpinService.createTpinInfo(tpinRequest);
			
		}*/
		return sb.toString();

	}

	@RequestMapping(value = "/validate/{tpin}", method = RequestMethod.GET)
	public Boolean validateTpin(@PathVariable("tpin") String tpin) {


		Boolean status=tpinService.validateTpin(tpin);

		return status;

	}
	@RequestMapping(value = "/update/{tpin}", method = RequestMethod.PUT)
	public Boolean updateTpin(@RequestBody Tpin tpin) {
       
		
			
       TpinDbo tpinfromdb = tpinRepository.findBymobileNumber(tpin.getMobileNumber());
       if(tpin.getMobileNumber() != null && tpin.getTpin()!= null)
		{
			tpinfromdb.setTpin(tpin.getTpin());
		}
       //check null condiions and set the object values from ui to tpinfromdb
       
		TpinDbo status = tpinRepository.save(tpinfromdb);

		return status;

	}




}
