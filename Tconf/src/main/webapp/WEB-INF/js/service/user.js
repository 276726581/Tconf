(function () {
    angular.module("userModule", ["restModule"]).service("userService", userService);

    function userService(rest) {

        return {
            login: login
        };

        function login(username, password) {
            return rest.post(function (options) {
                options.url = "/admin/login";
                options.data = {
                    username: username,
                    password: password
                }
            });
        }
    }
})();