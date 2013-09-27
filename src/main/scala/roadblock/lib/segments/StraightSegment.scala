package roadblock.lib.segments

import roadblock.lib.interfaces.{RoadNetwork, RoadState, Car, RoadSegment}

/**
 * User: denise
 * Date: 9/18/13
 * Time: 4:51 PM
 */
class StraightSegment extends NotNullSegment {
  var state: roadblock.lib.interfaces.RoadState = null
  var segmentType : Symbol = 'straight_segment
}
