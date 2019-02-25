package cn.com.demo.permission.controller;

import cn.com.demo.permission.core.api.ApiResult;
import cn.com.demo.permission.dto.ActOrderDto;
import cn.com.demo.permission.model.ActOrder;
import cn.com.demo.permission.service.IActOrderService;
import cn.com.demo.permission.utils.BeanConvert;
import cn.com.demo.permission.utils.CriteriaQuery;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author: jimw
 * @date: 2019/01/23 17:59:03
 * @description: ActOrder控制器
 */
@RestController
@RequestMapping("/act/order")
@Slf4j
public class ActOrderController {
    @Autowired
    private IActOrderService actOrderService;


    /**
     * 新增ActOrder
     */
    @PostMapping("/add")
    public ApiResult add(@RequestBody ActOrder actOrder) {
        boolean flag = actOrderService.save(actOrder);
        Assert.isTrue(flag, "新增失败！");
        return ApiResult.success();
    }

    /**
     * 删除ActOrder
     */
    @DeleteMapping("/delete")
    public ApiResult delete(@RequestParam Integer id) {
        boolean flag = actOrderService.deleteById(id);
        Assert.isTrue(flag, "被删除对象不存在！");
        return ApiResult.success();
    }

    /**
     * 更新ActOrder
     */
    @PutMapping("/update")
    public ApiResult update(@RequestBody ActOrder actOrder) {
        boolean flag = actOrderService.update(actOrder);
        Assert.isTrue(flag, "更新失败！");
        return ApiResult.success();
    }

    /**
     * ActOrder详情
     */
    @GetMapping("/detail")
    public ApiResult detail(@RequestParam Integer id) {
        ActOrder actOrder = actOrderService.findById(id);
        Assert.notNull(actOrder, "查找对象不存在！");
        return ApiResult.success(actOrder);
    }

    /**
     * ActOrder分页列表
     *
     * @param pageNum  页码
     * @param pageSize 每页记录数
     */
    @GetMapping("/pageList")
    public ApiResult pageList(ActOrder actOrder,
                              @RequestParam(defaultValue = "0")
                                      Integer pageNum,
                              @RequestParam(defaultValue = "5") Integer pageSize, @RequestParam(defaultValue = "0") int search) {
        // 分页
        PageHelper.startPage(pageNum, pageSize);
        // 增加查询条件，criteria.andCondition("xxxx");
        Condition condition = new Condition(ActOrder.class);
        Example.Criteria criteria = condition.createCriteria();
        condition.setOrderByClause("create_time desc ");
        //默认全局查询
        if (search == 0) {
            criteria.andEqualTo(actOrder);
        } else {
            CriteriaQuery.likeTo(actOrder, criteria);
        }
        List<ActOrder> list = actOrderService.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ApiResult.success(pageInfo);
    }

    /**
     * Activity 回调
     *
     * @param order 回调提供成功订单号
     */
    @PostMapping("/invokeOrder")
    public ApiResult invokeOrder(@RequestBody ActOrderDto order) {
        Condition condition = new Condition(ActOrder.class);
        Example.Criteria criteria = condition.createCriteria();
        ActOrder actOrder = BeanConvert.toJavaObject(order, ActOrder.class);
        criteria.andEqualTo(actOrder);
        List<ActOrder> list = actOrderService.findByCondition(condition);
        Assert.isTrue(list.size() > 1, "查找对象不存在！");
        actOrder = list.get(0);
        actOrder.setStatus(1);
        boolean result = actOrderService.update(actOrder);

        return ApiResult.success();
    }
}
