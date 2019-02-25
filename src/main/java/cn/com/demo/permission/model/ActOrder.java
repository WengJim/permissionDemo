package cn.com.demo.permission.model;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Table(name = "web_act_order")
@Data
public class ActOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 订单id
     */
    @Column(name = "order_no")
    private String orderNo;

    /**
     * 活动id
     */
    @Column(name = "act_id")
    private Integer actId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
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
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

}