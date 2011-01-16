/**
 * Created by IntelliJ IDEA.
 * User: denise
 * Date: 1/15/11
 * Time: 4:33 PM
 * To change this template use File | Settings | File Templates.
 */
package com.ichinco.road {
import flash.display.Sprite;

public class OpenRoad extends Sprite implements RoadSegment  {

    private var _length:int;
    private var width:int;
    private var cars:Vector.<CarPosition>;
    private var exitingCars:Vector.<CarPosition>;

    public function get length():int {
        return _length;
    }

    public function enter(c:CarPosition):void {
        cars[cars.length] = c;
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

    public function drawAt(x:int, y:int):void {
        this.graphics.lineStyle(2, 0x000000, 1);
        this.graphics.moveTo(x,y);
        this.graphics.lineTo(x,y+length);
        this.graphics.moveTo(x+width, y);
        this.graphics.lineTo(x+width, y+length);

        for (var car in cars){
            car.car.drawAt(width * .5, car.relativePositionY);
        }
    }

    public function OpenRoad(width:int, length:int) {
        cars = new Vector.<CarPosition>();
        this.width = width;
        this._length = length;
    }
}
}
