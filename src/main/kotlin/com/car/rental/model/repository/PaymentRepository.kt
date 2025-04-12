package com.car.rental.model.repository

import com.car.rental.model.Payment
import org.springframework.data.jpa.repository.JpaRepository

interface PaymentRepository:JpaRepository<Payment,Long> {
}