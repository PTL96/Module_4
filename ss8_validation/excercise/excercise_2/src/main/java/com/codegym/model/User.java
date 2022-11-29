package com.codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
public class User implements Validator {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Pattern(regexp = "[a-zA-z]{5,45}", message = "Họ tối thiểu là 5 ký tự, tối đa là 45 ký tự")
    private String firthName;
    @Pattern(regexp = "[a-zA-z]{5,45}", message = "Họ tối thiểu là 5 ký tự, tối đa là 45 ký tự")
    private String lastName;
    @Min(value = 18, message = "Chỉ hỗ trợ thành viên từ 18 tuổi trở lên")
    private String age;
    @Pattern(regexp = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$/", message = "Email không đúng định dạng: 'example@gmail.com'")
    private String email;

    public User() {
    }

    public User(int id, String firthName, String lastName, String age, String email) {
        this.id = id;
        this.firthName = firthName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirthName() {
        return firthName;
    }

    public void setFirthName(String firthName) {
        this.firthName = firthName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
