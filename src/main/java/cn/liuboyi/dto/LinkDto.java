package cn.liuboyi.dto;

import java.io.Serializable;

/**
 * Description:
 *
 * @author: boyi.liu
 * Date: 2019/11/28 11:31
 */
public class LinkDto implements Serializable {

    private static final long serialVersionUID = 645545645673686893L;

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
