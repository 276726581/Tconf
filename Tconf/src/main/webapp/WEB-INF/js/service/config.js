(function () {
    angular.module("configModule", ["restModule"]).service("configService", configService);

    function configService(rest) {

        return {
            getList: getList,
            getConfig: getConfig,
            addConfig: addConfig,
            updateConfig: updateConfig,
            deleteConfig: deleteConfig
        };

        function getList() {
            return rest.get(function (options) {
                options.url = "/config";
            });
        }

        function getConfig(id) {
            return rest.get(function (options) {
                options.url = "/config/" + id + "/map";
            });
        }

        function addConfig(name, props) {
            return rest.post(function (options) {
                options.url = "/config";
                options.data = {
                    name: name,
                    props: props
                }
            });
        }

        function updateConfig(id, name, props) {
            return rest.put(function (options) {
                options.url = "/config/" + id;
                options.data = {
                    name: name,
                    props: props
                }
            });
        }

        function deleteConfig(id) {
            return rest.del(function (options) {
                options.url = "/config/" + id
            });
        }
    }
})();