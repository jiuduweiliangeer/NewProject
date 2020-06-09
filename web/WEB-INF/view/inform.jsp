<%--
  Created by IntelliJ IDEA.
  User: x
  Date: 2020/6/9
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>首页</title>
    <link href="../../bootstrap-4.5.0-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../font/iconfont.css" rel="stylesheet">
    <link href="../../css/public.css" rel="stylesheet">
</head>
<body>
<section class="container-fluid">
    <a href="demojjj">回注册界面</a>
    <div class="row">
        <aside class="col-12">
            <div class="card">
                <div class="card-header bg-primary-9 d-flex align-items-center justify-content-between">
                    <h4 class="text-white-85 font-weight-normal">电子科技大学成都学院图书馆座位管理员管理系统</h4>
                    <p class="small"><a href="javascript:;" class="text-white-85">退出>></a></p>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-sm-4 pr-0">
                            <a href="#">
                                <div class="card text-white bg-orange mb-3 shadow-1 h-100">
                                    <div class="card-body d-flex align-items-center justify-content-center">
                                        <div>
                                            <i
                                                    class="iconfont icon-idcard-fill d-block text-center font-size-64"></i>
                                            <h5 class="text-white">姓名：<span>${requestScope.user.username}</span></h5>
                                            <h5 class="text-white">工号：<span>${requestScope.user.stuID}</span></h5>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="col-sm-3 pr-0">
                            <a href="#">
                                <div class="card text-white bg-magenta mb-3 shadow-1 h-100">
                                    <div class="card-body d-flex align-items-center justify-content-center">
                                        <div>
                                            <h5><a href="demothis/${username}" class="text-white">修改密码</a></h5>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="col-sm">
                            <a href="#">
                                <div class="card text-white bg-cyan mb-3 shadow-1">
                                    <div class="card-body d-flex align-items-center">
                                        <i
                                                class="iconfont icon-time-circle-fill d-block text-center font-size-64 mr-3"></i>
                                        <h5 class="text-white">用户管理</h5>
                                    </div>
                                </div>
                            </a>
                            <a href="#">
                                <div class="card text-white shadow-1 bg-blue">
                                    <div class="card-body d-flex align-items-center">
                                        <i
                                                class="iconfont icon-detail-fill d-block text-center font-size-64 mr-3"></i>
                                        <h5 class="text-white">座位管理</h5>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </aside>

    </div>
</section>

<script src="../../js/jquery.min.js"></script>
<script src="../../bootstrap-4.5.0-dist/js/bootstrap.bundle.min.js"></script>
<script src="../../bootstrap-4.5.0-dist/js/bootstrap.min.js"></script>
<script src="../../js/axios.min.js"></script>
<script src="../../js/mock-min.js"></script>

<!-- mock假数据 -->

</body>
</html>
