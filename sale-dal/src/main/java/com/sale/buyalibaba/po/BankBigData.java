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
 * 银行大数据信息表
 * </p>
 *
 * @author 祁飞鸿
 * @since 2022-04-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BankBigData implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 开户行编码:0045
     */
    @TableField("bank_code")
    private String bankCode;

    /**
     * 开户行名称:建设银行
     */
    @TableField("bank_name")
    private String bankName;

    /**
     * 联行号, CNAPS CODE
     */
    @TableField("branch_code")
    private String branchCode;

    /**
     * 开户行全称:xxx银行xx支行
     */
    @TableField("branch_name")
    private String branchName;

    /**
     * 开户行地址
     */
    @TableField("account_bank_address")
    private String accountBankAddress;

    /**
     * swift/BIC码
     */
    @TableField("swift_code")
    private String swiftCode;

    /**
     * 省代码
     */
    @TableField("province_code")
    private String provinceCode;

    /**
     * 省名称
     */
    @TableField("province_name")
    private String provinceName;

    /**
     * 市代码
     */
    @TableField("city_code")
    private String cityCode;

    /**
     * 市名称
     */
    @TableField("city_name")
    private String cityName;

    /**
     * 国家代码
     */
    @TableField("country_code")
    private String countryCode;

    /**
     * 国家
     */
    @TableField("country")
    private String country;

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
