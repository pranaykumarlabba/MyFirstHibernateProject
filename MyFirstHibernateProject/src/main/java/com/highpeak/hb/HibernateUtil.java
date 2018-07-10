package com.highpeak.hb;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


//import com.mysql.cj.api.Session;

public class HibernateUtil {
	
	private static StandardServiceRegistry standardServiceRegistry;
	
	private static SessionFactory sessionFactory;
	
	static {
		
		try {
			if(sessionFactory == null) {
				 standardServiceRegistry = new StandardServiceRegistryBuilder()
						 .configure()
						 .build();
				 
				 MetadataSources metadataSource = new MetadataSources(standardServiceRegistry);
				 
				Metadata metadata = metadataSource.getMetadataBuilder().build();
				sessionFactory = metadata.getSessionFactoryBuilder().build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			if(standardServiceRegistry != null) {
				StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
			}
			
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
		
	}
}
