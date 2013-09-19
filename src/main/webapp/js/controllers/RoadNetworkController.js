/**
 * Created with IntelliJ IDEA.
 * User: denise
 * Date: 9/19/13
 * Time: 2:55 PM
 * To change this template use File | Settings | File Templates.
 */

function RoadNetworkController($scope) {
    var height = 50;
    var width = 50;

    $scope.segments = [
        {type: "straight-segment", x: 0, y: 0, left:false, right: false, top: false, bottom: true},
        {type: "straight-segment", x: 0, y: 1, left:false, right: false, top: true, bottom: true},
        {type: "straight-segment", x: 0, y: 2, left:false, right: false, top: true, bottom: true},
        {type: "straight-segment", x: 0, y: 3, left:false, right: false, top: true, bottom: true},
        {type: "straight-segment", x: 0, y: 4, left:false, right: false, top: true, bottom: true},
        {type: "straight-segment", x: 0, y: 5, left:false, right: false, top: true, bottom: true},
        {type: "straight-segment", x: 0, y: 6, left:false, right: false, top: true, bottom: true},
        {type: "straight-segment", x: 0, y: 7, left:false, right: false, top: true, bottom: false}
    ];
}