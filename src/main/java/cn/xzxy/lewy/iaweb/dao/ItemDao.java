package cn.xzxy.lewy.iaweb.dao;

import cn.xzxy.lewy.iaweb.pojo.ItemIndex;
import cn.xzxy.lewy.iaweb.pojo.multiKey.ItemIndexMultiKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDao extends JpaRepository<ItemIndex, ItemIndexMultiKey> {

    @Query(value = "select count(*) num from t_item_index where nandu between :si and :ei and paper_code =:paperCode and create_time =:createTime",
            nativeQuery = true)
    int getNanduScale(@Param("si") double startPoint,
                      @Param("ei") double endPoint,
                      @Param("paperCode") String paperCode,
                      @Param("createTime") String createTime);

}
