package cn.xzxy.lewy.iaweb.controller;

import cn.xzxy.lewy.iaweb.pojo.ItemIndex;
import cn.xzxy.lewy.iaweb.pojo.TotalScore;
import cn.xzxy.lewy.iaweb.service.ItemService;
import cn.xzxy.lewy.iaweb.service.TotalScoreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Resource
    ItemService itemService;

    @Resource
    TotalScoreService totalScoreService;

    @GetMapping(value = "/records")
    public List<ItemIndex> getAllItems() {

        return itemService.getAllItems();
    }

    /**
     * 获取不同难度范围的试题数目
     */
    @GetMapping(value = "/nandu")
    public List<Map<String, Integer>> getNanduScale(@RequestParam String paperCode,
                                                    @RequestParam String createTime) {
        //String paperCode = "915003";
        //String createTime = "1555355855023";
        List<Map<String, Integer>> listMap = new ArrayList<>();
        int count;
        int nc;
        double si = 0.0;
        while (si <= 0.8) {
            double ei = si + 0.2;
            count = itemService.getNanduScale(si, ei, paperCode, createTime);
            nc = (int) (si * 10);
            Map<String, Integer> map = new HashMap<>();
            map.put("ndcode", nc);
            map.put("value", count);
            listMap.add(map);
            si += 0.2;
        }
        return listMap;
    }

    /**
     * 获取不同难度范围的试题数目
     */
    @GetMapping(value = "/qufendu")
    public List<Map<String, Integer>> getQufenduScale(@RequestParam String paperCode,
                                                      @RequestParam String createTime) {
        //String paperCode = "915003";
        //String createTime = "1555355855023";
        List<Map<String, Integer>> listMap = new ArrayList<>();
        int count;
        int nc;
        double si = 0.1;
        //区分度指标范围
        //(0,0.2),(0.2,0.3),(0.3,0.4),(0.4)
        while (si < 0.5) {
            double ei;
            if (si == 0.4) {
                ei = 1;
            } else if (si == 0.1) {
                si = -1;
                ei = 0.2;
            } else {
                ei = si + 0.1;
            }
            count = itemService.getQufenduScale(si, ei, paperCode, createTime);
            if (si == -1) {
                si = 0.1;
            }
            nc = (int) (si * 10);
            Map<String, Integer> map = new HashMap<>();
            map.put("qfdcode", nc);
            map.put("value", count);
            listMap.add(map);
            si += 0.1;
        }
        return listMap;
    }

    /**
     * 获取不同范围的总分数目
     */
    @GetMapping(value = "/totalScore")
    public List<Map<String, Integer>> getScoreScale(@RequestParam String paperCode,
                                                    @RequestParam String createTime) {
        //String paperCode = "915003";
        //String createTime = "1555355855023";
        List<Map<String, Integer>> listMap = new ArrayList<>();
        int count = 0;
        int start = 0;
        int end = 0;
        while(start < 100){
            end = start + 10;
            count = totalScoreService.getCountByPCodeAndCreate(start, end, paperCode, createTime);
            start += 10;
            Map<String, Integer> map = new HashMap<>();
            map.put("tsCount", count);
            listMap.add(map);
        }

        return listMap;
    }

}
