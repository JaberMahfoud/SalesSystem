/**
 * 
 */
package com.salesSystem.mvc.helper;

/**
 * @author Jaber
 *
 */
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.salesSystem.mvc.service.LogService;

@Aspect
@Component
public class LoggingManager {

	@Autowired
	private LogService LogService;

	@Pointcut(value = "execution(* com.salesSystem.mvc.controller.*.*(..) )")
	public void myPointcut() {

	}

	@Around("myPointcut()")
	public Object applicationLogger(ProceedingJoinPoint pjp) {
		Object object = null;
		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().toString();
		Long executionTime=(long) 0;
		try {
			Object[] array = pjp.getArgs();
			final StopWatch stopWatch = new StopWatch();
			stopWatch.start();
			object = pjp.proceed();
			stopWatch.stop();
			executionTime = stopWatch.getTotalTimeMillis();
			if (methodName.contains("Add") || methodName.contains("Edit")) {
				LogService.insert(className, methodName, array[0].toString(), object.toString(), executionTime);
			}

		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return object;
	}

}