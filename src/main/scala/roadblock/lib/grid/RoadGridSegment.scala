package roadblock.lib.grid

import roadblock.lib.interfaces.{RoadSegment}
import net.liftweb.json.{Xml, JValue, Extraction}
import scala.xml.Node

/**
 * User: denise
 * Date: 9/19/13
 * Time: 4:21 PM
 */
class RoadGridSegment {
  var segmentType : Symbol
  var x: Integer
  var y: Integer
  var top : Boolean
  var bottom : Boolean
  var left : Boolean
  var right : Boolean

  object RoadGridSegment {

    private implicit val formats =
      net.liftweb.json.DefaultFormats

    implicit def toXml(item: RoadGridSegment): Node =
      <segment>{Xml.toXml(item)}</segment>


    /**
     * Convert the item to JSON format.  This is
     * implicit and in the companion object, so
     * an Item can be returned easily from a JSON call
     */
    implicit def toJson(item: RoadGridSegment): JValue =
      Extraction.decompose(item)

    /**
     * Convert a Seq[Item] to JSON format.  This is
     * implicit and in the companion object, so
     * an Item can be returned easily from a JSON call
     */
    implicit def toJson(items: Seq[RoadGridSegment]): JValue =
      Extraction.decompose(items)
  }

}
