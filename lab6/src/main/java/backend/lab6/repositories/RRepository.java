package backend.lab6.repositories;

import backend.lab6.entities.EEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RRepository extends JpaRepository<EEntity, Long> {
}
