package com.naijatravelshop.persistence.model.flight;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;

/**
 * Created by Bruno on
 * 06/05/2019
 */
@Entity
@Table(name = "air_file")
public class AirFile implements Serializable {
    private Timestamp dateCreated;
    private String fileName;
    private byte[] fileData;
    private boolean processed = false;
    private Long dateSentFromAmadues;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public Long getDateSentFromAmadues() {
        return dateSentFromAmadues;
    }

    public void setDateSentFromAmadues(Long dateSentFromAmadues) {
        this.dateSentFromAmadues = dateSentFromAmadues;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AirFile{" +
                "dateCreated=" + dateCreated +
                ", fileName='" + fileName + '\'' +
                ", fileData=" + Arrays.toString(fileData) +
                ", processed=" + processed +
                ", dateSentFromAmadues=" + dateSentFromAmadues +
                ", id=" + id +
                '}';
    }
}
