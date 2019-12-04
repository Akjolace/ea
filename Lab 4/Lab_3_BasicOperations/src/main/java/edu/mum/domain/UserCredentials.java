package edu.mum.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Table("authentication")
@Entity
public class UserCredentials {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER", nullable = false, length = 127)
    String username;
    @Column(nullable = false)
    String password;
    String verifyPassword;
    Boolean enabled;


}
