package com.stradaperroma.account.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private UUID id;
    private String username;
    private String firstname;
    private String lastname;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    protected Role role = Role.STUDENT;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_at")
    private Date createAt;
    @PrePersist
    private void prePersist() {
        this.createAt = new Date();
    }


}
