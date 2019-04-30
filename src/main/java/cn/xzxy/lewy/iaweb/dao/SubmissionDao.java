package cn.xzxy.lewy.iaweb.dao;

import cn.xzxy.lewy.iaweb.pojo.Submission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubmissionDao extends JpaRepository<Submission, Integer> {

    List<Submission> findByUserId(int userId);

    List<Submission> findByUserIdAndStatusno(int userId, int status);

    Page<Submission> findByUserIdAndStatusno(int userId, int status, Pageable pageable);

}
