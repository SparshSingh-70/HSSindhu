package com.cdac.hss.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ExpertType {
    @Id
    private int expertTypeId;

    @Enumerated(EnumType.STRING)
    private com.cdac.hss.enums.ExpertType expertTypeName;
}
