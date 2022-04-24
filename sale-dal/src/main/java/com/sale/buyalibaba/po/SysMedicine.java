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
 * 药品表
 * </p>
 *
 * @author 祁飞鸿
 * @since 2022-04-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysMedicine implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 针对病症
     */
    @TableField("cdss_name")
    private String cdssName;

    /**
     * 通用名
     */
    @TableField("common_name")
    private String commonName;

    /**
     * 学名
     */
    @TableField("goods_name")
    private String goodsName;

    /**
     * 规格
     */
    @TableField("form")
    private String form;

    /**
     * 剂型
     */
    @TableField("jixing")
    private String jixing;

    /**
     * 厂家
     */
    @TableField("factory")
    private String factory;

    @TableField("app")
    private String app;

    /**
     * 类型
     */
    @TableField("type")
    private String type;

    /**
     * 69码
     */
    @TableField("code69")
    private String code69;

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

    /**
     * 别名
     */
    @TableField("alias")
    private String alias;

    /**
     * 零售价格
     */
    @TableField("retail_price")
    private BigDecimal retailPrice;

    /**
     * 产地
     */
    @TableField("origin_place")
    private String originPlace;

    /**
     * 品牌
     */
    @TableField("brand")
    private String brand;

    /**
     * 拼音缩写
     */
    @TableField("simple_pinyin")
    private String simplePinyin;

    /**
     * 拼音
     */
    @TableField("full_pinyin")
    private String fullPinyin;


}
