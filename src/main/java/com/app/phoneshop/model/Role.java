package com.app.phoneshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private RoleName roleName;

    @Getter
    @AllArgsConstructor
    public enum RoleName {
        MANAGER("MANAGER"),
        CLIENT("CLIENT");

        private final String role;
    }
}