package roadblock.comet

import net.liftweb.http.{CometListener, CometActor}
import net.liftweb.http.js.{JE, JsCmd}
import net.liftweb.json._
import net.liftweb.util.ClearClearable
import net.liftweb.json.JsonDSL._
import roadblock.lib.interfaces.{SegmentState, RoadSegment, RoadNetwork}
import roadblock.lib.segments.StraightSegment
import scala.collection.mutable.ListBuffer

/**
 * User: denise
 * Date: 9/22/13
 * Time: 3:52 PM
 */
class JsonListener extends CometActor with CometListener {

  def registerWith = Universe

  override def lowPriority = {
    case _ => {
      val segments : ListBuffer[RoadSegment] = ListBuffer()
      (0 to 10).foreach(
        (i : Int) => {

          val segment = new StraightSegment()
          segment.x = 0
          segment.y = i

          if (i>0){
            val previous = segments(i-1)
            segment.backNeighbor = previous
            previous.frontNeighbor = segment
          }

          segments.append(segment)
      })
      sendState(segments.toList)
    }
  }

  def render = {
    ClearClearable
  }

  private[this] def sendState(network : List[RoadSegment]) = {
    partialUpdate(NewMessageNg(network))
  }

}

case class NewMessageNg(network : Seq[RoadSegment]) extends JsCmd {
  implicit val formats = DefaultFormats.lossless
  val json: JValue = "segments" -> network.map(SegmentState(_))
  override val toJsCmd = JE.JsRaw(""" $(document).trigger('new-ng-state', %s)""".format( compact( render( json ) ) ) ).toJsCmd
}
