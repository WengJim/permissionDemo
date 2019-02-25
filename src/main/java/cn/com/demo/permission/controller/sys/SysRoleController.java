package cn.com.demo.permission.controller.sys;

import cn.com.demo.permission.core.api.ApiResult;
import cn.com.demo.permission.dto.SysRoleDto;
import cn.com.demo.permission.dto.SysRoleInfo;
import cn.com.demo.permission.model.SysMenu;
import cn.com.demo.permission.model.SysRole;
import cn.com.demo.permission.model.SysRoleMenu;
import cn.com.demo.permission.service.ISysMenuService;
import cn.com.demo.permission.service.ISysRoleMenuService;
import cn.com.demo.permission.service.ISysRoleService;
import cn.com.demo.permission.utils.BeanConvert;
import cn.com.demo.permission.utils.CriteriaQuery;
import cn.com.demo.permission.model.SysRole;
import cn.com.demo.permission.service.ISysRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;
import org.springframework.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: jimw
 * @date: 2019/02/22 16:56:48
 * @description: SysRole控制器
 */
@RestController
@RequestMapping("/sys/role")
@Slf4j
public class SysRoleController {
    @Autowired
    private ISysRoleService sysRoleService;


    /**
     * 新增SysRole
     */
    @PostMapping("/add")
    public ApiResult add(@RequestBody SysRole sysRole) {
        boolean flag = sysRoleService.save(sysRole);
        Assert.isTrue(flag, "新增失败！");
        return ApiResult.success();
    }

    /**
     * 删除SysRole
     */
    @DeleteMapping("/delete")
    public ApiResult delete(@RequestParam Integer id) {
        boolean flag = sysRoleService.deleteById(id);
        Assert.isTrue(flag, "被删除对象不存在！");
        return ApiResult.success();
    }

    @Autowired
    private ISysRoleMenuService sysRoleMenuService;

    /**
     * 更新SysRole
     */
    @PutMapping("/update")
    public ApiResult update(@RequestBody SysRoleDto sysRoleDto) {
        SysRole sysRole = BeanConvert.toJavaObject(sysRoleDto, SysRole.class);
        boolean flag = sysRoleService.update(sysRole);
        sysRoleMenuService.saveOrUpdate(sysRoleDto);
        Assert.isTrue(flag, "更新失败！");
        return ApiResult.success();
    }


    /**
     * SysRole详情
     */
    @GetMapping("/detail")
    public ApiResult detail(@RequestParam Integer id) {
        SysRole sysRole = sysRoleService.findById(id);
        Assert.notNull(sysRole, "查找对象不存在！");
        return ApiResult.success(sysRole);
    }

    /**
     * SysRole角色分页列表
     *
     * @param pageNum  页码
     * @param pageSize 每页记录数
     */
    @GetMapping("/pageList")
    public ApiResult pageList(SysRole sysRole,
                              @RequestParam(defaultValue = "0")
                                      Integer pageNum,
                              @RequestParam(defaultValue = "5") Integer pageSize, @RequestParam(defaultValue = "0") int search) {
        // 分页
        PageHelper.startPage(pageNum, pageSize);
        // 增加查询条件，criteria.andCondition("xxxx");
        Condition condition = new Condition(SysRole.class);
        Example.Criteria criteria = condition.createCriteria();
        condition.setOrderByClause("create_time desc ");
        //默认全局查询
        if (search == 0) {
            criteria.andEqualTo(sysRole);
        } else {
            CriteriaQuery.likeTo(sysRole, criteria);
        }
        List<SysRole> list = sysRoleService.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ApiResult.success(pageInfo);
    }

    /**
     * 获取角色菜单权限
     *
     * @param roleId 角色id
     */
    @GetMapping("/info")
    public ApiResult info(Long roleId) {
        List<Long> list = sysRoleService.queryRoleInfo(roleId);
        SysRoleInfo sysRoleInfo = new SysRoleInfo();
        sysRoleInfo.setMenuIds(list);
        return ApiResult.success(sysRoleInfo);
    }


}
