/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Andreas
 */
@Entity
@Table(name = "userentity")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT i FROM UserEn i"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT i FROM UserEn i WHERE i.username = :username"),
    @NamedQuery(name = "User.findById", query = "SELECT i FROM UserEn i WHERE i.id = :id"),})
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String password;  //Pleeeeease dont store me in plain text
    private String userName;
    List<String> roles = new ArrayList();

    public UserEntity() {
    }

    public UserEntity(String password, String userName) {
        this.password = password;
        this.userName = userName;
    }

    public UserEntity(String password, String userName, List<String> roles) {
        this.password = password;
        this.userName = userName;
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void AddRole(String role) {
        roles.add(role);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
