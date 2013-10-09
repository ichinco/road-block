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
    val oldSegments = segments.filter((s : RoadSegment) => {
      s.x.equals(segmentState.x) && s.y.equals(segmentState.y)
    })
    if (oldSegments.size > 0) {
      val oldSegment = oldSegments(0)
      val newSegment : RoadSegment = new StraightSegment()
      newSegment.x = segmentState.x
      newSegment.y = segmentState.y
      newSegment.leftSideNeighbor = oldSegment.leftSideNeighbor
      newSegment.rightSideNeighbor = oldSegment.rightSideNeighbor
      newSegment.frontNeighbor = oldSegment.frontNeighbor
      newSegment.backNeighbor = oldSegment.backNeighbor
      newSegment.leftSideNeighbor.rightSideNeighbor = newSegment
      newSegment.rightSideNeighbor.leftSideNeighbor = newSegment
      newSegment.frontNeighbor.backNeighbor = newSegment
      newSegment.backNeighbor.frontNeighbor = newSegment
      segments =  segments diff Seq(oldSegment)
      segments = newSegment +: segments
    }
    segments
  }

}
