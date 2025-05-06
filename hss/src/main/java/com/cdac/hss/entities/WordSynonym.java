package com.cdac.hss.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table( name = "word_synonyms")
@Data @AllArgsConstructor @NoArgsConstructor
public class WordSynonym {

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

    @Column(name = "synonym", columnDefinition = "TEXT")
    private String synonym;

    @ManyToOne
    @JoinColumn(name = "created_by", referencedColumnName = "user_id")
    private User createdBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;


}
