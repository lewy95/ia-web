package cn.xzxy.lewy.iaweb.service;

import cn.xzxy.lewy.iaweb.dao.ItemClusterDao;
import cn.xzxy.lewy.iaweb.pojo.ItemCluster;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItemClusterService {

    @Resource
    ItemClusterDao itemClusterDao;

    public ItemCluster getOneByPCodeAndCreate(String paperCode, String submitTime, double center) {
        return itemClusterDao.findOneByPCodeAndCreate(paperCode, submitTime, center);
    }

    public List<ItemCluster> getAllByPCodeAndCreate(String paperCode, String submitTime, double center) {
        return itemClusterDao.findAllByPCodeAndCreate(paperCode, submitTime, center);
    }

}
