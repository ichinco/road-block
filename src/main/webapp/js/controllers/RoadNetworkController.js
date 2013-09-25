/**
 * Created with IntelliJ IDEA.
 * User: denise
 * Date: 9/19/13
 * Time: 2:55 PM
 * To change this template use File | Settings | File Templates.
 */

function RoadNetworkController($scope) {
    $scope.segments = [];
    $scope.gridSize = function(dimension) {
        return dimension * 50 + "px";
    }
}