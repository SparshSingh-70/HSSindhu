package com.cdac.hss.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "word_examples")
@Data @AllArgsConstructor @NoArgsConstructor
public class WordExample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "vid", referencedColumnName = "vid")
    private WordEntry wordEntry;

    @ManyToOne
    @JoinColumn(name = "subdomain_id", referencedColumnName = "subdomain_id")
    private Subdomain subDomain;

    @Column(name = "example", columnDefinition = "TEXT" )
    private String example;

    @ManyToOne
    @JoinColumn(name = "created_by", referencedColumnName = "user_id")
    private User createdBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
