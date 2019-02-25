package cn.com.demo.permission.controller.sys;

import cn.com.demo.permission.core.api.ApiResult;
import cn.com.demo.permission.model.SysRoleMenu;
import cn.com.demo.permission.service.ISysRoleMenuService;
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
 * @date: 2019/02/22 16:57:13
 * @description: SysRoleMenu控制器
 */
@RestController
@RequestMapping("/sys/role/menu")
@Slf4j
public class SysRoleMenuController {
    @Autowired
    private ISysRoleMenuService sysRoleMenuService;


    /**
     * 新增SysRoleMenu
     */
    @PostMapping("/add")
    public ApiResult add(@RequestBody SysRoleMenu sysRoleMenu) {
        boolean flag = sysRoleMenuService.save(sysRoleMenu);
        Assert.isTrue(flag, "新增失败！");
        return ApiResult.success();
    }

    /**
     * 删除SysRoleMenu
     */
    @DeleteMapping("/delete")
    public ApiResult delete(@RequestParam Integer id) {
        boolean flag = sysRoleMenuService.deleteById(id);
        Assert.isTrue(flag, "被删除对象不存在！");
        return ApiResult.success();
    }

    /**
     * 更新SysRoleMenu
     */
    @PutMapping("/update")
    public ApiResult update(@RequestBody SysRoleMenu sysRoleMenu) {
        boolean flag = sysRoleMenuService.update(sysRoleMenu);
        Assert.isTrue(flag, "更新失败！");
        return ApiResult.success();
    }

    /**
     * SysRoleMenu详情
     */
    @GetMapping("/detail")
    public ApiResult detail(@RequestParam Integer id) {
        SysRoleMenu sysRoleMenu = sysRoleMenuService.findById(id);
        Assert.notNull(sysRoleMenu, "查找对象不存在！");
        return ApiResult.success(sysRoleMenu);
    }

    /**
     * SysRoleMenu分页列表
     *
     * @param pageNum  页码
     * @param pageSize 每页记录数
     */
    @GetMapping("/pageList")
    public ApiResult pageList(SysRoleMenu sysRoleMenu,
                              @RequestParam(defaultValue = "0")
                                      Integer pageNum,
                              @RequestParam(defaultValue = "5") Integer pageSize, @RequestParam(defaultValue = "0") int search) {
        // 分页
        PageHelper.startPage(pageNum, pageSize);
        // 增加查询条件，criteria.andCondition("xxxx");
        Condition condition = new Condition(SysRoleMenu.class);
        Example.Criteria criteria = condition.createCriteria();
        condition.setOrderByClause("create_time desc ");
        //默认全局查询
        if (search == 0) {
            criteria.andEqualTo(sysRoleMenu);
        } else {
            CriteriaQuery.likeTo(sysRoleMenu, criteria);
        }
        List<SysRoleMenu> list = sysRoleMenuService.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ApiResult.success(pageInfo);
    }
}
