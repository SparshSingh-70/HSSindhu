package com.cdac.hss.entities;

import com.cdac.hss.enums.AllotStatus;
import com.cdac.hss.enums.EntryStatus;
import com.cdac.hss.enums.VerificationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class WordEntry {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vid;

    private String word;
    private String english_translation;

    @ManyToOne
    @JoinColumn(name = "added_By")
    private User addedBy;

    @ManyToOne
    @JoinColumn(name = "verified_by")
    private User verifiedBy;

    @Enumerated(EnumType.STRING)
    @Column(name = "entry_status")
    private EntryStatus entryStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "allot_status")
    private AllotStatus allotStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "verification_status")
    private VerificationStatus verificationStatus;

    private boolean isLive;
    private String tempId;

    @ManyToOne
    @JoinColumn(name = "part_of_speech_id")
    private PartOfSpeech partOfSpeech; //Can also be an ENUM

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private WordGender gender;

    @ManyToOne
    @JoinColumn(name = "origin_id")
    private WordOrigin origin;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "word_entry_domain_mapping",
            joinColumns = @JoinColumn(name = "word_entry_id"),
            inverseJoinColumns = @JoinColumn(name = "domain_id")
    )
    private List<Domain> domains = new ArrayList<>();


}
