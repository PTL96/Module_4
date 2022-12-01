package com.codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class SongDto implements Validator {
    private int id;
    @NotEmpty(message = "Tên không được để trống")
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$",
            message = "Tên không đúng định dạng")
    private String songName;

    @NotEmpty(message = "Người trình bày không được để trống")
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$",
            message = "Người trình bày không đúng định dạng")
    private String present;

    @NotEmpty(message = "Thể loại không được để trống")
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$",
            message = "Thể loại không đúng định dạng")
    private String songType;

//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, fallbackPatterns = { "M/d/yy", "dd.MM.yyyy" })
    private String presentDate;

    public SongDto() {
    }

    public SongDto(int id, String songName, String present, String songType, String presentDate) {
        this.id = id;
        this.songName = songName;
        this.present = present;
        this.songType = songType;
        this.presentDate = presentDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
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

    public String getPresentDate() {
        return presentDate;
    }

    public void setPresentDate(String presentDate) {
        this.presentDate = presentDate;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
