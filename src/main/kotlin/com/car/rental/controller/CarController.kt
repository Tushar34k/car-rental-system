package com.car.rental.controller

import com.car.rental.model.Car
import com.car.rental.model.service.CarService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/cars")
class CarController(
    private val carService: CarService
) {

    @GetMapping
    fun getAllCars(): ResponseEntity<List<Car>> {
        val cars = carService.getAllCar()
        return ResponseEntity.ok(cars)
    }


    @GetMapping("/{id}")
    fun getCarById(@PathVariable id: Long): ResponseEntity<Car> {
        val car = carService.getCarById(id)
        return ResponseEntity.ok(car)
    }


    @PostMapping
    fun addCar(@RequestBody car: Car): ResponseEntity<Car> {
        val savedCar = carService.addCar(car)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCar)
    }


    @PutMapping("/{id}")
    fun updateCar(
        @PathVariable id: Long,
        @RequestBody updatedCar: Car
    ): ResponseEntity<Car> {
        val car = carService.updateCar(id, updatedCar)
        return ResponseEntity.ok(car)
    }


    @DeleteMapping("/{id}")
    fun deleteCar(@PathVariable id: Long): ResponseEntity<String> {
        carService.deleteCar(id)
        return ResponseEntity.ok("Car with ID $id has been deleted successfully.")
    }
}
