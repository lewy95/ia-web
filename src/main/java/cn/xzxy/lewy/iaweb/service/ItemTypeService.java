package cn.xzxy.lewy.iaweb.service;

import cn.xzxy.lewy.iaweb.dao.ItemTypeDao;
import cn.xzxy.lewy.iaweb.pojo.ItemType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItemTypeService {

    @Resource
    ItemTypeDao itemTypeDao;


    public List<ItemType> getAll() {
        return itemTypeDao.findAll();
    }
}
