package akademia.app_for_trainers.Repository;


import akademia.app_for_trainers.Models.TrainersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends JpaRepository<TrainersModel,Long> {

}
