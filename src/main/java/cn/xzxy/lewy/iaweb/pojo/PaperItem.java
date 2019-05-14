package cn.xzxy.lewy.iaweb.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "t_paper_item")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class PaperItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "paper_code")
    private String paperCode;

    @Column(name = "all_items")
    private int allItems;
    @Column(name = "o_items")
    private int oItems;
    @Column(name = "s_items")
    private int sItems;
    @Column(name = "os_items")
    private int osItems;

    @Column(name = "part1_type")
    private Integer part1Type;
    @Column(name = "part1_mark")
    private Integer part1Mark;
    @Column(name = "part1_qty")
    private Integer part1Qty;

    @Column(name = "part2_type")
    private Integer part2Type;
    @Column(name = "part2_mark")
    private Integer part2Mark;
    @Column(name = "part2_qty")
    private Integer part2Qty;

    @Column(name = "part3_type")
    private Integer part3Type;
    @Column(name = "part3_mark")
    private Integer part3Mark;
    @Column(name = "part3_qty")
    private Integer part3Qty;

    @Column(name = "part4_type")
    private Integer part4Type;
    @Column(name = "part4_mark")
    private Integer part4Mark;
    @Column(name = "part4_qty")
    private Integer part4Qty;

    @Column(name = "part5_type")
    private Integer part5Type;
    @Column(name = "part5_mark")
    private Integer part5Mark;
    @Column(name = "part5_qty")
    private Integer part5Qty;

    @Column(name = "part6_type")
    private Integer part6Type;
    @Column(name = "part6_mark")
    private Integer part6Mark;
    @Column(name = "part6_qty")
    private Integer part6Qty;

    @Column(name = "part7_type")
    private Integer part7Type;
    @Column(name = "part7_mark")
    private Integer part7Mark;
    @Column(name = "part7_qty")
    private Integer part7Qty;

    @Column(name = "part8_type")
    private Integer part8Type;
    @Column(name = "part8_mark")
    private Integer part8Mark;
    @Column(name = "part8_qty")
    private Integer part8Qty;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaperCode() {
        return paperCode;
    }

    public void setPaperCode(String paperCode) {
        this.paperCode = paperCode;
    }

    public int getAllItems() {
        return allItems;
    }

    public void setAllItems(int allItems) {
        this.allItems = allItems;
    }

    public int getoItems() {
        return oItems;
    }

    public void setoItems(int oItems) {
        this.oItems = oItems;
    }

    public int getsItems() {
        return sItems;
    }

    public void setsItems(int sItems) {
        this.sItems = sItems;
    }

    public int getOsItems() {
        return osItems;
    }

    public void setOsItems(int osItems) {
        this.osItems = osItems;
    }

    public Integer getPart1Type() {
        return part1Type;
    }

    public void setPart1Type(Integer part1Type) {
        this.part1Type = part1Type;
    }

    public Integer getPart1Mark() {
        return part1Mark;
    }

    public void setPart1Mark(Integer part1Mark) {
        this.part1Mark = part1Mark;
    }

    public Integer getPart1Qty() {
        return part1Qty;
    }

    public void setPart1Qty(Integer part1Qty) {
        this.part1Qty = part1Qty;
    }

    public Integer getPart2Type() {
        return part2Type;
    }

    public void setPart2Type(Integer part2Type) {
        this.part2Type = part2Type;
    }

    public Integer getPart2Mark() {
        return part2Mark;
    }

    public void setPart2Mark(Integer part2Mark) {
        this.part2Mark = part2Mark;
    }

    public Integer getPart2Qty() {
        return part2Qty;
    }

    public void setPart2Qty(Integer part2Qty) {
        this.part2Qty = part2Qty;
    }

    public Integer getPart3Type() {
        return part3Type;
    }

    public void setPart3Type(Integer part3Type) {
        this.part3Type = part3Type;
    }

    public Integer getPart3Mark() {
        return part3Mark;
    }

    public void setPart3Mark(Integer part3Mark) {
        this.part3Mark = part3Mark;
    }

    public Integer getPart3Qty() {
        return part3Qty;
    }

    public void setPart3Qty(Integer part3Qty) {
        this.part3Qty = part3Qty;
    }

    public Integer getPart4Type() {
        return part4Type;
    }

    public void setPart4Type(Integer part4Type) {
        this.part4Type = part4Type;
    }

    public Integer getPart4Mark() {
        return part4Mark;
    }

    public void setPart4Mark(Integer part4Mark) {
        this.part4Mark = part4Mark;
    }

    public Integer getPart4Qty() {
        return part4Qty;
    }

    public void setPart4Qty(Integer part4Qty) {
        this.part4Qty = part4Qty;
    }

    public Integer getPart5Type() {
        return part5Type;
    }

    public void setPart5Type(Integer part5Type) {
        this.part5Type = part5Type;
    }

    public Integer getPart5Mark() {
        return part5Mark;
    }

    public void setPart5Mark(Integer part5Mark) {
        this.part5Mark = part5Mark;
    }

    public Integer getPart5Qty() {
        return part5Qty;
    }

    public void setPart5Qty(Integer part5Qty) {
        this.part5Qty = part5Qty;
    }

    public Integer getPart6Type() {
        return part6Type;
    }

    public void setPart6Type(Integer part6Type) {
        this.part6Type = part6Type;
    }

    public Integer getPart6Mark() {
        return part6Mark;
    }

    public void setPart6Mark(Integer part6Mark) {
        this.part6Mark = part6Mark;
    }

    public Integer getPart6Qty() {
        return part6Qty;
    }

    public void setPart6Qty(Integer part6Qty) {
        this.part6Qty = part6Qty;
    }

    public Integer getPart7Type() {
        return part7Type;
    }

    public void setPart7Type(Integer part7Type) {
        this.part7Type = part7Type;
    }

    public Integer getPart7Mark() {
        return part7Mark;
    }

    public void setPart7Mark(Integer part7Mark) {
        this.part7Mark = part7Mark;
    }

    public Integer getPart7Qty() {
        return part7Qty;
    }

    public void setPart7Qty(Integer part7Qty) {
        this.part7Qty = part7Qty;
    }

    public Integer getPart8Type() {
        return part8Type;
    }

    public void setPart8Type(Integer part8Type) {
        this.part8Type = part8Type;
    }

    public Integer getPart8Mark() {
        return part8Mark;
    }

    public void setPart8Mark(Integer part8Mark) {
        this.part8Mark = part8Mark;
    }

    public Integer getPart8Qty() {
        return part8Qty;
    }

    public void setPart8Qty(Integer part8Qty) {
        this.part8Qty = part8Qty;
    }
}
