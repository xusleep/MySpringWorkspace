/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package functionTest.aspectj.staticaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


/**
 * 
 * @author Smile
 */
@Aspect
public class AspectJTest {
	
	@Pointcut("execution(* *.test(..))")
	public void test(){
		System.out.println("running...");
	}
	
	@Before("test()")
	public void beforeTest(){
		System.out.println("before test ...");
	}
	
	@After("test()")
	public void afterTest(){
		System.out.println("after test ...");
	}
	
	@Around("test()")
	public Object aroundTest(ProceedingJoinPoint p){
		System.out.println("before 1");
		Object o = null;
		try{
			o = p.proceed();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		System.out.println("after 1");
		return o;
	}
}
