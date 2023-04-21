package com.kimblue.auth.api.entity;

import com.kimblue.auth.api.global.base.BaseTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(
    name = "authority",
    indexes = {@Index(columnList = "deleted")}
)
@SQLDelete(sql = "UPDATE authority SET deleted = true WHERE authority_id = ?")
public class Authority extends BaseTime {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "authority_id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    private UUID authorityId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", length = 300)
    private String description;

    @ManyToMany(mappedBy = "authorities")
    private Set<Role> roles = new HashSet<>();

    @ManyToMany(mappedBy = "authorities")
    private Set<User> users = new HashSet<>();
    
}
