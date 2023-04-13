<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Image</title>
</head>
<body>

<h1> Add Image</h1>

<form action="ImageServ" method="post"  enctype="multipart/form-data">
select image:

<div align="center">
<input type="file" name="image">
<input type="submit" value="add image">


</form>
</div>
</body>
</html>