package model;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class StudentDAO {
	//here first create one static block for connection and driver register 
	//JDBC CONNECTIVITY
	static Connection con;
	static {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","redhat");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int insertStudent(StudentDTO dto) {
		//actual jdbc  code will be here 
		PreparedStatement pstmt;
		LocalDateTime currentDateTime = LocalDateTime.now();
		java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf(currentDateTime);
		String query="insert into student_detail(name,roll_no,total_class,attended_class,date_time,class) values(?,?,?,?,?,?)";
		int count=0;
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1,dto.getStudentName());
			pstmt.setString(2,dto.getBatchCode());
			pstmt.setInt(3,dto.getTotalClass());
			pstmt.setInt(4, dto.getAttendedClass());
			pstmt.setTimestamp(5, timestamp);
			pstmt.setString(6, dto.getDivison());
			count=	pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	public ArrayList<StudentDTO> getPercentage() {
		
		ArrayList<StudentDTO> per=new ArrayList<>();
		Statement stmt;
		ResultSet rs;
		String query="select * from student_detail";
		
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			
			while(rs.next())
			{
				
				
				int dbId=rs.getInt(1);
				String dbName=rs.getString(2);
				String dbBCode=rs.getString(3);
				int dbTClass=rs.getInt(4);
				int dbAClass=rs.getInt(5);
				Timestamp timestamp=rs.getTimestamp(6);
				String dbDivison=rs.getString(7);
				StudentDTO dto=new StudentDTO();
				
				dto.setStudentId(dbId);
				dto.setStudentName(dbName);
				dto.setBatchCode(dbBCode);
				dto.setTotalClass(dbTClass);
				dto.setAttendedClass(dbAClass);
				dto.setTimestamp(timestamp);
				dto.setDivison(dbDivison);
				per.add(dto);
				
						
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return per;
		
	}
	public int updateStudent(StudentDTO dto) {
		//actual jdbc  code will be here 
				PreparedStatement pstmt;
				LocalDateTime currentDateTime = LocalDateTime.now();
				java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf(currentDateTime);
				String query="update student_detail set name=?,roll_no=?,total_class=?,attended_class=?,date_time=?,class=? where id=?";
				int count=0;
				try {
					pstmt=con.prepareStatement(query);
					pstmt.setString(1,dto.getStudentName());
					pstmt.setString(2,dto.getBatchCode());
					pstmt.setInt(3,dto.getTotalClass());
					pstmt.setInt(4, dto.getAttendedClass());
					pstmt.setTimestamp(5, timestamp);
					pstmt.setString(6, dto.getDivison());
					pstmt.setInt(7,dto.getStudentId());
					count=	pstmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return count;
	}
	public int deleteStudent(StudentDTO dto) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt;
		String query="delete from student_detail where id=?";
		int count=0;
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1,dto.getStudentId());
			count=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	

}
