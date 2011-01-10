/**
 * Created by IntelliJ IDEA.
 * User: denise
 * Date: 1/9/11
 * Time: 10:57 PM
 * To change this template use File | Settings | File Templates.
 */
package com.ichinco.vehicle {
public class Car {

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
        this.speed += this.acceleration * (deltaSeconds / 3600);
        return this.speed * (deltaSeconds / 3600);
    }

    public function Car() {
    }
}
}
