package roadblock.lib.segments

import roadblock.lib.interfaces.{Car, RoadState, RoadSegment}

/**
 * User: denise
 * Date: 9/27/13
 * Time: 5:29 PM
 */
class NullSegment extends RoadSegment {
  var segmentType : Symbol = 'no_segment
  var frontNeighbor : RoadSegment = null
  var backNeighbor : RoadSegment = null
  var leftSideNeighbor : RoadSegment = null
  var rightSideNeighbor : RoadSegment = null
  var car : Car = null
  var state: RoadState = new RoadState {
    def occupied: Boolean = false

    def forwardMotionPermitted(): Boolean = false

    def leftwardMotionPermitted(): Boolean = false

    def backwardMotionPermitted(): Boolean = false

    def rightwardMotionPermitted(): Boolean = false

    def collided: Boolean = false
  }
}
