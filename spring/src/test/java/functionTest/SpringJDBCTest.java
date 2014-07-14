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

package functionTest;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 
 * @author Smile
 */
public class SpringJDBCTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext act = new ClassPathXmlApplicationContext("bean.xml");
		UserService userService = (UserService)act.getBean("userService");
		User user = new User();
		user.setName("ÕÅÈý");
		user.setAge(20);
		user.setSex("ÄÐ");
		//for(int i = 0; i < 10; i ++)
		//	userService.save(user);
		
		List<User> person1 = userService.getUsers();
		for(User person2 : person1)
		{
			System.out.println(person2.getId() + " " + person2.getName() + " " + person2.getSex() + " " + person2.getAge());
		}
	}

}
