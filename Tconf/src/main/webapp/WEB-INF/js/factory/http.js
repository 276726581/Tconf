(function () {
    angular.module("restModule", []).factory("rest", rest);

    function rest($http, $q) {

        return {
            setUnAuthHandler: setUnAuthHandler,
            request: request,
            get: get,
            post: post,
            put: put,
            del: del
        };

        var handler;

        function setUnAuthHandler(fn) {
            handler = fn;
        }

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
                } else if (401 == response.status) {
                    if (undefined != handler) {
                        handler();
                    }
                } else {
                    defer.reject(response);
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