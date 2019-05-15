package cn.xzxy.lewy.iaweb.service;

import cn.xzxy.lewy.iaweb.dao.PaperDao;
import cn.xzxy.lewy.iaweb.pojo.Paper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public Page<Paper> getAllByPage(int start, int limit) {
        Pageable pageable = new PageRequest(start, limit, Sort.Direction.DESC, "id");
        return paperDao.findAll(pageable);
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
