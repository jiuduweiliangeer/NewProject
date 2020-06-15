<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>历史记录</title>
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
                <li class="breadcrumb-item active" aria-current="page">历史记录</li>
            </ol>
        </nav>

        <div class="card" style="background: rgba(0,0,0,0.2);">
            <!--<img src="../../image/seat-pic.jpg" class="card-img-top" alt="" height="300">-->
            <div class="card-body">
            
             

                <table class="table table-striped table-dark mt-1">
                    <thead>
                        <tr>
                            <th scope="col">用户名</th>
                            <th scope="col">座位号</th>
                           
                            <th scope="col">日期时间</th>
                            <th scope="col">操作</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${!empty histories}">
                            <c:forEach items="${histories}" var="history">
                                <tr>
                                    <td>${history.username}</td>
                                    <td>${history.location}</td>

                                    <td>${history.date}</td>
                                    <td>${history.operate}</td>

                                </tr>
                            </c:forEach>
                        </c:if>
                        <%--<tr>
                            <td>2020-6-6 9:50:20</td>
                            <td>110</td>
                          
                            <td>良好完成</td>
                            <td>1</td>
                            <td>
                                
                                林美玲
                            </td>
                        </tr>
                        <tr>
                            <td>2020-6-6 9:50:20</td>
                            <td>110</td>
                            
                            <td>良好完成</td>
                            <td>1</td>
                            <td>
                               
                                林美玲
                            </td>
                        </tr>
                        <tr>
                            <td>2020-6-6 9:50:20</td>
                            <td>110</td>
                           
                            <td>良好完成</td>
                            <td>1</td>
                            <td>
                               
                                林美玲
                            </td>
                        </tr>--%>
                    </tbody>

                </table>

            </div>
        </div>


    </div>
</body>
</html>
