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

    //@Query(value = "select ha.pre_order,CONCAT(ig2.kl_content,'-',ha.suf_order) as suf_order ,ha.confidence,ha.paper_code,ha.create_time from (select CONCAT(ig.kl_content,'-',fp.pre_order) as pre_order,fp.suf_order,confidence,fp.paper_code,fp.create_time from t_item_fpg fp, temp_ik_group ig where fp.pre_order = ig.item_id and fp.paper_code = :pc and fp.create_time = :ct) ha, temp_ik_group ig2 where ha.suf_order = ig2.item_id ORDER BY confidence desc",
    //        nativeQuery = true)
    @Query(value = "select fp.pre_order,ki.kl_content as suf_order,fp.confidence,fp.paper_code,fp.create_time from t_item_fpg fp,t_knowledge_info ki where fp.suf_order = ki.kl_id and fp.paper_code = :pc and fp.create_time = :ct order by suf_order, confidence desc",
            nativeQuery = true)
    List<ItemFpg> findByPCodeAndCreate(@Param("pc") String paperCode,
                                       @Param("ct") String createTime);

    List<ItemFpg> findAllByPaperCodeAndCreateTime(String paperCode, String createTime);
}
