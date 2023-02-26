package com.service.eventdriven.order.aplication.teacher

import com.service.eventdriven.order.domain.Teacher

interface CommandI {
    fun create(teacher: Teacher): Boolean
}