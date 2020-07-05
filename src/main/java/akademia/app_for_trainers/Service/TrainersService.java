package akademia.app_for_trainers.Service;


import akademia.app_for_trainers.Models.TrainersModel;
import akademia.app_for_trainers.Repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainersService {
    private final TrainerRepository trainerRepository;

    public TrainersService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public List<TrainersModel> getAll (){
        return trainerRepository.findAll();
    }

}
