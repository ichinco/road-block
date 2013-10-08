package roadblock.lib.interfaces

import roadblock.lib.segments.SegmentState

/**
 * User: denise
 * Date: 9/19/13
 * Time: 1:10 PM
 */
trait RoadNetwork {
  var segments : Seq[RoadSegment]
  def getForwardSegment(segment: RoadSegment, i : Integer) : RoadSegment
  def getBackwardSegment(segment: RoadSegment, i : Integer) : RoadSegment
  def getLeftwardSegment(segment: RoadSegment, i : Integer) : RoadSegment
  def getRightwardSegment(segment: RoadSegment, i : Integer) : RoadSegment

  def updateSegment(segmentState: SegmentState)
}
