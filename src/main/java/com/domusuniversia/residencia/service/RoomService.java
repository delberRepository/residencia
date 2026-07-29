package com.domusuniversia.residencia.service;

import com.domusuniversia.residencia.model.Room;
import com.domusuniversia.residencia.model.RoomType;
import com.domusuniversia.residencia.repository.RoomRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    public List<Room> findAvailableRooms() {
        return roomRepository.findByAvailable(true);
    }

    public List<Room> findByAvailability(Boolean available) {
        return roomRepository.findByAvailable(available);
    }

    public List<Room> findByType(RoomType tipo) {
        return roomRepository.findByTipo(tipo);
    }

    public Room findById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Room not found with id: " + id));
    }

    public Room create(Room room) {
        room.setId(null);
        return roomRepository.save(room);
    }

    public Room update(Long id, Room room) {
        Room existingRoom = findById(id);
        existingRoom.setNumero(room.getNumero());
        existingRoom.setFloor(room.getFloor());
        existingRoom.setDescription(room.getDescription());
        existingRoom.setCapacity(room.getCapacity());
        existingRoom.setAvailable(room.getAvailable());
        existingRoom.setTipo(room.getTipo());
        existingRoom.setAmenities(room.getAmenities());
        existingRoom.setGalleryImages(room.getGalleryImages());
        return roomRepository.save(existingRoom);
    }

    public Room updateAvailability(Long id, Boolean available) {
        Room room = findById(id);
        room.setAvailable(available);
        return roomRepository.save(room);
    }

    public void delete(Long id) {
        Room room = findById(id);
        roomRepository.delete(room);
    }
}
