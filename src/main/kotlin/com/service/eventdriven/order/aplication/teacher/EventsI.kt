package com.service.eventdriven.order.aplication.teacher

interface EventsI {
    fun error(): Unit
    fun success(): Unit
}