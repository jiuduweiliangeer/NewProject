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

<body>
<section class="container-fluid">
    <div class="card-header bg-primary-9 d-flex align-items-center justify-content-between">
        <h4 class="text-white-85 font-weight-normal">电子科技大学成都学院图书馆座位管理系统</h4>
        <p class="small"><a href="javascript:;" class="text-white-85">退出>></a></p>
    </div>
    <div class="row">
        <aside class="col-7">
            <div class="card">
                <div class="card-header bg-primary-9 d-flex align-items-center justify-content-between">
                    <h4 class="text-white-85 font-weight-normal">快速导航</h4>
                    <p class="small"><a href="javascript:;" class="text-white-85">MOVE>></a></p>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-sm-4 pr-0">
                            <a href="#">
                                <div class="card text-white bg-blue mb-3 shadow-1 h-100">
                                    <div class="card-body d-flex align-items-center justify-content-center">
                                        <div>
                                            <i
                                                    class="iconfont icon-idcard-fill d-block text-center font-size-64"></i>
                                            <h5 class="text-white">姓名：<span>明慧</span></h5>
                                            <h5 class="text-white">学号：<span>20131003605</span></h5>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="col-sm-3 pr-0">
                            <a href="#">
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
                                <div class="card text-white bg-orange mb-3 shadow-1">
                                    <div class="card-body d-flex align-items-center">
                                        <i
                                                class="iconfont icon-time-circle-fill d-block text-center font-size-64 mr-3"></i>
                                        <h5 class="text-white">预约记录</h5>
                                    </div>
                                </div>
                            </a>
                            <a href="#">
                                <div class="card text-white shadow-1 bg-magenta">
                                    <div class="card-body d-flex align-items-center">
                                        <i
                                                class="iconfont icon-detail-fill d-block text-center font-size-64 mr-3"></i>
                                        <h5 class="text-white">历史记录</h5>
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
                <div class="card-header bg-primary-9 d-flex align-items-center justify-content-between">
                    <h4 class="text-white-85 font-weight-normal">通知公告</h4>
                    <p class="small"><a href="javascript:;" class="text-white-85">MOVE>></a></p>
                </div>

                <div class="card-body">
                    <div class="row">
                        <div>
                            <ul data-titles="titles">
                                <li>图书馆开展第二场“知雅”对话图</li>
                                <li>部分学习平台汇总</li>
                                <li>图书馆开展第二场“知雅”对话图</li>
                                <li>部分学习平台汇总</li>
                                <li>图书馆开展第二场“知雅”对话图</li>

                                <!-- 这里放通知公告的标题 -->
                            </ul>
                        </div>
                    </div>
                    <div class="row">
                        <div>
                            <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
                                <ol class="carousel-indicators mb-0">
                                    <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
                                    <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
                                    <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
                                </ol>
                                <div class="carousel-inner">
                                    <div class="carousel-item active">
                                        <img src="${pageContext.request.contextPath}/image/index/img-1.jpg" class="d-block img-fluid h-100" alt="...">
                                        <div class="carousel-caption d-none d-md-block">
                                            <h5></h5>
                                        </div>
                                    </div>
                                    <div class="carousel-item">
                                        <img src="${pageContext.request.contextPath}/image/index/img-2.jpg" class="d-block img-fluid h-100" alt="...">
                                        <div class="carousel-caption d-none d-md-block">
                                            <h5></h5>
                                        </div>
                                    </div>
                                    <div class="carousel-item">
                                        <img src="${pageContext.request.contextPath}/image/index/img-3.jpg" class="d-block img-fluid h-100" alt="...">
                                        <div class="carousel-caption d-none d-md-block">
                                            <h5></h5>
                                        </div>
                                    </div>
                                </div>
                                <!-- <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
                                  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                  <span class="sr-only">Previous</span>
                                </a>
                                <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
                                  <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                  <span class="sr-only">Next</span>
                                </a> -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </aside>
    </div>
</section>

<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap-4.5.0-dist/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap-4.5.0-dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/axios.min.js"></script>
<script src="${pageContext.request.contextPath}/js/mock-min.js"></script>

<!-- mock假数据 -->

</body>
</html>
