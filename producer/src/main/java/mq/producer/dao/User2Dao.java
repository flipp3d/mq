package mq.producer.dao;

import mq.producer.domain.User2;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
@Mapper
public interface User2Dao {
    List<User2> getById(Integer id1,Integer id2);

    @Select("select id," +
            "name," +
            "password," +
            "user_name" +
            " from" +
            " user2 " +
            "where state =0")
    List<User2> getAll( );
    @Update(
            "update user2 set state =1 where id= #{id}"
    )
    void reset(Integer id);

    int deleteByPrimaryKey(Integer id);

    int insert(User2 record);

    int insertSelective(User2 record);

    User2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User2 record);

    int updateByPrimaryKey(User2 record);
}