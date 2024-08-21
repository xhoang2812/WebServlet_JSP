<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/26/2024
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List-Add Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body class="container">
<%@include file="../header.jsp"%>
<div>
    <form action="/san-pham-chi-tiet/add" method="post" >
        <div>
            <label class="form-label">Ten San Pham</label>
            <select class="form-control" name="tenSanPham">
                <c:forEach items="${listSp}" var="list">
                    <option value="${list.id}">${list.tenSanPham}</option>
                </c:forEach>
            </select>
        </div>
        <div>
            <label class="form-label">Ten Mau Sac</label>
            <select class="form-control" name="tenMau">
                <c:forEach items="${listMs}" var="list">
                    <option value="${list.id}">${list.tenMau}</option>
                </c:forEach>
            </select>
        </div>
        <div>
            <label class="form-label">Ten Size</label>
            <select class="form-control" name="tenSize">
                <c:forEach items="${listSz}" var="list">
                    <option value="${list.id}">${list.tenSize}</option>
                </c:forEach>
            </select>
        </div>
        <div>
            <label class="form-label">Gia Ban</label>
            <input class="form-control" type="text" name="giaBan">
        </div>
        <div>
            <label class="form-label">So Luong Ton</label>
            <input class="form-control" type="text" name="soLuongTon">
        </div>
        <div>
            <div>
                <label class="form-label">Trang Thai</label>
            </div>
            <div class="form-check form-check-inline ms-5">
                <input class="form-check-input" type="radio" name="trangThai" id="inlineRadio1"
                       value="Active">
                <label class="form-check-label" for="inlineRadio1">Active</label>
            </div>
            <div class="form-check form-check-inline ms-5">
                <input class="form-check-input" type="radio" name="trangThai" id="inlineRadio2"
                       value="Inactive">
                <label class="form-check-label" for="inlineRadio2">Inactive</label>
            </div>
        </div>
        <div class="mt-3">
            <button type="submit" class="btn btn-warning">Thêm</button>
        </div>
    </form>
</div>
<div class="card mt-2">
    <div class="card-header">
        <h5>Danh Sach San Pham Chi Tiet</h5>
    </div>
    <div class="card-body">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Ten San Pham</th>
                <th scope="col">Ten Mau Sac</th>
                <th scope="col">Ten Size</th>
                <th scope="col">Gia Ban</th>
                <th scope="col">So Luong Ton</th>
                <th scope="col">Trang Thai</th>
                <th scope="col">Ngay Tao</th>
                <th scope="col">Ngay Sua</th>
                <th scope="col">Chuc Nang</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listSpct}" var="list" varStatus="i">
                <tr>
                    <td>${list.id}</td>
                    <td>${list.sanPham.tenSanPham}</td>
                    <td>${list.mauSac.tenMau}</td>
                    <td>${list.size.tenSize}</td>
                    <td>${list.giaBan}</td>
                    <td>${list.soLuongTon}</td>
                    <td>${list.trangThai}</td>
                    <td>${list.ngayTao}</td>
                    <td>${list.ngaySua}</td>
                    <td>
                        <a href="/san-pham-chi-tiet/delete?id=${list.id}" class="btn btn-danger">Xoa</a>
                        <a href="/san-pham-chi-tiet/detail?id=${list.id}" class="btn btn-Info">Chi Tiet</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
