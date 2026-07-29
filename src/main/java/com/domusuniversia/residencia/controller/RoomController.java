package com.domusuniversia.residencia.controller;

import com.domusuniversia.residencia.model.Room;
import com.domusuniversia.residencia.model.RoomType;
import com.domusuniversia.residencia.service.RoomService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<Room> findAll(@RequestParam(required = false) Boolean available,
                              @RequestParam(required = false) RoomType tipo) {
        if (available != null) {
            return roomService.findByAvailability(available);
        }

        if (tipo != null) {
            return roomService.findByType(tipo);
        }

        return roomService.findAll();
    }

    @GetMapping("/{id}")
    public Room findById(@PathVariable Long id) {
        return roomService.findById(id);
    }

    @GetMapping("/available")
    public List<Room> findAvailableRooms() {
        return roomService.findAvailableRooms();
    }

    @GetMapping("/type/{tipo}")
    public List<Room> findByType(@PathVariable RoomType tipo) {

        return roomService.findByType(tipo);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Room create(@RequestBody Room room) {

        return roomService.create(room);
    }

    @PutMapping("/{id}")
    public Room update(@PathVariable Long id, @RequestBody Room room) {
        return roomService.update(id, room);
    }

    @PatchMapping("/{id}/availability")
    public Room updateAvailability(@PathVariable Long id, @RequestBody AvailabilityRequest request) {
        return roomService.updateAvailability(id, request.available());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        roomService.delete(id);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFound(EntityNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    public record AvailabilityRequest(Boolean available) {
    }
}
