function RoadNetworkController($scope, editorService) {
    $scope.segments = [];
    $scope.gridSize = function(dimension) {
        return dimension * 25 + "px";
    };
    $scope.editSegment = function(segment) {
        console.log(segment);
        editor.editingSegment = segment;
    };
}