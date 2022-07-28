package cys.training.day9.test;

import java.sql.SQLException;
import java.util.List;

import cys.training.day9.dao.StudentImpl;
import cys.training.day9.model.Student;

public class TestStudent {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		StudentImpl student1 = new StudentImpl();
		// Student student = new Student(2, "Priya", 4);
		Student student = new Student();
		student.setId(15);
		student.setName("David");
		student.setGrade(5);
		//student1.save(student);
		List<Student> listofStudents = student1.listofStudents();
		System.out.println(listofStudents);

	}

}
