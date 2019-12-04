package edu.mum.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "user")
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", nullable = false)
    private Long id;

    @Column(name = "IS_ADMIN", nullable = false)
    private boolean admin = false;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private int rating;

    @Version
    @Column(nullable = false)
    private int version;

    @Temporal(TemporalType.TIME)
    private Date lastLogin;

    public User(String firstName, String lastName, String email, int rating, boolean admin, int version, Date lastLogin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.rating = rating;
        this.version = version;
        this.admin = admin;
        this.lastLogin = lastLogin;
    }

}