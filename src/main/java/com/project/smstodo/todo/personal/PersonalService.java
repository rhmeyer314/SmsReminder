package com.project.smstodo.todo.personal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// business logic for CRUD operations
@Service
public class PersonalService {

    @Autowired
    PersonalRepository personalRepository;

    public List<Personal> getAllPersonalItems() {
        List<Personal> items = new ArrayList<>();
        personalRepository.findAll().forEach(items::add);
        return items;
    }

    public Optional<Personal> getPersonalItem(String id) {
        return personalRepository.findById(id);
    }

    public void addPersonalItem(Personal personal) {
        personalRepository.save(personal);
    }

    public void updatePersonalItem(String id, Personal personal) {
        personalRepository.save(personal);
    }

    public void deletePersonalItem(String id) {
        personalRepository.deleteById(id);
    }
}
