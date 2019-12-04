package edu.mum.cs544.domain;

import com.sun.imageio.stream.StreamFinalizer;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "passenger_id")
    @OrderColumn(name = "sequence")
    List<Flight> flights = new ArrayList<Flight>();

    public Passenger(String firstName){
        this.name = firstName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String firstName) {
        this.name = firstName;
    }

    public String getName() {
        return name;
    }

    public void setFlightlist(List<Flight> flightlist) {
        System.out.println("===============setFlightlist===============");
        this.flights = flightlist;
    }

    public List<Flight> getFlightlist() {
        System.out.println("===============getFlightlist===============");
//        return Collections.unmodifiableList(flightlist);
        return flights;
    }

    public boolean addFlight(Flight flight) {
        return flights.add(flight);
    }

    public boolean removeFlight(Flight flight) {
        return flights.remove(flight);
    }
}
