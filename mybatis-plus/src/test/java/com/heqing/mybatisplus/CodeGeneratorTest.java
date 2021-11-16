package com.heqing.mybatisplus;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import org.junit.Test;

/**
 * 代码生成器测试   为啥Service有两个
 * @author heqing
 * @date 2021/3/29 18:16 
 */
public class CodeGeneratorTest {

	/**
	 * 基本路径
	 */
	public static final String SRC_MAIN_JAVA = "D:/code/src/main/java";

	/**
	 * 作者
	 */
	public static final String AUTHOR = "heqing";

	/**
	 * 代码生成位置
	 */
	private static String PARENT_NAME = "com.heqing.study.mybatisplus.demo";

	public static final String JDBC_MYSQL_URL = "jdbc:mysql://localhost:3306/demo?allowMultiQueries=true&autoReconnect=true&useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai";

	public static final String JDBC_PASSWORD = "246512";

	/**
	 * 需要生成的表名，多个表名之间 英文逗号分割"
	 */
	public static final String TABLE = "person";

	@Test
	public void codeGenerator() {
		// 代码生成器
		AutoGenerator mpg = new AutoGenerator();

		// 全局配置
		GlobalConfig gc = new GlobalConfig();
//		String projectPath = System.getProperty("user.dir");
//		gc.setOutputDir(projectPath + "/src/main/java");
		gc.setOutputDir(SRC_MAIN_JAVA);
		gc.setAuthor(AUTHOR);
		gc.setEntityName("%sPO");
		gc.setIdType(IdType.AUTO);
		gc.setDateType(DateType.ONLY_DATE);
		mpg.setGlobalConfig(gc);

		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setUrl(JDBC_MYSQL_URL);
		dsc.setDriverName("com.mysql.cj.jdbc.Driver");
		dsc.setUsername("root");
		dsc.setPassword(JDBC_PASSWORD);
		dsc.setDbType(DbType.MYSQL);
		mpg.setDataSource(dsc);

		// 包配置
		PackageConfig pc = new PackageConfig();
		pc.setParent(PARENT_NAME);
		pc.setEntity("model.po");
		pc.setMapper("mapper");
		pc.setXml("mapper.xml");
		pc.setService("service");
		pc.setServiceImpl("service.impl");
		pc.setController("controller");
		mpg.setPackageInfo(pc);

		// 自定义配置
		InjectionConfig cfg = new InjectionConfig() {
			@Override
			public void initMap() {
				// to do nothing
			}
		};
		mpg.setCfg(cfg);

		// 配置模板
		TemplateConfig templateConfig = new TemplateConfig();
		templateConfig.setController("Controller.java");
		mpg.setTemplate(templateConfig);

		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		strategy.setNaming(NamingStrategy.underline_to_camel);
		strategy.setEntityTableFieldAnnotationEnable(true);
		strategy.setColumnNaming(NamingStrategy.underline_to_camel);
		strategy.setEntityLombokModel(true);
		strategy.setRestControllerStyle(true);
		strategy.setInclude(TABLE);
		strategy.setControllerMappingHyphenStyle(true);
		strategy.setEntityTableFieldAnnotationEnable(true);
		mpg.setStrategy(strategy);

		// 模板引擎
		VelocityTemplateEngine vte = new VelocityTemplateEngine();
		mpg.setTemplateEngine(vte);
		mpg.execute();
	}

}