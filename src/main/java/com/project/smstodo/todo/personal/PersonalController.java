package com.project.smstodo.todo.personal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// setup endpoints for CRUD operations
@RestController
@CrossOrigin(origins = "http://localhost:8000")
public class PersonalController {

    @Autowired
    PersonalService personalService;

    @GetMapping("/api/v1/personal")
    public List<Personal> getAllPersonalItems() {
        return personalService.getAllPersonalItems();
    }

    @GetMapping("/api/v1/personal/{id}")
    public Optional<Personal> getPersonalItem(@PathVariable String id) {
        return personalService.getPersonalItem(id);
    }

    @PostMapping("/api/v1/personal")
    public @ResponseBody void addPersonalItem(@RequestBody Personal personal) {
        personalService.addPersonalItem(personal);
    }

    @PutMapping("/api/v1/personal/{id}")
    public void updatePersonalItem(@PathVariable String id, @RequestBody Personal personal) {
        personalService.updatePersonalItem(id, personal);
    }

    @DeleteMapping("/api/v1/personal/{id}")
    public void deletePersonalItem(@PathVariable String id) {
        personalService.deletePersonalItem(id);
    }
}
