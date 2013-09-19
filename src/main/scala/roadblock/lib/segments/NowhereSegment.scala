package roadblock.lib.segments

import roadblock.lib.interfaces.{RoadState, RoadSegment}

/**
 * User: denise
 * Date: 9/19/13
 * Time: 1:55 PM
 */
class NowhereSegment extends RoadSegment {

  def backNeighbor: RoadSegment = null
  def frontNeighbor:RoadSegment = null
  def leftSideNeighbor:RoadSegment = null
  def rightSideNeighbor: RoadSegment = null
  def state: RoadState = new RoadState {
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
