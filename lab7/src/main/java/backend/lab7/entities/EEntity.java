package backend.lab7.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="entityes")
public class EEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String img;
    private int price;
}
