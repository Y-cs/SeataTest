package self.nacos.client.controller;

import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import self.nacos.client.service.TestService;

/**
 * @Author: yuanchangshuai
 * @Date: 2020/11/27 16:23
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/test")
    @GlobalTransactional(name = "ycs_tx_group",rollbackFor = Exception.class)
    public String test(int pointCount,int count){
        try {
            testService.test(pointCount,count);
            return "添加"+pointCount+"积分,扣除"+count+"库存--->当前:"+testService.getNow();
        }catch (Exception e){
            e.printStackTrace();
            return "发生错误进行回滚--->当前:"+testService.getNow();
        }
    }


}
