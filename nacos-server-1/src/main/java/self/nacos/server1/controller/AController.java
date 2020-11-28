package self.nacos.server1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import self.nacos.server1.service.AServer;

/**
 * @Author: yuanchangshuai
 * @Date: 2020/11/27 16:18
 */
@RestController
public class AController {

    @Autowired
    private AServer aServer;

    @GetMapping("/addPointCount")
    public void addPointCount(@RequestParam("pointCount") int pointCount) {
        aServer.addPointCount(pointCount);
    }

    @GetMapping("/getPointCount")
    public long getPointCount() {
        return aServer.getPointCount();
    }


}
