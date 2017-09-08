package com.zz.domain.po;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by zhangz on 2017/7/18.
 */
@Entity
@Data
@DynamicInsert
@DynamicUpdate
public class UserAccount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String account;
    @Getter(onMethod = @__( @JsonIgnore ))
    @Setter(onMethod = @__( @JsonProperty))
    private String password;
    @Getter(onMethod = @__( @JsonIgnore ))
    @Setter(onMethod = @__( @JsonProperty))
    private String plainPassword;
    @Getter(onMethod = @__( @JsonIgnore ))
    @Setter(onMethod = @__( @JsonProperty))
    private String salt;
    private String email = "";
    private int state = 1;   //-1 锁定 0 忽略  1 正常
    @OneToOne(mappedBy = "userAccount", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private UserDetail userDetail = new UserDetail();

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(value = {org.hibernate.annotations.CascadeType.SAVE_UPDATE})          //设置级联关系
    @JoinTable(name = "user_role",                       //指定第三张表
            joinColumns = {@JoinColumn(name = "user_id")},             //本表与中间表的外键对应
            inverseJoinColumns = {@JoinColumn(name = "role_id")})  //另一张表与第三张表的外键的对应关系
    private Set<Role> roles = new HashSet<>();
    public UserAccount() {
    }
    public UserAccount(String account, String plainPassword) {
        this.account = account;
        this.plainPassword = plainPassword;
    }
    @Transient
    @JsonIgnore
    public String getCredentialsSalt() {
        return account + salt;
    }

    public static void main(String[] args) {
        UserAccount userAccount = new UserAccount("zz", "0000");
        System.out.println(userAccount.account);
    }

    public UserAccount(String account, String plainPassword, UserDetail userDetail) {
        this.account = account;
        this.plainPassword = plainPassword;
        this.userDetail = userDetail;
    }

    public List<String> getRoleNames() {
        List<String> roleNames = new LinkedList<>();
        this.roles.forEach(role -> {
            roleNames.add(role.getName());
        });
        return roleNames;
    }
}
