<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>example-data-get.jsp</h3>
	
	<p>
		<a href="/demo/">Home</a>
	</p>
	
	<form action="/demo/example/data" method="post">
		<input type="text" name="key" value="value">
		<input type="text" name="color" value="Red">
		<button type="submit">Send</button>
	</form>
</body>
</html>