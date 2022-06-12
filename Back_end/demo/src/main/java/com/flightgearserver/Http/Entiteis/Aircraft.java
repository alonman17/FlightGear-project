package flightgearserver.Http.Entiteis;

import org.hibernate.annotations.Type;

import javax.persistence.*;

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