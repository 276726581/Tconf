(function () {
    angular.module("httpModule", []).factory("http", http);

    function http($http, $q) {

        return {
            request: request,
            get: get,
            post: post,
            put: put,
            del: del
        };

        function request(req) {
            var options = {};
            req(options);

            var defer = $q.defer();
            $http({
                method: options.method,
                url: options.url,
                params: options.params,
                data: options.data
            }).success(function (response) {
                if (200 == response.status) {
                    defer.resolve(response);
                } else {
                    defer.reject(error);
                }
            }).error(function (response, status) {
                console.log(response);
                if (-1 != status) {
                    defer.reject({msg: "server error"});
                }
            });

            return defer.promise;
        }

        function get(req) {
            return request(function (options) {
                req(options);
                options.method = "GET";
            });
        }

        function post(req) {
            return request(function (options) {
                req(options);
                options.method = "POST";
            });
        }

        function put(req) {
            return request(function (options) {
                req(options);
                options.method = "PUT";
            });
        }

        function del(req) {
            return request(function (options) {
                req(options);
                options.method = "DELETE";
            });
        }
    }
})();