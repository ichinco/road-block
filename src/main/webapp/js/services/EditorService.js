var module = angular.module("road-block", []);
module.factory("editorService",
    function(){
        return {
            editingSegment : null
        }
    }
);