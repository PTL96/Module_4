package com.codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class TheSong implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Tên không được để trống")
    @Size(min = 1, max = 800, message = "Tên phải chứa ít nhất 1 ký tự và dài nhất 800 ký tự")
    private String name;
    @NotEmpty(message = "Người trình bày không được để trống")
    @Size(min = 1, max = 300)
    private String present;
    @NotEmpty(message = "Thể loại không được để trống")
    @Size(min = 1, max = 1000)
    private String songType;

    public TheSong() {
    }

    public TheSong(int id, String name, String present, String songType) {
        this.id = id;
        this.name = name;
        this.present = present;
        this.songType = songType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present;
    }

    public String getSongType() {
        return songType;
    }

    public void setSongType(String songType) {
        this.songType = songType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
