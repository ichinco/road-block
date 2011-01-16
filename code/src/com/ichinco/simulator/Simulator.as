/**
 * Created by IntelliJ IDEA.
 * User: denise
 * Date: 1/9/11
 * Time: 11:19 PM
 * To change this template use File | Settings | File Templates.
 */
package com.ichinco.simulator {
import com.ichinco.road.CarPosition;
import com.ichinco.road.OpenRoad;
import com.ichinco.road.RoadCollection;
import com.ichinco.road.RoadSegment;
import com.ichinco.road.RoadSink;
import com.ichinco.road.RoadSource;
import com.ichinco.vehicle.Car;

import flash.display.Sprite;

public class Simulator extends Sprite {

    private var roadSet:RoadCollection;
    private static var interval:int = 1;

    public function simulate():void{
        for(var i:int=0; i<roadSet.getNumberOfSegments(); i++){
            roadSet.getSegmentAt(i).advance(interval);
        }

        for (var j:int=0; j<roadSet.getNumberOfSegments()-1; j++){
            var exitingCars:Vector.<CarPosition> = roadSet.getSegmentAt(j).getExitingCars();
            var nextSegment:RoadSegment = roadSet.getSegmentAt(j+1);
            exitingCars.forEach(
                               function (car:CarPosition):void{
                                   nextSegment.enter(car);
                               }
                    );
        }

        roadSet.drawRoadSegments();
    }

    public function setup():void {
        var roadSource:RoadSource = new RoadSource();
        var roadSink:RoadSink = new RoadSink();
        var openRoad:OpenRoad = new OpenRoad(10,40);

        roadSet.appendRoadSegment(roadSource);
        roadSet.appendRoadSegment(openRoad);
        roadSet.appendRoadSegment(roadSink);

        roadSet.drawRoadSegments();
    }

    public function Simulator() {
        roadSet = new RoadCollection();
    }
}
}
