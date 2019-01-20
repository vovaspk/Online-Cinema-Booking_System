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
    <style>
        <%@include file="../WEB-INF/css/footers.css"%>
    </style>
</head>
<body>

<div id="registr">
    <form id="header">
        <h1>Cinema Registration</h1>
    </form>

    <div id="regInner">
        <form id="regSearh" method="post" action="/registration">

            <div id="user-name-label">
                <span class="input-reg">
                <input id="reg-usname" type="text" placeholder="Enter username" name="regUsername" required>
                <label name="username" id="s-user"><b class="b-class">username</b></label>
                </span>
            </div>

            <div id="email-reg">
                <span class="input-reg">
                <input id="reg-email" type="text" placeholder="Enter Email" name="regEmail" required>
                <label name="email" id="s-email"><b class="b-class">Email</b></label>
            </span>
            </div>


            <div id="psw-reg">
                <span class="input-reg">
                <input id="reg-psw" type="password" placeholder="Enter Password" name="regPsw" required>
                <label name="psw" id="s-pass"><b class="b-class">Password</b></label>
            </span>
            </div>
            <span class="input-reg">
            <input class="reg-submit-button" type="submit" <%--id="sign up"--%> value="sign up">
            </span>
        </form>
    </div>
</div>

</body>
</html>
