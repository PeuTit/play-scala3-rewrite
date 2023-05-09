import mill._
import $ivy.`com.lihaoyi::mill-contrib-playlib:`,  mill.playlib._

object playscala3 extends PlayModule with SingleModule {

  def scalaVersion = "3.3.0-RC5"
  def playVersion = "2.9.0-M4"
  def twirlVersion = "1.6.0-RC2"

  object test extends PlayTests
}
