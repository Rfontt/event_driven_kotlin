package com.service.eventdriven.order.services

import com.service.eventdriven.order.aplication.teacher.CommandI
import com.service.eventdriven.order.aplication.teacher.EventsI
import com.service.eventdriven.order.domain.Teacher

data class TeacherService(
    val command: CommandI,
    val event: EventsI
) {
    private val teacherCommand: CommandI = command
    private val teacherEvent: EventsI = event

    fun create(teacher: Teacher) {
        try {
            teacherCommand.create(teacher)

            teacherEvent.success()
        } catch (ex: Exception) {
            teacherEvent.error()
        }
    }
}