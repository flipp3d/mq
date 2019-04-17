package mq.consumer.dao;

import mq.consumer.vo.User3;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface User3Dao {
    int deleteByPrimaryKey(Integer id);

    int insert(User3 record);

    int insertSelective(User3 record);

    User3 selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User3 record);

    int updateByPrimaryKey(User3 record);
}