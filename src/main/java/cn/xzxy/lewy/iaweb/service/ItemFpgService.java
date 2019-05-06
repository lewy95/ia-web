package cn.xzxy.lewy.iaweb.service;

import cn.xzxy.lewy.iaweb.dao.ItemFpgDao;
import cn.xzxy.lewy.iaweb.pojo.ItemFpg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItemFpgService {

    @Resource
    ItemFpgDao itemFpgDao;

    public List<ItemFpg> getByPCodeAndCreate(String paperCode, String submitTime) {
        return itemFpgDao.findByPCodeAndCreate(paperCode, submitTime);
    }
}
