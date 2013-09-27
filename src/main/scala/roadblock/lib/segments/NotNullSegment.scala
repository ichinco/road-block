package roadblock.lib.segments

import roadblock.lib.interfaces.{Car, RoadSegment}

/**
 * User: denise
 * Date: 9/27/13
 * Time: 5:35 PM
 */
abstract class NotNullSegment extends RoadSegment {
  var frontNeighbor : RoadSegment = RoadSegment.empty()
  var backNeighbor : RoadSegment = RoadSegment.empty()
  var leftSideNeighbor : RoadSegment = RoadSegment.empty()
  var rightSideNeighbor : RoadSegment = RoadSegment.empty()
  override var car : Car = Car.empty()
}
