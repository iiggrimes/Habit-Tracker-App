package com.dev.habittracker.repositories;

import com.dev.habittracker.models.DailyLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DailyLogRepository extends JpaRepository<DailyLog, Long> {
    List<DailyLog> findHabitIdAndDateBetweenOrderByDateAsc(Long habitId, LocalDate startDate, LocalDate endDate);
}
