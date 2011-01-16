/**
 * Created by IntelliJ IDEA.
 * User: denise
 * Date: 1/15/11
 * Time: 4:33 PM
 * To change this template use File | Settings | File Templates.
 */
package com.ichinco.road {
public class OpenRoad implements RoadSegment {

    private var length:int;
    private var cars:Vector.<CarPosition>;
    private var exitingCars:Vector.<CarPosition>;

    public function enter(c:CarPosition):void {
        cars[length] = c;
        c.road = this;
        c.relativePositionY = 0;
    }

    public function getExitingCars():Vector.<CarPosition> {
        return exitingCars;
    }

    public function advance(seconds:int):void {
        exitingCars = new Vector.<CarPosition>();
        for (var car in cars){
            car.relativePositionY = car.car.advanceBySeconds(seconds);
            if (car.relativePositionY > this.length) {
                exitingCars[exitingCars.length] = car;
            }
        }
    }

    public function OpenRoad() {
        cars = new Vector.<CarPosition>();
    }

}
}
