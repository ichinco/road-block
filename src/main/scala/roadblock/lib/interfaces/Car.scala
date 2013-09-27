package roadblock.lib.interfaces

import roadblock.lib.segments.EmptySegment
import roadblock.lib.cars.NoCar

/**
 * User: denise
 * Date: 9/18/13
 * Time: 4:32 PM
 */
trait Car {
  var currentSegment : RoadSegment = null

  def tick(segments: RoadNetwork)

  def changeToSegment(newSegment : RoadSegment) = {
    this.currentSegment.unacceptCar(this)
    currentSegment = newSegment
    this.currentSegment.acceptCar(this)
  }
}

object Car {
  def empty() : Car = {
    new NoCar()
  }
}
