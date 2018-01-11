<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="by.asrohau.library.bean.UserDTO"%>
<%UserDTO userDTO = (UserDTO) request.getAttribute("myuser");%>
<%String message = (String) request.getAttribute("isChanged");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MAIN page</title>

</head>
<body>

<h3>Library</h3><hr/><hr/>
<h3>Привет！Dear, <font size="8"><%=userDTO.getLogin()%></font>> !!!! ------------------ <font size="8">MAIN</font></h3>

<!-- CHANGE PASSWORD -->
<hr/>
<h3>CHANGE PASSWORD</h3>
<div id="message"> </div>
<script type="text/javascript">
if("<%=message%>" != "null") {
	document.getElementById('message').innerText = "<%=message%>";
}
</script>
<form action="FrontController" method="post">
<input type="hidden" name="command" value="change_password"/><br/>
Login:<br/><input type="text" name="login" value=""/><br/>
Password:<br/><input type="password" name="password" value=""/><br/>
New Password:<br/><input type="password" name="newPassword" value=""/><br/>
<input type="submit" name="change" value="change"/>
</form>

<!-- DELETE -->
<br><hr/>
<h3>DELETE ACCOUNT</h3>
<form action="FrontController" method="post">
<input type="hidden" name="command" value="delete_user"/><br/>
Login:<br/><input type="text" name="login" value=""/><br/>
Password:<br/><input type="password" name="password" value=""/><br/>
<input type="submit" name="delete" value="delete"/>
</form>

</body>
</html>