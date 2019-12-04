package edu.mum.cs544;

import edu.mum.cs544.domain.Laptop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppMain {
    private static EntityManagerFactory emf;

    public void EmployeeLaptop(){

    }

    public static void main(String[] args) {

        emf = Persistence.createEntityManagerFactory("edu.mum.cs544");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();


    }
}
