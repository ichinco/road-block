package roadblock.lib.segments

import roadblock.lib.interfaces.{RoadState, Car, RoadSegment}

/**
 * User: denise
 * Date: 9/18/13
 * Time: 4:51 PM
 */
class StraightSegment extends RoadSegment {
  var backNeighbor: roadblock.lib.interfaces.RoadSegment = new NowhereSegment()
  var frontNeighbor: roadblock.lib.interfaces.RoadSegment = new NowhereSegment()
  var leftSideNeighbor: roadblock.lib.interfaces.RoadSegment = new NowhereSegment()
  var rightSideNeighbor: roadblock.lib.interfaces.RoadSegment = new NowhereSegment()
  var state: roadblock.lib.interfaces.RoadState = null
  var segmentType : Symbol = 'straight_segment

  def tick() {
    // nothing changes for a regular piece of road each second
  }
}
