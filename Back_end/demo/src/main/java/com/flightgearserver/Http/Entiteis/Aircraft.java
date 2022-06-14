package com.flightgearserver.Http.Entiteis;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "aircrafts")
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "type",columnDefinition = "text")
    private String type;

    @Column(name = "millage")
    private Double millage;

    @Column(name = "dateadded")
    private Instant dateadded;

    public Instant getDateadded() {
        return dateadded;
    }

    public void setDateadded(Instant dateadded) {
        this.dateadded = dateadded;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getMillage() {
        return millage;
    }

    public void setMillage(Double millage) {
        this.millage = millage;
    }

}