<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="app">
<head>
    <title>Tconf</title>
    <link type="text/css" rel="stylesheet" href="../../lib/css/normalize.css"/>
    <link type="text/css" rel="stylesheet" href="../../lib/css/bootstrap.css"/>
    <link type="text/css" rel="stylesheet" href="../../lib/css/bootstrap-theme.css"/>
    <script type="text/javascript" src="../../lib/js/jquery.js"></script>
    <script type="text/javascript" src="../../lib/js/bootstrap.js"></script>
    <script type="text/javascript" src="../../lib/js/angular/angular.js"></script>
</head>
<body ng-controller="ctrl">
<div>
    <form ng-submit="login()">
        <table>
            <tr>
                <td>用户名:</td>
                <td>
                    <input type="text" name="username" ng-model="username" placeholder="请输入帐号"/>
                </td>
            </tr>
            <tr>
                <td>密&nbsp;码:</td>
                <td>
                    <input type="password" name="password" ng-model="password" placeholder="请输入密码"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="登录"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
<script type="text/javascript">
    var app = angular.module("app", []);
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
    app.controller("ctrl", function ($scope, http, $window) {
        $scope.login = function () {
            http.request({
                method: "post",
                url: "/admin/login",
                data: {
                    username: $scope.username,
                    password: $scope.password
                }
            }, function (response) {
                $window.location = "/admin/admin.do";
            }, function (response) {
                alert(response.msg);
            });
        }
    });
</script>
</html>
