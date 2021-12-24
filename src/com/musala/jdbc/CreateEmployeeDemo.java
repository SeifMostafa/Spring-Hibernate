package com.musala.jdbc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateEmployeeDemo {

	public static void main(String[] args) {

		//createemployee();
		
		//readAllemployees();
		
		//updateemployee();
		
		deleteemployee();
		
		
	}
	private static void deleteemployee() {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {								
			long employeeId = 1l;
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve employee based on the id: primary key
			System.out.println("\nGetting employee with id: " + employeeId);
			
			Employee myemployee = session.get(Employee.class, employeeId);
			
			// delete the employee
			// System.out.println("Deleting employee: " + myemployee);
			// session.delete(myemployee);
			
			// delete employee id=2
			System.out.println("Deleting employee id=2");
			
			session.createQuery("delete from Employee where id=2").executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}
	private static void updateemployee() {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {								
			long employeeId = 1l;
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve employee based on the id: primary key
			System.out.println("\nGetting employee with id: " + employeeId);
			
			Employee myemployee = session.get(Employee.class, employeeId);
			
			System.out.println("Updating employee...");
			myemployee.setFirstName("Scooby");
			
			// commit the transaction
			session.getTransaction().commit();

			// NEW CODE
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// update email for all employees
			System.out.println("Update company for all employees");
			
			session.createQuery("update Employee set company='Musala'")
				.executeUpdate();
						
			// commit the transaction
			session.getTransaction().commit();

			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}
	private static void readAllemployees() {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			// query employees
			List<Employee> theemployees = session.createQuery("from Employee").getResultList();
			
			// display the employees
			displayemployees(theemployees);
			
			// query employees: lastName='Doe'
			theemployees = session.createQuery("from Employee s where s.lastName='Doe'").getResultList();
			
			// display the employees
			System.out.println("\n\nemployees who have last name of Doe");
			displayemployees(theemployees);
			
			// query employees: lastName='Doe' OR firstName='Daffy'
			theemployees =
					session.createQuery("from Employee s where"
							+ " s.lastName='Doe' OR s.firstName='Daffy'").getResultList();
			
			System.out.println("\n\nemployees who have last name of Doe OR first name Daffy");
			displayemployees(theemployees);
			
			// query employees where email LIKE '%gmail.com'
			theemployees = session.createQuery("from Employee s where"
					+ " s.company LIKE '%com'").getResultList();

			System.out.println("\n\nemployees whose company ends with com");			
			displayemployees(theemployees);
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}
	private static void displayemployees(List<Employee> theemployees) {
		for (Employee tempemployee : theemployees) {
			System.out.println(tempemployee);
		}
	}
	private static void createemployee() {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			// create a employee object
			System.out.println("Creating new employee object...");
			Employee tempemployee = new Employee("Paul", "Doe", "Musala");
			
			// start a transaction
			session.beginTransaction();
			
			// save the employee object
			System.out.println("Saving the employee...");
			session.save(tempemployee);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}





