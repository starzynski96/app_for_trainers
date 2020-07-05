package akademia.app_for_trainers.Repository;


import akademia.app_for_trainers.Models.TrainersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainerRepository extends JpaRepository<TrainersModel,Long> {


    @Query(value = "select c from TrainersModel c where c.name = ?1" )
    List<TrainersModel> getTrainerByName (String brand);

    @Query(value = "select c from TrainersModel c where c.surname = ?1" )
    List<TrainersModel> getTrainerBySurname (String brand);

    @Query(value = "select c from TrainersModel c where c.dateOfReservation = ?1" )
    List<TrainersModel> getReservationByTime (String brand);
}
