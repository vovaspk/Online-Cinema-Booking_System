<%--
  Created by IntelliJ IDEA.
  User: Vova
  Date: 10.01.2019
  Time: 0:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

<div id="registr">
    <h3>Cinema</h3>
    <form id="search" method="post" action="/registration">

        <input type="text" placeholder="Enter username" name="regUsername" required>
        <label name="username" id="s-user"><b>username</b></label>

        <input type="text" placeholder="Enter Email" name="regEmail" required>
        <label name="email" id="s-email"><b>Email</b></label>

        <input type="password" placeholder="Enter Password" name="regPsw" required>
        <label name="psw" id="s-pass"><b>Password</b></label>

        <input type="submit" id="sign up" value="sign up">
    </form>
</div>

</body>
</html>
