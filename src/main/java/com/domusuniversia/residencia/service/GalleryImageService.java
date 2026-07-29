package com.domusuniversia.residencia.service;

import com.domusuniversia.residencia.model.GaleryImage;
import com.domusuniversia.residencia.model.Room;
import com.domusuniversia.residencia.repository.GaleryImageRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GalleryImageService {

    private final GaleryImageRepository galeryImageRepository;
    private final RoomService roomService;

    public GalleryImageService(GaleryImageRepository galeryImageRepository, RoomService roomService) {
        this.galeryImageRepository = galeryImageRepository;
        this.roomService = roomService;
    }

    public List<GaleryImage> findAll() {
        return galeryImageRepository.findAll();
    }

    public List<GaleryImage> findByRoomId(Long roomId) {
        return galeryImageRepository.findByRoomId(roomId);
    }

    public GaleryImage findById(Long id) {
        return galeryImageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Gallery image not found with id: " + id));
    }

    public GaleryImage create(GaleryImage galeryImage) {
        galeryImage.setId(null);
        attachRoomIfPresent(galeryImage);
        return galeryImageRepository.save(galeryImage);
    }

    public GaleryImage update(Long id, GaleryImage galeryImage) {
        GaleryImage existingGaleryImage = findById(id);
        existingGaleryImage.setUrl(galeryImage.getUrl());
        existingGaleryImage.setTitle(galeryImage.getTitle());
        existingGaleryImage.setImageOrder(galeryImage.getImageOrder());
        existingGaleryImage.setRoom(galeryImage.getRoom());
        attachRoomIfPresent(existingGaleryImage);
        return galeryImageRepository.save(existingGaleryImage);
    }

    public void delete(Long id) {
        GaleryImage galeryImage = findById(id);
        galeryImageRepository.delete(galeryImage);
    }

    private void attachRoomIfPresent(GaleryImage galeryImage) {
        if (galeryImage.getRoom() != null && galeryImage.getRoom().getId() != null) {
            Room room = roomService.findById(galeryImage.getRoom().getId());
            galeryImage.setRoom(room);
        }
    }
}
