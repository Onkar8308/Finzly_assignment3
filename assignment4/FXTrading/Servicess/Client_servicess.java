package com.finzly.assignment4.FXTrading.Servicess;

import java.util.List;

import com.finzly.assignment4.FXTrading.Entity.Client_Details_book;
import com.finzly.assignment4.FXTrading.Entity.Client_detail_print;
import com.finzly.assignment4.FXTrading.Respository.CLientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Client_servicess {
	
	@Autowired
	CLientRepository CLientRepository;
	
	public String booktrades(Client_Details_book cd) {
		
		String msg =CLientRepository.bookedtrades(cd);
		return msg;
	}
	
	

	public List<Client_detail_print> printtrade() {
		List<Client_detail_print> list = CLientRepository.printtrades();
		return list;
	}
}
