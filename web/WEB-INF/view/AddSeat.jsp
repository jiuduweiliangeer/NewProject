<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta class="viewport" content="width=device-width, initial-scale=1">
    <title>添加座位</title>
    <link href="code/css/bootstrap.min.css" rel="stylesheet">
    <script src="code/js/jquery-3.2.1.min.js"></script>
    <script src="code/js/bootstrap.min.js"></script>
</head>
<style>
    body{
        margin: 0;
        padding: 0;
        font-family: sans-serif;
        background-size: cover;
    }
    .box{
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%,-50%);
        width: 400px;
        padding: 40px;
        background: rgba(0,0,0,.8);
        box-sizing: border-box;
        box-shadow: 0 15px 25px rgba(0,0,0,.5);
        border-radius: 10px;
    }
    .box h2{
        margin: 0 0 30px;
        padding: 0;
        color: #fff;
        text-align: center;
    }
    .box .inputBox{
        position: relative;
    }
    .box .inputBox input{
        width: 100%;
        padding: 10px 0;
        font-size: 16px;
        color: #fff;
        margin-bottom: 30px;
        border: none;
        border-bottom: 1px solid #fff;
        outline: none;
        background: transparent;
    }
    .box .inputBox p{

        width: 100%;
        padding: 10px 0;
        font-size: 16px;
        color: #fff;
        margin-bottom: 30px;
        border: none;
        border-bottom: 1px solid #fff;
        outline: none;
        background: transparent;
    }
    /*    .box .inputBox lable{
            position: absolute;
            top: 0;
            left: 0;
            padding: 10px 0;
            font-size: 16px;
            color: #fff;
            pointer-events: none;
            transition: .5s;
        }*/
    /*    .box input[type="submit"]{
            background: transparent;
            border: none;
            outline: none;
            color: #fff;
            background: #03a9f4;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 5px;
        }*/
    .submit{
        background: transparent;
        border: none;
        outline: none;
        color: #fff;
        background: #03a9f4;
        padding: 10px 20px;
        cursor: pointer;
        border-radius: 5px;

    }/*
    .box input[type="button"]{
        background: transparent;
        border: none;
        outline: none;
        color: #fff;
        background: #03a9f4;
        padding: 10px 20px;
        cursor: pointer;
        border-radius: 5px;
        margin-left:123px;
    }*/
    .register{
        background: transparent;
        border: none;
        outline: none;
        color: #fff;
        background: #03a9f4;
        padding: 10px 20px;
        cursor: pointer;
        border-radius: 5px;
        float: right;
    }
    .red{
        color: red;
    }
</style>
<body background="${pageContext.request.contextPath}/image/Login1.jpg">
<div class="box">
    <h2>AddSeat</h2>
    <form action="${pageContext.request.contextPath}/seatadd/${username}" method="post">
        <div class="inputBox">
            <input type="text" name="location" required="" placeholder="location">
        </div>

        <input type="submit" name="" value="add" id="submit" class="submit">
        <a href="${pageContext.request.contextPath}/seatjsp/${username}">
            <input type="button" value="return" class="register">
        </a>
    </form>
</div>
</body>
<script>

</script>