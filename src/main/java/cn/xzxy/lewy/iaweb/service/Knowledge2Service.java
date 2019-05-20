package cn.xzxy.lewy.iaweb.service;

import cn.xzxy.lewy.iaweb.dao.Knowledge2Dao;
import cn.xzxy.lewy.iaweb.pojo.Knowledge2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Knowledge2Service {

    @Resource
    Knowledge2Dao knowledge2Dao;

    public Knowledge2 getOneById(int klId) {
        return knowledge2Dao.findOne(klId);
    }
}
