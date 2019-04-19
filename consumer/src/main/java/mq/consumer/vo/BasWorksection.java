package mq.consumer.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data

public class BasWorksection  implements Serializable {

    private String time;
    private String dataType;
    private List<Bas> objectDatas;

    @Data
    public class Bas {
        private String objectDataID;
        private String objectDataDesc;

    }
}