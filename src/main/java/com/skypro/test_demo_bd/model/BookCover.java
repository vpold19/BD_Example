package com.skypro.test_demo_bd.model;

import javax.persistence.*;
import java.util.Arrays;

@Entity
public class BookCover {
    @Id
    @GeneratedValue
    private Long id;

    private String filePath;
    private Long fileSize;
    private String mediaType;

    @Lob
    private byte[] preview;

    @OneToOne
    private Book book;

    public Long getId() {
        return id;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public int getFileSize() {
        return Math.toIntExact(fileSize);
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public byte[] getPreview() {
        return preview;
    }

    public void setPreview(byte[] preview) {
        this.preview = preview;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "BookCover{" +
                "id=" + id +
                ", filePath='" + filePath + '\'' +
                ", fileSize=" + fileSize +
                ", preview=" + Arrays.toString(preview) +
                ", book=" + book +
                '}';
    }
}
