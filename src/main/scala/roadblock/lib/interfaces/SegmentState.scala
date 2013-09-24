package roadblock.lib.interfaces

import net.liftweb.json._

import net.liftweb._
import util._
import Helpers._
import common._
import json._

/**
 * User: denise
 * Date: 9/24/13
 * Time: 12:07 PM
 */
case class SegmentState(segment : RoadSegment) {
  val segmentType = segment.segmentType
  val x = segment.x
  val y = segment.y
  val left = segment.state.leftwardMotionPermitted()
  val right = segment.state.rightwardMotionPermitted()
  val top = segment.state.forwardMotionPermitted()
  val bottom = segment.state.backwardMotionPermitted()
}

object SegmentState {
  private implicit val formats = net.liftweb.json.DefaultFormats

  implicit def toJson(item: SegmentState): JValue = Extraction.decompose(item)

  implicit def toJson(items: Seq[SegmentState]): JValue = Extraction.decompose(items)
}
