package com.example.baitap6.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="users")
@NamedQuery(name="AppUser.findAll", query="SELECT u FROM AppUser u")
public class AppUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="username", columnDefinition = "NVARCHAR(255)")
    private String username;
    
    @Column(name="password", columnDefinition = "NVARCHAR(255)")
    private String password;
    
    @Column(name="email", columnDefinition = "NVARCHAR(255)")
    private String email;
    
    @Column(name="fullname", columnDefinition = "NVARCHAR(255)")
    private String fullname;
    
    @Column(name="images", columnDefinition = "NVARCHAR(MAX)")
    private String images;
    
    @Column(name="isAdmin")
    private Boolean isAdmin;
    
    @Column(name="isActive")
    private Boolean isActive;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="createDate")
    private Date createDate;
}
