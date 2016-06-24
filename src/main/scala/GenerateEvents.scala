import scala.util.Random

object GenerateEvents {
  def main(args: Array[String]): Unit = {
    val count = args(0).toInt

    (1 to count).foreach { i =>
      println(generate())
    }
  }

  def generate() = {
    val r = Random.nextDouble
    if (r < 0.05) {
      ""
    } else if (r < 0.3) {
      "click"
    } else {
      "view"
    }
  }
}
