package cn.com.demo.permission.controller.sys;

import cn.com.demo.permission.core.api.ApiResult;
import cn.com.demo.permission.dto.SysDeptDto;
import cn.com.demo.permission.model.SysDept;
import cn.com.demo.permission.service.ISysDeptService;
import cn.com.demo.permission.utils.BeanConvert;
import cn.com.demo.permission.utils.TreeNode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author: jimw
 * @date: 2019/02/22 16:56:29
 * @description: SysDept控制器
 */
@RestController
@RequestMapping("/sys/dept")
@Slf4j
public class SysDeptController {
    @Autowired
    private ISysDeptService sysDeptService;


    /**
     * 新增SysDept
     */
    @PostMapping("/add")
    public ApiResult add(@RequestBody SysDept sysDept) {
        boolean flag = sysDeptService.save(sysDept);
        Assert.isTrue(flag, "新增失败！");
        return ApiResult.success();
    }

    /**
     * 删除SysDept
     */
    @DeleteMapping("/delete")
    public ApiResult delete(@RequestParam Integer id) {
        boolean flag = sysDeptService.deleteById(id);
        Assert.isTrue(flag, "被删除对象不存在！");
        return ApiResult.success();
    }

    /**
     * 更新SysDept
     */
    @PutMapping("/update")
    public ApiResult update(@RequestBody SysDept sysDept) {
        boolean flag = sysDeptService.update(sysDept);
        Assert.isTrue(flag, "更新失败！");
        return ApiResult.success();
    }

    /**
     * SysDept详情
     */
    @GetMapping("/detail")
    public ApiResult detail(@RequestParam Integer id) {
        SysDept sysDept = sysDeptService.findById(id);
        Assert.notNull(sysDept, "查找对象不存在！");
        return ApiResult.success(sysDept);
    }

    /**
     * SysDept分页列表
     *
     * @param pageNum  页码
     * @param pageSize 每页记录数
     */
    @GetMapping("/pageList")
    public ApiResult pageList(SysDeptDto sysDept,
                              @RequestParam(defaultValue = "0")
                                      Integer pageNum,
                              @RequestParam(defaultValue = "5") Integer pageSize) {
        // 分页
        PageHelper.startPage(pageNum, pageSize);
        Condition condition = new Condition(SysDept.class);
        Example.Criteria criteria = condition.createCriteria();
        condition.setOrderByClause("order_num desc ");
        //默认全局查询
        criteria.andEqualTo(sysDept);
        List<SysDept> list = sysDeptService.findByCondition(condition);
        List<SysDeptDto> sysDepList = Lists.newArrayList();
        for (int i = 0; i < list.size(); i++) {
            SysDeptDto sysDeptDto = BeanConvert.toJavaObject(list.get(i), SysDeptDto.class);
            sysDepList.add(sysDeptDto);
        }
        sysDepList = TreeNode.toTrees(sysDepList);
        PageInfo pageInfo = new PageInfo(sysDepList);
        return ApiResult.success(pageInfo);
    }
}
