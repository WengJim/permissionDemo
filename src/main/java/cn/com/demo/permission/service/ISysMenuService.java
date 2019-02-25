package cn.com.demo.permission.service;

import cn.com.demo.permission.dto.SysMenuDto;
import cn.com.demo.permission.model.SysMenu;
import cn.com.demo.permission.core.Service;

import java.util.List;


/**
 * @author: jimw
 * @date: 2019/02/22 16:56:38
 * @description: SysMenu服务接口
 */
public interface ISysMenuService extends Service<SysMenu> {
    /**
     * 根据父类id获取子类信息
     *
     * @param parentId
     * @return
     */
    List<SysMenu> queryChildren(long parentId);


    List<SysMenu> queryUserMenus(long userId);

}
