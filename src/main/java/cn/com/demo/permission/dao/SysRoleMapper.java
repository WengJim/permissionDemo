package cn.com.demo.permission.dao;

import cn.com.demo.permission.core.Mapper;
import cn.com.demo.permission.model.SysRole;
import cn.com.demo.permission.model.SysRole;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysRoleMapper extends Mapper<SysRole> {
    @Select("SELECT m.menu_id FROM sys_role r LEFT JOIN sys_role_menu rm ON rm.role_id = r.role_id LEFT JOIN sys_menu m ON rm.menu_id = m.menu_id WHERE r.role_id = ${roleId}")
    List<Long> queryRoleInfo(@Param("roleId") Long roleId);
}