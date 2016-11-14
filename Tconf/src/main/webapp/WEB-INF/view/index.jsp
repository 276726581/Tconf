<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html ng-app="app">
<head>
    <title>Tconf</title>
    <%--<link href="http://cdn.bootcss.com/normalize/5.0.0/normalize.min.css" rel="stylesheet">--%>
    <%--<link href="http://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">--%>
    <%--<link href="http://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" rel="stylesheet">--%>
    <%--<script src="http://cdn.bootcss.com/jquery/2.2.3/jquery.min.js"></script>--%>
    <%--<script src="http://cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>--%>
    <%--<script src="http://cdn.bootcss.com/angular.js/1.5.8/angular.min.js"></script>--%>
    <link href="../lib/css/normalize.css" rel="stylesheet">
    <link href="../lib/css/bootstrap.css" rel="stylesheet">
    <link href="../lib/css/bootstrap-theme.css" rel="stylesheet">
    <script src="../lib/js/jquery.js"></script>
    <script src="../lib/js/bootstrap.js"></script>
    <script src="../lib/js/angular/angular.js"></script>
    <style type="text/css">
        .margin-top {
            margin-top: 20px;
        }

        .form-top {
            margin-top: 200px;
        }
    </style>
</head>
<body ng-controller="ctrl">
<div class="container">
    <div class="row">
        <div class="col-md-offset-4 col-md-4">
            <form class="form-top" ng-submit="login()">
                <div class="row margin-top">
                    <label class="control-label">用户名:</label>
                    <input type="text" class="form-control" name="username" ng-model="username"
                           placeholder="请输入帐号"/>
                </div>
                <div class="row margin-top">
                    <label class="control-label">密码:</label>
                    <input type="password" class="form-control" name="password" ng-model="password"
                           placeholder="请输入密码"/>
                </div>
                <div class="row margin-top">
                    <input type="submit" class="form-control btn btn-primary" value="登录"/>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="../js/factory/http.js"></script>
<script type="text/javascript" src="../js/service/user.js"></script>
<script type="text/javascript" src="../js/controller/index.js"></script>
</html>
