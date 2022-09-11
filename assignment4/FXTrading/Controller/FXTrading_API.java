package com.finzly.assignment4.FXTrading.Controller;

import java.util.List;

import com.finzly.assignment4.FXTrading.Entity.Client_Details_book;
import com.finzly.assignment4.FXTrading.Entity.Client_detail_print;
import com.finzly.assignment4.FXTrading.Servicess.Client_servicess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class FXTrading_API {
	
	@Autowired
	Client_servicess Client_servicess ;
	
	@PostMapping("booktrade")
	public String boketrade(@RequestBody Client_Details_book data) {

		String msg = Client_servicess.booktrades(data);
		return msg;
	}	
	
	@GetMapping("printtrade")
	public List<Client_detail_print> printtrade() {
		List<Client_detail_print> list =	Client_servicess.printtrade();
		return list;
	}
	static void comfirmation() {
		
	}
}
