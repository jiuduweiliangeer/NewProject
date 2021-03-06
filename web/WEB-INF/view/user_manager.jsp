﻿﻿﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>用户管理</title>
    <link href="/favicon.ico" rel="shortcut icon" type="image/x-icon" />
    <meta charset="utf-8">
    <meta name="renderer" content="webkit" />
    <meta name="force-rendering" content="webkit" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="referrer" content="always">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript">

    </script>
</head>
<body class="bg-secondary" background="${pageContext.request.contextPath}/image/back.jpg" style="background-size: 100%;">
<div class="container-fluid">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb bg-dark">
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/viewmore/${username}">首页</a></li>
            <li class="breadcrumb-item active" aria-current="page">用户管理</li>
        </ol>
    </nav>

    <div class="row">
        <div class="col-12">
        	<form action="${pageContext.request.contextPath}/user_manager_select/${username}">
            <div style="overflow:hidden;" class="bg-dark p-1 rounded">
                <div class="input-group input-group-sm float-left" style="width:140px;">
                    <div class="input-group-prepend">
                        <label class="input-group-text" for="inputGroupSelect01">状态</label>
                    </div>
                    <select class="custom-select" name="state" id="inputGroupSelect01">
                        <option selected value="">请选择</option>
                        <option value="T">T</option>
                        <option value="F">F</option>
                    </select>
                </div>

                <div class="input-group input-group-sm ml-2 float-left" style="width:140px;">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-sm">昵称</span>
                    </div>
                    <input type="text" class="form-control" name="susername" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
                </div>

                <div class="input-group input-group-sm ml-2 float-left" style="width:140px;">
                    <div class="input-group-prepend">
                        <span class="input-group-text"  id="inputGroup-sizing-sm">邮箱</span>
                    </div>
                    <input type="text" class="form-control" name="email" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
                </div>

                <div class="float-right text-right" style="width:140px;">
                    <button type="submit" class="btn btn-primary btn-sm">查询</button>
                    <button type="reset" class="btn btn-secondary btn-sm ml-2">重置</button>
                </div>
                <div style="clear:both"></div>
            </div>
             </form>
        </div>
    </div>

    <table class="table table-striped table-dark mt-1">
        <thead>
        <tr>
            <!-- <th scope="col">头像</th>-->
            <th scope="col">姓名</th>
            <th scope="col">昵称</th>
            <th scope="col">性别</th>
            <th scope="col">专业</th>
            <th scope="col">班级</th>
            <th scope="col">邮箱</th>
            <!-- <th scope="col">地址</th>-->
            <th scope="col">状态</th>
            <th scope="col">操作</th>
        </tr>
        </thead>
        <tbody>
            <c:if test="${!empty users}">
                <c:forEach items="${users}" var="user">
                    <tr>
                        <!--<td>
                            <img src="./img/head-pic.jpg" width="30" height="30" class="rounded-circle" />
                        </td>-->
                        <td>${user.name}</td>
                        <td>${user.username}</td>
                        <td>${user.gender}</td>
                        <td>${user.major}</td>
                        <td>${user.stuclass}</td>
                        <td>${user.email}</td>
                        <!-- <td>浙江杭州</td>-->
                        <td>${user.state}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/openuser/${username}/${user.username}"><button type="button" class="btn btn-primary btn-sm ml-2">启用</button></a>
                            <a href="${pageContext.request.contextPath}/closeuser/${username}/${user.username}"><button type="button" class="btn btn-danger btn-sm ml-2">停用</button></a>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
        </tbody>

    </table>

    
</div>
</body>
</html>
