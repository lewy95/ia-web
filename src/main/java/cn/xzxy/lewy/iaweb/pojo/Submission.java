package cn.xzxy.lewy.iaweb.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "t_submission_info")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String comments;

    private Integer statusno;

    @Column(name = "submit_time")
    private String submitTime;

    @OneToOne
    @JoinColumn(name = "paperId", referencedColumnName = "id")
    private Paper paper;

    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getStatusno() {
        return statusno;
    }

    public void setStatusno(Integer statusno) {
        this.statusno = statusno;
    }

    @Override
    public String toString() {
        return "Submission{" +
                "id=" + id +
                ", comments='" + comments + '\'' +
                ", statusno=" + statusno +
                ", submitTime='" + submitTime + '\'' +
                ", paper=" + paper +
                ", user=" + user +
                '}';
    }
}
