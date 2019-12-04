package edu.mum.cs544.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String type;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Employee employee;

    public Laptop(String brand, String type) {
        this.brand = brand;
        this.type = type;
    }
}
