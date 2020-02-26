package com.project.smstodo.todo.professional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessionalService {

    @Autowired
    private ProfessionalRepository professionalRepository;

    public List<Professional> getAllProfessionalItems() {
        List<Professional> items = new ArrayList<>();
        professionalRepository.findAll().forEach(items::add);
        return items;
    }

    public Optional<Professional> getProfessionalItem(String id) {
        return professionalRepository.findById(id);
    }

    public void addProfessionalItem(Professional professional) {
        professionalRepository.save(professional);
    }

    public void updateProfessionalItem(String id, Professional professional) {
        professionalRepository.save(professional);
    }

    public void deleteProfessionalItem(String id) {
        professionalRepository.deleteById(id);
    }

}
