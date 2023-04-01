package com.dev.habittracker.services;

import com.dev.habittracker.models.Habit;
import com.dev.habittracker.repositories.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitService {

    @Autowired
    private HabitRepository habitRepository;

    public List<Habit> getHabitsByUserId(Long userId) {
        return habitRepository.findByUserId(userId);
    }

    public Habit saveHabit(Habit habit) {
        return habitRepository.save(habit);

    }

    public void deleteHabit(Long habitId){
        habitRepository.deleteById(habitId);
    }

}
