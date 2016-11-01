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

        .list-group {
            width: 150px;
        }
    </style>
</head>
<body ng-controller="ctrl" ng-init="init()">
<div class="container">
    <div class="row">
        <div class="col-md-4">
            <div class="list-group">
                <a class="list-group-item" ng-cloak ng-repeat="item in groupItems"
                   href="#" ng-class="{'active':item.selected}" ng-click="groupItemChanged(item)">
                    {{item.name}}
                </a>
            </div>
        </div>
        <div class="col-md-8" ng-cloak>
            <div ng-class="{'hidden':confHidden}" ng-controller="confCtrl">
                <button type="button" class="btn" ng-click="add()">增加配置</button>
                <table class="table">
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
            <div ng-class="{'hidden':userHidden}" ng-controller="userCtrl">
                <button type="button" class="btn" ng-click="add()">增加用户</button>
                <table class="table">
                    <thead>
                    <tr>
                        <th>用户名</th>
                        <th>管理</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-cloak ng-repeat="item in list">
                        <td>{{item.name}}</td>
                        <td>
                            <button type="button" class="btn" ng-click="update(item)">修改密码</button>
                            <button type="button" class="btn" ng-click="delete(item)">删除</button>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="../../js/admin.js"></script>
</html>
