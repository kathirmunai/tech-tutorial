package com.kathirmunai.cms.multiple.ds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kathirmunai.cms.multiple.ds.exception.KathirmunaiException;
import com.kathirmunai.cms.multiple.ds.service.IMultipleDSService;

@RestController
public class MultipleDSController {

	@Autowired
	IMultipleDSService multipleDSService;
	
	@GetMapping("/")
    public String index() throws KathirmunaiException {
		return "Hello Kathirmunai";
    }

	@GetMapping("/ds1Sysdate")
	public ResponseEntity<Object> ds1Sysdate() {
		return new ResponseEntity<>(multipleDSService.getDs1Sysdate(), HttpStatus.OK);
	}
	
	@GetMapping("/ds2Sysdate")
	public ResponseEntity<Object> ds2Sysdate() {
		multipleDSService.getDs2Sysdate();
		return new ResponseEntity<>(multipleDSService.getDs2Sysdate(), HttpStatus.OK);
	}

}
