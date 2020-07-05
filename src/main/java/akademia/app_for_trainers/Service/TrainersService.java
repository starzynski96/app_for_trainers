package akademia.app_for_trainers.Service;


import akademia.app_for_trainers.Models.TrainersModel;
import akademia.app_for_trainers.Repository.TrainerRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class TrainersService {
    private final TrainerRepository trainerRepository;

    public TrainersService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public List<TrainersModel> getAll() {
        return trainerRepository.findAll();
    }

    public ResponseEntity<?> addReservaation(TrainersModel trainersModel) {
        trainerRepository.save(trainersModel);
        return ResponseEntity.ok().header("Dodawanie rezerwacji", "Dodano!").body(trainersModel);

    }

    public ResponseEntity<?> updateCar(TrainersModel updateReservation, long id) {
        TrainersModel reservation = trainerRepository.getOne(id);
        reservation.setDateOfReservation(updateReservation.getDateOfReservation() == null ? reservation.getDateOfReservation() : updateReservation.getDateOfReservation());
        reservation.setName(updateReservation.getName() == null ? reservation.getName() : updateReservation.getName());
        reservation.setSurname(updateReservation.getSurname() == null ? reservation.getSurname() : updateReservation.getSurname());
        trainerRepository.save(reservation);
        return ResponseEntity
                .ok()
                .body(reservation);
    }

    public ResponseEntity<?> deleteById(long id) {
        try {
            trainerRepository.deleteById(id);

        } catch (EmptyResultDataAccessException | EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();

    }

    public List<TrainersModel> getByName(String name) {
        return trainerRepository.getTrainerByName(name);
    }

    public List<TrainersModel> getBySurname(String surname) {
        return trainerRepository.getTrainerBySurname(surname);
    }

    public List<TrainersModel> getReservationByTime(String date) {
        return trainerRepository.getReservationByTime(date);
    }
}
