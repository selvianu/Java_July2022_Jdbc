package cys.training.day9.dao;

import java.sql.SQLException;
import java.util.List;

import cys.training.day9.model.Student;

public interface StudentDAO {
	public void save(Student student) throws ClassNotFoundException, SQLException;

	public List<Student> listofStudents() throws ClassNotFoundException, SQLException;
}
