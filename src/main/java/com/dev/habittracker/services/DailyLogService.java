package com.dev.habittracker.services;

import com.dev.habittracker.models.DailyLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev.habittracker.repositories.DailyLogRepository;



import java.time.LocalDate;
import java.util.List;

@Service
public class DailyLogService {

    @Autowired
    private DailyLogRepository dailyLogRepository;

    public List<DailyLog> getDailyLogsByHabitIdAndDateRange(Long habitId, LocalDate startDate, LocalDate endDate){
        return dailyLogRepository.findByHabitIdAndDateBetweenOrderByDateAsc(habitId, startDate, endDate);

    }

    public DailyLog saveDailyLog(DailyLog dailyLog){
        return dailyLogRepository.save(dailyLog);
    }
}
