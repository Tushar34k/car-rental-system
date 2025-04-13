package com.car.rental.model.service

import com.car.rental.model.Car
import com.car.rental.model.repository.CarRepository
import com.car.rental.exception.CarNotFoundException
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

    fun getCarById(id: Long): Car {
        return carRepository.findById(id)
            .orElseThrow { CarNotFoundException("Car with ID $id not found") }
    }

    fun updateCar(id: Long, updatedCar: Car): Car {
        val existingCar = carRepository.findById(id)
            .orElseThrow { CarNotFoundException("Cannot update. Car with ID $id not found") }

        val carToSave = existingCar.copy(
            model = updatedCar.model ?: existingCar.model,
            brand = updatedCar.brand ?: existingCar.brand,
            numberPlate = updatedCar.numberPlate ?: existingCar.numberPlate,
            rentPerDay = updatedCar.rentPerDay ?: existingCar.rentPerDay,
            status = updatedCar.status ?: existingCar.status
        )

        return carRepository.save(carToSave)
    }

    fun deleteCar(id: Long) {
        if (!carRepository.existsById(id)) {
            throw CarNotFoundException("Cannot delete. Car with ID $id not found")
        }
        carRepository.deleteById(id)
    }
}
