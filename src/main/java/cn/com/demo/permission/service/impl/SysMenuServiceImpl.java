package cn.com.demo.permission.service.impl;

import cn.com.demo.permission.dao.SysMenuMapper;
import cn.com.demo.permission.dto.SysMenuDto;
import cn.com.demo.permission.model.SysMenu;
import cn.com.demo.permission.service.ISysMenuService;
import cn.com.demo.permission.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author: jimw
 * @date: 2019/02/22 16:56:38
 * @description: SysMenu服务实现
 */
@Service
@Transactional
public class SysMenuServiceImpl extends AbstractService<SysMenu> implements ISysMenuService {
    @Resource
    private SysMenuMapper sysMenuMapper;

    /**
     * 根据父类id获取子类信息
     *
     * @param parentId
     * @return
     */
    @Override
    public List<SysMenu> queryChildren(long parentId) {
        SysMenu sysMenu = new SysMenu();
        sysMenu.setParentId(parentId);
        return sysMenuMapper.selectByCondition(sysMenu);
    }

    @Override
    public List<SysMenu> queryUserMenus(long userId) {
        return sysMenuMapper.queryUserMenus(userId);
    }
}
