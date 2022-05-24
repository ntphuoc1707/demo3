package com.example.demo3.models;

import javax.persistence.*;

/**
 * com.example.demo3.models;
 * Created by Phuoc -19127520
 * Date 24/04/2022 - 10:36 CH
 * Description: ...
 */
@Entity
@Table(name="STUDENTS")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "image")
    private String image;
    @Column(name = "address")
    private String address;
    @Column(name = "note")
    private String note;
    @Column(name = "idclass")
    private String idclass;
    @Column(name = "mark")
    private double mark;

    public void setIdclass(String idclass) {
        this.idclass = idclass;
    }

    public String getIdclass() {
        return idclass;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", address='" + address + '\'' +
                ", note='" + note + '\'' +
                ", idclass='" + idclass + '\'' +
                ", mark=" + mark +
                '}';
    }

    public Student(String name, String image, String address, String note, String idclass, double mark) {
        this.name = name;
        this.image = image;
        this.address = address;
        this.note = note;
        this.idclass = idclass;
        this.mark = mark;
    }

    public Student(Long id, String name, String image, String address, String note, String idclass, double mark) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.address = address;
        this.note = note;
        this.idclass = idclass;
        this.mark = mark;
    }

    public Student() {    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getAddress() {
        return address;
    }

    public String getNote() {
        return note;
    }

    public double getMark() {
        return mark;
    }
}
