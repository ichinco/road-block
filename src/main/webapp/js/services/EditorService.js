var module = angular.module("road-block", []);
module.factory("editorService",
    function(){
        var editingSegment = null;
        var editorService = {};

        editorService.set = function(item) {
            editingSegment = item;
        };
        editorService.list = function() {
            return editingSegment;
        };

        return editorService;
    }
);