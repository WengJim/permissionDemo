package cn.com.demo.permission.service.impl;

import cn.com.demo.permission.dao.SysRoleMenuMapper;
import cn.com.demo.permission.dto.SysRoleDto;
import cn.com.demo.permission.model.SysRole;
import cn.com.demo.permission.model.SysRoleMenu;
import cn.com.demo.permission.service.ISysRoleMenuService;
import cn.com.demo.permission.core.AbstractService;
import cn.com.demo.permission.dao.SysRoleMenuMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;


/**
* @author: jimw
* @date: 2019/02/22 16:57:13
* @description: SysRoleMenu服务实现
*/
@Service
@Transactional
public class SysRoleMenuServiceImpl extends AbstractService<SysRoleMenu> implements ISysRoleMenuService {
    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdate(SysRoleDto sysRole) {
        List<Long> menuIds = sysRole.getMenuIds();
        Condition condition = new Condition(SysRoleMenu.class);
        Example.Criteria criteria = condition.createCriteria();
        SysRoleMenu roleMenu = new SysRoleMenu();
        roleMenu.setRoleId(sysRole.getRoleId());
        criteria.andEqualTo(roleMenu);
        List<SysRoleMenu> list = findByCondition(condition);
        String roleMenuIds = "";
        for (int i = 0; i < list.size(); i++) {
            roleMenuIds = roleMenuIds + list.get(i).getId() + ",";
        }
        deleteByIds(roleMenuIds);
        if (!StringUtils.isEmpty(menuIds)) {
            for (int i = 0; i < menuIds.size(); i++) {
                SysRoleMenu sysRoleMenu =new SysRoleMenu();
                sysRoleMenu.setRoleId(menuIds.get(i));
                sysRoleMenu.setRoleId(sysRole.getRoleId());
                save(sysRoleMenu);
            }
        }

    }

}
