package cys.training.day9.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cys.training.day9.Employee;
import cys.training.day9.connection.ConnectionUtil;

public class EmployeeImpl implements EmployeeDao {

	Employee emp = new Employee();

	public void saveEmp(Employee employee) {
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
			String save = "insert into employee(id,name,designation,basicsalary)values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(save);

			System.out.println(employee.getId() + employee.getName());
			ps.setInt(1, employee.getId());
			ps.setString(2, employee.getName());
			ps.setString(3, employee.getDesignation());
			ps.setLong(4, employee.getBasicSalary());
			int i = ps.executeUpdate();
			System.out.println(i);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Employee> displayListOfEmployee() {
		try {
			Connection con = ConnectionUtil.getConnection();
			String q1 = "select * from employee";
			PreparedStatement ps1 = con.prepareStatement(q1);
			ResultSet rs = ps1.executeQuery();
			ArrayList list = new ArrayList();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String designation = rs.getString("designation");
				long salary = rs.getLong("basicsalary");
				Employee emp = new Employee();
				emp.setId(id);
				emp.setName(name);
				emp.setDesignation(designation);
				emp.setBasicSalary(salary);
				list.add(emp);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
