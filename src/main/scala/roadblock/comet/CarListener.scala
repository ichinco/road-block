package roadblock.comet

import net.liftweb.http.{RenderOut, CometActor, CometListener}
import roadblock.lib.interfaces.{Car, RoadNetwork}

/**
 * User: denise
 * Date: 9/19/13
 * Time: 1:08 PM
 */
class CarListener(car : Car) extends CometActor with CometListener {
  var currentRoad : RoadNetwork = null

  def registerWith = Universe

  override def lowPriority = {
      case v: RoadNetwork => currentRoad = v; sendTick()
  }

  def sendTick() = {
    car.tick(currentRoad)
  }

  def render: RenderOut = null
}
