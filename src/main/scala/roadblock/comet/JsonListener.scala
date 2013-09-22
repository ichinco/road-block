package roadblock.comet

import net.liftweb.http.{CometListener, CometActor}
import net.liftweb.http.js.{JE, JsCmd}
import roadblock.comet.Tick
import roadblock.comet.NewMessageNg
import net.liftweb.json.{JValue, DefaultFormats}
import net.liftweb.util.ClearClearable

/**
 * User: denise
 * Date: 9/22/13
 * Time: 3:52 PM
 */
class JsonListener extends CometActor with CometListener {

  def registerWith = Universe

  override def lowPriority = {
    case Tick => {
      sendState()
    }
  }

  def render = {
    ClearClearable
  }

  private[this] def sendState() = {
    partialUpdate(NewMessageNg(""))
  }

}

case class NewMessageNg(message: String) extends JsCmd {
  implicit val formats = DefaultFormats.lossless
  val json: JValue = ("message" -> message)
  override val toJsCmd = JE.JsRaw(""" $(document).trigger('new-ng-chat', %s)""".format( compact( render( json ) ) ) ).toJsCmd
}
