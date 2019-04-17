package mq.consumer.conService;

import com.rabbitmq.client.Channel;
import mq.consumer.dao.BasWorksectionDao;
import mq.consumer.dao.User3Dao;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

import static mq.consumer.config.ConsumerConfig.QUEUE_NAME1;


@Service
public class MessageConsumerService {
    //    public static String a;

    @Resource
    private User3Dao user3Dao;
    @Resource
    private BasWorksectionDao basWorksectionDao;

    @RabbitListener(queues = QUEUE_NAME1)
    public void receiveMessage(Message message, Channel channel) {
//        a = text;//给页面传值的，实际不这么做
        String s = new String(message.getBody());
//        JSONObject jsonObject = JSONObject.parseObject(s);
//        JSONArray datas = jsonObject.getJSONArray("objectDatas");
//        for (Object data : datas) {
//            System.out.println("***接受消息***" +data );
//        }

//        User3 object = JSON.parseObject(s, User3.class);
//        basPlantDao.insert(object);
//        user3Dao.insert(object);

        System.out.println("***接受消息***" + s);


        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
