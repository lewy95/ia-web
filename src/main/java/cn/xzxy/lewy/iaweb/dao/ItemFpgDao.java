package cn.xzxy.lewy.iaweb.dao;

import cn.xzxy.lewy.iaweb.pojo.ItemFpg;
import cn.xzxy.lewy.iaweb.pojo.multiKey.ItemFpgMultiKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemFpgDao extends JpaRepository<ItemFpg, ItemFpgMultiKey> {

    @Query(value = "select * from t_item_fpg where paper_code = :pc and create_time = :ct order by confidence desc",
            nativeQuery = true)
    List<ItemFpg> findByPCodeAndCreate(@Param("pc") String paperCode,
                                       @Param("ct") String createTime);
}
