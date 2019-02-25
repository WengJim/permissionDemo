package cn.com.demo.permission.service.impl;

import cn.com.demo.permission.dao.SysUserMapper;
import cn.com.demo.permission.model.SysUser;
import cn.com.demo.permission.service.ISysUserService;
import cn.com.demo.permission.core.AbstractService;
import cn.com.demo.permission.core.AbstractService;
import cn.com.demo.permission.dao.SysUserMapper;
import cn.com.demo.permission.service.ISysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
* @author: jimw
* @date: 2019/02/22 16:57:23
* @description: SysUser服务实现
*/
@Service
@Transactional
public class SysUserServiceImpl extends AbstractService<SysUser> implements ISysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

}
