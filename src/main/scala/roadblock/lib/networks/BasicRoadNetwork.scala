package roadblock.lib.networks

import roadblock.lib.interfaces.{RoadSegment, RoadNetwork}
import roadblock.lib.segments._

/**
 * User: denise
 * Date: 9/24/13
 * Time: 1:13 PM
 */
class BasicRoadNetwork extends RoadNetwork {

  var segments :Seq[RoadSegment] = Seq.empty

  def getForwardSegment(segment: RoadSegment, i : Integer) : RoadSegment = {
    var localSegment : RoadSegment = segment
    (0 until i).foreach(
      (i : Int) => {
        if (localSegment != null) {
          localSegment = localSegment.frontNeighbor
        }
      }
    )

    localSegment
  }
  def getBackwardSegment(segment: RoadSegment, i : Integer) : RoadSegment = {
    var localSegment : RoadSegment = segment
    (0 until i).foreach(
      (i : Int) => {
        if (localSegment != null) {
          localSegment = localSegment.backNeighbor
        }
      }
    )

    localSegment
  }
  def getLeftwardSegment(segment: RoadSegment, i : Integer) : RoadSegment = {
    var localSegment : RoadSegment = segment
    (0 until i).foreach(
      (i : Int) => {
        if (localSegment != null) {
          localSegment = localSegment.leftSideNeighbor
        }
      }
    )

    localSegment
  }
  def getRightwardSegment(segment: RoadSegment, i : Integer) : RoadSegment = {
    var localSegment : RoadSegment = segment
    (0 until i).foreach(
      (i : Int) => {
        if (localSegment != null) {
          localSegment = localSegment.rightSideNeighbor
        }
      }
    )

    localSegment
  }

  def getSegmentByCoordinates(x:Int, y:Int):RoadSegment = {
    val matchingSegments = segments.filter((s : RoadSegment) => {
      s.x.equals(x) && s.y.equals(y)
    })

    if (matchingSegments.size > 0){
      matchingSegments(0)
    } else {
      new NullSegment()
    }
  }

  def updateSegment(segmentState : SegmentState) {
    val oldSegment = getSegmentByCoordinates(segmentState.x, segmentState.y)
    var newSegment : RoadSegment = new NullSegment()
    if (segmentState.segmentType == 'straight_segment) {
      newSegment = new StraightSegment()
    } else if (segmentState.segmentType == 'source) {
      newSegment = new CarSource(3)
    } else if (segmentState.segmentType == 'sink) {
      newSegment = new CarSink()
    } else if (segmentState.segmentType == 'intersection) {
      newSegment = new Intersection()
    }
    newSegment.x = segmentState.x
    newSegment.y = segmentState.y
    if (segmentState.direction == 'left){
      newSegment.frontNeighbor = getSegmentByCoordinates(segmentState.x-1, segmentState.y)
      newSegment.backNeighbor = getSegmentByCoordinates(segmentState.x+1, segmentState.y)
      newSegment.leftSideNeighbor = getSegmentByCoordinates(segmentState.x, segmentState.y-1)
      newSegment.rightSideNeighbor = getSegmentByCoordinates(segmentState.x, segmentState.y+1)
    } else if (segmentState.direction == 'right) {
      newSegment.frontNeighbor = getSegmentByCoordinates(segmentState.x+1, segmentState.y)
      newSegment.backNeighbor = getSegmentByCoordinates(segmentState.x-1, segmentState.y)
      newSegment.leftSideNeighbor = getSegmentByCoordinates(segmentState.x, segmentState.y+1)
      newSegment.rightSideNeighbor = getSegmentByCoordinates(segmentState.x, segmentState.y-1)
    } else if (segmentState.direction == 'up) {
      newSegment.frontNeighbor = getSegmentByCoordinates(segmentState.x, segmentState.y-1)
      newSegment.backNeighbor = getSegmentByCoordinates(segmentState.x, segmentState.y+1)
      newSegment.leftSideNeighbor = getSegmentByCoordinates(segmentState.x-1, segmentState.y)
      newSegment.rightSideNeighbor = getSegmentByCoordinates(segmentState.x+1, segmentState.y)
    }else if (segmentState.direction == 'down) {
      newSegment.frontNeighbor = getSegmentByCoordinates(segmentState.x, segmentState.y+1)
      newSegment.backNeighbor = getSegmentByCoordinates(segmentState.x, segmentState.y-1)
      newSegment.leftSideNeighbor = getSegmentByCoordinates(segmentState.x+1, segmentState.y)
      newSegment.rightSideNeighbor = getSegmentByCoordinates(segmentState.x-1, segmentState.y)
    }
    newSegment.leftSideNeighbor.rightSideNeighbor = newSegment
    newSegment.rightSideNeighbor.leftSideNeighbor = newSegment
    newSegment.frontNeighbor.backNeighbor = newSegment
    newSegment.backNeighbor.frontNeighbor = newSegment
    newSegment.initializeState()
    segments =  segments diff Seq(oldSegment)
    segments = newSegment +: segments
    segments
  }

}
