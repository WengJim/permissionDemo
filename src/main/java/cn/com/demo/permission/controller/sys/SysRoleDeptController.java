package cn.com.demo.permission.controller.sys;

import cn.com.demo.permission.core.api.ApiResult;
import cn.com.demo.permission.model.SysRoleDept;
import cn.com.demo.permission.service.ISysRoleDeptService;
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
 * @date: 2019/02/22 16:57:01
 * @description: SysRoleDept控制器
 */
@RestController
@RequestMapping("/sys/role/dept")
@Slf4j
public class SysRoleDeptController {
    @Autowired
    private ISysRoleDeptService sysRoleDeptService;


    /**
     * 新增SysRoleDept
     */
    @PostMapping("/add")
    public ApiResult add(@RequestBody SysRoleDept sysRoleDept) {
        boolean flag = sysRoleDeptService.save(sysRoleDept);
        Assert.isTrue(flag, "新增失败！");
        return ApiResult.success();
    }

    /**
     * 删除SysRoleDept
     */
    @DeleteMapping("/delete")
    public ApiResult delete(@RequestParam Integer id) {
        boolean flag = sysRoleDeptService.deleteById(id);
        Assert.isTrue(flag, "被删除对象不存在！");
        return ApiResult.success();
    }

    /**
     * 更新SysRoleDept
     */
    @PutMapping("/update")
    public ApiResult update(@RequestBody SysRoleDept sysRoleDept) {
        boolean flag = sysRoleDeptService.update(sysRoleDept);
        Assert.isTrue(flag, "更新失败！");
        return ApiResult.success();
    }

    /**
     * SysRoleDept详情
     */
    @GetMapping("/detail")
    public ApiResult detail(@RequestParam Integer id) {
        SysRoleDept sysRoleDept = sysRoleDeptService.findById(id);
        Assert.notNull(sysRoleDept, "查找对象不存在！");
        return ApiResult.success(sysRoleDept);
    }

    /**
     * SysRoleDept分页列表
     *
     * @param pageNum  页码
     * @param pageSize 每页记录数
     */
    @GetMapping("/pageList")
    public ApiResult pageList(SysRoleDept sysRoleDept,
                              @RequestParam(defaultValue = "0")
                                      Integer pageNum,
                              @RequestParam(defaultValue = "5") Integer pageSize, @RequestParam(defaultValue = "0") int search) {
        // 分页
        PageHelper.startPage(pageNum, pageSize);
        // 增加查询条件，criteria.andCondition("xxxx");
        Condition condition = new Condition(SysRoleDept.class);
        Example.Criteria criteria = condition.createCriteria();
        condition.setOrderByClause("create_time desc ");
        //默认全局查询
        if (search == 0) {
            criteria.andEqualTo(sysRoleDept);
        } else {
            CriteriaQuery.likeTo(sysRoleDept, criteria);
        }
        List<SysRoleDept> list = sysRoleDeptService.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ApiResult.success(pageInfo);
    }
}
