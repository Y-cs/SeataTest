package self.nacos.client.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: yuanchangshuai
 * @Date: 2020/11/27 14:34
 */
@FeignClient(name = "server-1")
public interface Server1Client {

    @GetMapping("/addPointCount")
    public void addPointCount(@RequestParam("pointCount") int pointCount);

    @GetMapping("/getPointCount")
    public long getPointCount();

}
