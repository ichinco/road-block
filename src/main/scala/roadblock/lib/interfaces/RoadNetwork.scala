package roadblock.lib.interfaces

/**
 * User: denise
 * Date: 9/19/13
 * Time: 1:10 PM
 */
trait RoadNetwork {
  def getForwardSegment(segment: RoadSegment, i : Integer) : RoadSegment
  def getBackwardSegment(segment: RoadSegment, i : Integer) : RoadSegment
  def getLeftwardSegment(segment: RoadSegment, i : Integer) : RoadSegment
  def getRightwardSegment(segment: RoadSegment, i : Integer) : RoadSegment
}
