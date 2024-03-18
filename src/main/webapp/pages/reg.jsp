<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Skritex
  Date: 05.03.2024
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

<s:form action="/user/reg" modelAttribute="newUser">
    <s:input path="firstname" placeholder="Firstname"/>
    <br>
    <s:errors path="firstname"/>
    <br>
    <s:input path="lastname" placeholder="Lastname"/>
    <br>
    <s:errors path="lastname"/>
    <br>
    <s:input path="username" placeholder="Username"/>
    <br>
    <s:errors path="username"/>
    <br>
    <s:input path="email" placeholder="Email"/>
    <br>
    <s:errors path="email"/>
    <br>
    <s:input path="password" placeholder="Password"/>
    <br>
    <s:errors path="password"/>
    <br>
    <s:button>Registration</s:button>
    <br>
</s:form>

<h1>${regError}</h1>


</body>
</html>
