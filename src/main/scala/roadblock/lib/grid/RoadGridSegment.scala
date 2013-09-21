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
  var segmentType : Symbol = 'none
  var x: Integer = 0
  var y: Integer = 0
  var top : Boolean = false
  var bottom : Boolean = false
  var left : Boolean = false
  var right : Boolean = false

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
