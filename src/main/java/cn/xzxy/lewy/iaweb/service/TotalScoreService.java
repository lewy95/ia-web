package cn.xzxy.lewy.iaweb.service;

import cn.xzxy.lewy.iaweb.dao.TotalScoreDao;
import cn.xzxy.lewy.iaweb.pojo.TotalScore;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TotalScoreService {

    @Resource
    TotalScoreDao totalScoreDao;

    public List<TotalScore> getByPCodeAndCreate(String paperCode, String createTime) {
        return totalScoreDao.findAllByPaperCodeAndCreateTime(paperCode, createTime);
    }

    public int getCountByPCodeAndCreate(int start, int end, String paperCode, String createTime) {
        return totalScoreDao.getCountByPCodeAndCreate(start, end, paperCode, createTime);
    }
}
