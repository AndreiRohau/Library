<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String isRegistered = (String) request.getAttribute("isRegistered"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>INDEX page</title>
</head>
<body>
<h3>Library</h3><hr/>
<h1>您好！---------INDEX</h1>
<hr/><hr/>

<h2>To login insert personal data below</h2>
<form action="FrontController" method="post">
<input type="hidden" name="command" value="logination"/><br/>
Login:<br/><input type="text" name="login" value=""/><br/>
Password:<br/><input type="password" name="password" value=""/><br/>
<input type="submit" name="sign in" value="sign in"/>
</form>
<br/><hr/>
<h2>To register insert personal data below</h2>
<div id="registered"> </div>
<script type="text/javascript">
if("<%=isRegistered%>" != "null") {
	document.getElementById('registered').innerText = "<%=isRegistered%>";
}
</script>
<form action="FrontController" method="post">
<input type="hidden" name="command" value="registration"/><br/>
Login:<br/><input type="text" name="login" value=""/><br/>
Password:<br/><input type="password" name="password" value=""/><br/>
<input type="submit" name="sign up" value="sign up"/>
</form>

</body>
</html>