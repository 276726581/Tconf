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
            }).error(function (response, status) {
                if (-1 != status) {
                    error({msg: "server error"});
                    console.log(response);
                }
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
    $scope.browse = function (item, size) {
        var modalInstance = $uibModal.open({
            templateUrl: "/view/template/browse.html",
            controller: "browseCtrl",
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

        }, function () {

        });
    };
    $scope.add = function (size) {
        var modalInstance = $uibModal.open({
            templateUrl: "/view/template/edit.html",
            controller: "addCtrl",
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
app.controller("browseCtrl", function ($scope, $uibModalInstance, items, http) {
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
app.controller("addCtrl", function ($scope, $uibModalInstance, items, http) {
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