package cn.com.demo.permission.dao;

import cn.com.demo.permission.core.Mapper;
import cn.com.demo.permission.dto.SysMenuDto;
import cn.com.demo.permission.model.SysMenu;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysMenuMapper extends Mapper<SysMenu> {

    List<SysMenu> queryUserMenus(long userId);

}