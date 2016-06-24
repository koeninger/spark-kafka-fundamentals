import scala.util.Random

object GenerateJsonEvents {
  def main(args: Array[String]): Unit = {
    val count = args(0).toInt

    (1 to count).foreach { i =>
      println(generate(i))
    }
  }

  def generate(i: Int) = {
      val r = Random.nextDouble
      if (r < 0.05) {
        ""
      } else if (r < 0.3) {
        s"""{"id":$i,"event":"click","value":$r}"""
      } else {
        s"""{"id":$i,"event":"view","value":$r}"""
      }
  }
}
