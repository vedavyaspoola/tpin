package com.cts.tpin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.tpin.repository.TpinRepository;
import com.cts.tpin.service.TpinService;
import com.cts.tpin.transport.Tpin;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/tpin")
public class TpinController {

	@Autowired
	private TpinService tpinService;

	@Autowired
	private TpinRepository tpinRepository;

	@ApiOperation(value = "Create Tpin", response = Iterable.class)
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<String> create(@RequestBody Tpin tpinRequest) {

		Boolean response = tpinService.createTpinInfo(tpinRequest);
		if (!response) {
			return new ResponseEntity<String>("User aready exists", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<String>("Successfuy Saved", HttpStatus.OK);
		}

	}

	@ApiOperation(value = "Validate Tpin", response = Iterable.class)
	@RequestMapping(value = "/validate/{tpin}", method = RequestMethod.GET)
	public ResponseEntity<String> validateTpin(@PathVariable("tpin") String tpin) {

		Boolean response = tpinService.validateTpin(tpin);
		if (!response) {
			return new ResponseEntity<String>("User Not exists", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<String>("Given MobileNumber or Tpin Validaed", HttpStatus.OK);
		}

	}

	@ApiOperation(value = "Update Tpin", response = Iterable.class)
	@RequestMapping(value = "/update/{mobieNo}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateTpin(@RequestBody Tpin tpin, @PathVariable("mobieNo") String mobieNo) {

		Boolean response = tpinService.updateTpin(mobieNo, tpin);

		if (!response) {
			return new ResponseEntity<String>("User Not exists", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<String>("Record Updaed Successfully", HttpStatus.OK);
		}
	}

}
