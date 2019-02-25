package cn.com.demo.permission.controller;

import cn.com.demo.permission.core.api.ApiResult;
import cn.com.demo.permission.model.Activity;
import cn.com.demo.permission.service.IActivityService;
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
 * @date: 2019/01/23 15:25:23
 * @description: Activity控制器
 */
@RestController
@RequestMapping("/activity")
@Slf4j
public class ActivityController {
    @Autowired
    private IActivityService activityService;


    /**
     * 新增Activity
     */
    @PostMapping("/add")
    public ApiResult add(@RequestBody Activity activity) {
      // LocalDateTime localDate = LocalDateTime.now();
      //  Date date = Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant());
        boolean flag = activityService.save(activity);
        Assert.isTrue(flag, "新增失败！");
        return ApiResult.success();
    }

    /**
     * 删除Activity
     */
    @DeleteMapping("/delete")
    public ApiResult delete(@RequestParam Integer id) {
        Activity activity = activityService.findById(id);
        Assert.notNull(activity, "查找对象不存在！");
        activity.setIsDelete(1);
        boolean flag = activityService.update(activity);
        return ApiResult.success();
    }

    /**
     * 更新Activity
     */
    @PutMapping("/update")
    public ApiResult update(@RequestBody Activity activity) {
        boolean flag = activityService.update(activity);
        Assert.isTrue(flag, "更新失败！");
        return ApiResult.success();
    }

    /**
     * Activity详情
     */
    @GetMapping("/detail")
    public ApiResult detail(@RequestParam Integer id) {
        Activity activity = activityService.findById(id);
        Assert.notNull(activity, "查找对象不存在！");
        return ApiResult.success(activity);
    }

    /**
     * Activity分页列表
     *
     * @param pageNum  页码
     * @param pageSize 每页记录数
     */
    @GetMapping("/pageList")
    public ApiResult pageList(Activity activity,
                              @RequestParam(defaultValue = "0")
                                      Integer pageNum,
                              @RequestParam(defaultValue = "5") Integer pageSize, @RequestParam(defaultValue = "0") int search) {
        // 分页
        PageHelper.startPage(pageNum, pageSize);
        // 增加查询条件，criteria.andCondition("xxxx");
        Condition condition = new Condition(Activity.class);
        Example.Criteria criteria = condition.createCriteria();
        condition.setOrderByClause("create_time desc ");
        //默认全局查询
        if (search == 0) {
            criteria.andEqualTo(activity);
        } else {
            CriteriaQuery.likeTo(activity, criteria);
        }
        List<Activity> list = activityService.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ApiResult.success(pageInfo);
    }

}
