package roadblock.comet

import net.liftweb.http.{CometListener, CometActor}
import net.liftweb.http.js.{JE, JsCmd}
import net.liftweb.json._
import net.liftweb.util.ClearClearable
import net.liftweb.json.JsonDSL._
import roadblock.lib.interfaces.{Car, RoadSegment, RoadNetwork}
import roadblock.lib.segments._
import scala.collection.mutable.ListBuffer
import roadblock.lib.networks.{NetworkState, BasicRoadNetwork}
import roadblock.lib.cars.CruiseControl
import roadblock.comet.NewMessageNg

/**
 * User: denise
 * Date: 9/22/13
 * Time: 3:52 PM
 */
class RoadNetworkListener extends CometActor with CometListener {

  def registerWith = Universe

  val network : RoadNetwork = {
    val segments : ListBuffer[RoadSegment] = ListBuffer()
    (0 until 15).foreach(
      (i:Int) => {
        (0 until 15).foreach (
          (j:Int) => {
            val segment = new EmptySegment()
            segment.x = i
            segment.y = j
            segments.append(segment)


          }
        )
      }
    )
    segments.foreach(f => f.initializeState())
    val n : RoadNetwork = new BasicRoadNetwork()
    n.segments = segments.toList
    n
  }

//  val network : RoadNetwork = {
//    val segments : ListBuffer[RoadSegment] = ListBuffer()
//    (0 to 10).foreach(
//      (i : Int) => {
//
//        val segment = new StraightSegment()
//        segment.x = 0
//        segment.y = 11-i
//
//        if (i>0){
//          val previous = segments(i-1)
//          segment.backNeighbor = previous
//          previous.frontNeighbor = segment
//        }
//
//        segments.append(segment)
//    })
//    val source : RoadSegment = new CarSource(3)
//    source.x = 0
//    source.y = 12
//    source.frontNeighbor = segments(0)
//    segments(0).backNeighbor = source
//    val sink : RoadSegment = new CarSink()
//    sink.x=0
//    sink.y=0
//    sink.backNeighbor = segments(10)
//    segments(10).frontNeighbor=sink
//    segments.append(source)
//    segments.append(sink)
//    segments.foreach(f => f.initializeState())
//    val n : RoadNetwork = new BasicRoadNetwork()
//    n.segments = segments.toList
//    n
//  }

  override def lowPriority = {
    case s: SegmentState => {
      network.updateSegment(s)
      sendState()
    }
    case _ => {
      network.segments.foreach(
        (f:RoadSegment) => {
          f.tick(network)
        }
      )
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
