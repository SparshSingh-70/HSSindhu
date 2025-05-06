package com.cdac.hss.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class UserRoleId implements Serializable {

        @Column(name = "user_id")
        private Integer userId;

        @Column(name = "domain_id")
        private Integer domainId;

        @Column(name = "role_id")
        private Integer roleId;

       @Column(name = "subdomain_id")
        private Integer subdomainId;

        // Getters and setters
        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                UserRoleId that = (UserRoleId) o;
                return userId == that.userId && roleId == that.roleId && domainId == that.domainId
                        && subdomainId == that.subdomainId;
        }

        @Override
        public int hashCode() {
                return Objects.hash(userId, roleId, domainId);
        }

}
