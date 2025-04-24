package com.cdac.hss.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserRole {
    @EmbeddedId
    private UserRoleId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "expert_type_id")
    private ExpertType expertType;

    @ManyToOne
    @JoinColumn(name = "domain_id", insertable = false, updatable = false)
    private Domain domain;

    @ManyToOne
    @JoinColumn(name = "subdomain_id", insertable = false, updatable = false)
    private Subdomain subdomain;


}


