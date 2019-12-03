package com.skr.hbr;

import java.util.Date;

import org.hibernate.Session;

import com.skr.hbr.DAO.HibernateDAO;
import com.skr.hbr.stock1.Stock;
import com.skr.hbr.stock1.StockDetail;

public class OneToOneAnnotationTest {
	
	/*
	 * ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY
	 * 'root';
	 * 
	 * 
	 * CREATE TABLE `stock` ( `stock_id` int(11) NOT NULL AUTO_INCREMENT,
	 * `stock_name` varchar(128) NOT NULL, `stock_code` varchar(512) NOT NULL,
	 * 
	 * PRIMARY KEY (`stock_id`) );
	 * 
	 * CREATE TABLE `stock_detail` ( `stock_id` int(11) NOT NULL, `comp_Name`
	 * varchar(45) NOT NULL, `comp_DESc` varchar(45) NOT NULL, `LISTED_DATE` date
	 * NOT NULL, `remark` varchar(45) , PRIMARY KEY (`stock_id`) );
	 */

	public static void main(String[] args) {
		System.out.println("Hibernate one to one (Annotation)");
		Session session = HibernateDAO.getSessionFactory().openSession();

		session.beginTransaction();

		Stock stock = new Stock();

		stock.setStockCode("7052");
		stock.setStockName("PADINI");

		StockDetail stockDetail = new StockDetail();
		stockDetail.setCompName("PADINI Holding Malaysia");
		stockDetail.setCompDesc("one stop shopping");
		stockDetail.setRemark("vinci vinci");
		stockDetail.setListedDate(new Date());

		stock.setStockDetail(stockDetail);
		stockDetail.setStock(stock);

		session.save(stock);
		session.getTransaction().commit();

		System.out.println("Done");
	}
}
