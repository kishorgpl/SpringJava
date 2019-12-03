package com.skr.hbr;

import java.util.Date;

import org.hibernate.Session;

import com.skr.hbr.DAO.HibernateDAO;
import com.skr.hbr.stock.Stock;
import com.skr.hbr.stock.StockDetail;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        System.out.println("Maven + Hibernate One-to-One example + MySQL");
        Session session = HibernateDAO.getSessionFactory().openSession();
        
        session.beginTransaction();
        
        Stock stock = new Stock();
        
        stock.setStockCode("4715");
        stock.setStockName("GENM");
     
        StockDetail stockDetail = new StockDetail();
        stockDetail.setCompName("GENTING Malaysia");
        stockDetail.setCompDesc("Best resort in the world");
        stockDetail.setListedDate(new Date());
        
        stock.setStockDetail(stockDetail);
        stockDetail.setStock(stock);
        
        session.save(stock);
        session.delete(stock);
        session.getTransaction().commit();
        
        
    }

}
