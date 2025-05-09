package com.cdac.hss.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Subdomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subdomain_id")
    private int subDomainId;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "domain_id", referencedColumnName = "domain_id")
    private Domain domain;

    @Column(name = "subdomain_sequence_id")
    private Integer subdomainSequenceId;


}
