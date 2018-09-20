package com.artmall.service;

import com.artmall.pojo.Works;

import java.util.List;

/**
 * 投标管理
 *
 * @author mllove
 * @create 2018-09-17 17:41
 **/

public interface BidService {
    List<Works> getWorksList(Long projectId);
}
