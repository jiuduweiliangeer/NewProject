<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>座位预定</title>
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
<body class="bg-secondary"  background="${pageContext.request.contextPath}/image/back.jpg" style="background-size: 100%;">
    <div class="container-fluid">
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb bg-dark">
                <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/viewinform/${username}">首页</a></li>
                <li class="breadcrumb-item active" aria-current="page">座位预定</li>
            </ol>
        </nav>
		<form action="${pageContext.request.contextPath}/select_seat_stu/${username}">
        <div class="row">
            <div class="col-12">
                <div style="overflow:hidden;" class="bg-dark p-1 rounded">
                    <div class="input-group input-group-sm float-left" style="width:140px;">
                        <div class="input-group-prepend">
                            <label class="input-group-text" for="inputGroupSelect01">状态</label>
                        </div>
                        <select class="custom-select" id="inputGroupSelect01" name="useruse">
                            <option value="" selected>请选择</option>
                            <option value="idle">idle</option>
                            <option value="occupy">occupy</option>
                            <option value="false">false</option>
                        </select>
                    </div>

                    <div class="input-group input-group-sm ml-2 float-left" style="width:100px;">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="inputGroup-sizing-sm">座号</span>
                        </div>
                        <input type="text" class="form-control" name="location" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
                    </div>

                    <div class="float-right text-right" style="width:140px;">
                        <button type="submit" class="btn btn-primary btn-sm">查询</button>
                        <button type="reset" class="btn btn-secondary btn-sm ml-2">重置</button>
                    </div>
                </div>
            </div>
        </div>
		</form>

        <div class="row row-cols-4 my-4">
            <c:if test="${!empty seats}">
                <c:forEach items="${seats}" var="seat">
                    <div class="col my-1">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">座位号：${seat.location}</h5>
                                <p class="card-text"><small class="text-success">${seat.useruse}</small></p>
                            </div>
                            <div class="card-footer">
                                <small class="text-primary"><a href="#">预定：查看</a></small>
                                <small class="text-danger"><a href="#" onclick="falseSeat(${seat.location})">故障：报错</a></small>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
        </div>
        <form:form id="falseSeat" action="${pageContext.request.contextPath}"/>
</body>
<script>
    function falseSeat(location) {
        var formdel=document.getElementById("falseSeat");
        formdel.action=formdel.action+"/false/"+"${username}/"+location;
        if(confirm("确认该位置发生故障？")){
            formdel.submit();
        }
    }
</script>
</html>
