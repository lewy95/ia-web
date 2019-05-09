package cn.xzxy.lewy.iaweb.dao;

import cn.xzxy.lewy.iaweb.pojo.TotalScore;
import cn.xzxy.lewy.iaweb.pojo.multiKey.TotalScoreMultiKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TotalScoreDao extends JpaRepository<TotalScore, TotalScoreMultiKey> {

    List<TotalScore> findAllByPaperCodeAndCreateTime(String paperCode, String createTime);

    @Query(value = "select count(1) from t_score_total where total_score BETWEEN :st and :en and paper_code = :pc and create_time = :ct",
            nativeQuery = true)
    int getCountByPCodeAndCreate(@Param("st") int start,
                                 @Param("en") int end,
                                 @Param("pc") String paperCode,
                                 @Param("ct") String createTime);
}
