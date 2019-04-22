package cn.xzxy.lewy.iaweb.controller;

import cn.xzxy.lewy.iaweb.pojo.ItemIndex;
import cn.xzxy.lewy.iaweb.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping(value = "/records")
    public List<ItemIndex> getAllItems() {

        return itemService.getAllItems();
    }

    /**
     * 获取不同难度范围的试题数目
     */
    @GetMapping(value = "/nandu")
    public List<Map<String, Integer>> getNanduScale2() {
        String paperCode = "915003";
        String createTime = "1555355855023";
        List<Map<String, Integer>> listMap = new ArrayList<>();
        int count;
        int nc;
        double si = 0.0;
        while (si <= 0.8) {
            double ei = si + 0.2;
            count = itemService.getNandeScale(si, ei, paperCode, createTime);
            nc = (int) (si*10);
            Map<String, Integer> map = new HashMap<>();
            map.put("ndcode", nc);
            map.put("value", count);
            listMap.add(map);
            si += 0.2;
        }
        return listMap;
    }
}
