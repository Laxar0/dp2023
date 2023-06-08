package backend.lab7.repositories;

import backend.lab7.entities.EEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "entityes", path = "entityes")
public interface RRepository extends JpaRepository<EEntity, Long> {
}
