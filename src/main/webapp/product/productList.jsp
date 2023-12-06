<%--
  Created by IntelliJ IDEA.
  User: chiuchiuleuleu
  Date: 04/12/2023
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
      integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
        crossorigin="anonymous"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="http://localhost:8080">BoDoi</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/pc">PC Manager<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/product">Product Manager<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/user">User Manager<span class="sr-only">(current)</span></a>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
                    Về chúng tôi
                </a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="https://youtube.com">YouTube</a>
                    <a class="dropdown-item" href="https://fb.com">FaceBook</a>
                    <div class="dropdown-divider"></div>
                </div>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" method="post">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class=offset-2></div>
        <div class="col-8">
            <h1>Danh sách sản phẩm:</h1>
            <button class="btn btn-primary" style="margin-bottom: 20px"><a href="/product?action=create"
                                                                           style="color: aliceblue">Tạo mới</a></button>
            <h3>Id, Tên, Số lượng, Giá</h3>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col-5">Id</th>
                    <th scope="col-5">Tên</th>
                    <th scope="col-5">Số lượng</th>
                    <th scope="col-5">Giá</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items='${productList}' var="product">
                    <tr>
                        <td>${product.idProduct}</td>
                        <td>${product.nameProduct}</td>
                        <td>${product.quantity}</td>
                        <td>${product.priceProduct}</td>
                        <td><a href="/product?action=editProduct&idProduct=${product.idProduct}">Sửa</a></td>
                        <td><a href="/product?action=deleteProduct&idProduct=${product.idProduct}">Xóa</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <br>
            <button class="btn btn-primary"><a href="http://localhost:8080" style="color: aliceblue">Quay lại</a>
            </button>
        </div>
    </div>
</div>

</body>
</html>
