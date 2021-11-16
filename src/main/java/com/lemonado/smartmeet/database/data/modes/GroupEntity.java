package com.lemonado.smartmeet.database.data.modes;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "group")
public class GroupEntity {

    @Id
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToOne()
    private UserEntity creator;

    @Column(name = "code", unique = true)
    private String code;

    @OneToMany
    private Set<GroupUserEntity> users;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserEntity getCreator() {
        return creator;
    }

    public void setCreator(UserEntity creator) {
        this.creator = creator;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<GroupUserEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<GroupUserEntity> users) {
        this.users = users;
    }
}
