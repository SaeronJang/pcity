package com.pcity.project.repository;

import com.pcity.project.domain.HotelReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<HotelReservation, String> {
}
