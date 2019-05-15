package cn.xzxy.lewy.iaweb.dao;

import cn.xzxy.lewy.iaweb.pojo.ItemType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemTypeDao extends JpaRepository<ItemType, Integer> {

    ItemType findByTypeId(Integer tc);
}
