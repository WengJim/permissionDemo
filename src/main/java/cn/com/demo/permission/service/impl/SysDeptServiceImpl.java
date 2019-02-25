package cn.com.demo.permission.service.impl;

import cn.com.demo.permission.dao.SysDeptMapper;
import cn.com.demo.permission.model.SysDept;
import cn.com.demo.permission.service.ISysDeptService;
import cn.com.demo.permission.core.AbstractService;
import cn.com.demo.permission.core.AbstractService;
import cn.com.demo.permission.dao.SysDeptMapper;
import cn.com.demo.permission.service.ISysDeptService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
* @author: jimw
* @date: 2019/02/22 16:56:29
* @description: SysDept服务实现
*/
@Service
@Transactional
public class SysDeptServiceImpl extends AbstractService<SysDept> implements ISysDeptService {
    @Resource
    private SysDeptMapper sysDeptMapper;

}
