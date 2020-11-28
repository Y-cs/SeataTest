package self.nacos.server1;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @Author: yuanchangshuai
 * @Date: 2020/11/27 14:07
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoDataSourceProxy
@EntityScan("self.nacos.server1.domain")
@EnableJpaRepositories(basePackages = "self.nacos.server1.dao")
public class Server1Application {

    public static void main(String[] args) {
        SpringApplication.run(Server1Application.class, args);
        System.out.println("service1 start");
    }

}
