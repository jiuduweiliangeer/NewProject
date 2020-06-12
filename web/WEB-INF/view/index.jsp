<%--
  Created by IntelliJ IDEA.
  User: x
  Date: 2020/6/9
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>首页</title>
    <link href="${pageContext.request.contextPath}/bootstrap-4.5.0-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/font/iconfont.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/public.css" rel="stylesheet">
</head>
<body background="${pageContext.request.contextPath}/image/back.jpg" style="background-size: 100%;">
<section class="container-fluid">
    <div class="card-header bg-dark d-flex align-items-center justify-content-between">
      <h4 class="text-white-85 font-weight-normal">电子科技大学成都学院图书馆座位管理系统</h4>
      <p class="small"><a href="${pageContext.request.contextPath}/loginjsp" class="text-white-85">退出>></a></p>
    </div>
    <div class="row">
        <aside class="col-7">
            <div class="card">
                <div class="card-header bg-dark d-flex align-items-center justify-content-between">
                    <h4 class="text-white-85 font-weight-normal">快速导航</h4>
                    <p class="small"><a href="${pageContext.request.contextPath}/message/${user.username}" class="text-white-85">个人信息完善>></a></p>
                </div>
                <div class="card-body" style="background: rgba(0,0,0,0.2);">
                    <div class="row">
                        <div class="col-sm-4 pr-0" style="height: 450px;">
                            <a href="#">
                                <div class="card text-white bg-blue mb-3 shadow-1 h-100">
                                    <div class="card-body d-flex align-items-center justify-content-center">
                                        <div>
                                            <i
                                                    class="iconfont icon-idcard-fill d-block text-center font-size-64"></i>
                                            <h5 class="text-white">姓名：<span>${user.username}</span></h5>
                                            <h5 class="text-white">学号：<span>${user.stuID}</span></h5>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="col-sm-3 pr-0">
                            <a href="${pageContext.request.contextPath}/demothis/${user.username}">
                                <div class="card text-white bg-cyan mb-3 shadow-1 h-100">
                                    <div class="card-body d-flex align-items-center justify-content-center">
                                        <div>
                                            <i
                                                    class="iconfont icon-setting-fill d-block text-center font-size-64"></i>
                                            <h5 class="text-white">修改密码</h5>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="col-sm">
                            <a href="#">
                                <div class="card text-white bg-orange mb-3 shadow-1" style="height: 120px;">
                                    <div class="card-body d-flex align-items-center">
                                        <i
                                                class="iconfont icon-time-circle-fill d-block text-center font-size-64 mr-3"></i>
                                        <h5 class="text-white">预约记录</h5>
                                    </div>
                                </div>
                            </a>
                            <a href="#">
                                <div class="card text-white shadow-1 mb-3 bg-magenta" style="height: 180px;">
                                    <div class="card-body d-flex align-items-center">
                                        <i
                                                class="iconfont icon-detail-fill d-block text-center font-size-64 mr-3"></i>
                                        <h5 class="text-white">历史记录</h5>
                                    </div>
                                </div>
                            </a>
                            <a href="#">
                                <div class="card text-white bg-orange mb-3 shadow-1" style="height: 120px;">
                                    <div class="card-body d-flex align-items-center">
                                        <i
                                                class="iconfont icon-detail-fill d-block text-center font-size-64 mr-3"></i>
                                        <h5 class="text-white">座位选择</h5>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </aside>
        <aside class="col-5">
            <div class="card">
                <div class="card-header bg-dark d-flex align-items-center justify-content-between">
                    <h4 class="text-white-85 font-weight-normal">通知公告</h4>
                    <p class="small"><a href="javascript:;" class="text-white-85">MOVE>></a></p>
                </div>
									
                <div class="card-body" style="background: rgba(0,0,0,0.2);">
                	
                    <div class="row">
                        <div>
                            <ul data-titles="titles">
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
                                <li>图书馆开展第二场“知雅”对话图</li>
                                <li>部分学习平台汇总</li>
                                <li>图书馆开展第二场“知雅”对话图</li>
                                <li>部分学习平台汇总</li>
                                <li>图书馆开展第二场“知雅”对话图</li>
																<li>部分学习平台汇总</li>
                                <li>图书馆开展第二场“知雅”对话图</li>
                                <li>部分学习平台汇总</li>
                                <li>图书馆开展第二场“知雅”对话图</li>
                                <!-- 这里放通知公告的标题 -->
                            </ul>
                        </div>
                     
                    </div>
                    
                </div>
            </div>
        </aside>
    </div>
</section>

<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src=".${pageContext.request.contextPath}/bootstrap-4.5.0-dist/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap-4.5.0-dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/axios.min.js"></script>
<script src="${pageContext.request.contextPath}/js/mock-min.js"></script>

<!-- mock假数据 -->

</body>
</html>
