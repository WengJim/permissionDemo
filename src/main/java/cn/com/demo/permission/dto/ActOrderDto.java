package cn.com.demo.permission.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class ActOrderDto {
    private Integer id;

    /**
     * 订单id
     */
    private String orderNo;

    /**
     * 活动id
     */
    private Integer actId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * -1:过时 0:未支付 1:已支付
     */
    private Integer status;

    /**
     * 活动可能支持多个场景，使用类型区分即可
     */
    private Integer type;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

}