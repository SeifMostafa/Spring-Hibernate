package com.musala.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseWithStudentsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

//			Course course = new Course("Spring & Hibernate");
//			session.save(course);
//			Student csseifms = new Student("Seif","Mostafa","csseifms@gmail.com");
//			Student menna = new Student("Iman","El Gohary","iman.elgohary28@gmail.com");
//			course.addStudent(csseifms);
//			course.addStudent(menna);
//			
//			session.save(csseifms);
//			session.save(menna);
			
			
//			Student menna = session.get(Student.class, 2);
//			
//			Course course = new Course("Act");
//			Course course2 = new Course("testing");
//			
//			course.addStudent(menna);
//			course2.addStudent(menna);
//			
//			session.save(course);
//			session.save(course2);
//			System.out.println(course.toString());
			
			
//			Course actCourse = session.get(Course.class, 15);
//			session.delete(actCourse);
//			
//			Student menna = session.get(Student.class, 2);
//			
//			System.out.println(menna);
//			
//			System.out.println(menna.getCourses());
			
			Student menna = session.get(Student.class, 2);
			session.delete(menna);
			
			Course testing = session.get(Course.class, 16);
			
			System.out.println(testing);
			
			System.out.println(testing.getStudents());
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {

			// add clean up code
			session.close();

			factory.close();
		}
	}

}
