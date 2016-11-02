(function () {
    angular.module("propsModule", ["httpModule"]).service("propsService", propsService);

    function propsService(http) {

        return {
            getList: getList,
            getConf: getConf,
            addConf: addConf,
            updateConf: updateConf,
            deleteConf: deleteConf
        };

        function getList() {
            return http.get(function (options) {
                options.url = "/props/list";
            });
        }

        function getConf(id) {
            return http.get(function (options) {
                options.url = "/props/" + id + "/map";
            });
        }

        function addConf(name, props) {
            return http.post(function (options) {
                options.url = "/props/add";
                options.data = {
                    name: name,
                    props: props
                }
            });
        }

        function updateConf(id, name, props) {
            return http.put(function (options) {
                options.url = "/props/" + id;
                options.data = {
                    name: name,
                    props: props
                }
            });
        }

        function deleteConf(id) {
            return http.del(function (options) {
                options.url = "/props/" + id
            });
        }
    }
})();