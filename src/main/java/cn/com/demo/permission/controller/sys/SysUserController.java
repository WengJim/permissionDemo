package cn.com.demo.permission.controller.sys;

import cn.com.demo.permission.core.api.ApiResult;
import cn.com.demo.permission.model.SysUser;
import cn.com.demo.permission.service.ISysUserService;
import cn.com.demo.permission.utils.CriteriaQuery;
import cn.com.demo.permission.core.api.ApiResult;
import cn.com.demo.permission.model.SysUser;
import cn.com.demo.permission.service.ISysUserService;
import cn.com.demo.permission.utils.CriteriaQuery;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;
import org.springframework.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: jimw
 * @date: 2019/02/22 16:57:23
 * @description: SysUser控制器
 */
@RestController
@RequestMapping("/sys/user")
@Slf4j
public class SysUserController {
    @Autowired
    private ISysUserService sysUserService;


    /**
     * 新增SysUser
     */
    @PostMapping("/add")
    public ApiResult add(@RequestBody SysUser sysUser) {
        boolean flag = sysUserService.save(sysUser);
        Assert.isTrue(flag, "新增失败！");
        return ApiResult.success();
    }

    /**
     * 删除SysUser
     */
    @DeleteMapping("/delete")
    public ApiResult delete(@RequestParam Integer id) {
        boolean flag = sysUserService.deleteById(id);
        Assert.isTrue(flag, "被删除对象不存在！");
        return ApiResult.success();
    }

    /**
     * 更新SysUser
     */
    @PutMapping("/update")
    public ApiResult update(@RequestBody SysUser sysUser) {
        boolean flag = sysUserService.update(sysUser);
        Assert.isTrue(flag, "更新失败！");
        return ApiResult.success();
    }

    /**
     * SysUser详情
     */
    @GetMapping("/detail")
    public ApiResult detail(@RequestParam Integer id) {
        SysUser sysUser = sysUserService.findById(id);
        Assert.notNull(sysUser, "查找对象不存在！");
        return ApiResult.success(sysUser);
    }

    /**
     * SysUser分页列表
     *
     * @param pageNum  页码
     * @param pageSize 每页记录数
     */
    @GetMapping("/pageList")
    public ApiResult pageList(SysUser sysUser,
                              @RequestParam(defaultValue = "0")
                                      Integer pageNum,
                              @RequestParam(defaultValue = "5") Integer pageSize, @RequestParam(defaultValue = "0") int search) {
        // 分页
        PageHelper.startPage(pageNum, pageSize);
        // 增加查询条件，criteria.andCondition("xxxx");
        Condition condition = new Condition(SysUser.class);
        Example.Criteria criteria = condition.createCriteria();
        condition.setOrderByClause("create_time desc ");
        //默认全局查询
        if (search == 0) {
            criteria.andEqualTo(sysUser);
        } else {
            CriteriaQuery.likeTo(sysUser, criteria);
        }
        List<SysUser> list = sysUserService.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ApiResult.success(pageInfo);
    }


}
