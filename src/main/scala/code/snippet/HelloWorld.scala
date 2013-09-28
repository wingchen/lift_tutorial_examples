package code
package snippet

import scala.xml.{NodeSeq, Text}
import net.liftweb.util._
import net.liftweb.common._
import java.util.Date
import Helpers._

class HelloWorld {

  // replace the contents of the element with id "time" with the date
  def howdy = {
	var binding = ".header_h2 *" #> "Hello world. The header is rewritten here."
	binding &= "#time *" #> (new Date).toString
	binding
  }

  def iteration = {
	val listItems = List("This", "Is", "A", "Simple", "HTML", "Iteration", "Example")
	".iteration_container *" #> ((ns: NodeSeq) => listItems.flatMap( item =>{
		val result = ".single_item *" #> item
		result(ns)
	}))
  }

}

