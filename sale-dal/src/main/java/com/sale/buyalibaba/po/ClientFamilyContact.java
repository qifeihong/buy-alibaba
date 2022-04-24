package com.sale.buyalibaba.po;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 老人联系人表
 * </p>
 *
 * @author 祁飞鸿
 * @since 2022-04-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ClientFamilyContact implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 老人id
     */
    @TableField("client_id")
    private Long clientId;

    /**
     * 关系
     */
    @TableField("relation")
    private String relation;

    /**
     * 1男 2女
     */
    @TableField("gender")
    private String gender;

    /**
     * 出生日期
     */
    @TableField("birth_date")
    private String birthDate;

    /**
     * 工作
     */
    @TableField("job")
    private String job;

    /**
     * 公司名称
     */
    @TableField("company")
    private String company;

    /**
     * 姓名
     */
    @TableField("name")
    private String name;

    /**
     * 手机号
     */
    @TableField("phone")
    private String phone;

    /**
     * 文化程度
     */
    @TableField("education")
    private String education;

    /**
     * 省市区
     */
    @TableField("province")
    private String province;

    /**
     * 居住地址
     */
    @TableField("live_address")
    private String liveAddress;

    /**
     * 是否紧急联系人
     */
    @TableField("is_emergency")
    private Boolean isEmergency;

    /**
     * 是否删除 0未删除 1删除
     */
    @TableField("deleted")
    private Boolean deleted;

    /**
     * 创建者id
     */
    @TableField("create_id")
    private Long createId;

    /**
     * 创建者姓名
     */
    @TableField("create_by")
    private String createBy;

    /**
     * 创建日期
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 更新者id
     */
    @TableField("update_id")
    private Long updateId;

    /**
     * 更新者姓名
     */
    @TableField("update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;


}
