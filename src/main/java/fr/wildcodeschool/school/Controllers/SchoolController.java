package fr.wildcodeschool.school.Controllers;

import fr.wildcodeschool.school.Entity.School;
import fr.wildcodeschool.school.Repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SchoolController {

    @Autowired
    private SchoolRepository schoolRepository;

    @PostMapping("/schools")
    public School create (@RequestBody School school) {
        return schoolRepository.save(school);
    }

    @GetMapping("/schools")
    public List<School> read () {
        return schoolRepository.findAll();
    }

    @GetMapping("schools/{id}")
    public School readById(@PathVariable Long id) {
        return schoolRepository.findById(id).get();
    }

    @DeleteMapping("schools/{id}")
    public void delete(@PathVariable Long id) {
         schoolRepository.deleteById(id);
    }

    @PutMapping("schools/{id}")
    public School update(@PathVariable Long id, @RequestBody School schoolUpdate) {
         School schoolFromDatabase = schoolRepository.findById(id).get();
         schoolFromDatabase.setName(schoolUpdate.getName());
         schoolFromDatabase.setCity(schoolUpdate.getCity());
         return schoolRepository.save(schoolFromDatabase);
    }
}
