package cn.xzxy.lewy.iaweb.service;

import cn.xzxy.lewy.iaweb.dao.KnowledgeDao;
import cn.xzxy.lewy.iaweb.pojo.Knowledge;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class KnowledgeService {

    @Resource
    KnowledgeDao knowledgeDao;

    public Knowledge getOneById(int itemId, String paperCode) {
        return knowledgeDao.findById(itemId, paperCode);
    }
}
