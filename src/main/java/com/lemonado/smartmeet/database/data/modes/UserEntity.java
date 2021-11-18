package com.lemonado.smartmeet.database.data.modes;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public final class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "email")
    private String email;

    @Column(name = "delete_timestamp")
    private OffsetDateTime deleteTimestamp;

    @Column(name = "valid_token_timestamp")
    private OffsetDateTime validTokenTimestamp;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<RoleEntity> roles = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public OffsetDateTime getDeleteTimestamp() {
        return deleteTimestamp;
    }

    public void setDeleteTimestamp(OffsetDateTime deleteTimestamp) {
        this.deleteTimestamp = deleteTimestamp;
    }

    public OffsetDateTime getValidTokenTimestamp() {
        return validTokenTimestamp;
    }

    public void setValidTokenTimestamp(OffsetDateTime validTokenTimestamp) {
        this.validTokenTimestamp = validTokenTimestamp;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

}
