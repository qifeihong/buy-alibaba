package com.sale.buyalibaba.po;

import java.math.BigDecimal;
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
 * 工资设置表(每个机构下面,设置的基本工资，护理工资,考勤，证书)
 * </p>
 *
 * @author 祁飞鸿
 * @since 2022-04-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysStaffSalary implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 机构id
     */
    @TableField("org_id")
    private Long orgId;

    /**
     * 工资项编码
     */
    @TableField("code")
    private String code;

    /**
     * 工资项名称
     */
    @TableField("name")
    private String name;

    /**
     * 当月金额
     */
    @TableField("amount")
    private BigDecimal amount;

    /**
     * 结算方式
     */
    @TableField("payment_type")
    private String paymentType;

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

    /**
     * 上次修改金额
     */
    @TableField("update_amount")
    private BigDecimal updateAmount;

    /**
     * 1.可用;2.已删除;0.禁用
     */
    @TableField("lifecycle")
    private Integer lifecycle;

    /**
     * 费用说明
     */
    @TableField("description")
    private String description;

    /**
     * 期望金额更新时间
     */
    @TableField("update_amount_time")
    private Date updateAmountTime;


}
