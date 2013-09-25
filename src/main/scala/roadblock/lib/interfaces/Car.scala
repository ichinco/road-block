package roadblock.lib.interfaces

import roadblock.lib.segments.NowhereSegment

/**
 * User: denise
 * Date: 9/18/13
 * Time: 4:32 PM
 */
trait Car {
  var currentSegment : RoadSegment = new NowhereSegment()

  def tick(segments: RoadNetwork)

  def changeToSegment(newSegment : RoadSegment) = {
    this.currentSegment.unacceptCar(this)
    currentSegment = newSegment
    this.currentSegment.acceptCar(this)
  }
}
