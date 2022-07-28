package cys.training.day9.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cys.training.day9.connection.ConnectionUtil;
import cys.training.day9.model.Student;

public class StudentImpl implements StudentDAO {

	public void save(Student student) {
		try {
			Connection connection = ConnectionUtil.getConnection();
			System.out.println(connection);
			// String saveStudent = "insert into student(id,name,grade)values(12,'ram',2)";
			String saveStudent = "insert into student(id,name,grade)values(?,?,?)";
			PreparedStatement ps = connection.prepareStatement(saveStudent);
		
			ps.setInt(1, student.getId());
			//System.out.println("Getting student details : " + student.getId() + student.getName() + student.getGrade());
			ps.setString(2, student.getName());
			ps.setInt(3, student.getGrade());
			
			int rows = ps.executeUpdate();
			System.out.println(rows);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Student> listofStudents() throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String query = "select * from student";
		PreparedStatement ps = connection.prepareStatement(query);
		ArrayList<Student> list = new ArrayList();
		ResultSet resultSet = ps.executeQuery();
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			int grade = resultSet.getInt(3);

			Student stud1 = new Student();
			stud1.setId(id);
			stud1.setName(name);
			stud1.setGrade(grade);
			list.add(stud1);
		//	System.out.println(list);
		}
		return list;
	}

}
