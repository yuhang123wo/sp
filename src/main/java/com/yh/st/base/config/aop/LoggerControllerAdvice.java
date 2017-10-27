package com.yh.st.base.config.aop;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

/**
 * 
 * @author yh
 * @Date 2017年10月17日
 * @desc controller日志
 */
@Aspect
@Service
public class LoggerControllerAdvice {

	private Logger logger = Logger.getLogger(this.getClass());

	@Before("within(com.yh.st.web.controller..*)")
	public void addBeforeLogger(JoinPoint joinPoint) {
		logger.info("执行 " + joinPoint.getSignature().getName() + " 开始");
		logger.info("方法：" + joinPoint.getSignature().toString());
		logger.info(parseParames(joinPoint.getArgs()));
	}

	@Pointcut("execution(* com.yh.st.web.controller..*.*(..))")
	private void pointCutMethod() {
	}

	@Around("pointCutMethod()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		long begin = System.currentTimeMillis();
		Object o = pjp.proceed();
		long end = System.currentTimeMillis();
		logger.info("执行 " + pjp.getSignature().getName() + "结束,耗时:"
				+ (end - begin));

		return o;
	}

	@AfterReturning(returning = "rvt", pointcut = "within(com.yh.st.web.controller..*)")
	public void addAfterReturningLogger(JoinPoint joinPoint, Object rvt) {
		logger.info("执行 " + joinPoint.getSignature().getName() + "返回结果：" + rvt);
	}

	@AfterThrowing(pointcut = "within(com.yh.st.web.controller..*)", throwing = "ex")
	public void addAfterThrowingLogger(JoinPoint joinPoint, Exception ex) {
		logger.error("执行 " + joinPoint.getSignature().getName() + "异常", ex);
	}

	private String parseParames(Object[] parames) {
		if (null == parames || parames.length <= 0) {
			return "传入参数[{}]";
		}
		StringBuffer param = new StringBuffer("传入参数[{}] ");
		for (Object obj : parames) {
			param.append(ToStringBuilder.reflectionToString(obj)).append("  ");
		}
		return param.toString();
	}

}
