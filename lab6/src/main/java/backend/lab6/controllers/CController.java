package backend.lab6.controllers;

import backend.lab6.entities.EEntity;
import backend.lab6.exceptions.ResourceNotFoundException;
import backend.lab6.repositories.RRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lab6/api")
@CrossOrigin(origins = "*")
public class CController {

    @Autowired
    private RRepository cRepo;

    @GetMapping("/list")
    public List<EEntity> getEntityes() {
        return cRepo.findAll();
    }

    @PostMapping("/add")
    public EEntity postEntityes(@RequestBody EEntity entity) {
        return cRepo.save(entity);
    }

    @PutMapping("/update/{id}")
    public EEntity putEntity(@PathVariable long id, @RequestBody EEntity updatedEntity) {
        EEntity newEntity = cRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No entity found with id:" + id));

        newEntity.setName(updatedEntity.getName());
        newEntity.setImg(updatedEntity.getImg());
        newEntity.setPrice(updatedEntity.getPrice());

        return cRepo.save(newEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEntity(@PathVariable long id) {
        EEntity entity = cRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No entity found with id:" + id));

        cRepo.delete(entity);
    }
}