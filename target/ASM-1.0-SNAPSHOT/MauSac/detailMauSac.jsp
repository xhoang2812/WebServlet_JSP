<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/29/2024
  Time: 14:11
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
    <form action="/mau-sac/update" method="post">
        <div>
            <label class="form-label">ID Mau</label>
            <input type="text" class="form-control" name="id" value="${msDetail.id}" readonly>
        </div>
        <div>
            <label class="form-label">Ma Mau</label>
            <input type="text" class="form-control" name="maMau" value="${msDetail.maMau}">
        </div>
        <div>
            <label class="form-label">Ten Mau</label>
            <input type="text" class="form-control" name="tenMau" value="${msDetail.tenMau}">
        </div>
        <div>
            <div>
                <label class="form-label">Trang Thai</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="trangThai" id="inlineRadio1"
                       value="Active"<c:if test="${msDetail.trangThai == 'Active'}">checked</c:if> >
                <label class="form-check-label" for="inlineRadio1">Active</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="trangThai" id="inlineRadio2"
                       value="Inactive" <c:if test="${msDetail.trangThai == 'Inactive'}">checked</c:if>>
                <label class="form-check-label" for="inlineRadio2">Inactive</label>
            </div>
        </div>
        <div>
            <label class="form-label">Ngay Tao</label>
            <input type="text" class="form-control" name="ngayTao" value="${msDetail.ngayTao}" readonly>
        </div>
        <div>
            <label class="form-label">Ngay Sua</label>
            <input type="text" class="form-control" name="ngaySua" value="${msDetail.ngaySua}" readonly>
        </div>
        <div  style="text-align: center" class="mt-3">
            <button type="submit" class="btn btn-success">Sua</button>
            <a href="/mau-sac/list" class="btn btn-secondary">Quay Lai</a>
        </div>
    </form>
</div>
</body>
</html>