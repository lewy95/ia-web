package cn.xzxy.lewy.iaweb.service;

import cn.xzxy.lewy.iaweb.dao.PaperIndexDao;
import cn.xzxy.lewy.iaweb.pojo.PaperIndex;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaperIndexService {

    @Resource
    PaperIndexDao paperIndexDao;

    public PaperIndex getByPCodeAndCreate(String paperCode, String createTime) {
        return paperIndexDao.findByPaperCodeAndCreateTime(paperCode, createTime);
    }
}
