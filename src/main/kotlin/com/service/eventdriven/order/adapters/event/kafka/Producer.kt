package com.service.eventdriven.order.adapters.event.kafka

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.Producer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringSerializer
import java.util.Properties

private fun config(): Producer<String, String> {
    val props = Properties()

    props["bootstrap.servers"] = "localhost:9092"
    props["key.serializer"] = StringSerializer::class.java
    props["value.serializer"] = StringSerializer::class.java

    return KafkaProducer<String, String>(props)
}

fun createProducer(
    topic: String,
    message: String
) {
    val producer = config()

    val future = producer.send(
        ProducerRecord(
            topic,
            "",
            message
        )
    )
}