<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>座位管理</title>
    <link href="${pageContext.request.contextPath}/bootstrap-4.5.0-dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-table-master/dist/bootstrap-table.min.css">
    <link href="${pageContext.request.contextPath}/font/iconfont.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/public.css" rel="stylesheet">
</head>

<body background="${pageContext.request.contextPath}/image/back.jpg" style="background-size: 100%;">
<section class="container-fluid">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb bg-dark">
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/viewmore/${username}">首页</a></li>
            <li class="breadcrumb-item active" aria-current="page">座位管理</li>
        </ol>
    </nav>
    <div class="mt-4">
        <form>
            <div class="row">
                <div class="col d-flex align-items-center">
                    <span class="text-nowrap mr-2">状态</span>
                    <select class="form-control" id="state" name="state">
                        <option>请选择</option>
                        <option>空闲中</option>
                        <option>维修中</option>
                    </select>
                </div>
                
                <div class="col d-flex align-items-center">
                    <span class="text-nowrap mr-2">座号</span>
                    <input type="text" class="form-control" id="seat-no">
                </div>
                <div class="col">
                    <div class="text-right">
                        <button class="btn btn-primary mr-3">查询</button>
                        <button class="btn btn-secondary" type="reset">重置</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
</section>
<section class="container-fluid mt-4">
    <div>
        <a href="${pageContext.request.contextPath}/addseat/${username}"><button class="btn btn-primary">添加座位</button></a></div>
    <table class="table table-striped table-dark mt-4" id="table" style="background: rgba(0,0,0,0.2);">
        <thead>
        <tr>
            <th scope="col" data-field="seatno">座位号</th>
            <th scope="col" data-field="state">状态</th>
            <th scope="col" data-field="operate">
                操作</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${!empty seats}">
            <c:forEach items="${seats}" var="seat">
                <tr>
                    <td>${seat.location}</td>
                    <td>${seat.state}</td>
                    <td>
                        <input type="button" value="维修" class="btn btn-danger btn-sm ml-2">
                        <input type="button" value="删除" class="btn btn-danger btn-sm ml-2">
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>
</section>

<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap-4.5.0-dist/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap-4.5.0-dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/axios.min.js"></script>
<script src="${pageContext.request.contextPath}/js/mock-min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap-table-master/dist/bootstrap-table.min.js"></script>
<script src=".${pageContext.request.contextPath}/bootstrap-table-master/dist/locale/bootstrap-table-zh-CN.min.js"></script>
<script>
    var $table = $('#table')

    function operateFormatter(value, row, index) {
        return [
            '<button class="btn btn-sm btn-warning text-white mr-2">维修</button>',
            '<button class="btn btn-sm btn-success text-white">编辑</button>'
        ].join('')
    }
    // mock假数据
    var datas = Mock.mock('https://www.test.com', {
        "info|30": [{
            "id|+1": 1,
            "date|1": '@datetime("yyyy-MM-dd HH:mm:ss")',
            "seatno|1-30": 30,
            "buildingno|1-4": 4,
            "floorno|1-9": 9,
            "roomno|101-310": 310,
            "grade|1-5": 5,
            "color|1": ["奶黄色", "米黄色", "粉红色", "蓝色"],
            "state|1": ["空闲中", "维修中"]
        }]
    });

    $.get('https://www.test.com', function (data) {
        var dataall=JSON.parse(data).info;
        console.log(dataall);
    });

</script>
</body>


</html>