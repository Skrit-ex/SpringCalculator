<%--
  Created by IntelliJ IDEA.
  User: Skritex
  Date: 19.03.2024
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-link active" aria-current="page" href="/">Home</a>
                <a class="nav-link" href="/user/reg">Registration</a>
                <a class="nav-link" href="/user/login">LogIn</a>

                <c:if test="${sessionScope.userSession != null}">
                    <li class="nav-item">
                        <a class="nav-link" href="/calc">Calculator</a>
                    </li>
                </c:if>

                <li class="nav-item">

                    <c:if test="${sessionScope.userSession == null}">
                    <a class="nav-link disabled">Hello Guest</a>
                    </c:if>

                    <c:if test="${sessionScope.userSession != null}">
                    <a class="nav-link disabled">Hello ${sessionScope.userSession.username}</a>
                    </c:if>
                </li>
            </div>
        </div>
    </div>
</nav>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
