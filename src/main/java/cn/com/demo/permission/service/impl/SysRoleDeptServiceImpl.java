package cn.com.demo.permission.service.impl;

import cn.com.demo.permission.dao.SysRoleDeptMapper;
import cn.com.demo.permission.model.SysRoleDept;
import cn.com.demo.permission.service.ISysRoleDeptService;
import cn.com.demo.permission.core.AbstractService;
import cn.com.demo.permission.dao.SysRoleDeptMapper;
import cn.com.demo.permission.model.SysRoleDept;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
* @author: jimw
* @date: 2019/02/22 16:57:01
* @description: SysRoleDept服务实现
*/
@Service
@Transactional
public class SysRoleDeptServiceImpl extends AbstractService<SysRoleDept> implements ISysRoleDeptService {
    @Resource
    private SysRoleDeptMapper sysRoleDeptMapper;

}
