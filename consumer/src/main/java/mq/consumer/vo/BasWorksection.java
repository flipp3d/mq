package mq.consumer.vo;

import lombok.Data;

import java.io.Serializable;


@Data
public class BasWorksection  implements Serializable {

    private String objectDatas;

    private String time;
    private String dataType;
}