<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>display details</title>
<style>
 .container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}
body {
  background-image: url('https://cdn.pixabay.com/photo/2016/10/13/16/40/green-1738220_960_720.jpg');
  background-size: cover;
  font-family: Arial, sans-serif;
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
	 <h1>Student's Not Exist in Database</h1>
      <p>student's are you trying to Display isn't exist in the system. Insert student details first.</p>
      <a href="nav.html">Back to Home</a>
      </div>
      </div>
</body>
</html>