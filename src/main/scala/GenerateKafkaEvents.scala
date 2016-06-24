import org.apache.kafka.clients.producer._
import java.util.Properties

object GenerateKafkaEvents {
  def main(args: Array[String]): Unit = {
    val perSecond = args(0).toInt

    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9092")
    props.put("acks", "all")
    props.put("retries", 0: java.lang.Integer)
    props.put("batch.size", 16384: java.lang.Integer)
    props.put("linger.ms", 1: java.lang.Integer)
    props.put("buffer.memory", 33554432: java.lang.Integer)
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

    val producer = new KafkaProducer[String, String](props)

    while (true) {
      (0 to perSecond).foreach { i =>
        producer.send(new ProducerRecord[String, String]("test", Integer.toString(i), GenerateEvents.generate()))
      }
      Thread.sleep(1000)
    }

    producer.close()

  }
}
