package com.backendagenda.AgendaApplication.controllers;

import com.backendagenda.AgendaApplication.dto.ContactDTO;
import com.backendagenda.AgendaApplication.dto.ScheduleDTO;
import com.backendagenda.AgendaApplication.dto.ScheduleMinDTO;
import com.backendagenda.AgendaApplication.services.ScheduleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;
    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/all")
    public ResponseEntity<Page<ScheduleDTO>> getAllSchedules(
            @RequestParam(name="name", defaultValue = "") String name, Pageable pageable) {
        return ResponseEntity.ok(scheduleService.getAllSchedules(name, pageable));
    }

    @Transactional
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ScheduleDTO>>getSchedulesByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(scheduleService.getSchedulesByUserId(userId));
    }

    @Transactional
    @PostMapping("/add")
    public ResponseEntity<ScheduleDTO> addSchedule(@Valid @RequestBody ScheduleDTO dto) {
        dto = scheduleService.addSchedule(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);

    }

    @DeleteMapping("/delete/{scheduleId}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long scheduleId) {
        scheduleService.deleteSchedule(scheduleId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{scheduleId}")
    public ResponseEntity<ScheduleDTO> updateSchedule(@PathVariable Long scheduleId,@Valid @RequestBody ScheduleDTO scheduleDetails) {
        return ResponseEntity.ok(scheduleService.updateSchedule(scheduleId, scheduleDetails));
    }
    // Endpoint para adicionar um contato a uma agenda
    @PostMapping("/{scheduleId}/contacts")
    public ResponseEntity<ScheduleMinDTO> updateContactToSchedule(@PathVariable Long scheduleId, @Valid @RequestBody ScheduleMinDTO dto) {

        return ResponseEntity.ok(scheduleService.updateContactToSchedule(scheduleId, dto));
    }
}
