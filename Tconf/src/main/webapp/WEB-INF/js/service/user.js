(function () {
    angular.module("userServiceModule", ["restModule"]).service("userService", userService);

    function userService(rest) {

        return {
            login: login,
            getList: getList,
            updatePassWord: updatePassWord,
            addUser: addUser,
            deleteUser: deleteUser
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

        function getList() {
            return rest.get(function (options) {
                options.url = "/user";
                options.data = {}
            });
        }

        function updatePassWord(id) {
            return rest.put(function (options) {
                options.url = "/user/" + id;
                options.data = {}
            });
        }

        function addUser(username, password) {
            return rest.post(function (options) {
                options.url = "/user";
                options.data = {
                    username: username,
                    password: password
                }
            });
        }

        function deleteUser(id) {
            return rest.del(function (options) {
                options.url = "/user/" + id;
                options.data = {}
            });
        }
    }
})();