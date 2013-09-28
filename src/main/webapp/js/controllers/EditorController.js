function EditorController($scope, editorService) {
    $scope.segment = editorService.list;
}