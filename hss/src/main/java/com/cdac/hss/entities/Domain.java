package com.cdac.hss.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "domains")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "domain_id")
    private int domainId;

    @Column(name = "name")
    private String name;

    @Column(name = "eng_name")
    private String engName;

    @ManyToMany(mappedBy = "domains")
    private List<WordEntry> wordEntries = new ArrayList<>();

}
