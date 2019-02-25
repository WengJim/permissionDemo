package cn.com.demo.permission.service;
import cn.com.demo.permission.dto.SysRoleDto;
import cn.com.demo.permission.model.SysRole;
import cn.com.demo.permission.model.SysRoleMenu;
import cn.com.demo.permission.core.Service;
import cn.com.demo.permission.core.Service;
import cn.com.demo.permission.dto.SysRoleDto;


/**
* @author: jimw
* @date: 2019/02/22 16:57:13
* @description: SysRoleMenu服务接口
*/
public interface ISysRoleMenuService extends Service<SysRoleMenu> {


    void saveOrUpdate(SysRoleDto sysRole);
}
