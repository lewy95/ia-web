package cn.xzxy.lewy.iaweb.dao;

import cn.xzxy.lewy.iaweb.pojo.Knowledge;
import cn.xzxy.lewy.iaweb.pojo.multiKey.KnowledgeMultiKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface KnowledgeDao extends JpaRepository<Knowledge, KnowledgeMultiKey> {

    @Query(value = "select * from temp_ik_group where item_id = :ii and paper_code =:pc",
            nativeQuery = true)
    Knowledge findById(@Param("ii") int itemId,
                       @Param("pc") String paperCode);
}
