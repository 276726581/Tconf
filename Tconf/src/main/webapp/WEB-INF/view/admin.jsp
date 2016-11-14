<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html ng-app="app">
<head>
    <title>管理</title>
    <%--<link href="http://cdn.bootcss.com/normalize/5.0.0/normalize.min.css" rel="stylesheet">--%>
    <%--<link href="http://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">--%>
    <%--<link href="http://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" rel="stylesheet">--%>
    <%--<script src="http://cdn.bootcss.com/jquery/2.2.3/jquery.min.js"></script>--%>
    <%--<script src="http://cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>--%>
    <%--<script src="http://cdn.bootcss.com/angular.js/1.5.8/angular.min.js"></script>--%>
    <%--<script src="http://cdn.bootcss.com/angular-ui-bootstrap/2.2.0/ui-bootstrap-tpls.min.js"></script>--%>
    <link href="../lib/css/normalize.css" rel="stylesheet">
    <link href="../lib/css/bootstrap.css" rel="stylesheet">
    <link href="../lib/css/bootstrap-theme.css" rel="stylesheet">
    <script src="../lib/js/jquery.js"></script>
    <script src="../lib/js/bootstrap.js"></script>
    <script src="../lib/js/angular/angular.js"></script>
    <script src="../lib/js/angular/angular-route.js"></script>
    <script src="../lib/js/angular/angular-ui-bootstrap-tpls.js"></script>
    <style type="text/css">
        .main {
            padding-top: 30px;
        }

        .list-group {
            width: 150px;
        }
    </style>
</head>
<body ng-controller="ctrl" ng-init="init()">
<div class="container">
    <div class="main">
        <div class="row">
            <div class="col-md-2">
                <div class="list-group">
                    <a class="list-group-item" ng-cloak ng-repeat="item in groupItems"
                       ng-href="{{item.link}}" ng-class="{'active':item.selected}">
                        {{item.name}}
                    </a>
                </div>
            </div>
            <div class="col-md-10">
                <div ng-view=""></div>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript" src="../js/factory/http.js"></script>
<script type="text/javascript" src="../js/service/user.js"></script>
<script type="text/javascript" src="../js/service/props.js"></script>
<script type="text/javascript" src="../js/controller/admin.js"></script>
</html>
