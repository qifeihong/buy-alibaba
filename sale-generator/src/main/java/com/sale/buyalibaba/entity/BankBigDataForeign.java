package com.sale.buyalibaba.entity;

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
 * 国外银行大数据信息表
 * </p>
 *
 * @author 祁飞鸿
 * @since 2022-04-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BankBigDataForeign implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * BIC码
     */
    @TableField("bic")
    private String bic;

    /**
     * 国家
     */
    @TableField("country")
    private String country;

    /**
     * 省
     */
    @TableField("department")
    private String department;

    /**
     * 城市
     */
    @TableField("city_name")
    private String cityName;

    /**
     * 状态
     */
    @TableField("status")
    private String status;

    /**
     * 类型
     */
    @TableField("type")
    private String type;

    /**
     * 机构名称
     */
    @TableField("institution_name")
    private String institutionName;

    /**
     * 支行信息
     */
    @TableField("branch_info")
    private String branchInfo;

    /**
     * CHIPS ID
     */
    @TableField("chips_id")
    private String chipsId;

    /**
     * NATIONAL ID
     */
    @TableField("NATIONAL_ID")
    private String nationalId;

    /**
     * 租户id
     */
    @TableField("tenant_id")
    private String tenantId;

    /**
     * 法人公司
     */
    @TableField("corporation_code")
    private String corporationCode;

    /**
     * 创建人id
     */
    @TableField("create_uid")
    private String createUid;

    /**
     * 创建人名称
     */
    @TableField("create_name")
    private String createName;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 更新人id
     */
    @TableField("update_uid")
    private String updateUid;

    /**
     * 更新人名称
     */
    @TableField("update_name")
    private String updateName;

    /**
     * 删除状态
     */
    @TableField("is_del")
    private Integer isDel;


}
