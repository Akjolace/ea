package edu.mum.cs544.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


//@Setter
//@Getter
//@Table(name = "employee")
@NoArgsConstructor
@Entity
public class Employee {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    String firstName;
    @Getter
    @Setter
    String lastName;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.PERSIST)
    Set<Laptop> laptops = new HashSet<Laptop>();

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public Set<Laptop> getLaptops(){
        return Collections.unmodifiableSet(laptops);
    }

    public boolean addLaptop(Laptop laptop) {
        boolean added = laptops.add(laptop);
        if (added) {
            laptop.setEmployee(this);
        }
        return added;

//        if (laptops.add(laptop)){
//            laptop.setEmployee(this);
//            return true;
//        }
//        return false;
    }

    public boolean removeLaptop(Laptop laptop){
        boolean removed = laptops.add(laptop);
        if (removed) {
            laptop.setEmployee(null);
        }
        return removed;

//        if(laptops.remove(laptop)){
//            laptop.setEmployee(null);
//            return true;
//        }
//        return false;
    }
}
