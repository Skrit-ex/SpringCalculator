<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Skritex
  Date: 08.03.2024
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>

<s:form action="/calc" method="post" modelAttribute="newOperationDto">

    <s:input path="num1" placeholder="Num1"/>
    <br>
    <s:errors path="num1"/>
    <br>
    <s:input path="num2" placeholder="Num2"/>
    <br>
    <s:errors path="num2"/>

    <s:select path="type">
              <s:option value="SUM" label="SUM"/>
              <s:option value="SUB" label="SUB"/>
              <s:option value="MUL" label="MUL"/>
              <s:option value="DIV" label="DIV"/>
    </s:select>
    <br>
    <s:button>Calculate</s:button>
</s:form>
<h1>Result = ${result}</h1>

</body>
</html>
