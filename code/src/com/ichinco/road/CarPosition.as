/**
 * Created by IntelliJ IDEA.
 * User: denise
 * Date: 1/15/11
 * Time: 5:43 PM
 * To change this template use File | Settings | File Templates.
 */
package com.ichinco.road {
import com.ichinco.vehicle.Car;

public class CarPosition {

    private var _car:Car;
    private var _road:RoadSegment;
    private var _relativePositionY:int;

    public function get car():Car {
        return _car;
    }

    public function set car(value:Car):void {
        _car = value;
    }

    public function get road():RoadSegment {
        return _road;
    }

    public function set road(value:RoadSegment):void {
        _road = value;
    }

    public function get relativePositionY():int {
        return _relativePositionY;
    }

    public function set relativePositionY(value:int):void {
        _relativePositionY = value;
    }

    public function CarPosition(car:Car) {
        this._car = car;
    }
}
}
