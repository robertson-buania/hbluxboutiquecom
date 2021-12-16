package com.buania.buanialaxtechhblux.reservation;

import com.buania.buanialaxtechhblux.reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
