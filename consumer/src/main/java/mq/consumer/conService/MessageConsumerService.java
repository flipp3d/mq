package mq.consumer.conService;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import mq.consumer.dao.User3Dao;
import mq.consumer.vo.BasWorksection;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;


@Service
public class MessageConsumerService {
    //    public static String a;


    @Resource
    private User3Dao user3Dao;

//    @RabbitListener(queues = ConsumerConfig.QUEUE_NAME1)
    public void receiveMessage(Message message, Channel channel) {
//        a = text;//给页面传值的，实际不这么做
        String s = new String(message.getBody());
//        JSONObject jsonObject = JSONObject.parseObject(s);

        List<BasWorksection> ss = JSON.parseObject(s, List.class);
        for (BasWorksection o : ss) {


            System.out.println(o);
        }
//
//        JSONObject jsonObject = JSONObject.parseObject(s);
//        JSONArray datas = jsonObject.getJSONArray("objectDatas");
//        for (Object data : datas) {
//            System.out.println("***接受消息***" +data );
//        }

//        User3 object = JSON.parseObject(s, User3.class);
//        basPlantDao.insert(object);
//        user3Dao.insert(object);

//        System.out.println("***接受消息***" + ss);


        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
