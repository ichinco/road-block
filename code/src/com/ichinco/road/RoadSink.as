/**
 * Created by IntelliJ IDEA.
 * User: denise
 * Date: 1/9/11
 * Time: 11:15 PM
 * To change this template use File | Settings | File Templates.
 */
package com.ichinco.road {
public class RoadSink implements RoadSegment {

    public function get length():int {
        return 0;
    }

    public function enter(c:CarPosition):void {
    }

    public function getExitingCars():Vector.<CarPosition> {
        return new Vector.<CarPosition>();
    }

    public function advance(seconds:int):void {
    }

    public function drawAt(x:int, y:int):void {
    }

    public function RoadSink() {
    }
}
}
