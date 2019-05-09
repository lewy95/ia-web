package cn.xzxy.lewy.iaweb.dao;

import cn.xzxy.lewy.iaweb.pojo.PaperIndex;
import cn.xzxy.lewy.iaweb.pojo.multiKey.PaperIndexMultiKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperIndexDao extends JpaRepository<PaperIndex, PaperIndexMultiKey> {

    PaperIndex findByPaperCodeAndCreateTime(String paperCode, String createTime);
}
