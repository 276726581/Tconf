<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <button type="button" class="btn" ng-click="edit(item)">编辑</button>
                <button type="button" class="btn" ng-click="delete(item)">删除</button>
            </td>
        </tr>
        </tbody>
    </table>
</div>
</body>
<script type="text/javascript">
    var app = angular.module("app", ["ui.bootstrap"]);
    app.factory("http", function ($http) {
        return {
            request: function (request, success, error) {
                $http(request).success(function (response) {
                    if (200 == response.status) {
                        success(response);
                    } else {
                        error(response);
                    }
                }).error(function () {
                    error({msg: "server error"});
                });
            }
        }
    });
    app.controller("ctrl", function ($scope, $uibModal, http) {
        $scope.init = function () {
            http.request({
                method: "get",
                url: "/props/list"
            }, function (response) {
                $scope.list = response.data;
            }, function (response) {
                alert(response.msg);
            });
        };
        $scope.edit = function (item, size) {
            var modalInstance = $uibModal.open({
                templateUrl: "/view/template/edit.html",
                controller: "editCtrl",
                size: size,
                resolve: {
                    items: function () {
                        return {
                            id: item.id
                        };
                    }
                }
            });
            modalInstance.result.then(function (it) {
                item.name = it.name;
            }, function () {

            });
        };
        $scope.delete = function (item) {
            http.request({
                method: "delete",
                url: "/props/" + item.id
            }, function (response) {
                $scope.list.splice($scope.list.indexOf(item), 1);
            }, function (response) {
                alert(response.msg);
            });
        };
    });
    app.controller("editCtrl", function ($scope, $uibModalInstance, items, http) {
        $scope.init = function () {
            http.request({
                method: "get",
                url: "/props/" + items.id
            }, function (response) {
                $scope.title = "编辑";
                $scope.name = response.data.name;
                $scope.props = response.data.properties;
            }, function (response) {
                alert(response.msg);
            });
        };
        $scope.save = function () {
            http.request({
                method: "put",
                url: "/props/" + items.id,
                data: {
                    name: $scope.name,
                    props: $scope.props
                }
            }, function (response) {
                var item = {name: $scope.name, props: $scope.props};
                $uibModalInstance.close(item);
            }, function (response) {
                alert(response.msg);
            });
        };
        $scope.cancel = function () {
            $uibModalInstance.dismiss();
        };
    });
</script>
</html>
