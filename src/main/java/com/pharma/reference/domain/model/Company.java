package com.pharma.reference.domain.model;

import jakarta.persistence.*;
import lombok.Getter;

import com.pharma.reference.domain.valeobjects.CompanyPrefix;

@Entity
@Table(name = "company")
@Getter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Embedded
    @AttributeOverride(name="value", column=@Column(name = "prefix", nullable = false))
    private CompanyPrefix prefix;

    @Column(name = "last_reference_number", nullable = false)
    private long lastReferenceNumber;

    @Version
    private long version;

    protected Company() {
    }

    public Company(String name, CompanyPrefix prefix, long initialNumber) {
        this.name = name;
        this.prefix = prefix;
        this.lastReferenceNumber = initialNumber;
    }

    public String generateNextReference() {
        long nextNumber = ++lastReferenceNumber;
        return prefix.value() + String.format("%06d", nextNumber);
    }

    public String getPrefixValue() {
        return prefix != null ? prefix.value() : null;
    }
}
