package cn.xzxy.lewy.iaweb.service;

import cn.xzxy.lewy.iaweb.dao.SubmissionDao;
import cn.xzxy.lewy.iaweb.pojo.Submission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SubmissionService {

    @Resource
    SubmissionDao submissionDao;

    public List<Submission> getByUserId(int userId) {
        return submissionDao.findByUserId(userId);
    }

    public List<Submission> getByUserIdAndStatus(int userId, int status) {
        return submissionDao.findByUserIdAndStatusno(userId, status);
    }

    public Page<Submission> getByUserIdAndStatus(int start, int limit, int userId, int status) {
        Pageable pageable = new PageRequest(start, limit, Sort.Direction.DESC, "submitTime");
        return submissionDao.findByUserIdAndStatusno(userId, status, pageable);
    }

    public Submission getById(Integer id) {
        return submissionDao.getOne(id);
    }

    public void saveOne(Submission submission) {
        submissionDao.save(submission);
    }
}
