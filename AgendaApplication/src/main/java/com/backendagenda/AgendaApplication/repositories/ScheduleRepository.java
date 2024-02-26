package com.backendagenda.AgendaApplication.repositories;
import com.backendagenda.AgendaApplication.dto.ScheduleDTO;
import com.backendagenda.AgendaApplication.entities.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
//    @Query(" SELECT obj FROM com.backendagenda.AgendaApplication.entities.Schedule obj " +
//            "WHERE UPPER(obj.name) LIKE UPPER(CONCAT('%', :name, '%'))")
@Query(nativeQuery = true, value = "SELECT * FROM tb_schedule WHERE UPPER(name) LIKE UPPER(CONCAT('%', :name, '%'))")
    Page<Schedule> searchByName(String name, Pageable pageable);
}
