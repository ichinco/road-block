function EditorController($scope, editorService) {
    $scope.segment = editorService.editingSegment;
}