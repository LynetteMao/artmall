package com.artmall.mapper;

import com.artmall.pojo.Bid;
import com.artmall.pojo.BidExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BidMapper {
    long countByExample(BidExample example);

    int deleteByExample(BidExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Bid record);

    int insertSelective(Bid record);

    List<Bid> selectByExample(BidExample example);

    Bid selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Bid record, @Param("example") BidExample example);

    int updateByExample(@Param("record") Bid record, @Param("example") BidExample example);

    int updateByPrimaryKeySelective(Bid record);

    int updateByPrimaryKey(Bid record);
}