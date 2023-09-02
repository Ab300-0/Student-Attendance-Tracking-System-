<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Added Successfully</title>
<style>
body {
  background-image: url('https://cdn.pixabay.com/photo/2016/10/13/16/40/green-1738220_960_720.jpg');
  background-size: cover;
  font-family: Arial, sans-serif;
}

.container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.card {
  background-color: #fff;
  border-radius: 5px;
  box-shadow: 0px 3px 3px rgba(0, 0, 0, 0.2);
  padding: 20px;
  max-width: 500px;
  width: 100%;
}

h1 {
  color: BLACK;
  font-size: 36px;
  text-align: center;
  text-shadow: 1px 1px #444;
}

p {
  font-size: 18px;
  text-align: center;
}

a {
  background-color: #007bff;
  border-radius: 5px;
  color: #fff;
  display: block;
  font-size: 20px;
  margin-top: 20px;
  padding: 10px;
  text-align: center;
  text-decoration: none;
  transition: all 0.3s ease;
  width: 200px;
}

a:hover {
  background-color: #0062cc;
}
</style>
</head>
<body>
<div class="container">
  <div class="card">
    <% int count=(int)request.getAttribute("count"); %>
    <% if (count == 0) { %>
      <h1>Student Not Exist</h1>
      <p>The student you are trying to update isn't exist in the system.</p>
    <% } else { %>
      <h1><%=count %> Student Updated Successfully</h1>
      <p>Thank you for using our system. We appreciate your business!</p>
    <% } %>
    <a href="nav.html">Back to Home</a>
  </div>
</div>
</body>
</html>
