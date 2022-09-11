package com.finzly.assignment4.FXTrading.Respository;

import java.util.List;

import com.finzly.assignment4.FXTrading.Configuration.HybernateConfiguration;
import com.finzly.assignment4.FXTrading.Entity.Client_Details_book;
import com.finzly.assignment4.FXTrading.Entity.Client_detail_print;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class CLientRepository {	
		
		public String bookedtrades(Client_Details_book details) {
			
			final double rate = 66.00;
	
			 int count = 0;
			//currencyPair check
			if(details.getCurrencypair().equalsIgnoreCase("usdinr")) {
				//checking client want to get rate or not
				if(details.getGetrate().equalsIgnoreCase("yes") ) {
					//checking confirmation of client to book trade
					 if(details.getBookingConfirmation().equalsIgnoreCase("yes")) {
								count++;
			
								SessionFactory factory = HybernateConfiguration.getonnection();
								Session session = factory.openSession();
								Transaction tr = session.beginTransaction();
								Client_detail_print data = new Client_detail_print();
								data.setName(details.getName());
								data.setAmount(Conversion.USDTOINR(details.getAmount()));
								data.setCurrencypair(details.getCurrencypair());
								data.setGetrate(rate);
								data.setTradeno(count);
								session.save(data);
								tr.commit();
								session.close();
						
								return "Trade for USDINR has been booked with rate 66.00 , The amount of Rs " + data.getAmount() +" will  be transferred in 2 working days to " +details.getName(); 
						}
					 else if(details.getBookingConfirmation().equalsIgnoreCase("no"))
							return "booking cancelled";		
					 else
						 return "invalid input (bookingconfirmation) " + details.getBookingConfirmation() + " please give input as yes or no";
						
				}
				
				else if(details.getGetrate().equalsIgnoreCase("no"))  {
					if(details.getBookingConfirmation().equalsIgnoreCase("yes")) {
					
						SessionFactory factory = HybernateConfiguration.getonnection();
						Session session = factory.openSession();
						Transaction tr = session.beginTransaction();
						Client_detail_print data = new Client_detail_print();
						data.setName(details.getName());
						data.setAmount(Conversion.USDTOINR(details.getAmount()));
						data.setCurrencypair(details.getCurrencypair());
						data.setGetrate(rate);
						data.setTradeno(count);
						session.save(data);
						tr.commit();
						session.close();
				

					return "Trade for USDINR has been booked with rate 66.00 , The amount of Rs " + data.getAmount() +" will  be transferred in 2 working days to " +data.getName(); 
					}
					else if(details.getBookingConfirmation().equalsIgnoreCase("no"))
							return "booking cancelled";		
					else
							return "invalid input (bookingconfirmation) " + details.getBookingConfirmation() + " please give input as yes or no";
				}	
				else
					return "invalid choice " + details.getGetrate() + " plese enter yes or no";
					
				}
				else 
					return "invalid input "+ details.getCurrencypair() + " only usdinr is allowed";
		}

				
			public List<Client_detail_print> printtrades() {
			SessionFactory factory = HybernateConfiguration.getonnection();
			Session session =factory.openSession();
			@SuppressWarnings("deprecation")
			Criteria criteria = session.createCriteria(Client_detail_print.class);
			List<Client_detail_print> trades = criteria.list();
			return trades;
		}

}
