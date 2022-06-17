package com.flightgearserver.Http.Entiteis;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "starttime")
    private LocalTime starttime;

    @Column(name = "endtime")
    private LocalTime endtime;

    @Column(name = "date")
    private LocalDate date;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "startpoint",columnDefinition = "text")
    private String startpoint;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "endpoint",columnDefinition = "text")
    private String endpoint;

    @Column(name = "aircraftid")
    private Integer aircraftid;

    public Double getMilagedone() {
        return milagedone;
    }

    public void setMilagedone(Double milagedone) {
        this.milagedone = milagedone;
    }

    @Column(name="milagedone")
    private Double milagedone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getStarttime() {
        return starttime;
    }

    public void setStarttime(LocalTime starttime) {
        this.starttime = starttime;
    }

    public LocalTime getEndtime() {
        return endtime;
    }

    public void setEndtime(LocalTime endtime) {
        this.endtime = endtime;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStartpoint() {
        return startpoint;
    }

    public void setStartpoint(String startpoint) {
        this.startpoint = startpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public Integer getAircraftid() {
        return aircraftid;
    }

    public void setAircraftid(Integer aircraftid) {
        this.aircraftid = aircraftid;
    }

}