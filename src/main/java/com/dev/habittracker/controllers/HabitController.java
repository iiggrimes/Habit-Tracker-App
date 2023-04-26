package com.dev.habittracker.controllers;

import com.dev.habittracker.models.Habit;
import com.dev.habittracker.repositories.HabitRepository;
import com.dev.habittracker.services.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/habits")
public class HabitController {
    @Autowired
    private HabitRepository habitRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Habit> getHabitById(@PathVariable Long id){
        Optional<Habit> habitOptional = habitRepository.findById(id);
        return habitOptional.map(habit -> ResponseEntity.ok().body(habit)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Habit> createHabit(@RequestBody Habit habit) {
        Habit savedHabit = habitRepository.save(habit);
        return ResponseEntity.created(URI.create("/habits" + savedHabit.getId())).body(savedHabit);


    }

    @GetMapping("/{id}/records")
    public ResponseEntity<List<Record>> getHabitRecords(@PathVariable Long id) {
        Optional<Habit> habitOptional = habitRepository.findById(id);
        if (habitOptional.isPresent()) {
            Habit habit = habitOptional.get();
            return ResponseEntity.ok().body(habit.getRecords());
        } else {
            return ResponseEntity.notFound().build();

        }
    }



}
