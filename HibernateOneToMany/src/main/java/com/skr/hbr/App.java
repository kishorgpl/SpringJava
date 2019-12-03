package com.skr.hbr;

import java.util.Date;

import org.hibernate.Session;

import com.skr.hbr.DAO.HibernateDAO;
import com.skr.hbr.stock.Stock;
import com.skr.hbr.stock.StockDailyRecord;

public class App {
	public static void main(String[] args) {
	
        System.out.println("Hibernate one to many (XML Mapping)");
	Session session = HibernateDAO.getSessionFactory().openSession();

	session.beginTransaction();

	Stock stock = new Stock();
        stock.setStockCode("7052");
        stock.setStockName("PADINI");
        session.save(stock);
        
        StockDailyRecord stockDailyRecords = new StockDailyRecord();
        stockDailyRecords.setPriceOpen(new Float("1.2"));
        stockDailyRecords.setPriceClose(new Float("1.1"));
        stockDailyRecords.setPriceChange(new Float("10.0"));
        stockDailyRecords.setVolume(3000000L);
        stockDailyRecords.setDate(new Date());
        
        stockDailyRecords.setStock(stock);        
        stock.getStockDailyRecords().add(stockDailyRecords);

        session.save(stockDailyRecords);

	session.getTransaction().commit();
	System.out.println("Done");
	}
}