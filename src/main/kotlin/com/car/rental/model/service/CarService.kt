package com.car.rental.model.service

import com.car.rental.model.Car
import com.car.rental.model.repository.CarRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CarService(
    @Autowired private val carRepository: CarRepository
) {
    fun getAllCar(): List<Car> {
        return carRepository.findAll()
    }

    fun addCar(car: Car): Car {
        return carRepository.save(car)
    }


    fun updateCar(id: Long, updatedCar: Car): Car {
        val existingCar = carRepository.findById(id).orElseThrow()
        val carToSave = existingCar.copy(
            model = updatedCar.model ?: existingCar.model,
            brand = updatedCar.brand ?: existingCar.brand,
            numberPlate = updatedCar.numberPlate ?: existingCar.numberPlate,
            rentPerDay = updatedCar.rentPerDay ?: existingCar.rentPerDay,
            status = updatedCar.status ?: existingCar.status
        )
        return carRepository.save(carToSave)
    }


}