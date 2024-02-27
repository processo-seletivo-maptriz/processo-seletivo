package com.backendagenda.AgendaApplication.services;

import com.backendagenda.AgendaApplication.dto.ContactDTO;
import com.backendagenda.AgendaApplication.dto.ScheduleDTO;
import com.backendagenda.AgendaApplication.dto.ScheduleMinDTO;
import com.backendagenda.AgendaApplication.dto.UserToScheduleDTO;
import com.backendagenda.AgendaApplication.entities.Contact;
import com.backendagenda.AgendaApplication.entities.Schedule;
import com.backendagenda.AgendaApplication.entities.User;
import com.backendagenda.AgendaApplication.repositories.ContactRepository;
import com.backendagenda.AgendaApplication.repositories.ScheduleRepository;
import com.backendagenda.AgendaApplication.repositories.UserRepository;
import com.backendagenda.AgendaApplication.services.exceptions.DatabaseException;
import jakarta.persistence.EntityNotFoundException;

import com.backendagenda.AgendaApplication.services.exceptions.ResourNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    private ContactRepository contactRepository;

    public ScheduleService(ScheduleRepository scheduleRepository, UserRepository userRepository, ContactRepository contactRepository) {
        this.scheduleRepository = scheduleRepository;
        this.userRepository = userRepository;
        this.contactRepository = contactRepository;
    }

    public Page<ScheduleDTO> getAllSchedules(String name, Pageable pageable) {
        try {
            Page<Schedule> schedule = scheduleRepository.searchByName(name, pageable);
            return schedule.map(ScheduleDTO::new);
        }catch (DataAccessException e) {
            throw new ResourNotFoundException("Erro ao buscar agendamentos por nome" + e);
        }
    }

    public List<ScheduleDTO> getSchedulesByUserId(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourNotFoundException("Usuario não encontrada com ID : " + userId));
        List<Schedule> schedules = user.getSchedules();
        return schedules.stream().map(ScheduleDTO::new).collect(Collectors.toList());
    }


    public ScheduleDTO addSchedule(ScheduleDTO dto) {
        try {
            Schedule entity = new Schedule();

            LocalDateTime now = LocalDateTime.now();
            entity.setName(dto.getName());
            entity.setExpirationDate(dto.getExpirationDate().toLocalDate());
            entity.setCreatedAt(now);
            entity.setUpdatedAt(now);

            entity.getUsers().clear();

            for (UserToScheduleDTO userToScheduleDto : dto.getUsers()) {
                User user = new User();
                user.setId(userToScheduleDto.getId());
                entity.getUsers().add(user);
            }
            entity = scheduleRepository.save(entity);
            return new ScheduleDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourNotFoundException("Erro ao salvar no banco de dados" + e);
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteSchedule(Long scheduleId) {
        try {
            scheduleRepository.deleteById(scheduleId);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourNotFoundException("Recurso não encontrado");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    public ScheduleDTO updateSchedule(Long id, ScheduleDTO dto) {
        try {
            Schedule entity = scheduleRepository.findById(id)
                    .orElseThrow(() -> new ResourNotFoundException("Agenda não encontrada com ID: " + id));

            entity.setName(dto.getName());
            entity.setExpirationDate(dto.getExpirationDate().toLocalDate());
            entity.setUpdatedAt(LocalDateTime.now());

            entity.getUsers().clear();

            for (UserToScheduleDTO userToScheduleDto : dto.getUsers()) {
                User user = userRepository.findById(userToScheduleDto.getId())
                        .orElseThrow(() -> new ResourNotFoundException("Usuário não encontrado com ID: " + userToScheduleDto.getId()));
                entity.getUsers().add(user);
            }
            return new ScheduleDTO(scheduleRepository.save(entity));
        } catch (EntityNotFoundException e) {
            throw new ResourNotFoundException("Recurso não encontrado" + e);
        }
    }

    public ScheduleMinDTO updateContactToSchedule(Long scheduleId, ScheduleMinDTO dto) {
        try {


            Schedule schedule = scheduleRepository.findById(scheduleId)
                    .orElseThrow(() -> new ResourNotFoundException("Agenda não encontrada com o ID: " + scheduleId));
            Schedule entity = new Schedule();
            entity = schedule;
            entity.getContacts().clear();
            for (ContactDTO contactDto : dto.getContacts()) {
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
            return new ScheduleMinDTO(scheduleRepository.save(entity));
        } catch (ResourNotFoundException e) {
            throw e;
        } catch (Exception e){
            throw new RuntimeException("Erro ao atualizar contato na agenda", e);
        }
    }
}
