/**
 * Created by IntelliJ IDEA.
 * User: denise
 * Date: 1/9/11
 * Time: 11:13 PM
 * To change this template use File | Settings | File Templates.
 */
package com.ichinco.road {
public interface RoadSegment {

    function enter(c:CarPosition):void;
    function getExitingCars():Vector.<CarPosition>;
    function advance(seconds:int):void;
    function drawAt(x:int, y:int):void;
    function getLength():int;

}
}
