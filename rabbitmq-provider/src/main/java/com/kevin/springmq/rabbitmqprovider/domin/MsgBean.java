package com.kevin.springmq.rabbitmqprovider.domin;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: MsgBean
 * @Description:
 * @Author: Kevin
 * @Date: 2018/8/15 16:00
 */
@Data
public class MsgBean implements Serializable {

    private String id;
    private String title;
    private String content;


    @Override
    public String toString() {
        return "MsgBean{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
