package roadblock.lib.interfaces

/**
 * User: denise
 * Date: 9/18/13
 * Time: 4:30 PM
 */
trait RoadState {
  def occupied:Boolean
  def collided:Boolean
  def forwardMotionPermitted():Boolean
  def leftwardMotionPermitted():Boolean
  def rightwardMotionPermitted():Boolean
  def backwardMotionPermitted():Boolean
}
