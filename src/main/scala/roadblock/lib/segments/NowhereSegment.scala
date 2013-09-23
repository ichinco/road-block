package roadblock.lib.segments

import roadblock.lib.interfaces.{RoadState, RoadSegment}

/**
 * User: denise
 * Date: 9/19/13
 * Time: 1:55 PM
 */
class NowhereSegment extends RoadSegment {

  var backNeighbor: RoadSegment = null
  var frontNeighbor:RoadSegment = null
  var leftSideNeighbor:RoadSegment = null
  var rightSideNeighbor: RoadSegment = null
  var segmentType : Symbol = 'no_segment
  var state: RoadState = new RoadState {
    def isOccupied(): Boolean = false

    def forwardMotionPermitted(): Boolean = false

    def leftwardMotionPermitted(): Boolean = false

    def backwardMotionPermitted(): Boolean = false

    def rightwardMotionPermitted(): Boolean = false

    def isCollided(): Boolean = false
  }
  def tick(): Unit = {

  }

}
