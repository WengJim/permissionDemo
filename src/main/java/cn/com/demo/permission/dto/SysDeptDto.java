package cn.com.demo.permission.dto;

import cn.com.demo.permission.utils.TreeNode;
import lombok.Data;

import javax.persistence.Column;

@Data
public class SysDeptDto extends TreeNode {
    private Long deptId;

    /**
     * 上级部门ID，一级部门为0
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 排序
     */
    @Column(name = "order_num")
    private Integer orderNum;

    /**
     * 是否删除  -1：已删除  0：正常
     */
    @Column(name = "del_flag")
    private Byte delFlag;

    private Long id;

    private String parentName;

    @Override
    public void setId(Long id) {
        this.id = deptId;
    }

    @Override
    public Long getId() {
        return deptId;
    }

    @Override
    public void setParentId(Long parentId) {
        this.id = deptId;
        this.parentId = parentId;
    }
}