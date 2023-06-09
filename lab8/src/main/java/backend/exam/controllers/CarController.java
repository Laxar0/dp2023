package backend.exam.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import backend.exam.entities.CarEntity;
import backend.exam.repositories.CarRepository;

import java.util.List;

@RestController
@RequestMapping("/exam/api")
@Slf4j
public class CarController {
    @Autowired
    private CarRepository cRepo;

    @GetMapping("/list")
    public List<CarEntity> getCars() {
        List<CarEntity> carsList = cRepo.findAll();
        log.info("[CAR CONTROLLER] GET method performed: found {} cars", carsList.size());
        return carsList;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CarEntity postCar(@RequestBody CarEntity car) {
        cRepo.save(car);
        log.info("[CAR CONTROLLER] POST method performed: added {} car", car.getName());
        return car;
    }

    @PutMapping("/update/{id}")
    public CarEntity putCar(@PathVariable long id, @RequestBody CarEntity updatedCar) {
        CarEntity newCar = cRepo.findById(id)
                .orElseThrow(() -> new ResourceAccessException("No car found with id:" + id));

        newCar.setName(updatedCar.getName());
        newCar.setImg(updatedCar.getImg());
        newCar.setMaxSpeed(updatedCar.getMaxSpeed());

        log.info("[CAR CONTROLLER] PUT method performed: car with id {} was updated", id);
        return cRepo.save(newCar);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCar(@PathVariable long id) {
        CarEntity delCar = cRepo.findById(id)
                .orElseThrow(() -> new ResourceAccessException("No car found with id:" + id));

        cRepo.delete(delCar);
        log.info("[CAR CONTROLLER] DELETE method performed: car with id {} was deleted", id);
    }
}
