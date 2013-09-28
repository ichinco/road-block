function RoadNetworkController($scope, editorService) {
    $scope.segments = [];
    $scope.gridSize = function(dimension) {
        return dimension * 25 + "px";
    };
    $scope.editSegment = function(segment) {
        editorService.set(segment);
        console.log(editorService.list());
    };
}