(function () {
    angular.module("userModule", ["httpModule"]).service("userService", userService);

    function userService(http) {

        return {
            login: login
        };

        function login(username, password) {
            return http.post(function (options) {
                options.url = "/admin/login";
                options.data = {
                    username: username,
                    password: password
                }
            });
        }
    }
})();