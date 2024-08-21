<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/24/2024
  Time: 18:03
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
<body class="container">
<%@include file="../header.jsp"%>
<div>
<form action="/size/add" method="post">
    <div>
        <label class="form-label">Ma Size</label>
        <input type="text" class="form-control" name="maSize">
    </div>
    <div>
        <label class="form-label">Ten Size</label>
        <input type="text" class="form-control" name="tenSize">
    </div>
    <div>
        <div>
            <label class="form-label">Trang Thai</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="trangThai" id="inlineRadio1"
                   value="Active">
            <label class="form-check-label" for="inlineRadio1">Active</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="trangThai" id="inlineRadio2"
                   value="Inactive">
            <label class="form-check-label" for="inlineRadio2">Inactive</label>
        </div>
        <div>
            <button type="submit" class="btn btn-warning mt-2">Thêm</button>
        </div>
    </div>
</form>
</div>
<div class="card">
    <div class="card-header">
        <h5>Danh Sach Size</h5>
    </div>
    <div class="card-body">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Ma Size</th>
                <th scope="col">Ten Size</th>
                <th scope="col">Trang Thai</th>
                <th scope="col">Ngay Tao</th>
                <th scope="col">Ngay Sua</th>
                <th scope="col">Chuc Nang</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listSize}" var="list" varStatus="i">
                <tr>
                    <td>${list.id}</td>
                    <td>${list.maSize}</td>
                    <td>${list.tenSize}</td>
                    <td>${list.trangThai}</td>
                    <td>${list.ngayTao}</td>
                    <td>${list.ngaySua}</td>
                    <td>
                        <a href="/size/delete?id=${list.id}" class="btn btn-danger">Xoa</a>
                        <a href="/size/detail?id=${list.id}" class="btn btn-info">Detail</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
