package com.car.rental.model.service

import com.car.rental.model.Payment
import com.car.rental.model.repository.PaymentRepository
import org.springframework.beans.factory.annotation.Autowired

class PaymentService(
    @Autowired private val paymentRepository: PaymentRepository
) {

    fun addPayment(payment: Payment): Payment {
        return paymentRepository.save(payment)
    }

    fun getAllPayments(): List<Payment>
    {
        return paymentRepository.findAll();
    }

    fun getPaymentById(id:Long): Payment
    {
        return paymentRepository.findById(id).orElse(null)
    }
}