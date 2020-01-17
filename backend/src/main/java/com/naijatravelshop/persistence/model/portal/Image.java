package com.naijatravelshop.persistence.model.portal;

import com.naijatravelshop.persistence.model.enums.FileType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Bruno on
 * 06/05/2019
 */
@Entity
@Table(name = "image")
public class Image implements Serializable {
    private String name;
    @Column(nullable = false)
    private byte[] data;
    private Long sizeInKb;
    private String externalReferencePath;
    private FileType type;
    private byte[] thumbnail;
    private String fileName;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Long getSizeInKb() {
        return sizeInKb;
    }

    public void setSizeInKb(Long sizeInKb) {
        this.sizeInKb = sizeInKb;
    }

    public String getExternalReferencePath() {
        return externalReferencePath;
    }

    public void setExternalReferencePath(String externalReferencePath) {
        this.externalReferencePath = externalReferencePath;
    }

    public FileType getType() {
        return type;
    }

    public void setType(FileType type) {
        this.type = type;
    }

    public byte[] getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(byte[] thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
