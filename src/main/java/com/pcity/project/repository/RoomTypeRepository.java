package com.pcity.project.repository;

import com.pcity.project.domain.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {
    public Optional<RoomType> findRoomTypeByRoomTypeStrId(String RoomTypeStrId);
}
