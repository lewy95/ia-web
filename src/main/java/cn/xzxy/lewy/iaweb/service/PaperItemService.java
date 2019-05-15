package cn.xzxy.lewy.iaweb.service;

import cn.xzxy.lewy.iaweb.dao.PaperItemDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaperItemService {

    @Resource
    PaperItemDao paperItemDao;

    public void deleteById(int ptId) {

        paperItemDao.delete(ptId);
    }

}
