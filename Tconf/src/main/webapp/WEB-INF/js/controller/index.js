angular.module("app", ["userModule"]).controller("ctrl", indexController);

function indexController($scope, $window, rest, userService) {
    rest.setUnAuthHandler(function () {
        console.log("未认证");
    });

    $scope.login = function () {
        userService.login($scope.username, $scope.password).then(function () {
            $window.location = "/admin/admin.do";
        }, function (error) {
            alert(error.msg);
        });
    }
}