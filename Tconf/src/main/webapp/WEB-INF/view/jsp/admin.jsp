<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html ng-app="app">
<head>
    <title>管理</title>
    <link type="text/css" rel="stylesheet" href="../../lib/css/normalize.css"/>
    <link type="text/css" rel="stylesheet" href="../../lib/css/bootstrap.css"/>
    <link type="text/css" rel="stylesheet" href="../../lib/css/bootstrap-theme.css"/>
    <script type="text/javascript" src="../../lib/js/jquery.js"></script>
    <script type="text/javascript" src="../../lib/js/bootstrap.js"></script>
    <script type="text/javascript" src="../../lib/js/angular/angular.js"></script>
    <script type="text/javascript" src="../../lib/js/angular/angular-ui-bootstrap-tpls.js"></script>
    <style type="text/css">
        tr td {
            padding: 5px;
        }
    </style>
</head>
<body ng-controller="ctrl" ng-init="init()">
<div class="container">
    <button type="button" class="btn" ng-click="add()">增加</button>
    <table border="1" cellpadding="10px">
        <thead>
        <tr>
            <th>名称</th>
            <th>UUID</th>
            <th>管理</th>
        </tr>
        </thead>
        <tbody>
        <tr ng-cloak ng-repeat="item in list">
            <td>{{item.name}}</td>
            <td>{{item.uuid}}</td>
            <td>
                <button type="button" class="btn" ng-click="browse(item)">浏览</button>
                <button type="button" class="btn" ng-click="edit(item)">编辑</button>
                <button type="button" class="btn" ng-click="delete(item)">删除</button>
            </td>
        </tr>
        </tbody>
    </table>
</div>
</body>
<script type="text/javascript" src="../../js/admin.js"></script>
</html>
