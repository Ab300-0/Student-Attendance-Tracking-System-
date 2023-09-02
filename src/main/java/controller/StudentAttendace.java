package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.StudentDAO;
import model.StudentDTO;
import model.UserDAO;
import model.UserDTO;

@WebServlet(urlPatterns = {"/loginlink","/logout","/signuplink","/adddetails","/getdetails","/updatedetails","/deletedetails"})
public class StudentAttendace extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path=req.getServletPath();//to fetch html link from urlpatterns we use req.getServletPath()
		
		
		switch(path) {
		case "/loginlink" :
			login(req,resp);
			break;
		case "/signuplink" :
			signUp(req, resp);
			break;
		case "/logout":
			logout(req,resp);
			break;
		case "/adddetails" :
				addDetails(req,resp);
				break;
		case "/getdetails" :
				getDetails(req,resp);
				break;
		case "/updatedetails" : 
			updateDetails(req,resp);
			break;
		case "/deletedetails" :
			deleteDetails(req,resp);
			
			
		
		}
	}
	
	private void deleteDetails(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		int userId=Integer.parseInt(req.getParameter("studentId"));
		System.out.println(userId);
		StudentDTO dto=new StudentDTO();
		dto.setStudentId(userId);
		
		StudentDAO dao=new StudentDAO();
		int count=dao.deleteStudent(dto);
		
		req.setAttribute("count", count);
		RequestDispatcher rd=req.getRequestDispatcher("deletedetails.jsp");
		try {
			rd.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	private void signUp(HttpServletRequest req,HttpServletResponse resp) {
		String username=req.getParameter("username");
		long cno=Long.parseLong(req.getParameter("contact"));
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String cpassword=req.getParameter("cpassword");
		
		
		UserDTO dto=new UserDTO();
		dto.setUsername(username);
		dto.setContact(cno);
		dto.setEmail(email);
		dto.setPassword(password);
		dto.setCpass(cpassword);
		
		UserDAO dao=new UserDAO();
		boolean signup=dao.signingUp(dto);
		
		if(signup) {
			try {
				resp.sendRedirect("index.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			RequestDispatcher rd=req.getRequestDispatcher("signup.html");
			try {
				PrintWriter pw=resp.getWriter();
				pw.print("<h5>User Already Exist<h5>");
				rd.include(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	private void logout(HttpServletRequest req,HttpServletResponse resp) {
		HttpSession session=req.getSession(false);
		session.invalidate();
		try {
			resp.sendRedirect("index.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	private void login(HttpServletRequest req,HttpServletResponse resp) {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		UserDTO dto =new UserDTO();
		dto.setUsername(username);
		dto.setPassword(password);
		
		UserDAO dao=new UserDAO();
		boolean login=dao.logIn(dto);
//		
		if(login) {
			HttpSession session=req.getSession(true);
			
			RequestDispatcher rd=req.getRequestDispatcher("nav.html");
			try {
				rd.include(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else {
			PrintWriter pw;
			try {
				pw = resp.getWriter();
				pw.print("<h1>Invalid Username Password</h1>");
				resp.sendRedirect("index.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}
		
	}

	
	private void getDetails(HttpServletRequest req, HttpServletResponse resp) {
		
		
		StudentDAO dao=new StudentDAO();
		ArrayList<StudentDTO> per= dao.getPercentage();
		//send data to jsp 
		req.setAttribute("details", per);
		RequestDispatcher rd=req.getRequestDispatcher("studentdetails.jsp");
		try {
			rd.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	private void addDetails(HttpServletRequest req, HttpServletResponse resp) {
		//fetch the data from html 
		String studentName=req.getParameter("studentName");
		String batchCode=req.getParameter("batchCode");
		int totalClass=Integer.parseInt(req.getParameter("totalClass"));
		int attendedClass=Integer.parseInt(req.getParameter("attendedClass"));
		String divsion=req.getParameter("c");
		System.out.println(divsion);
		
		//send the data to dto class first create private members and public getters setters in model dto class.
		StudentDTO dto=new StudentDTO();
	
		dto.setStudentName(studentName);
		dto.setBatchCode(batchCode);
		dto.setTotalClass(totalClass);
		dto.setAttendedClass(attendedClass);
		dto.setDivison(divsion);
		
		//after sending data to dto class we have to implement actual databace code in dao class so we have to go in dao
		
		StudentDAO dao=new StudentDAO();
		int count=dao.insertStudent(dto);
		//send data to jsp view 
		req.setAttribute("count", count);
		RequestDispatcher rd=req.getRequestDispatcher("addstudent.jsp");
		try {
			rd.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	private void updateDetails(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		//fetch the data from html 
				int studentId=Integer.parseInt(req.getParameter("studentId"));
				String studentName=req.getParameter("studentName");
				String batchCode=req.getParameter("batchCode");
				int totalClass=Integer.parseInt(req.getParameter("totalClass"));
				int attendedClass=Integer.parseInt(req.getParameter("attendedClass"));
				String divsion=req.getParameter("c");
				System.out.println(divsion);
				
				//send the data to dto class first create private members and public getters setters in model dto class.
				StudentDTO dto=new StudentDTO();
				
				dto.setStudentId(studentId);
				dto.setStudentName(studentName);
				dto.setBatchCode(batchCode);
				dto.setTotalClass(totalClass);
				dto.setAttendedClass(attendedClass);
				dto.setDivison(divsion);
				
				//after sending data to dto class we have to implement actual databace code in dao class so we have to go in dao
				
				StudentDAO dao=new StudentDAO();
				int count=dao.updateStudent(dto);
				//send data to jsp view 
				req.setAttribute("count", count);
				RequestDispatcher rd=req.getRequestDispatcher("updatestudent.jsp");
				try {
					rd.forward(req, resp);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
	}

}
