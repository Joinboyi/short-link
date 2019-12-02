package cn.liuboyi.mongodb.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Link implements Serializable {

    private static final long serialVersionUID = -2497946978345999056L;

    private String url;

    private String code;

    private LocalDateTime createdAt;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
