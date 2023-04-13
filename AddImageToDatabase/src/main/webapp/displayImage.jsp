<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> Display Image</h1>

<div align="center">
<form action="DisplayServ" method="post">
Enter Image Id:
<input type="number" name="imageId">
<input type="submit" value="display">
</form>
</div>
<hr>


<div align="center">

<table border="5px" style="width:600px">
<tr>
<th>Image Id</th>
<th>Image</th>
</tr>

<tr>
<td></td>
<td></td>
</tr>


</div>
</body>
</html>