package self.nacos.server2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import self.nacos.server2.domain.Goods;

/**
 * @Author: yuanchangshuai
 * @Date: 2020/11/27 15:32
 */
@Repository
public interface GoodsDao extends JpaRepository<Goods, Long> {
}
