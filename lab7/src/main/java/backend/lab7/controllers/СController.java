package backend.lab7.controllers;

import backend.lab7.entities.EEntity;
import backend.lab7.repositories.RRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

import javax.swing.text.html.parser.Entity;

@RestController
@RequestMapping("/lab8/api")
@Slf4j
public class СController {
    @Autowired
    private RRepository cRepo;

    @GetMapping("/list")
    public List<EEntity> getEntityes() {
        List<EEntity> entityesList = cRepo.findAll();
        log.info("[ENTITY CONTROLLER] GET method performed: found {} entityes", entityesList.size());
        return entityesList;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public EEntity postEntity(@RequestBody EEntity Entity) {
        cRepo.save(Entity);
        log.info("[ENTITY CONTROLLER] POST method performed: added {} Entity", Entity.getName());
        return Entity;
    }

    @PutMapping("/update/{id}")
    public EEntity putEntity(@PathVariable long id, @RequestBody EEntity updatedEntity) {
        EEntity newEntity = cRepo.findById(id)
                .orElseThrow(() -> new ResourceAccessException("No Entity found with id:" + id));

        newEntity.setName(updatedEntity.getName());
        newEntity.setImg(updatedEntity.getImg());
        newEntity.setPrice(updatedEntity.getPrice());

        log.info("[ENTITY CONTROLLER] PUT method performed: Entity with id {} was updated", id);
        return cRepo.save(newEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEntity(@PathVariable long id) {
        EEntity delEntity = cRepo.findById(id)
                .orElseThrow(() -> new ResourceAccessException("No Entity found with id:" + id));

        cRepo.delete(delEntity);
        log.info("[ENTITY CONTROLLER] DELETE method performed: Entity with id {} was deleted", id);
    }
}
