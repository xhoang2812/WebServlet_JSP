<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/5/2024
  Time: 09:18
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
<%@include file="header.jsp"%>
<div class="card">
    <div class="card-header">
        <h5>Danh Sach Hoa Don</h5>
    </div>
    <div class="card-body">
        <table class="table table-hover">
            <thead>
            <tr>
                <td>STT</td>
                <td>ID</td>
                <td>Ten khach hang</td>
                <td>Ngay tao</td>
                <td>Trang Thai</td>
                <td>Chuc nang</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listHd}" var="list" varStatus="i">
                <tr>
                    <td>${i.index}</td>
                    <td>${list.id}</td>
                    <td>${list.khachHang == null ? 'Khach Vang Lai' :list.khachHang.hoTen}</td>
                    <td>${list.ngayTao}</td>
                    <td>${list.trangThai}</td>
                    <td>
                        <a href="/hoa-don-ct/detail?idHoaDon=${list.id}" class="btn btn-primary">Chon</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<div class="card mt-4">
    <div class="card-header">
        <h5>Danh Sach Hoa Don Chi Tiet</h5>
    </div>
    <div class="card-body">
        <table class="table table-hover card-body">
            <thead>
            <tr>
                <td>STT</td>
                <td>ID</td>
                <td>Ten san pham</td>
                <td>So luong</td>
                <td>Gia ban</td>
                <td>Tong tien</td>
                <td>Ngay Tao</td>
                <td>NgaySua</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listHdct}" var="list" varStatus="i">
                <tr>
                    <td>${i.index}</td>
                    <td>${list.id}</td>
                    <td>${list.sanPhamChiTiet.sanPham.tenSanPham}</td>
                    <td>${list.soLuongMua}</td>
                    <td>${list.giaBan}</td>
                    <td>${list.tongTien}</td>
                    <td>${list.ngayTao}</td>
                    <td>${list.ngaySua}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
