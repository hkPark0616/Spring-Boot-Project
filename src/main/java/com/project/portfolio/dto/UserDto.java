package com.project.portfolio.dto;

import com.project.portfolio.domain.entity.UserEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDto {
    private String id;
    private String name;
    private String password;

    public UserEntity toEntity() {
        UserEntity build = UserEntity.builder()
                .id(id)
                .name(name)
                .password(password)
                .build();
        return build;
    }

    @Builder
    public UserDto(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
}
