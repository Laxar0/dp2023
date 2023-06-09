package backend.exam.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="cars")
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String img;
    private int maxSpeed;
}
