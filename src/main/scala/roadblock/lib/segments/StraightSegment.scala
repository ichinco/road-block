package roadblock.lib.segments

import roadblock.lib.interfaces.{RoadState, Car, RoadSegment}

/**
 * User: denise
 * Date: 9/18/13
 * Time: 4:51 PM
 */
class StraightSegment extends RoadSegment {
  def backNeighbor: roadblock.lib.interfaces.RoadSegment = new NowhereSegment()
  def frontNeighbor: roadblock.lib.interfaces.RoadSegment = new NowhereSegment()
  def leftSideNeighbor: roadblock.lib.interfaces.RoadSegment = new NowhereSegment()
  def rightSideNeighbor: roadblock.lib.interfaces.RoadSegment = new NowhereSegment()
  def state: roadblock.lib.interfaces.RoadState = null
  def segmentType : Symbol = 'straight_segment

  def tick() {
    // nothing changes for a regular piece of road each second
  }
}
