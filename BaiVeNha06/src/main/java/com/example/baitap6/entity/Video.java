package com.example.baitap6.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="videos")
@NamedQuery(name="Video.findAll", query="SELECT v FROM Video v")
public class Video implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="title", columnDefinition = "NVARCHAR(255)")
    private String title;
    
    @Column(name="href", columnDefinition = "NVARCHAR(255)")
    private String href;
    
    @Column(name="poster", columnDefinition = "NVARCHAR(255)")
    private String poster;
    
    @Column(name="views")
    private Integer views;
    
    @Column(name="shares")
    private Integer shares;
    
    @Column(name="description", columnDefinition = "NVARCHAR(MAX)")
    private String description;
    
    @Column(name="isActive")
    private Boolean isActive;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="createDate")
    private Date createDate;
    
    @ManyToOne
    @JoinColumn(name="categoryId")
    private Category category;
}
