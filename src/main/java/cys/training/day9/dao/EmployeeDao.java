package cys.training.day9.dao;

import java.sql.SQLException;
import java.util.List;

import cys.training.day9.Employee;

public interface EmployeeDao {

	public void saveEmp(Employee employee) throws ClassNotFoundException, SQLException;

	public List<Employee> displayListOfEmployee();

}
