package self.nacos.client.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: yuanchangshuai
 * @Date: 2020/11/27 14:34
 */
@FeignClient(name = "server-2")
public interface Server2Client {

    @GetMapping("/cutGoodsCount")
    public void cutGoodsCount(@RequestParam("count") int count);

    @GetMapping("/getGoodsCount")
    public long getGoodsCount();

}
