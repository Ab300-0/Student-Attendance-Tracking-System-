<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.*" %>
     <%@ page import="model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Attendance</title>
<style>
    .c1 {
        background-color: #f2f2f2;
        padding: 10px;
    }

    .c2 {
        background-color: white;
        padding: 20px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
    }

    th, td {
        padding: 10px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }

    th {
        background-color: black;
        color: white;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    a {
        display: inline-block;
        padding: 10px;
        background-color: #4CAF50;
        color: white;
        text-decoration: none;
        border-radius: 5px;
        margin-top: 20px;
    }

    a:hover {
        background-color: #3e8e41;
    }
   
</style>
</head>
<body>
<%ArrayList<StudentDTO> per=(ArrayList<StudentDTO>)request.getAttribute("details"); %>

	<%if(per.size()==0){ %>
	 <% response.sendRedirect("nulldisplay.jsp"); %>
      
      <%}else { 

    	  Collections.sort(per, new Comparator<StudentDTO>() {
              @Override
              public int compare(StudentDTO s1, StudentDTO s2) {
                  return s1.getBatchCode().compareTo(s2.getBatchCode());
              }
          });
      %>
      <div class="c1">
	<div class="c2">
	<h1>---PDEA'S--- <br>---Attendance Details---</h1>
		<table border="2px">
		<tr>
		<th>id</th>
		<th>Name</th>
		<th>RollNO</th>
		<th>Total class</th>
		<th>Attended class</th>
		<th>Percentage</th>
		<th>TimeStamp</th>
		<th>Class</th>
		</tr>
		<% 
		
			for(StudentDTO data:per){
				 int percentage = (data.getAttendedClass()*100)/data.getTotalClass();
				  String bgColor = percentage > 75 ? "#8bc34a" : "#FF4500";
		%>
		
		<tr style="background-color: <%=bgColor%>;">
		<td><%=data.getStudentId() %></td>
		<td><%=data.getStudentName() %></td>
		<td><%=data.getBatchCode() %></td>
		<td><%=data.getTotalClass() %></td>
		<td><%=data.getAttendedClass() %></td>
		<td><%=percentage%></td>
		<td><%=data.getTimestamp() %></td>
		<td> <%=data.getDivison() %></td>
		</tr>
		
		<%} %>
		</table>
		</div>
<br><br>
<a href="nav.html">Back To Home</a></h1>
</div>
<%} %>
</body>
</html>
