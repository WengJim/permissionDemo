package cn.com.demo.permission.dto;

import lombok.Data;

import java.util.List;


/**
 * 获取个人权限信息
 */
@Data
public class SysRoleInfo {
    private List<Long> menuIds;
}
