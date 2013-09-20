package roadblock.lib.grid

import scala.xml.Node
import net.liftweb.json.{JValue, Extraction, Xml}

/**
 * User: denise
 * Date: 9/19/13
 * Time: 4:09 PM
 */
class RoadGrid(id : Integer) {

  object RoadGrid {

    private implicit val formats =
      net.liftweb.json.DefaultFormats

    /**
     * Convert an item to XML
     */
    implicit def toXML(item: RoadGrid): Node =
      <grid>{Xml.toXml(item)}</grid>


    /**
     * Convert the item to JSON format.  This is
     * implicit and in the companion object, so
     * an Item can be returned easily from a JSON call
     */
    implicit def toJSON(item: RoadGrid): JValue =
      Extraction.decompose(item)

    /**
     * Convert a Seq[Item] to JSON format.  This is
     * implicit and in the companion object, so
     * an Item can be returned easily from a JSON call */
    implicit def toJSON(items: Seq[RoadGrid]): JValue = Extraction.decompose(items)

  }

  def segments = {
    (0 to 7) map
      ((i : Int) => {
          val segment = new RoadGridSegment()
          segment.x = 0
          segment.y = i
          segment.left = false
          segment.right = false
          segment.top = true
          segment.bottom = true
          segment.segmentType = 'straight_segment
          segment
      })
  }

}
