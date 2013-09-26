package roadblock.lib.segments

import roadblock.lib.interfaces.{RoadNetwork, RoadState, RoadSegment}

/**
 * User: denise
 * Date: 9/19/13
 * Time: 1:55 PM
 */
class NowhereSegment extends RoadSegment {
  var segmentType : Symbol = 'no_segment
  var state: RoadState = new RoadState {
    def occupied: Boolean = false

    def forwardMotionPermitted(): Boolean = false

    def leftwardMotionPermitted(): Boolean = false

    def backwardMotionPermitted(): Boolean = false

    def rightwardMotionPermitted(): Boolean = false

    def collided: Boolean = false
  }
}
