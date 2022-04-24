package com.sale.buyalibaba.test;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author hl
 * @Date 2020/6/5
 * @Description: TODO
 */
public class CodeGenerator {


    private static final String PROJECT_PATH = "/Users/qfh/buy-alibaba/";
    private static final String ENTITY_PATH = PROJECT_PATH + "sale-dal/src/main/java/com/sale/buyalibaba/po";
    private static final String MAPPER_PATH = PROJECT_PATH + "sale-dal/src/main/java/com/sale/buyalibaba/mapper";
    private static final String XML_PATH = PROJECT_PATH + "sale-dal/src/main/resources/com/sale/buyalibaba/mapper";
    private static final String SERVICE_PATH = PROJECT_PATH + "sale-dal/src/main/java/com/sale/buyalibaba/service";
    private static final String SERVICE_IMPL_PATH = PROJECT_PATH + "sale-dal/src/main/java/com/sale/buyalibaba/service/impl";
    //private static final String CONTROLLER_PATH = PROJECT_PATH + "sale-client/src/main/java/com/sale/buyalibaba/controller";

    public static void main(String[] args) {
        // 1、创建代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 2、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/sale-generator/src/main/java");
        gc.setAuthor("祁飞鸿");
        gc.setOpen(false); //生成后是否打开资源管理器
        gc.setFileOverride(true); //重新生成时文件是否覆盖
        gc.setServiceName("%sService"); //去掉Service接口的首字母I
        gc.setIdType(IdType.AUTO); //主键策略
        gc.setDateType(DateType.ONLY_DATE);//定义生成的实体类中日期类型
        gc.setSwagger2(false);//开启Swagger2模式

        mpg.setGlobalConfig(gc);

        // 3、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://124.222.85.36:3306/sale");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        // 4、包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(null); //模块名
        pc.setParent("com.sale.buyalibaba");
        pc.setController("controller");
        pc.setEntity("po");
        pc.setService("service");
        pc.setMapper("mapper");

        Map<String, String> pathInfo = new HashMap<>();
        pathInfo.put(ConstVal.ENTITY_PATH, ENTITY_PATH);
        pathInfo.put(ConstVal.MAPPER_PATH, MAPPER_PATH);
        pathInfo.put(ConstVal.XML_PATH, XML_PATH);
        pathInfo.put(ConstVal.SERVICE_PATH, SERVICE_PATH);
        pathInfo.put(ConstVal.SERVICE_IMPL_PATH, SERVICE_IMPL_PATH);
        //pathInfo.put(ConstVal.CONTROLLER, CONTROLLER_PATH);
        pc.setPathInfo(pathInfo);
        mpg.setPackageInfo(pc);


        // 5、策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("sys_staff_salary");//对那一张表生成代码

        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
        strategy.setTablePrefix(pc.getModuleName() + "_"); //生成实体时去掉表前缀
        strategy.entityTableFieldAnnotationEnable(true);//实体属性上添加表字段映射
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略
        strategy.setEntityLombokModel(true); // lombok 模型 @Accessors(chain = true) setter链式操作
        strategy.setRestControllerStyle(true); //restful api风格控制器
        strategy.setControllerMappingHyphenStyle(true); //url中驼峰转连字符

        mpg.setStrategy(strategy);

        // 6、执行
        mpg.execute();
    }
}