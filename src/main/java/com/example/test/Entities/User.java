package com.example.test.Entities;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String country;
    private String city;
    private String gender;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "basket",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    List<Product> chosenProducts;

    public User(String name, String email, String password,
                String country, String city, String gender){
        this.name = name;
        this.email = email;
        this.password = password;
        this.country = country;
        this.city = city;
        this.gender = gender;
    }
    public List<Product> getChosenProducts(){
        return chosenProducts;
    }
    @Override
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o)
            return true;
        if(!(o instanceof User))
            return false;
        User user = (User) o;
        return Objects.equals(this.id, user.id) &&
                Objects.equals(this.name, user.name) &&
                Objects.equals(this.email, user.email) &&
                Objects.equals(this.country, user.country) &&
                Objects.equals(this.city, user.city);
    }
    @Override
    public int hashCode()
    {
        return Objects.hash(this.id,
                this.name, this.email, this.country, this.city);
    }
    @Override
    public String toString() {
        return "User{ " + "id=" + this.id +
                ", name="+this.name + ", email="+this.email +
                ", country=" + this.country + ", city="+this.city + " }\n";
    }
}
