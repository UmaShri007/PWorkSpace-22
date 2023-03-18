package ai.neuron.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ai.neuron.dto.Student;
import ai.neuron.util.JDBCUtil;

//Persistence logic using JDBC API
public class StudentDaoImpl implements IStudentDao {

	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet resultSet = null;

	@Override

	public String addStudent(String sname, Integer sage, String saddress) {

		String sqlInsertQuery = "Insert into Student01 (`sname`,`sage`,`saddress`) values(?,?,?)";

		try {
			connection = JDBCUtil.getJdbcConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlInsertQuery);
			}
			if (pstmt != null) {
				pstmt.setString(1, sname);
				pstmt.setInt(2, sage);
				pstmt.setString(3, saddress);

				int rowAffected = pstmt.executeUpdate();

				if (rowAffected == 1) {
					return "success";
				}
			}
			return "failure";
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return "failure";
	}

	@Override
	public Student searchStudent(Integer sid) {

		String sqlSelectQuery = "Select  `sid`, `sname`,`sage`,`saddress` from Student01 where sid=? ";
		Student student = null;

		try {
			connection = JDBCUtil.getJdbcConnection();

			if (connection != null)
				pstmt = connection.prepareStatement(sqlSelectQuery);

			if (pstmt != null) {
				pstmt.setInt(1, sid);

			}
			if (pstmt != null) {
				resultSet = pstmt.executeQuery();
			}
			if (resultSet != null) {
				if(resultSet.next()) {
				student = new Student();
				
				// copy resultSet data to student object
				student.setSid(resultSet.getInt(1));
				student.setSname(resultSet.getString(2));
				student.setSage(resultSet.getInt(3));
				student.setSaddress(resultSet.getString(4));

				return student;
			}
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public String deleteStudent(Integer sid) {
		
		String sqlDeleteQuery = "Delete from Student01 where sid=?";
		
		try {
			
			connection = JDBCUtil.getJdbcConnection();
			
			if(connection!=null) {
				pstmt = connection.prepareStatement(sqlDeleteQuery);
			}
			
			if(pstmt!=null) {
				pstmt.setInt(1, sid);
			}
			
			if(pstmt!=null) {
				 int rowAffected = pstmt.executeUpdate();
				 if(rowAffected==1) {
						return "success";
				 }
				 else {
					return "not found";
			}
			}
			
		}catch(SQLException|IOException e) {
			e.printStackTrace();
			return "failure";
		}
		return "failure";
	}
	
	@Override
	public String updateStudent( Student student) {
		
		String sqlUpdateQuery="update student01 set sname =?,sage=?,saddress=? where sid=?";
		
		try {
			connection = JDBCUtil.getJdbcConnection();
			
			if(connection!=null) {
				pstmt = connection.prepareStatement(sqlUpdateQuery);
			}
			
			if(pstmt!=null) {
				pstmt.setString(1, student.getSname());
				pstmt.setInt(2, student.getSage());
				pstmt.setString(3, student.getSaddress());
				pstmt.setInt(4, student.getSid());
			}
			
			if(pstmt!=null) {
				 int rowAffected = pstmt.executeUpdate();
				 if(rowAffected==1) {
						return "success";
				 }
			}
			
		}catch(SQLException|IOException e) {
			e.printStackTrace();
		}
		return "failure";
	}
		}


