package com.finzly.assignment4.FXTrading.Configuration;

import com.finzly.assignment4.FXTrading.Entity.Client_detail_print;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HybernateConfiguration {
	
public static  SessionFactory getonnection() {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			cfg.addAnnotatedClass(Client_detail_print.class);
			SessionFactory sf = cfg.buildSessionFactory();
			return sf;
		}

}
