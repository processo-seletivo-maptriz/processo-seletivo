package com.backendagenda.AgendaApplication.services;

import com.backendagenda.AgendaApplication.dto.ContactDTO;
import com.backendagenda.AgendaApplication.dto.ScheduleDTO;
import com.backendagenda.AgendaApplication.dto.UserToScheduleDTO;
import com.backendagenda.AgendaApplication.entities.Contact;
import com.backendagenda.AgendaApplication.entities.Schedule;
import com.backendagenda.AgendaApplication.entities.User;
import com.backendagenda.AgendaApplication.repositories.ContactRepository;
import com.backendagenda.AgendaApplication.repositories.ScheduleRepository;
import com.backendagenda.AgendaApplication.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    private ContactRepository contactRepository;

    public ScheduleService(ScheduleRepository scheduleRepository, UserRepository userRepository,ContactRepository contactRepository) {
        this.scheduleRepository = scheduleRepository;
        this.userRepository = userRepository;
        this.contactRepository = contactRepository;
    }

    public Page<ScheduleDTO> getAllSchedules(String name, Pageable pageable) {
        Page<Schedule> schedule = scheduleRepository.searchByName(name, pageable);
        return schedule.map(ScheduleDTO::new);
    }

    public List<ScheduleDTO> getSchedulesByUserId(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
        List<Schedule> schedules = user.getSchedules();
        return schedules.stream().map(ScheduleDTO::new).collect(Collectors.toList());
    }


    public ScheduleDTO addSchedule(ScheduleDTO dto) {
        Schedule entity = new Schedule();

        LocalDateTime now = LocalDateTime.now();
        entity.setName(dto.getName());
        entity.setExpirationDate(dto.getExpirationDate().toLocalDate());
        entity.setCreatedAt(now);
        entity.setUpdatedAt(now);

//        for (UserToScheduleDTO userToScheduleDTO : dto.getUsers()) {
//            System.out.println("dados usuarios service" + "=" + userToScheduleDTO.getId());
//        }

        entity.getUsers().clear();

        for (UserToScheduleDTO userToScheduleDto : dto.getUsers()) {
            User user = new User();
            user.setId(userToScheduleDto.getId());
            entity.getUsers().add(user);
        }
        entity = scheduleRepository.save(entity);
        return new ScheduleDTO(entity);
    }


    public void deleteSchedule(Long scheduleId) {
        scheduleRepository.deleteById(scheduleId);
        try {
            scheduleRepository.deleteById(scheduleId);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    public ScheduleDTO updateSchedule(Long id, ScheduleDTO dto) {
        try {
            Schedule entity = scheduleRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Agenda não encontrada com ID: " + id));

            entity.setName(dto.getName());
            entity.setExpirationDate(dto.getExpirationDate().toLocalDate());
            entity.setUpdatedAt(LocalDateTime.now());

            entity.getUsers().clear();

            for (UserToScheduleDTO userToScheduleDto : dto.getUsers()) {
                User user = userRepository.findById(userToScheduleDto.getId())
                        .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + userToScheduleDto.getId()));
                entity.getUsers().add(user);
            }
            return new ScheduleDTO(scheduleRepository.save(entity));
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado", e);
        }
    }

    public ScheduleDTO addContactToSchedule(Long scheduleId, ScheduleDTO dto) {
        Schedule entity = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new EntityNotFoundException("Agenda não encontrada com o ID: " + scheduleId));

        entity.getContacts().clear();
        for (ContactDTO contactDto: dto.getContacts()) {
            Contact contact = new Contact();
            contact.setName(contactDto.getName());
            contact.setCep(contactDto.getCep());
            contact.setEmail(contactDto.getEmail());
            contact.setPhone(contactDto.getPhone());
            contact.setCnpj(contactDto.getCnpj());
            contact.setCpf(contactDto.getCpf());
            contact.setSchedule(entity);

            entity.getContacts().add(contact);
        }
        return new ScheduleDTO(scheduleRepository.save(entity));
    }

}
