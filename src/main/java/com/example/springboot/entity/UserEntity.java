package com.example.springboot.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;


@Document(collection = "user")
public class UserEntity {
    @Id
    private String id;
    private String username;
    private String password;
    private String useremail;
    private String userphone;
    private String useraddress;
    private List<String> address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return password;
    }

    public void setUserpassword(String userpassword) {
        this.password = userpassword;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(useremail, that.useremail) &&
                Objects.equals(userphone, that.userphone) &&
                Objects.equals(useraddress, that.useraddress);
    }

    @Override
    public int hashCode() {

        return Objects.hash(username, password, useremail, userphone, useraddress);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }
}
