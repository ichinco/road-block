package roadblock.comet

import net.liftweb.http.ListenerManager
import net.liftweb.actor.LiftActor

/**
 * User: denise
 * Date: 9/19/13
 * Time: 1:05 PM
 */
object Universe extends LiftActor with ListenerManager {
  protected def createUpdate: Any = null
}
