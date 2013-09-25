package roadblock.comet

import net.liftweb.http.{CometListener, CometActor}
import net.liftweb.http.js.{JE, JsCmd}
import net.liftweb.json._
import net.liftweb.util.ClearClearable
import net.liftweb.json.JsonDSL._
import roadblock.lib.interfaces.{Car, RoadSegment, RoadNetwork}
import roadblock.lib.segments.{SegmentState, StraightSegment}
import scala.collection.mutable.ListBuffer
import roadblock.lib.networks.{NetworkState, BasicRoadNetwork}
import roadblock.lib.cars.CruiseControl

/**
 * User: denise
 * Date: 9/22/13
 * Time: 3:52 PM
 */
class RoadNetworkListener extends CometActor with CometListener {

  def registerWith = Universe

  val car : Car = new CruiseControl(2)

  val network : RoadNetwork = {
    val segments : ListBuffer[RoadSegment] = ListBuffer()
    (0 to 10).foreach(
      (i : Int) => {

        val segment = new StraightSegment()
        segment.x = 0
        segment.y = 10-i

        if (i>0){
          val previous = segments(i-1)
          segment.backNeighbor = previous
          previous.frontNeighbor = segment
        }

        segments.append(segment)
    })
    segments.foreach(f => f.initializeState())
    val n : RoadNetwork = new BasicRoadNetwork()
    n.segments = segments.toList

    car.changeToSegment(segments(0))
    n
  }

  override def lowPriority = {
    case _ => {
      car.tick(network)
      sendState()
    }
  }

  def render = {
    ClearClearable
  }

  private[this] def sendState() = {
    partialUpdate(NewMessageNg(this.network))
  }

}

case class NewMessageNg(network : RoadNetwork) extends JsCmd {
  implicit val formats = DefaultFormats.lossless
  val json: JValue = NetworkState(network)
  override val toJsCmd = JE.JsRaw(""" $(document).trigger('new-ng-state', %s)""".format( compact( render( json ) ) ) ).toJsCmd
}