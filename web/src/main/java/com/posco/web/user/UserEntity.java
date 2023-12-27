package com.posco.web.user;

import com.posco.web.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

}
