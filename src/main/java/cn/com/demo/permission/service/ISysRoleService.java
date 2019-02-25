package cn.com.demo.permission.service;
import cn.com.demo.permission.model.SysRole;
import cn.com.demo.permission.core.Service;
import cn.com.demo.permission.model.SysRole;

import java.util.List;


/**
* @author: jimw
* @date: 2019/02/22 16:56:48
* @description: SysRole服务接口
*/
public interface ISysRoleService extends Service<SysRole> {

   List<Long> queryRoleInfo(Long roleId);

}
