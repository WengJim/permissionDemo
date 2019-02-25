package cn.com.demo.permission.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "web_activity")
public class Activity {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 活动名称
     */
    private String name;

    /**
     * 1:开启 0：关闭 默认关闭状态
     */
    private Integer status;

    /**
     * 渠道
     */
    private Integer channel;

    /**
     * 开始时间
     */
    @Column(name = "begin_time")
    private Date beginTime;

    /**
     * 失效时间
     */
    @Column(name = "invalid_time")
    private Date invalidTime;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 0:未删除 1 已经删除
     */
    @Column(name = "is_delete")
    private Integer isDelete;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取活动名称
     *
     * @return name - 活动名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置活动名称
     *
     * @param name 活动名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取1:开启 0：关闭 默认关闭状态
     *
     * @return status - 1:开启 0：关闭 默认关闭状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置1:开启 0：关闭 默认关闭状态
     *
     * @param status 1:开启 0：关闭 默认关闭状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取渠道
     *
     * @return channel - 渠道
     */
    public Integer getChannel() {
        return channel;
    }

    /**
     * 设置渠道
     *
     * @param channel 渠道
     */
    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    /**
     * 获取开始时间
     *
     * @return begin_time - 开始时间
     */
    public Date getBeginTime() {
        return beginTime;
    }

    /**
     * 设置开始时间
     *
     * @param beginTime 开始时间
     */
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * 获取失效时间
     *
     * @return invalid_time - 失效时间
     */
    public Date getInvalidTime() {
        return invalidTime;
    }

    /**
     * 设置失效时间
     *
     * @param invalidTime 失效时间
     */
    public void setInvalidTime(Date invalidTime) {
        this.invalidTime = invalidTime;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取0:未删除 1 已经删除
     *
     * @return is_delete - 0:未删除 1 已经删除
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 设置0:未删除 1 已经删除
     *
     * @param isDelete 0:未删除 1 已经删除
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}