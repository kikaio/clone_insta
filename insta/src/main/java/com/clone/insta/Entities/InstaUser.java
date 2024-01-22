package com.clone.insta.Entities;

import java.util.Collection;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.clone.insta.Entities.Base.UTCTimeBaseEntity;
import com.clone.insta.enums.ERoles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@Entity
@SuperBuilder
public class InstaUser extends UTCTimeBaseEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @ColumnDefault("''")
    @Builder.Default
    private String password = "";

    @Column
    @ColumnDefault("''")
    @Builder.Default
    private String signProvider = "";

    @Column
    private ERoles role;

    @Column
    @ColumnDefault("false")
    @Builder.Default
    private boolean isAccountExpired = false;

    @Column
    @ColumnDefault("true")
    @Builder.Default
    private boolean isAccountNonLocked = true;

    @Column
    @ColumnDefault("false")
    @Builder.Default
    private boolean isCredentialsNonExpired = false;

    @Column
    @ColumnDefault("true")
    @Builder.Default
    private boolean isEnabled = true;

    public String name() {
        return email;
    }

    public String getRoleKey() {
        return this.role.getName();
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.isAccountExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }

    @Override
    public Collection<SimpleGrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.toString()));
    }

}
