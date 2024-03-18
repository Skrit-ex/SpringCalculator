<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Skritex
  Date: 08.03.2024
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<s:form action="user/login" modelAttribute="newLoginUser">
  <s:input path="email" placeholder="Email"/>
  <br>
  <s:errors path="email"/>
  <br>
  <s:input path="password" placeholder="Password"/>
  <br>
  <s:errors path="password"/>
  <br>
  <s:button>Login</s:button>
</s:form>


</body>
</html>
