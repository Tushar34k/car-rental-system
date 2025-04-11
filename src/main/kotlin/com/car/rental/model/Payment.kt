package com.car.rental.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
data class Payment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null,
//    @OneToOne
//    private val booking: Booking? = null
    val amountPaid: Double? = null,
    val paymentMode: String? = null, // Cash / Card / UPI
    val paymentDate: LocalDate? = null
) {

}
