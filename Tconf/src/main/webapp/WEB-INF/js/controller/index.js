angular.module("app", ["userModule"]).controller("ctrl", indexController);

function indexController($scope, $window, userService) {

    $scope.login = function () {
        userService.login($scope.username, $scope.password).then(function () {
            $window.location = "/admin/admin.do";
        }, function (error) {
            alert(error.msg);
        });
    }
}