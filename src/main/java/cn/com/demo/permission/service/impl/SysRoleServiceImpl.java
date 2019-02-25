package cn.com.demo.permission.service.impl;

import cn.com.demo.permission.dao.SysRoleMapper;
import cn.com.demo.permission.model.SysRole;
import cn.com.demo.permission.service.ISysRoleService;
import cn.com.demo.permission.core.AbstractService;
import cn.com.demo.permission.model.SysRole;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
* @author: jimw
* @date: 2019/02/22 16:56:48
* @description: SysRole服务实现
*/
@Service
@Transactional
public class SysRoleServiceImpl extends AbstractService<SysRole> implements ISysRoleService {
    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<Long> queryRoleInfo(Long roleId) {
        return sysRoleMapper.queryRoleInfo(roleId);
    }
}
