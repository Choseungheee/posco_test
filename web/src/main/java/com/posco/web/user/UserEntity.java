package com.posco.web.user;

import com.posco.web.TodoEntity;
import com.posco.web.common.BaseEntity;
import jakarta.persistence.*;
import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="users")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity {
    @Id
    @Column(length=10)
    private String id;

    @Column(name="password")
    private String password;

    @Column
    private String nickName;

    @Column
    private String email;

    @Column(name="name")
    private String name;

    @Column(name="salary")
    private String salary;

    @Column
    private Integer age;

    @Column
    private String profile;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.REMOVE)
    private List<TodoEntity> todoEntityList;

    public UserDTO toUserDTO(){
        UserDTO user = UserDTO.builder()
                .id(this.id)
                .name(this.name)
                .nickName(this.nickName)
                .password(this.password)
                .email(this.email)
                .profile(this.profile)
                .build();
        return user;
    }
}
