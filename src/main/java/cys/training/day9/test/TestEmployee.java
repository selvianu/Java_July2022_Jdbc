package cys.training.day9.test;

import java.sql.SQLException;
import java.util.List;

import cys.training.day9.Employee;
import cys.training.day9.dao.EmployeeImpl;

public class TestEmployee {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		EmployeeImpl emp1 = new EmployeeImpl();
		Employee emp = new Employee();
		emp.setId(9);
		emp.setName("ramesh");
		emp.setDesignation("manager");
		emp.setBasicSalary(9000l);
		System.out.println(emp.getId() + emp.getName());
		// emp1.saveEmp(emp);
		List<Employee> displayListOfEmployee = emp1.displayListOfEmployee();
		System.out.println(displayListOfEmployee);

	}

}
