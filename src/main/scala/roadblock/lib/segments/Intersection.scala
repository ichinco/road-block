package roadblock.lib.segments

import roadblock.lib.interfaces.{Car, RoadState, RoadSegment}
import scala.util.Random

/**
 * User: denise
 * Date: 10/14/13
 * Time: 10:53 PM
 */
class Intersection extends NotNullSegment {

  var segmentType : Symbol= 'intersection
  var state : RoadState= null

  override def acceptCar(car:Car) = {

    val topLeft : Seq[RoadSegment] = Random.shuffle(Seq(this.frontNeighbor, this.leftSideNeighbor))
    val bottomRight : Seq[RoadSegment] = Random.shuffle(Seq(this.backNeighbor, this.rightSideNeighbor))
    val newFront = topLeft(0)
    val newLeft = topLeft(1)
    val newBack = bottomRight(0)
    val newRight = bottomRight(1)

    this.frontNeighbor = newFront
    this.backNeighbor = newBack
    this.leftSideNeighbor = newLeft
    this.rightSideNeighbor = newRight

    super.acceptCar(car)
  }
}
