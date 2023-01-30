package com.example.test;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String country;

    public Customer(){}
    public Customer(String name, String country){
        this.name = name;
        this.country = country;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o)
            return true;
        if(!(o instanceof Customer))
            return false;
        Customer customer = (Customer) o;
        return Objects.equals(this.id, customer.id) &&
                Objects.equals(this.name, customer.name) &&
                Objects.equals(this.country, customer.country);
    }
    @Override
    public int hashCode()
    {
        return Objects.hash(this.id, this.name, this.country);
    }
    @Override
    public String toString() {
        return "Customer{ " + "id=" + this.id +
                ", name="+this.name + ", role=" + this.country + " }\n";
    }
}
