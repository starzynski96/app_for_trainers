package akademia.app_for_trainers.Controller;

import akademia.app_for_trainers.Models.TrainersModel;
import akademia.app_for_trainers.Service.TrainersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@EnableSwagger2
@RestController
public class TrainersController {
    private final TrainersService trainersService;

    public TrainersController(TrainersService trainersService) {
        this.trainersService = trainersService;
    }

    @GetMapping("api/v1/all")
    public List<TrainersModel> getAllReservation() {
        return trainersService.getAll();
    }
    @GetMapping("api/v1/all/byName")
    public List<TrainersModel> getByName(@RequestParam String name) {
        return trainersService.getByName(name);
    }
    @GetMapping("api/v1/all/bySurname")
    public List<TrainersModel> getBySurname(@RequestParam String surname) {
        return trainersService.getBySurname(surname);
    }
    @GetMapping("api/v1/all/byDate")
    public List<TrainersModel> getByDate (@RequestParam String date) {
        return trainersService.getReservationByTime(date);
    }


    @PostMapping("api/v1/trainer")
    public ResponseEntity<?> addReservation(@RequestBody TrainersModel trainersModel) {
        return trainersService.addReservaation(trainersModel);

    }

    @PutMapping("/api/v1/trainer")
    public ResponseEntity<?> updateResrevation(@RequestBody TrainersModel trainersModel, @RequestParam long id) {
        return trainersService.updateCar(trainersModel, id);

    }

    @DeleteMapping("/api/v1/trainer/{id}")
    public ResponseEntity<?> deleteByID ( @PathVariable(value = "id") long id){
        return trainersService.deleteById(id);
    }
}
