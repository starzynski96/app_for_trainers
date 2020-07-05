package akademia.app_for_trainers.Controller;

import akademia.app_for_trainers.Models.TrainersModel;
import akademia.app_for_trainers.Service.TrainersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrainersController {
    private final TrainersService trainersService;

    public TrainersController(TrainersService trainersService) {
        this.trainersService = trainersService;
    }

    @GetMapping("api/v1/all")
    public List<TrainersModel> getAllReservation(){
        return trainersService.getAll();
    }
}
