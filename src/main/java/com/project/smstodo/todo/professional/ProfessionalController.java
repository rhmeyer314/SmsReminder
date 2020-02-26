package com.project.smstodo.todo.professional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8000")
public class ProfessionalController {

    @Autowired
    ProfessionalService professionalService;

    @GetMapping("/api/v1/professional")
    public List<Professional> getAllProfessionalItems() {
        return professionalService.getAllProfessionalItems();
    }

    @GetMapping("/api/v1/professional/{id}")
    public Optional<Professional> getProfessionalItem(@PathVariable String id) {
        return professionalService.getProfessionalItem(id);
    }

    @PostMapping("/api/v1/professional")
    public void addProfessionalItem(@RequestBody Professional professional) {
        professionalService.addProfessionalItem(professional);
    }

    @PutMapping("/api/v1/professional/{id}")
    public void updateProfessionalItem(@PathVariable String id, @RequestBody Professional professional) {
        professionalService.updateProfessionalItem(id, professional);
    }

    @DeleteMapping("/api/v1/professional/{id}")
    public void deleteProfessionalItem(@PathVariable String id) {
        professionalService.deleteProfessionalItem(id);
    }


}
