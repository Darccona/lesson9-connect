package geo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class RegionEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    public RegionEntity() { }

    public RegionEntity(String name) {
        this.name = name;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<CityEntity> city = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "страны", nullable = false)
    private CountryEntity country;

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setCity(Set<CityEntity> city) {
        this.city = city;
    }
    public Set<CityEntity> getCity() {
        return city;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }
    public CountryEntity getCountry() {
        return country;
    }
}
