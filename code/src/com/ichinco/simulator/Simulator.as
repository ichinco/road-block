/**
 * Created by IntelliJ IDEA.
 * User: denise
 * Date: 1/9/11
 * Time: 11:19 PM
 * To change this template use File | Settings | File Templates.
 */
package com.ichinco.simulator {
import com.ichinco.road.CarPosition;
import com.ichinco.road.RoadCollection;
import com.ichinco.road.RoadSegment;
import com.ichinco.vehicle.Car;

public class Simulator {

    private var roadSet:RoadCollection;
    private static var interval:int = 1;

    public function simulate(){
        for(var i=0; i<roadSet.getNumberOfSegments(); i++){
            roadSet.getSegmentAt(i).advance(interval);
        }

        for (var i=0; i<roadSet.getNumberOfSegments()-1; i++){
            var exitingCars:Vector.<CarPosition> = roadSet.getSegmentAt(i).getExitingCars();
            var nextSegment:RoadSegment = roadSet.getSegmentAt(i+1);
            for (var car in exitingCars){
                nextSegment.enter(car);
            }
        }
    }

    public function Simulator() {
    }
}
}
