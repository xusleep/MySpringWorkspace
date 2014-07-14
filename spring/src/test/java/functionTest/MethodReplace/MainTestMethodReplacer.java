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

package functionTest.MethodReplace;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import functionTest.lookup.bean.GetBeanTest;


/**
 * 
 * @author Smile
 */
public class MainTestMethodReplacer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext bf = new ClassPathXmlApplicationContext("bean.xml");
		TestChangeMethod test = (TestChangeMethod)bf.getBean("testChangeMethod");
		test.changeMe();
	}
}
