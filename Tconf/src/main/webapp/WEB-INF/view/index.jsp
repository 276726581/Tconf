<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html ng-app="app">
<head>
    <title>Tconf</title>
    <link href="http://cdn.bootcss.com/normalize/5.0.0/normalize.min.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" rel="stylesheet">
    <script src="http://cdn.bootcss.com/jquery/2.2.3/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="http://cdn.bootcss.com/angular.js/1.5.8/angular.min.js"></script>
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
<script type="text/javascript" src="../js/factory/http.js"></script>
<script type="text/javascript" src="../js/service/user.js"></script>
<script type="text/javascript" src="../js/controller/index.js"></script>
</html>
