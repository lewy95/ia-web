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

    public void savePaper(Paper paper) {
        paperDao.save(paper);
    }

    public Paper getById(Integer id) {
        return paperDao.getOne(id);
    }

    public void deleteById(Integer id) {
        paperDao.delete(id);
    }
}
