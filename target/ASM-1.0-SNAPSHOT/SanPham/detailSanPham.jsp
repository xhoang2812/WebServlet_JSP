<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/27/2024
  Time: 15:14
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
<body class="container" style="width: 40%">
<div>
    <form action="/san-pham/update" method="post">
        <div>
            <label class="form-label">ID San Pham</label>
            <input type="text" class="form-control" name="id" value="${sanPhamDetail.id}" readonly>
        </div>
        <div>
            <label class="form-label">Ma San Pham</label>
            <input type="text" class="form-control" name="maSanPham" value="${sanPhamDetail.maSanPham}">
        </div>
        <div>
            <label class="form-label">Ten San Pham</label>
            <input type="text" class="form-control" name="tenSanPham" value="${sanPhamDetail.tenSanPham}">
        </div>
        <div>
            <label class="form-label">Ngay Tao</label>
            <input type="text" class="form-control" name="ngayTao" value="${sanPhamDetail.ngayTao}" readonly>
        </div>
        <div>
            <label class="form-label">Ngay Sua</label>
            <input type="text" class="form-control" name="ngaySua" value="${sanPhamDetail.ngaySua}" readonly>
        </div>
        <div>
            <div>
                <label class="form-label">Trang Thai</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="trangThai" id="inlineRadio1"
                       value="Active" <c:if test="${sanPhamDetail.trangThai == 'Active'}">Checked</c:if>>

                <label class="form-check-label" for="inlineRadio1">Active</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="trangThai" id="inlineRadio2"
                       value="Inactive" <c:if test="${sanPhamDetail.trangThai == 'Inactive'}">Checked</c:if>>
                <label class="form-check-label" for="inlineRadio2">Inactive</label>
            </div>
        </div>
        <div>
            <div>
                <label class="form-label">Danh Muc</label>
                <select class="form-control" name="danhMuc">
                    <c:forEach items="${listDanhMuc}" var="list">
                        <option value="${list.id}"
                                <c:if test="${sanPhamDetail.danhMuc.id == list.id}">selected</c:if>>${list.tenDanhMuc}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <br>
        <div style="text-align: center">
            <button type="submit" class="btn btn-Success">Sửa</button>
            <a class="btn btn-secondary" href="/san-pham/list">Quay Lai</a>
        </div>
    </form>
</div>
</body>
</html>
