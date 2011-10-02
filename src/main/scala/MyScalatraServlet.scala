import org.scalatra._
import org.wandledi.wandlet.scala.{Wandlet, Page}
import org.wandledi.scala._

class MyScalatraServlet extends ScalatraServlet with Wandlet {

  def httpServletResponse = response // required by Wandlet

  get("/") {
    <html>
      <body>
        <h1>Hello, world!</h1>
        Say <a href="hello-wandledi">hello to Wandledi</a>.
      </body>
    </html>
  }

  get("/hello-wandledi") {
    val title = "Scalatra: a tiny, Sinatra-like web framework for Scala"
    val headline = "Welcome to Scalatra"
    val page = new Page("/hello-wandledi.html") {
      $("title").text = title
      $("h1").text = headline
      $("#content") insertLast "Hello, Wandledi!"
    }
    render(page)
  }
}
