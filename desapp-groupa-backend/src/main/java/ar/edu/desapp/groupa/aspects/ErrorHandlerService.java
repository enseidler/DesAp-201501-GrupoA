package ar.edu.desapp.groupa.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ErrorHandlerService {

	Logger logger;
		
	@Around("execution( * ar.edu.desapp.groupa.services..*(..))")
	public Object logException(ProceedingJoinPoint pjp) throws Throwable{
		try {
			return pjp.proceed();
		} catch (Exception e) {
			logger = Logger.getLogger(pjp.getTarget().getClass());
			logger.error(e);
			throw new Exception();
		}
	}	
}
