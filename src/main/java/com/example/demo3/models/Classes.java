package com.example.demo3.models;

import javax.persistence.*;

/**
 * com.example.demo3.models;
 * Created by Phuoc -19127520
 * Date 24/05/2022 - 03:59 CH
 * Description: ...
 */

@Entity
@Table(name = "CLASSES")
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String id;

    @Column(name = "name")
    String name;

    public Classes() {
    }

    public Classes(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
