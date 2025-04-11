package com.car.rental.model.repository

import com.car.rental.model.Car
import org.springframework.data.jpa.repository.JpaRepository

interface CarRepository:JpaRepository<Car,Long> {
}