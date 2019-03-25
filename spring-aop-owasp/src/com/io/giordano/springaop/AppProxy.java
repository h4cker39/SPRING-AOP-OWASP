package com.io.giordano.springaop;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.owasp.encoder.Encode;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AppProxy {
	
	@AfterReturning(
			pointcut="execution(* com.io.giordano.dao.dbClass.user(..))",
			returning="result"
			)
	public void alterMessage(JoinPoint joinPoint, String result) {
		String mn = joinPoint.getSignature().toShortString();
		result = result.toString();
		System.out.println(mn);
		System.out.println("Inside the dam aspect");
		System.out.println(protectFromXss(result));
	}
	public static String protectFromXss(String name) {
		name  =Encode.forHtml(name);
		name  = Encode.forJavaScript(name);
		return name;
	}
	
}