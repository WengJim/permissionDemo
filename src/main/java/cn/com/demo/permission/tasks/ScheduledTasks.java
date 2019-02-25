package cn.com.demo.permission.tasks;

import cn.com.demo.permission.service.IActOrderService;
import cn.com.demo.permission.service.IActOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 轮询查询为支付的订单状态
 *
 * @author jimw
 * @date 2019-1-25
 */
@Component
@Slf4j
public class ScheduledTasks {

    @Autowired
    private IActOrderService actOrderService;
    /**
     * 从当前方法开始执行后10m再次执行
     * 每次重启都会触发一次，然后10m后再次执行
     * 主要是
     * -1:过时 0:未支付 1:已支付
     */
      @Scheduled(fixedDelay = 60000 * 10)
  // @Scheduled(fixedDelay = 6000)
    public void scheduledTask() {
     //   log.info("订单执行时间为：{}", LocalDateTime.now());
    }
}
