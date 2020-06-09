<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑用户信息</title>
    <link href="favicon.ico" rel="shortcut icon" type="image/x-icon" />
    <meta charset="utf-8">
    <meta name="renderer" content="webkit" />
    <meta name="force-rendering" content="webkit" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="referrer" content="always">
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <script src="../../js/jquery-3.5.0.min.js"></script>
    <script src="../../js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript">

    </script>
</head>
<body class="bg-secondary">
<div class="container-fluid">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb bg-dark">
            <li class="breadcrumb-item"><a href="index.jsp">首页</a></li>
            <li class="breadcrumb-item active" aria-current="page">编辑用户</li>
        </ol>
    </nav>

    <div class="card text-center">
        <div class="card-header">
            <ul class="nav nav-pills card-header-pills">
                <li class="nav-item">
                    <a class="nav-link active" href="#">编辑用户信息</a>
                </li>
            </ul>
        </div>
        <div class="card-body">
            <form action="#" method="post">
                <div class="row">
                    <div class="col">
                        <img id="head" src="../../image/head-pic.jpg" width="120" height="120" class="rounded-circle" title="点击头像修改" />
                        <p>
                        <div class="input-group flex-nowrap d-none" id="head_file_div">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="addon-wrapping2">更新头像</span>
                            </div>
                            <input type="file" class="form-control-file ml-4 mt-1" id="head_file" />
                        </div>
                        </p>
                    </div>
                </div>


                <div class="row">
                    <div class="col-6">
                        <div class="input-group flex-nowrap">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><span style="color:red;">&nbsp;*&nbsp;</span>姓名</span>
                            </div>
                            <input type="text" class="form-control" placeholder="请输入姓名" style="width:140px;">
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="input-group flex-nowrap">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><span style="color:red;">&nbsp;*&nbsp;</span>学号</span>
                            </div>
                            <input type="text" class="form-control" placeholder="请输入学号" style="width:140px;">
                        </div>
                    </div>
                </div>

                <div class="row mt-4">
                    <div class="col-6">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><span style="color:red;">&nbsp;*&nbsp;</span>性别</span>
                            </div>
                            <select class="custom-select">
                                <option selected>请选择</option>
                                <option value="1">男</option>
                                <option value="2">女</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="input-group flex-nowrap">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><span style="color:red;">&nbsp;*&nbsp;</span>班级</span>
                            </div>
                            <input type="number" class="form-control" placeholder="请输入班级" style="width:140px;">
                        </div>
                    </div>
                </div>

                <div class="row mt-4">
                    <div class="col-6">
                        <div class="input-group flex-nowrap">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><span style="color:red;">&nbsp;*&nbsp;</span>手机</span>
                            </div>
                            <input type="text" class="form-control" placeholder="请输入手机号码" style="width:140px;">
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="input-group flex-nowrap">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><span style="color:red;">&nbsp;*&nbsp;</span>邮箱</span>
                            </div>
                            <input type="email" class="form-control" placeholder="请输入邮箱地址" style="width:140px;">
                        </div>
                    </div>
                </div>
                <!--<div class="row mt-4">
                    <div class="col-12">
                        <div class="input-group flex-nowrap">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><span style="color:red;">&nbsp;*&nbsp;</span>地址</span>
                            </div>
                            <input type="text" class="form-control" placeholder="请输入地址">
                        </div>
                    </div>
                </div>-->

                <p class="mt-4">
                    <button type="submit" class="btn btn-primary">提交</button>
                    <button type="button" class="btn btn-secondary">重置</button>
                </p>
            </form>
        </div>
    </div>
</div>

<script>
    $(function () {
        $("#head").on("click", function () {
            $("#head_file").click();
        });
        $("#head_file").on("change", function () {
            $("#head_file_div").removeClass("d-none");
        })
    })
</script>
</body>
</html>
