var app = angular.module("app", ["ui.bootstrap", "userModule", "configModule"]);
app.controller("ctrl", function ($scope, userService, configService) {

    $scope.init = function () {
        $scope.groupItems = [{name: "配置管理", selected: true, index: 0}, {name: "用户管理", selected: false, index: 1}];
        $scope.confHidden = false;
        $scope.userHidden = true;

        configService.getList().then(function (response) {
            $scope.list = response.data;
        }, function () {
            alert(response.msg);
        });
    };

    $scope.groupItemChanged = function (item) {
        $scope.groupItems.forEach(function (it) {
            if (item == it) {
                it.selected = true;
            } else {
                it.selected = false;
            }
        });
        if (item.index == 0) {
            $scope.confHidden = false;
            $scope.userHidden = true;
        } else if (item.index == 1) {
            $scope.confHidden = true;
            $scope.userHidden = false;
        }
    };
});
app.controller("confCtrl", function ($scope, $uibModal, http) {
    $scope.browse = function (item, size) {
        $uibModal.open({
            templateUrl: "/template/browse.html",
            controller: "browseConfCtrl",
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
    $scope.add = function (size) {
        var modalInstance = $uibModal.open({
            templateUrl: "/template/edit.html",
            controller: "addConfCtrl",
            size: size,
            resolve: {
                items: function () {
                    return {};
                }
            }
        });
        modalInstance.result.then(function (it) {
            $scope.list.push(it);
        }, function () {

        });
    };
    $scope.edit = function (item, size) {
        var modalInstance = $uibModal.open({
            templateUrl: "/template/edit.html",
            controller: "editConfCtrl",
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
app.controller("userCtrl", function ($scope, $uibModal, http) {
    $scope.list = [];
    $scope.add = function (size) {
        var modalInstance = $uibModal.open({
            templateUrl: "/template/adduser.html",
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
        }, function () {

        });
    };
});
app.controller("addUserCtrl", function ($scope, $uibModalInstance, items, http) {
    $scope.save = function () {
        $scope.title = "增加用户";
        http.request({
            method: "get",
            url: "/props/" + items.id + "/map"
        }, function (response) {
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
app.controller("browseConfCtrl", function ($scope, $uibModalInstance, items, http) {
    $scope.init = function () {
        $scope.title = "浏览";
        http.request({
            method: "get",
            url: "/props/" + items.id + "/map"
        }, function (response) {
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
app.controller("addConfCtrl", function ($scope, $uibModalInstance, items, http) {
    $scope.init = function () {
        $scope.title = "增加";
    };
    $scope.save = function () {
        http.request({
            method: "post",
            url: "/props/add",
            data: {
                name: $scope.name,
                props: $scope.props
            }
        }, function (response) {
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
app.controller("editConfCtrl", function ($scope, $uibModalInstance, items, http) {
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