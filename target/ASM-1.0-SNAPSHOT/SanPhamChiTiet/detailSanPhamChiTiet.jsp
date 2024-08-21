<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/29/2024
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Detail Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body class="container" style="width: 40%;">
<div>
    <form action="/san-pham-chi-tiet/update" method="post">
        <div>
            <label class="form-label">ID</label>
            <input class="form-control" type="text" name="id" value="${spctDetail.id}" readonly>
        </div>
        <div>
            <label class="form-label">Ten San Pham</label>
            <select class="form-control" name="tenSanPham">
                <c:forEach items="${listSp}" var="list">
                    <option value="${list.id}"
                            <c:if test="${spctDetail.sanPham.id == list.id}">selected</c:if> >${list.tenSanPham}</option>
                </c:forEach>
            </select>
        </div>
        <div>
            <label class="form-label">Ten Mau Sac</label>
            <select class="form-control" name="tenMau">
                <c:forEach items="${listMs}" var="list">
                    <option value="${list.id}" <c:if test="${spctDetail.mauSac.id == list.id}">selected</c:if>>${list.tenMau}</option>
                </c:forEach>
            </select>
        </div>
        <div>
            <label class="form-label">Ten Size</label>
            <select class="form-control" name="tenSize">
                <c:forEach items="${listSz}" var="list">
                    <option value="${list.id}" <c:if test="${spctDetail.size.id == list.id}">selected</c:if>>${list.tenSize}</option>
                </c:forEach>
            </select>
        </div>
        <div>
            <label class="form-label">Gia Ban</label>
            <input class="form-control" type="text" name="giaBan" value="${spctDetail.giaBan}">
        </div>
        <div>
            <label class="form-label">So Luong Ton</label>
            <input class="form-control" type="text" name="soLuongTon" value="${spctDetail.soLuongTon}">
        </div>
        <div>
            <label class="form-label">Ngay Tao</label>
            <input class="form-control" type="text" name="ngayTao" value="${spctDetail.ngayTao}" readonly>
        </div>
        <div>
            <label class="form-label">Ngay Sua</label>
            <input class="form-control" type="text" name="ngaySua" value="${spctDetail.ngaySua}" readonly>
        </div>
        <div>
            <div>
                <label class="form-label">Trang Thai</label>
            </div>
            <div class="form-check form-check-inline ms-5">
                <input class="form-check-input" type="radio" name="trangThai" id="inlineRadio1"
                       value="Active" <c:if test="${spctDetail.trangThai == 'Active'}">checked</c:if>>
                <label class="form-check-label" for="inlineRadio1">Active</label>
            </div>
            <div class="form-check form-check-inline ms-5">
                <input class="form-check-input" type="radio" name="trangThai" id="inlineRadio2"
                       value="Inactive" <c:if test="${spctDetail.trangThai == 'Inactive'}">checked</c:if>>
                <label class="form-check-label" for="inlineRadio2">Inactive</label>
            </div>
        </div>
        <div class="mt-3" style="text-align: center">
            <button type="submit" class="btn btn-Success">Sửa</button>
            <a href="/san-pham-chi-tiet/list" class="btn btn-secondary">Quay Lai</a>
        </div>
    </form>
</div>
</body>
</html>
