package mq.consumer.vo;

import lombok.Data;

import java.io.Serializable;


@Data
public class ObjectDatas implements Serializable {



    private String objectDataID;
    private String objectDataDesc;
}