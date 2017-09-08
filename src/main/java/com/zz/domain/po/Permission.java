package com.zz.domain.po;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhangz on 2017/7/18.
 */
@Entity
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String permissionName;
    private String permissionIdentifier;
    private boolean isAvailable;

    @JsonBackReference
    @ManyToOne(cascade = javax.persistence.CascadeType.MERGE, fetch = FetchType.EAGER)
    private Permission parent;
    @JsonManagedReference
    @OneToMany(cascade = javax.persistence.CascadeType.ALL, mappedBy = "parent", fetch = FetchType.EAGER)
    private Set<Permission> children;

    public Permission getParent() {
        return parent;
    }

    public void setParent(Permission parent) {
        this.parent = parent;
    }

    public Set<Permission> getChildren() {
        return children;
    }

    public void setChildren(Set<Permission> children) {
        this.children = children;
    }

    @JsonIgnore
    @ManyToMany                                      //多对多关系
    @Cascade(value = {CascadeType.SAVE_UPDATE})        //级联关系
    @JoinTable(name = "role_permission",                     //中间表的名称
            joinColumns = {@JoinColumn(name = "permission_id")},   //本表与中间表的外键对应关系
            inverseJoinColumns = {@JoinColumn(name = "role_id")}) //另一张表与中间表的外键的对应关系
    private Set<Role> roles = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionIdentifier() {
        return permissionIdentifier;
    }

    public void setPermissionIdentifier(String permissionIdentifier) {
        this.permissionIdentifier = permissionIdentifier;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", permissionName='" + permissionName + '\'' +
                ", permissionIdentifier='" + permissionIdentifier + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
