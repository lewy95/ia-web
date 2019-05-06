package cn.xzxy.lewy.iaweb.dao;

import cn.xzxy.lewy.iaweb.pojo.ItemCluster;
import cn.xzxy.lewy.iaweb.pojo.multiKey.ItemClusterMultiKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemClusterDao extends JpaRepository<ItemCluster, ItemClusterMultiKey> {

    @Query(value = "select * from t_item_cluster where paper_code=:pc and create_time=:ct and centers=:ce limit 1",
            nativeQuery = true)
    ItemCluster findOneByPCodeAndCreate(@Param("pc") String paperCode,
                                        @Param("ct") String createTime,
                                        @Param("ce") double center);

    @Query(value = "select * from t_item_cluster where paper_code=:pc and create_time=:ct and centers=:ce",
            nativeQuery = true)
    List<ItemCluster> findAllByPCodeAndCreate(@Param("pc") String paperCode,
                                        @Param("ct") String createTime,
                                        @Param("ce") double center);

}
