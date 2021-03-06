package roadblock.comet

import net.liftweb.http.{CometActor, ListenerManager}
import net.liftweb.actor.{LAPinger, LiftActor}
import net.liftweb.http.js.{JsCmd, JE}
import net.liftweb.json.{DefaultFormats, JValue}
import roadblock.lib.segments.SegmentState

/**
 * User: denise
 * Date: 9/19/13
 * Time: 1:05 PM
 */
object Universe extends LiftActor with ListenerManager {
  protected def createUpdate: Any = null

  LAPinger.schedule(this, Tick, 1000L)

  override def lowPriority = {
    case s:SegmentState => {
      updateListeners(s)
    }
    case _ => {
      updateListeners()
      LAPinger.schedule(this, Tick, 1000L)
    }
  }

}




