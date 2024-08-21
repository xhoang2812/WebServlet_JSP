<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/3/2024
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-4">
    <div class="container" >
        <a class="btn btn-light me-1" href="/ban-hang">Ban Hang</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item me-1">
                    <a class="btn btn-primary" aria-current="page" href="/san-pham-chi-tiet/list">San Pham Chi Tiet</a>
                </li>
                <li class="nav-item me-1">
                    <a class="btn btn-info" href="/hoa-don/list">Hoa Don</a>
                </li>
                <li class="nav-item me-1">
                    <a class="btn btn-secondary" href="/san-pham/list">San Pham</a>
                </li>
                <li class="nav-item me-1">
                    <a class="btn btn-Success" href="/mau-sac/list">Mau Sac</a>
                </li>
                <li class="nav-item me-1">
                    <a class="btn btn-Danger" href="/danh-muc/list">Danh Muc</a>
                </li>
                <li class="nav-item me-1">
                    <a class="btn btn-Warning" href="/size/list">Size</a>
                </li>
                <li class="nav-item me-1">
                    <a class="btn btn-Info" href="/khach-hang/list">Khach Hang</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
</body>
</html>
