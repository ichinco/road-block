/**
 * Created by IntelliJ IDEA.
 * User: denise
 * Date: 1/9/11
 * Time: 11:15 PM
 * To change this template use File | Settings | File Templates.
 */
package com.ichinco.road {
import com.ichinco.vehicle.Car;

public class RoadSource implements RoadSegment {

    private var _framesBetweenCars:int;
    private var framesSinceLastCar:int;
    private var exitingCars:Vector.<CarPosition>;

    public function set framesBetweenCars(value:int):void {
        _framesBetweenCars = value;
    }

    public function enter(c:CarPosition):void {
        exitingCars[exitingCars.length] = c;
    }

    public function getExitingCars():Vector.<CarPosition> {
        return this.exitingCars;
    }

    public function get length():int {
        return 0;
    }

    public function advance(seconds:int):void {
        exitingCars = new Vector.<CarPosition>();
        if (framesSinceLastCar >= _framesBetweenCars){
            //generate car and add to exiting cars
            this.exitingCars[exitingCars.length] = new CarPosition(new Car(4, 0, 6, 4));
            framesSinceLastCar = 0;
        } else {
            framesSinceLastCar += seconds;
        }
    }

    public function drawAt(x:int, y:int):void {
    }

    public function RoadSource() {
        this.framesSinceLastCar = 0;
    }
}
}
