package com.skr.hbr.DAO;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
public class HibernateDAO {


    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        	 if (sessionFactory == null) {
                 Configuration configuration = new Configuration().configure();
                 ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
                 registry.applySettings(configuration.getProperties());
                 ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
                  
                return sessionFactory = configuration.buildSessionFactory(serviceRegistry);           
             }
			return sessionFactory;
              
            
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void shutdown() {
    	// Close caches and connection pools
    	getSessionFactory().close();
    }

}