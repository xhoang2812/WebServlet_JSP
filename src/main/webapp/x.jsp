<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/27/2024
  Time: 14:42
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
<%@include file="header.jsp" %>
<div class="row">
    <div class="col-7">
        <div class="card">
            <h4 class="card-header">Danh sách hoá đơn</h4>
            <table class="table table-hover card-body">
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
                            <a href="/hoa-don/detail?idHoaDon=${list.id}" class="btn btn-primary">Chon</a>
                            <a href="/hoa-don/delete?idHoaDon=${list.id}" class="btn btn-primary">Xoa</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="card mt-2">
            <h4 class="card-header">Danh sách hoá đơn chi tiết</h4>
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
                    <td>Chuc nang</td>
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
                        <td>
                            <a class="btn btn-primary"
                               href="/hoa-don-chi-tiet/delete?idHoaDonChiTiet=${list.id}&idSanPhamChiTiet=${list.sanPhamChiTiet.id}">Xoa</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="col-5">
        <h2>Tạo hoá đơn</h2>
        <div class="row">
            <div>
                <form action="/khach-hang/detail-phone" method="get">
                    <div>
                        <label class="col-3">Số điện thoại</label>
                        <input class="form-control" type="text" class="col-7" value="${khDetailByPhone.sdt}"
                               name="timKiem">
                    </div>
                    <button type="submit" class="btn btn-primary mt-2">Search</button>
                </form>
            </div>
            <form action="/hoa-don/thanh-toan" method="post">
                <div class="mb-3">
                    <label class="col-3">Ten Khach hang</label>
                    <input type="text" class="form-control" class="col-7" name="tenKhachHang"
                           value="${khDetailByPhone.hoTen}">
                </div>
                <div class="mb-3">
                    <label class="col-3">ID Hoa don</label>
                    <input type="text" class="form-control" class="col-7" name="idHoaDon" value="${hdDetail.id}"
                           readonly>
                </div>
                <div class="mb-3">
                    <label class="col-3">Tong tien</label>
                    <input type="text" class="form-control" class="col-7" name="tongTien" value="${tongTien}" readonly>
                </div>
                <div>
                    <a href="/hoa-don/add?timKiem=${sdt}" class="btn btn-primary">Tạo hoá đơn</a>
                    <button class="btn btn-primary">Thanh toán</button>
                </div>
            </form>
        </div>

    </div>
</div>
<div class="mt-2 card">
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
                        <a href="/hoa-don-chi-tiet/add?idSanPhamChiTiet=${list.id}" class="btn btn-danger">Chon</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
