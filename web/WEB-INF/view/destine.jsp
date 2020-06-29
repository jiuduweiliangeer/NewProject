<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>预约管理</title>
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
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/viewinform/${username}">首页</a></li>
            <li class="breadcrumb-item active" aria-current="page">预约管理</li>
        </ol>
    </nav>


    <table class="table table-striped table-dark mt-1">
        <thead>
        <tr>

            <!-- <th scope="col">头像</th>-->
            <th scope="col">个人预约信息</th>

        </tr>
        <tr>

            <th scope="col">用户名</th>

            <th scope="col">座位号</th>
            <th scope="col">开始时间</th>
            <th scope="col">结束时间</th>
            <th scope="col">目前状态</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${!empty dastine}">
            <tr>
                <td>${dastine.username}</td>
                <td>${dastine.location}</td>
                <td>${dastine.opentime}</td>
                <td>${dastine.closetime}</td>
                <td>${dastine.state}</td>
                <!-- <td>浙江杭州</td>-->
            </tr>
        </c:if>
        </tbody>
    </table>
    <div class="row">
        <div class="col-12">
            <form>
                <div style="overflow:hidden;" class="bg-dark p-1 rounded">
                    <div class="mt-2" style="text-align: center;">
                        <a href="${pageContext.request.contextPath}/cancel/${username}/${dastine.location}"><button type="button" class="btn btn-danger btn-sm ml-3">取消预约</button></a>
                        <a href="${pageContext.request.contextPath}/confirm/${username}/${dastine.location}"><button type="button" class="btn btn-primary btn-sm ml-3">确认预约</button></a>
                        <a href="${pageContext.request.contextPath}/end/${username}/${dastine.location}"><button type="button" class="btn btn-primary btn-sm ml-3">结束使用</button></a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
