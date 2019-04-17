package mq.producer.proService;


public interface MessageProducerService   {


     /**
      * 查询多个对象，遍历
      * @param id1
      * @param id2
      */

     void sendMessage(int id1, int id2);

     /**
      * 查询多个对象，遍历
      */

     void sendMessage2();


     /**
      * 查询单个对象，转为json发送
      */
     void sendMessage3(int id);
}
