package cn.xzxy.lewy.iaweb.service;

import cn.xzxy.lewy.iaweb.dao.PaperDao;
import cn.xzxy.lewy.iaweb.pojo.Paper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PaperService {

    @Resource
    PaperDao paperDao;

    public List<Paper> getAll() {
        return paperDao.findAll();
    }
}
