package cn.xzxy.lewy.iaweb.dao;

import cn.xzxy.lewy.iaweb.pojo.Paper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperDao extends JpaRepository<Paper,Integer> {
}
