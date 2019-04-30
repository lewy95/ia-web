package cn.xzxy.lewy.iaweb.service;

import cn.xzxy.lewy.iaweb.dao.ItemDao;
import cn.xzxy.lewy.iaweb.pojo.ItemIndex;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItemService {

    @Resource
    ItemDao itemDao;

    public List<ItemIndex> getAllItems() {
        return itemDao.findAll();
    }

    /**
     * 获取不同难度范围的试题数目
     * @param startPoint 难度指标开始点
     * @param endPoint 难度指标结束点
     * @param paperCode 试卷id
     * @param createTime 创建时间
     * @return 记录数
     */
    public int getNanduScale(double startPoint, double endPoint, String paperCode, String createTime) {
        return itemDao.getNanduScale(startPoint, endPoint, paperCode, createTime);
    }

    /**
     * 获取不同难度范围的试题数目
     * @param startPoint 难度指标开始点
     * @param endPoint 难度指标结束点
     * @param paperCode 试卷id
     * @param createTime 创建时间
     * @return 记录数
     */
    public int getQufenduScale(double startPoint, double endPoint, String paperCode, String createTime) {
        return itemDao.getQufenduScale(startPoint, endPoint, paperCode, createTime);
    }
}
