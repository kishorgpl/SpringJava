package com.skr.hbr;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import com.skr.hbr.DAO.HibernateDAO;
import com.skr.hbr.stock1.Stock;
import com.skr.hbr.stock1.StockDailyRecord;

public class App2 {
	/*
	 DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock` (
  `STOCK_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `STOCK_CODE` varchar(10) NOT NULL,
  `STOCK_NAME` varchar(20) NOT NULL,
  PRIMARY KEY (`STOCK_ID`) USING BTREE,
  UNIQUE KEY `UNI_STOCK_NAME` (`STOCK_NAME`),
  UNIQUE KEY `UNI_STOCK_ID` (`STOCK_CODE`) USING BTREE
) ;


DROP TABLE IF EXISTS `sys`.`stock_daily_record`;
CREATE TABLE  `sys`.`stock_daily_record` (
  `RECORD_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `PRICE_OPEN` float(6,2) DEFAULT NULL,
  `PRICE_CLOSE` float(6,2) DEFAULT NULL,
  `PRICE_CHANGE` float(6,2) DEFAULT NULL,
  `VOLUME` bigint(20) unsigned DEFAULT NULL,
  `DATE` date NOT NULL,
  `STOCK_ID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`RECORD_ID`) USING BTREE,
  
  KEY `FK_STOCK_TRANSACTION_STOCK_ID` (`STOCK_ID`),
  CONSTRAINT `FK_STOCK_TRANSACTION_STOCK_ID` FOREIGN KEY (`STOCK_ID`) 
  REFERENCES `stock` (`STOCK_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ;
	 */
public static void main(String[] args) {
		
        System.out.println("Hibernate one to many (Annotation)");
	Session session = HibernateDAO.getSessionFactory().openSession();

	session.beginTransaction();

		/*
		 * Stock stock = new Stock(); stock.setStockCode("7054");
		 * stock.setStockName("Kishor"); session.save(stock);
		 * 
		 * StockDailyRecord stockDailyRecords = new StockDailyRecord();
		 * stockDailyRecords.setPriceOpen(new Float("1.8"));
		 * stockDailyRecords.setPriceClose(new Float("1.2"));
		 * stockDailyRecords.setPriceChange(new Float("10.1"));
		 * stockDailyRecords.setVolume(4000000L); stockDailyRecords.setDate(new Date());
		 * stockDailyRecords.setStock(stock); session.save(stockDailyRecords);
		 * 
		 * StockDailyRecord stockDailyRecord1 = new StockDailyRecord();
		 * stockDailyRecord1.setPriceOpen(new Float("1.8"));
		 * stockDailyRecord1.setPriceClose(new Float("1.2"));
		 * stockDailyRecord1.setPriceChange(new Float("10.1"));
		 * stockDailyRecord1.setVolume(4000000L); stockDailyRecord1.setDate(new Date());
		 * 
		 * 
		 * stockDailyRecord1.setStock(stock); session.save(stockDailyRecord1);
		 */
       
		/*
*/
	
		/*
		 * List<Stock> list = session.createQuery("from Stock").list();
		 * 
		 * for(Stock stock : list){
		 * 
		 * Set sets = stock.getStockDailyRecords();
		 * 
		 * for ( Iterator iter = sets.iterator();iter.hasNext(); ) { StockDailyRecord
		 * sdr = (StockDailyRecord) iter.next(); System.out.println(sdr.getRecordId());
		 * System.out.println(sdr.getDate()); } }
		 */
	Stock stock = (Stock)session.get(Stock.class, 2); 
	Set sets = stock.getStockDailyRecords();

	//no extra select
	for ( Iterator iter = sets.iterator();iter.hasNext(); ) { 
	      StockDailyRecord sdr = (StockDailyRecord) iter.next();
	      System.out.println(sdr.getRecordId());
	      System.out.println(sdr.getDate());
	}
	
	session.getTransaction().commit();
	System.out.println("Done");
	}
}