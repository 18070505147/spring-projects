package com.chejet.cloud.annotation;

import java.lang.annotation.*;

/**
 * 后台日志注解
 * @author ansen.zhu@carlt.com.cn
 * @date 2018/12/05
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Slog {
	
	/**
	 * 描述模块名称:Xxx管理
	 * 
	 * @return
	 */
	String modelName() default "";
	
	/**
	 * 描述业务操作 例:执行Xxx操作
	 * @return
	 */
	String description() default "";
	/**
	 * 日志类型:operation,account,login
	 * 
	 * @return
	 */
	String type() default "operation";

	/**
	 * 操作类型：
	 * @return
	 */
	OperationType operation_type() default OperationType.UNDEFINED;
}
