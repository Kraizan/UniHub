package com.kraizan.userms.user;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "AppUser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long collegeId;
    private List<Long> userProducts;

    public User() {}

    public User(Long id, String name, Long collegeId, List<Long> userProducts) {
        this.id = id;
        this.name = name;
        this.collegeId = collegeId;
        this.userProducts = userProducts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Long collegeId) {
        this.collegeId = collegeId;
    }

    public List<Long> getUserProducts() {
        return userProducts;
    }

    public void setUserProducts(List<Long> userProducts) {
        this.userProducts = userProducts;
    }
}
