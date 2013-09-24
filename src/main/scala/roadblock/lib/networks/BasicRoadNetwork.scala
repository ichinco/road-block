package roadblock.lib.networks

import roadblock.lib.interfaces.{RoadSegment, RoadNetwork}

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
        localSegment = localSegment.frontNeighbor
      }
    )

    localSegment
  }
  def getBackwardSegment(segment: RoadSegment, i : Integer) : RoadSegment = {
    var localSegment : RoadSegment = segment
    (0 until i).foreach(
      (i : Int) => {
        localSegment = localSegment.backNeighbor
      }
    )

    localSegment
  }
  def getLeftwardSegment(segment: RoadSegment, i : Integer) : RoadSegment = {
    var localSegment : RoadSegment = segment
    (0 until i).foreach(
      (i : Int) => {
        localSegment = localSegment.leftSideNeighbor
      }
    )

    localSegment
  }
  def getRightwardSegment(segment: RoadSegment, i : Integer) : RoadSegment = {
    var localSegment : RoadSegment = segment
    (0 until i).foreach(
      (i : Int) => {
        localSegment = localSegment.rightSideNeighbor
      }
    )

    localSegment
  }

}
