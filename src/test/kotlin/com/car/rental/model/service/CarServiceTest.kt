package com.car.rental.model.service

import com.car.rental.model.Car
import com.car.rental.model.repository.CarRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import java.util.*


@ExtendWith(MockitoExtension::class)
class CarServiceTest {
    @Mock
    private lateinit var carRepository: CarRepository

    @InjectMocks
    private lateinit var carService: CarService

    private lateinit var car: Car
    private lateinit var updatedCar: Car

    @BeforeEach
    fun setUp() {
        car = Car(
            id = 1L,
            model = "Civic",
            brand = "Honda",
            numberPlate = "ABC123",
            rentPerDay = 50.0,
            status = "AVAILABLE"
        )
        updatedCar = Car(
            id = 1L,
            model = "Accord",
            brand = "Honda",
            numberPlate = "XYZ789",
            rentPerDay = 60.0,
            status = "RENTED"
        )
    }

    @Test
    fun `should return allCar`() {
        var carList = listOf(car, updatedCar)
        `when`(carRepository.findAll()).thenReturn(carList)
        var car = carService.getAllCar()
        assertEquals(2, car.size)
    }

    @Test
    fun `should return byId`()
    {
        `when`(carRepository.findById(1L)).thenReturn(Optional.of(car))
        var result=carService.getCarById(1L)
        assertEquals(car,result)
        verify(carRepository, times(1)).findById(1L)
    }

    @Test
    fun `should update the car`()
    {
        `when`(carRepository.findById(1L)).thenReturn(Optional.of(car))
        `when`(carRepository.save(updatedCar)).thenReturn(updatedCar)
        var updateCar=carService.updateCar(1L,updatedCar)
        assertEquals(updatedCar.model,updatedCar.model)
    }



}