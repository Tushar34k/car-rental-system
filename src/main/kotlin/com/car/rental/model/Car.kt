package com.car.rental.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Car(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null,
    val model: String? = null,
    val brand: String? = null,
    val numberPlate: String? = null,
    val rentPerDay: Double? = null,
    val status: String? = null
) {

}
