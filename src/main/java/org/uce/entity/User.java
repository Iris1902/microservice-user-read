package org.uce.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User extends PanacheEntity {

    @Column(nullable = false, unique = true)
    public String email;

    @Column(nullable = false)
    public String username;

    @Column(nullable = false)
    public String passwordHash;

    @Column(nullable = false)
    public String fullName;

    public String phoneNumber;
    public String address;

    @Enumerated(EnumType.STRING)
    public Role role;

    public boolean isActive = true;

    public enum Role {
        CUSTOMER, ADMIN, PROVIDER
    }

    // Getters para serialización JSON
    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public Role getRole() {
        return role;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public Long getId() {
        return id;
    }
}