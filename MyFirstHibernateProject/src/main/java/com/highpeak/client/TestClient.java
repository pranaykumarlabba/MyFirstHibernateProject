package com.highpeak.client;

import java.util.Date;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import com.highpeak.Entity.Employee;
import com.highpeak.hb.HibernateUtil;

public class TestClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			
			/*String sql = "select version()";
			String result = (String)session.createNativeQuery(sql).getSingleResult();
			System.out.println("Mysql version...");
			System.out.println(result);
			*/
			session.beginTransaction();  
			//this method is used to save an entity/object in the database and return void
			//it will throw exception if entity is already exists.
			session.persist(getEmployeeOne());
			
			
			
			//used to save entity/object in database and return generated primary key.
			//throw exception if entity already exists in the database
			Integer id = (Integer)session.save(getEmployeeTwo());
			System.out.println("Employee is created with id::"+ id);
			
			//used to save/update entity in database.
			session.saveOrUpdate(getEmployeeThree());
			
			session.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Employee getEmployeeOne() {
		Employee employee = new Employee();
		employee.setEmployeeName("Pranay");
		employee.setEmail("pranay@gmail.com");
		employee.setDateOfJoining(new Date());
		employee.setSalary(40000.00);
		return employee;
		
		}
	
	public static Employee getEmployeeTwo() {
		Employee employee = new Employee();
		employee.setEmployeeName("phaneendra");
		employee.setEmail("phani@gmail.com");
		employee.setDateOfJoining(new Date());
		employee.setSalary(65000.00);
		return employee;
		
		}
	
	public static Employee getEmployeeThree() {
		Employee employee = new Employee();
		employee.setEmployeeName("Mamatha");
		employee.setEmail("mammu467@gmail.com");
		employee.setDateOfJoining(new Date());
		employee.setSalary(350000.00);
		return employee;
		
		}

}
