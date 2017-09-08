package com.zz.domain.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhangz on 2017/7/18.
 */
@Entity
@Data
@DynamicInsert
@DynamicUpdate
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String identifier;
    private String description;
    private boolean available;

    @ManyToMany                                      //多对多关系
    @Cascade(value = {CascadeType.SAVE_UPDATE})        //级联关系
    @JoinTable(name = "role_permission",                     //中间表的名称
            joinColumns = {@JoinColumn(name = "role_id")},   //本表与中间表的外键对应关系
            inverseJoinColumns = {@JoinColumn(name = "permission_id")}) //另一张表与中间表的外键的对应关系
    private Set<Permission> permissions = new HashSet<>();

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)                                      //多对多关系
    @Cascade(value = {CascadeType.SAVE_UPDATE})        //级联关系
    @JoinTable(name = "user_role",                     //中间表的名称
            joinColumns = {@JoinColumn(name = "role_id")},   //本表与中间表的外键对应关系
            inverseJoinColumns = {@JoinColumn(name = "user_id")}) //另一张表与中间表的外键的对应关系
    private Set<UserAccount> userAccounts = new HashSet<>();

    @Transient
    public Set<String> getPermissionIdentifiers() {
        Set<String> permissionIdentifiers = new HashSet<>();StringBuffer sb = new StringBuffer();
        this.getPermissions().forEach(permission -> permissionIdentifiers.add(permission.getPermissionIdentifier()));
        return permissionIdentifiers;
    }

}
