function EditorController($scope, editorService) {
    $scope.segmentTypes = [
        {name:"straight road", value:"straight_segment"},
        {name:"none", value:"empty_segment"},
        {name:"car source", value:"source"},
        {name:"car sink", value:"sink"}];
    $scope.directions = [
        {name:"up", value:"up"},
        {name:"down", value:"down"},
        {name:"left", value:"left"},
        {name:"right", value:"right"}
    ];
    $scope.segment = editorService.list;
    $scope.updateSegment = function() {
        console.log($scope.segment());
    }
}