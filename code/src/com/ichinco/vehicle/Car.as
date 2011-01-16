/**
 * Created by IntelliJ IDEA.
 * User: denise
 * Date: 1/9/11
 * Time: 10:57 PM
 * To change this template use File | Settings | File Templates.
 */
package com.ichinco.vehicle {
import flash.display.Sprite;

public class Car extends Sprite {

    private var speed:int;
    private var acceleration:int;

    private var _preferredSpeed:int;
    private var _maxAcceleration:int;
    private var _carWidth:int;
    private var _carLength:int;

    public function set preferredSpeed(value:int):void {
        _preferredSpeed = value;
    }

    public function set maxAcceleration(value:int):void {
        _maxAcceleration = value;
    }

    public function set carWidth(value:int):void {
        _carWidth = value;
    }

    public function set carLength(value:int):void {
        _carLength = value;
    }

    public function advanceBySeconds(deltaSeconds:int):int {
        this.speed = this._preferredSpeed;
        this.speed += this.acceleration * (deltaSeconds / 3600);
        return this.speed * (deltaSeconds / 3600);
    }

    public function drawAt(x:int, y:int):void{
        this.graphics.lineStyle(2, 0x000000, 1);
        var left:int = x-(this.width * .5);
        var right:int = x+(this.width * .5);
        var top:int = y+(this.height * .5);
        var bottom:int = y-(this.height * .5);

        this.graphics.moveTo(left, bottom);
        this.graphics.beginFill(0x000000);
        this.graphics.lineTo(left, top);
        this.graphics.lineTo(right, top);
        this.graphics.lineTo(right, bottom);
        this.graphics.lineTo(left, bottom);
    }

    public function Car(preferredSpeed:int, maxAcceleration:int, width:int, length:int) {
        this._preferredSpeed = preferredSpeed;
        this._maxAcceleration = maxAcceleration;
        this._carWidth = width;
        this._carLength = length;
    }
}
}
