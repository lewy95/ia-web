package cn.xzxy.lewy.iaweb.service;

import cn.xzxy.lewy.iaweb.dao.ItemDao;
import cn.xzxy.lewy.iaweb.pojo.ItemIndex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemDao itemDao;

    public List<ItemIndex> getAllItems() {
        return itemDao.findAll();
    }

    /**
     * 获取不同难度范围的试题数目
     * @param startPoint 难度指标开始点
     * @param ensPoint 难度指标结束点
     * @param paperCode 试卷id
     * @param createTime 创建世界
     * @return 记录数
     */
    public int getNandeScale(double startPoint, double ensPoint, String paperCode, String createTime) {
        return itemDao.getNanduScale(startPoint, ensPoint, paperCode, createTime);
    }


}
