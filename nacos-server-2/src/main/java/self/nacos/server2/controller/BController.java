package self.nacos.server2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import self.nacos.server2.service.BServer;

/**
 * @Author: yuanchangshuai
 * @Date: 2020/11/27 16:18
 */
@RestController
public class BController {

    @Autowired
    private BServer bServer;

    @GetMapping("/cutGoodsCount")
    public void cutGoodsCount(@RequestParam("count") int count) throws Exception {
        bServer.cutGoodsCount(count);
    }

    @GetMapping("/getGoodsCount")
    public long getGoodsCount() {
        return bServer.getGoodsCount();
    }


}
