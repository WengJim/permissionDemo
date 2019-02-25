package cn.com.demo.permission.dto;

import cn.com.demo.permission.utils.TreeNode;
import cn.com.demo.permission.utils.TreeNode;
import lombok.Data;

@Data
public class SysMenuDto extends TreeNode {
    private Long menuId;

    /**
     * 父菜单ID，一级菜单为0
     */
    private Long parentId;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单URL
     */
    private String url;

    /**
     * 授权(多个用逗号分隔，如：user:list,user:create)
     */
    private String perms;

    /**
     * 类型   0：目录   1：菜单   2：按钮
     */
    private Integer type;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 排序
     */
    private Integer orderNum;
    private Long id;

    private String parentName;

    @Override
    public void setId(Long id) {
        this.id = menuId;
    }

    @Override
    public Long getId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.id = menuId;
        this.menuId = menuId;
    }
}