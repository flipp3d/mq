package mq.producer.proService;

import com.alibaba.fastjson.JSON;
import mq.producer.config.ProducerConfig;
import mq.producer.dao.User2Dao;
import mq.producer.domain.User2;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class MessageProducerServiceImpl implements MessageProducerService {
    @Resource
    private RabbitTemplate rabbitTemplate;

    @Resource
    private User2Dao user2Dao;

    /**
     * 查询一个范围，遍历数组放入队列
     * @param id1
     * @param id2
     */
    @Override
    public void sendMessage(int id1, int id2) {
        List<User2> list = user2Dao.getById(id1, id2);
        for (Object msgs : list){
          String s = JSON.toJSONString(msgs);


        this.rabbitTemplate.convertAndSend(ProducerConfig.EXCHANGE, ProducerConfig.ROUTINGKEY, s);
    }
    }

    @Override
    public void sendMessage2( ) {

        List<User2> list = user2Dao.getAll();
        for (User2 msgs : list) {
            String s = JSON.toJSONString(msgs);
            String ss= "["+ s +"]";
            System.out.println(ss);
            Message message = MessageBuilder.withBody(ss.getBytes())
                    .setContentType("application/json")
                    .setContentEncoding("utf-8")
                    .setHeader("srcSystem","ME").setHeader("desSystem","IMES").setHeader("msgType","IMES_ME_BAS_WORKSECTION").setMessageId(UUID.randomUUID()+"")
                    .build();

            this.rabbitTemplate.convertAndSend(ProducerConfig.EXCHANGE, ProducerConfig.ROUTINGKEY, message);
            user2Dao.reset(msgs.getId());

        }
    }

        /**
         * 查询单个对象，转为json发送
         */
        @Override
        public void sendMessage3(int id) {
            User2 one = user2Dao.selectByPrimaryKey(id);
            String msg = JSON.toJSONString(one);
//        ObjectMapper mapper = new ObjectMapper();
//        String msg= null;
//        try {
//            msg = mapper.writeValueAsString(one);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
        this.rabbitTemplate.convertAndSend(ProducerConfig.EXCHANGE, ProducerConfig.ROUTINGKEY, msg);
    }
}
