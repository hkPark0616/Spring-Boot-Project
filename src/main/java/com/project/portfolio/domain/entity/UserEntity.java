package com.project.portfolio.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    private String id;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String password;

    @Builder
    public UserEntity(String id,
                      String name,
                      String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
}
