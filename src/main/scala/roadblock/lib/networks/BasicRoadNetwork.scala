package roadblock.lib.networks

import roadblock.lib.interfaces.{RoadSegment, RoadNetwork}
import roadblock.lib.segments.{StraightSegment, SegmentState}

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

  def updateSegment(segmentState : SegmentState) {
    var segmentToRemove : RoadSegment = null
    var newSegment : RoadSegment = null
    segments.foreach(
      segment => {
        if (segment.x.equals(segmentState.x) &&
            segment.y.equals(segmentState.y)) {
          segmentToRemove = segment
          newSegment = new StraightSegment()
          newSegment.x = segmentState.x
          newSegment.y = segmentState.y
          newSegment.leftSideNeighbor = segmentToRemove.leftSideNeighbor
          newSegment.rightSideNeighbor = segmentToRemove.rightSideNeighbor
          newSegment.frontNeighbor = segmentToRemove.frontNeighbor
          newSegment.backNeighbor = segmentToRemove.backNeighbor
          newSegment.leftSideNeighbor.rightSideNeighbor = newSegment
          newSegment.rightSideNeighbor.leftSideNeighbor = newSegment
          newSegment.frontNeighbor.backNeighbor = newSegment
          newSegment.backNeighbor.frontNeighbor = newSegment
        }
      }
    )
    segments =  segments diff Seq(segmentToRemove)
    newSegment +: segments
  }

}
