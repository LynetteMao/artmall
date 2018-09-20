package com.artmall.Impl;

import com.artmall.pojo.Works;
import com.artmall.service.BidService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mllove
 * @create 2018-09-17 17:42
 **/
@Service
public class BidServiceImpl implements BidService {

    @Override
    public List<Works> getWorksList(Long projectId) {
        return null;
    }
}
