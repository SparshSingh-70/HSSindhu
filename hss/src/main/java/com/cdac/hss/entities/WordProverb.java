package com.cdac.hss.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "word_proverbs")
@Data @AllArgsConstructor @NoArgsConstructor
public class WordProverb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    //the entry in WordProverb table will be the "name" = vid column
    //the referenced column is vid of wordEntry Table
    @ManyToOne
    @JoinColumn(name = "vid", referencedColumnName = "vid")
    private WordEntry wordEntry;

    @ManyToOne
    @JoinColumn(name = "subdomain_id", referencedColumnName = "subdomain_id")
    private Subdomain subDomain;

    @Column(name = "proverb")
    private String proverb;

    @ManyToOne
    @JoinColumn(name = "created_by", referencedColumnName = "user_id")
    private User createdBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
