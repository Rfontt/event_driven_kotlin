package com.service.eventdriven

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.Producer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringSerializer
import java.util.Properties

private fun createProducer(): Producer<String, String> {
    val props = Properties()

    props["bootstrap.servers"] = "localhost:9092"
    props["key.serializer"] = StringSerializer::class.java
    props["value.serializer"] = StringSerializer::class.java

    return KafkaProducer<String, String>(props)
}

fun main() {
    val producer = createProducer()

    for (i in 0..4) {
        val future = producer.send(ProducerRecord(
            "Topic1",
            i.toString(),
            "Hello test $i"
        ))

        future.get()
    }
}