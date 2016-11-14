var app = angular.module("app", ["ngRoute", "ui.bootstrap", "propsServiceModule", "userServiceModule"]);
app.config(function ($routeProvider) {
    $routeProvider
        .when('/props', {
            templateUrl: "/template/props.html",
            controller: "propsCtrl"
        })
        .when('/user', {
            templateUrl: "/template/user.html",
            controller: "userCtrl"
        })
        .otherwise({
            redirectTo: '/props'
        });
});
app.controller("ctrl", function ($scope, $rootScope) {
    $rootScope.$on('$routeChangeSuccess', function (event, current, previous) {
        routeChanged(current.$$route.originalPath);
    });
    $scope.init = function () {
        $scope.groupItems = [{
            name: "配置管理",
            selected: false,
            link: "#/props"
        }, {
            name: "用户管理",
            selected: false,
            link: "#/user"
        }];
    };
    function routeChanged(path) {
        $scope.groupItems.forEach(function (it) {
            if (("#" + path) == it.link) {
                it.selected = true;
            } else {
                it.selected = false;
            }
        });
    };
});
app.controller("propsCtrl", function ($scope, $uibModal, propsService) {
    $scope.init = function () {
        propsService.getList().then(function (response) {
            $scope.list = response.data;
        }, function (response) {
            alert(response.msg);
        });
    };
    $scope.add = function (size) {
        var modalInstance = $uibModal.open({
            templateUrl: "/template/edit_props.html",
            controller: "addPropsCtrl",
            size: size,
            resolve: {
                items: function () {
                    return {};
                }
            }
        });
        modalInstance.result.then(function (it) {
            $scope.list.push(it);
        });
    };
    $scope.browse = function (item, size) {
        $uibModal.open({
            templateUrl: "/template/props_browse.html",
            controller: "browsePropsCtrl",
            size: size,
            resolve: {
                items: function () {
                    return {
                        id: item.id
                    };
                }
            }
        });
    };
    $scope.edit = function (item, size) {
        var modalInstance = $uibModal.open({
            templateUrl: "/template/edit_props.html",
            controller: "editPropsCtrl",
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
        });
    };
    $scope.delete = function (item) {
        propsService.deleteProps(item.id).then(function () {
            $scope.list.splice($scope.list.indexOf(item), 1);
        }, function (response) {
            alert(response.msg);
        });
    };

});
app.controller("userCtrl", function ($scope, $uibModal, userService) {
    $scope.init = function () {
        userService.getList().then(function (response) {
            $scope.list = response.data;
        }, function () {
            alert(response.msg);
        });
    };
    $scope.add = function (size) {
        var modalInstance = $uibModal.open({
            templateUrl: "/template/add_user.html",
            controller: "addUserCtrl",
            size: size,
            resolve: {
                items: function () {
                    return {};
                }
            }
        });
        modalInstance.result.then(function (it) {
            $scope.list.push(it);
        });
    };
    $scope.update = function (item, size) {
        var modalInstance = $uibModal.open({
            templateUrl: "/template/edit_user.html",
            controller: "editUserCtrl",
            size: size,
            resolve: {
                items: function () {
                    return {
                        id: item.id,
                        userName: item.userName
                    };
                }
            }
        });
        modalInstance.result.then(function (it) {
            $scope.list.push(it);
        });
    };
    $scope.delete = function (item) {
        userService.deleteUser(item.id).then(function () {
            $scope.list.splice($scope.list.indexOf(item), 1);
        }, function (response) {
            alert(response.msg);
        });
    };
});
app.controller("addUserCtrl", function ($scope, $uibModalInstance, items, userService) {
    $scope.init = function () {
        $scope.title = "增加用户";
    };
    $scope.save = function () {
        userService.addUser($scope.username, $scope.password).then(function (response) {
            var item = {id: response.data.id, userName: response.data.userName};
            $uibModalInstance.close(item);
        }, function (response) {
            alert(response.msg);
        });
    };
    $scope.cancel = function () {
        $uibModalInstance.dismiss();
    };
});
app.controller("editUserCtrl", function ($scope, $uibModalInstance, items, userService) {
    $scope.init = function () {
        $scope.title = "修改密码";
        $scope.username = items.userName;
    };
    $scope.update = function () {
        userService.updatePassWord(items.id, $scope.password).then(function (response) {
            var item = {id: items.id, userName: items.userName};
            $uibModalInstance.close(item);
        }, function (response) {
            alert(response.msg);
        });
    };
    $scope.cancel = function () {
        $uibModalInstance.dismiss();
    };
});
app.controller("browsePropsCtrl", function ($scope, $uibModalInstance, items, propsService) {
    $scope.init = function () {
        $scope.title = "浏览";
        propsService.getPropsMap(items.id).then(function (response) {
            $scope.name = response.data.name;
            $scope.props = response.data.props;
        }, function (response) {
            alert(response.msg);
        });
    };
    $scope.cancel = function () {
        $uibModalInstance.dismiss();
    };
});
app.controller("addPropsCtrl", function ($scope, $uibModalInstance, items, propsService) {
    $scope.init = function () {
        $scope.title = "增加";
    };
    $scope.save = function () {
        propsService.addProps($scope.name, $scope.props).then(function (response) {
            var item = response.data;
            $uibModalInstance.close(item);
        }, function (response) {
            alert(response.msg);
        });
    };
    $scope.cancel = function () {
        $uibModalInstance.dismiss();
    };
});
app.controller("editPropsCtrl", function ($scope, $uibModalInstance, items, propsService) {
    $scope.init = function () {
        $scope.title = "编辑";
        propsService.getProps(items.id).then(function (response) {
            $scope.id = items.id;
            $scope.name = response.data.name;
            $scope.props = response.data.content;
        }, function (response) {
            alert(response.msg);
        });
    };
    $scope.save = function () {
        propsService.updateProps($scope.id, $scope.name, $scope.props).then(function () {
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