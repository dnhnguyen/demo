package com.bezkoder.springjwt.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles_user_modules")
public class RolesUserModule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 200)
    private String actions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_module_id")
    private GroupModule groupModule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    public RolesUserModule(String actions, GroupModule groupModule, User user) {
        this.actions = actions;
        this.groupModule = groupModule;
        this.user = user;
    }
}