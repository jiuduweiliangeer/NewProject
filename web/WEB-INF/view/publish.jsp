<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>公告消息</title>
    <link href="${pageContext.request.contextPath}/bootstrap-4.5.0-dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-table-master/dist/bootstrap-table.min.css">
    <link href="${pageContext.request.contextPath}/font/iconfont.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/public.css" rel="stylesheet">
</head>

<body background="${pageContext.request.contextPath}/image/back.jpg" style="background-size: 100%;">
<section class="container-fluid">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb bg-dark">
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/viewinform/${username}">首页</a></li>
            <li class="breadcrumb-item active" aria-current="page">公告栏</li>
        </ol>
    </nav>
    <aside class="col-12">
            <div class="card">
                <div class="card-header bg-dark d-flex align-items-center justify-content-between">
                    <h4 class="text-white-85 font-weight-normal">通知公告</h4>
                    <p class="small"><a href="javascript:;" class="text-white-85">MOVE>></a></p>
                </div>
									
                <div class="card-body" style="background: rgba(0,0,0,0.2);">
                	
                    <div class="row">
                        <div>
                            <ul data-titles="titles">
                                <c:if test="${!empty publishes}">
                                    <c:forEach items="${publishes}" var="publish">
                                        <a href="${publish.purl}" style="color: black"><li style="color: black">${publish.urlname}</li></a>
                                    </c:forEach>
                                </c:if>
                                <%--<li>图书馆开展第二场“知雅”对话图</li>
                                <li>部分学习平台汇总</li>
                                <li>图书馆开展第二场“知雅”对话图</li>
                                <li>部分学习平台汇总</li>
                                <li>图书馆开展第二场“知雅”对话图</li>
                                <li>图书馆开展第二场“知雅”对话图</li>
                                <li>部分学习平台汇总</li>
                                <li>图书馆开展第二场“知雅”对话图</li>
                                <li>部分学习平台汇总</li>
                                <li>图书馆开展第二场“知雅”对话图</li>
                                <li>图书馆开展第二场“知雅”对话图</li>
                                <li>部分学习平台汇总</li>
                                <li>图书馆开展第二场“知雅”对话图</li>
                                <li>部分学习平台汇总</li>
                                <li>图书馆开展第二场“知雅”对话图</li>
																<li>部分学习平台汇总</li>
                                
                                <!-- 这里放通知公告的标题 -->--%>
                            </ul>
                        </div>
                     
                    </div>
                    
                </div>
            </div>
        </aside>
</section>

<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap-4.5.0-dist/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap-4.5.0-dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/axios.min.js"></script>
<script src="${pageContext.request.contextPath}/js/mock-min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap-table-master/dist/bootstrap-table.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap-table-master/dist/locale/bootstrap-table-zh-CN.min.js"></script>

</body>


</html>