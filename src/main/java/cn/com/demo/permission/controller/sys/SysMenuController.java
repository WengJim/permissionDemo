package cn.com.demo.permission.controller.sys;

import cn.com.demo.permission.core.api.ApiResult;
import cn.com.demo.permission.dto.SysMenuDto;
import cn.com.demo.permission.model.SysMenu;
import cn.com.demo.permission.service.ISysMenuService;
import cn.com.demo.permission.utils.BeanConvert;
import cn.com.demo.permission.utils.CriteriaQuery;
import cn.com.demo.permission.utils.TreeNode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;
import org.springframework.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: jimw
 * @date: 2019/02/22 16:56:38
 * @description: SysMenu控制器
 */
@RestController
@RequestMapping("/sys/menu")
@Slf4j
public class SysMenuController {
    @Autowired
    private ISysMenuService sysMenuService;


    /**
     * 新增SysMenu
     */
    @PostMapping("/add")
    public ApiResult add(@RequestBody SysMenu sysMenu) {
        boolean flag = sysMenuService.save(sysMenu);
        Assert.isTrue(flag, "新增失败！");
        return ApiResult.success();
    }

    /**
     * 删除SysMenu
     */
    @DeleteMapping("/delete")
    public ApiResult delete(@RequestParam Integer id) {
        boolean flag = sysMenuService.deleteById(id);
        Assert.isTrue(flag, "被删除对象不存在！");
        return ApiResult.success();
    }

    /**
     * 更新SysMenu
     */
    @PutMapping("/update")
    public ApiResult update(@RequestBody SysMenu sysMenu) {
        boolean flag = sysMenuService.update(sysMenu);
        Assert.isTrue(flag, "更新失败！");
        return ApiResult.success();
    }

    /**
     * SysMenu详情
     */
    @GetMapping("/detail")
    public ApiResult detail(@RequestParam Integer id) {
        SysMenu sysMenu = sysMenuService.findById(id);
        Assert.notNull(sysMenu, "查找对象不存在！");
        return ApiResult.success(sysMenu);
    }

    /**
     * SysMenu分页列表
     *
     * @param pageNum  页码
     * @param pageSize 每页记录数
     */
    @GetMapping("/pageList")
    public ApiResult pageList(SysMenuDto sysMenu,
                              @RequestParam(defaultValue = "0")
                                      Integer pageNum,
                              @RequestParam(defaultValue = "500") Integer pageSize, @RequestParam(defaultValue = "0") int search) {
        // 分页
        PageHelper.startPage(pageNum, pageSize);
        // 增加查询条件，criteria.andCondition("xxxx");
        Condition condition = new Condition(SysMenu.class);
        Example.Criteria criteria = condition.createCriteria();
        condition.setOrderByClause("order_num desc ");
        //    sysMenu.setType(0);
        //默认全局查询
        if (search == 0) {
            criteria.andEqualTo(sysMenu);
        } else {
            CriteriaQuery.likeTo(sysMenu, criteria);
        }
        List<SysMenu> list = sysMenuService.findByCondition(condition);
        List<SysMenuDto> sysMenuList = Lists.newArrayList();
        for (int i = 0; i < list.size(); i++) {
            SysMenuDto sysMenuDto = BeanConvert.toJavaObject(list.get(i), SysMenuDto.class);
            sysMenuList.add(sysMenuDto);
        }
        sysMenuList = TreeNode.toTrees(sysMenuList);

        PageInfo pageInfo = new PageInfo(sysMenuList);
        return ApiResult.success(pageInfo);
    }

    /**
     * 根据用户id获取权限菜单
     *
     * @param pageNum  页码
     * @param pageSize 每页记录数
     */
    @GetMapping("/userMenus")
    public ApiResult userMenus(Long userId,
                               @RequestParam(defaultValue = "0")
                                       Integer pageNum,
                               @RequestParam(defaultValue = "500") Integer pageSize, @RequestParam(defaultValue = "0") int search) {
        // 分页
        PageHelper.startPage(pageNum, pageSize);
        // 增加查询条件，criteria.andCondition("xxxx");
        //默认全局查询
        List<SysMenu> list = sysMenuService.queryUserMenus(userId);
        List<SysMenuDto> sysMenuList = Lists.newArrayList();
        for (int i = 0; i < list.size(); i++) {
            SysMenuDto sysMenuDto = BeanConvert.toJavaObject(list.get(i), SysMenuDto.class);
            sysMenuList.add(sysMenuDto);
        }
        sysMenuList = TreeNode.toTrees(sysMenuList);
        PageInfo pageInfo = new PageInfo(sysMenuList);
        return ApiResult.success(pageInfo);
    }
}
