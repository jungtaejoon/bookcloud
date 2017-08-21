package bookcloud.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerInterceptor {
    protected Logger log = LoggerFactory.getLogger(getClass());
 
	@Pointcut("execution(* bookcloud..*.*(..))")
	public void pcForLog() {}
	
	@Pointcut("execution(* bookcloud.logger.*.*(..))")
	public void expcForLog() {}
	
	@Before("pcForLog() && !expcForLog()")
    public void preHandle(JoinPoint jp) throws Exception {
		
            log.info("======================================          START         ======================================");
            log.info("method path : " + jp.getSignature());
    }
    
	@After("pcForLog() && !expcForLog()")
    public void postHandle() throws Exception {
            log.info("======================================           END          ======================================\n");
    }
}
