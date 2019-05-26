package pl.bykowski.springbootapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/animal")
public class AnimalApi {

    private AnimalRepo animalRepo;

    @Autowired
    public AnimalApi (AnimalRepo animalRepo){

        this.animalRepo = animalRepo;
    }

    @GetMapping
    public Iterable <Animal> getAnimals() {
        return  animalRepo.findAll();
    }

    @PostMapping
    public void addAnimal(@RequestBody Animal animal) {
         animalRepo.save(animal);
    }

    @PutMapping
    public void updateAnimal(@RequestBody Animal animal) {
        animalRepo.save(animal);
    }

    @DeleteMapping
    public void deleteAnimal(@RequestParam Long id) {
        animalRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        Animal animal = new Animal();
        animal.setId(1L);
        animal.setName("Pucek");
        animal.setAge(11);
    }


}
