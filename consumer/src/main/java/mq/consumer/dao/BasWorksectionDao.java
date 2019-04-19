package mq.consumer.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BasWorksectionDao {
   @Insert("insert into BasWorksection(objectDataID, objectDataDesc,time,dataType) values(#{objectDataID},#{objectDataDesc},#{time},#{dataType})")
  void insert(String objectDataID,String objectDataDesc,String time,String dataType);
}