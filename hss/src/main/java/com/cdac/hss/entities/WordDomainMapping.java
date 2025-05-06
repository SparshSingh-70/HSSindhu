package com.cdac.hss.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "word_entry_domain_mapping")
public class WordDomainMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "word_entry_id", referencedColumnName = "vid")
    private WordEntry wordEntry;

    @ManyToOne
    @JoinColumn(name = "domain_id", referencedColumnName = "domain_id")
    private Domain domain;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
