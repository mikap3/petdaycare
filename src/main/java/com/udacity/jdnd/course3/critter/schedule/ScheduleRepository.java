package com.udacity.jdnd.course3.critter.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query("SELECT DISTINCT s FROM Customer c INNER JOIN c.pets p INNER JOIN p.schedules s WHERE c.id = :customerId")
    List<Schedule> findByCustomerId(Long customerId);
}
