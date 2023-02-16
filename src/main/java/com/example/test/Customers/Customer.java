package com.example.test.Customers;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String country;
    private String city;
    private String gender;

    public Customer(){}
    public Customer(String name, String email, String password,
                    String country, String city, String gender){
        this.name = name;
        this.email = email;
        this.password = password;
        this.country = country;
        this.city = city;
        this.gender = gender;
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
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

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
                Objects.equals(this.email, customer.email) &&
                Objects.equals(this.country, customer.country) &&
                Objects.equals(this.city, customer.city);
    }
    @Override
    public int hashCode()
    {
        return Objects.hash(this.id,
                this.name, this.email, this.country, this.city);
    }
    @Override
    public String toString() {
        return "Customer{ " + "id=" + this.id +
                ", name="+this.name + ", email="+this.email +
                ", country=" + this.country + ", city="+this.city + " }\n";
    }
}
