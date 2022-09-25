package edu.iit.sat.itmd4515.jreginaldo.lab3;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class Country {
    public Country() {
    }

    public Country(String code, String name, String continent, String region, Double surfaceArea, Integer population,
                   String localName, String governmentForm, String code2) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.surfaceArea = surfaceArea;
        this.population = population;
        this.localName = localName;
        this.governmentForm = governmentForm;
        this.code2 = code2;
    }

    @NotBlank(message = "Country Code is Required")
    private String code;

    @NotBlank(message = "Country Name is Required")
    private String name;

    @NotBlank(message = "Country Continent is Required")
    private String continent;

    @NotBlank(message = "Country Region is Required")
    private String region;

    @NotNull(message = "Surface Area is Required")
    @Positive(message = "Surface Area must be a Positive Value")
    private Double surfaceArea;

    @NotNull(message = "Population Count is Required")
    @Positive(message = "Population Count must be a Positive Value")
    private Integer population;

    @NotBlank(message = "Local Name is Required")
    private String localName;

    @NotBlank(message = "Government Form is Required")
    private String governmentForm;

    @NotBlank(message = "Secondary Country Code is Required")
    private String code2;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(Double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getGovernmentForm() {
        return governmentForm;
    }

    public void setGovernmentForm(String governmentForm) {
        this.governmentForm = governmentForm;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    @Override
    public String toString() {
        return "iit.sat.itmd4515.jreginaldo.domain.Country{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", region='" + region + '\'' +
                ", surfaceArea=" + surfaceArea +
                ", population=" + population +
                ", localName='" + localName + '\'' +
                ", governmentForm='" + governmentForm + '\'' +
                ", code2=" + code2 +
                '}';
    }
}
