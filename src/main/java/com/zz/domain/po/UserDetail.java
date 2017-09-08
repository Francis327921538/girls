package com.zz.domain.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhangz on 2017/7/18.
 */
@Entity
@DynamicUpdate@DynamicInsert
public class UserDetail  implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "foreignKey" ,//生成器名称
            strategy = "foreign",//使用hibernate的外键策略
            parameters = @Parameter(value = "userAccount",name = "property"))//指定成员属性中的userAccount所在类的主键为本类的主键,这里的参数属性name必须为"property"
    @GeneratedValue(generator = "foreignKey")//使用上述定义的id生成器
    private int id;
    private String username;
    private Date birthday;
    private short gender;
    private String phone;
    private String avatar;
    private Date createDate;
    private String description;
    private Date lastVisit;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private UserAccount userAccount;

    public UserDetail() {
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public short getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public String getDescription() {
        return description;
    }

    public Date getLastVisit() {
        return lastVisit;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setGender(short gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public String toString() {
        return "UserDetail{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", avatar='" + avatar + '\'' +
                ", createDate=" + createDate +
                ", description='" + description + '\'' +
                ", lastVisit=" + lastVisit +
                '}';
    }

    public UserDetail(String username, short gender, String phone) {
        this.username = username;
        this.gender = gender;
        this.phone = phone;
    }
}
