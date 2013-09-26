import org.eclipse.jetty.server.Server
import org.eclipse.jetty.server.session.{SessionHandler, HashSessionManager}
import org.eclipse.jetty.servlet.{DefaultServlet, ServletContextHandler}
import org.eclipse.jetty.server.nio.SelectChannelConnector
import net.liftweb.http.LiftFilter

object RunWebApp {

  def main(args: Array[String]): Unit = {
    //Transfer the run.mode from system environment to system properties. Otherwise Lift's calculation of
    //mode will not work
    if (System.getProperty("run.mode") == null){
      System.setProperty("run.mode", System.getenv("run.mode"))
    }

    //Create the server and set the port to listen to
    val port = if (System.getenv("PORT") != null) System.getenv("PORT").toInt else 8080
    val server = new Server
    val scc = new SelectChannelConnector
    scc.setPort(port)
    server.setConnectors(Array(scc))

    //Initialize the session handler
    val sessionHandler = new SessionHandler()
    val sessionManager = new HashSessionManager()
    sessionHandler.setSessionManager(sessionManager)
    sessionManager.setMaxInactiveInterval(600)

    val context = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS)
    context.setSessionHandler(sessionHandler)
    context.addServlet(classOf[DefaultServlet], "/")
    context.addFilter(classOf[LiftFilter], "/*", 0)
    context.setResourceBase("src/main/webapp")

    server.start
    server.join
  }
}