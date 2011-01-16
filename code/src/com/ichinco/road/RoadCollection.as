/**
 * Created by IntelliJ IDEA.
 * User: denise
 * Date: 1/15/11
 * Time: 4:39 PM
 * To change this template use File | Settings | File Templates.
 */
package com.ichinco.road {
public class RoadCollection {

    private var segments:Vector.<RoadSegment>;

    public function addRoadSegmentAt(index:int, road:RoadSegment){
        segments[index] = road;
    }

    public function appendRoadSegment(road:RoadSegment){
        segments[segments.length] = road;
    }

    public function getSegmentAt(index:int):RoadSegment{
        return segments[index];
    }

    public function getNumberOfSegments():int{
        return segments.length;
    }

    public function drawRoadSegments():void{
        var x:int = 10;
        var y:int = 10;
        for (var segment in segments){
            segment.drawAt(x, y);
            y += segment.length;
        }
    }

    public function RoadCollection() {
        segments = new Vector.<RoadSegment>();
    }
}
}
