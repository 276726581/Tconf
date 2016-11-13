(function () {
    angular.module("propsServiceModule", ["restModule"]).service("propsService", propsService);

    function propsService(rest) {

        return {
            getList: getList,
            getProps: getProps,
            getPropsMap: getPropsMap,
            addProps: addProps,
            updateProps: updateProps,
            deleteProps: deleteProps
        };

        function getList() {
            return rest.get(function (options) {
                options.url = "/props";
            });
        }

        function getProps(id) {
            return rest.get(function (options) {
                options.url = "/props/" + id;
            });
        }

        function getPropsMap(id) {
            return rest.get(function (options) {
                options.url = "/props/" + id + "/map";
            });
        }

        function addProps(name, content) {
            return rest.post(function (options) {
                options.url = "/props";
                options.data = {
                    name: name,
                    content: content
                }
            });
        }

        function updateProps(id, name, content) {
            return rest.put(function (options) {
                options.url = "/props/" + id;
                options.data = {
                    name: name,
                    content: content
                }
            });
        }

        function deleteProps(id) {
            return rest.del(function (options) {
                options.url = "/props/" + id
            });
        }
    }
})();