package com.naijatravelshop.persistence.model.portal;

import javax.persistence.*;

/**
 * Created by Bruno on
 * 07/05/2019
 */
@Entity
@Table(name = "setting")
public class Setting {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String value;
    private String description;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
