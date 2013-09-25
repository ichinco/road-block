import javax.servlet.DispatcherType
import org.eclipse.jetty.servlet.ServletContextHandler
import org.eclipse.jetty.servlet.ServletHolder
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.io.File
import org.eclipse.jetty.server.Server
import net.liftweb.http.LiftFilter
import org.eclipse.jetty.servlet.FilterHolder
import java.util.EnumSet
import org.eclipse.jetty.servlet.DefaultServlet

object RunWebApp {

  def main(args: Array[String]): Unit = {
    val server = new Server(Integer.valueOf(System.getenv("PORT")));
    val context = new ServletContextHandler(ServletContextHandler.SESSIONS);

    context.setContextPath("/")
    server.setHandler(context)

    context.addServlet(new ServletHolder(new DefaultServlet), "/*");

    val tFilter = new LiftFilter()
    context.addFilter(new FilterHolder(new LiftFilter()), "/*", EnumSet.of(DispatcherType.REQUEST))

    server.start()
    server.join()
  }
}