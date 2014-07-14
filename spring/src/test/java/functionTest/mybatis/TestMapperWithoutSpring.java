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

package functionTest.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


/**
 * 
 * @author Smile
 */
public class TestMapperWithoutSpring {
	static SqlSessionFactory sqlSessionFactory;
	static{
		sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
	}
	
	public void testAdd(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try
		{
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			User user = new User("Tom", new Integer(5));
			userMapper.insertUser(user);
			sqlSession.commit();
		}
		finally
		{
			sqlSession.close();
		}
	}
	
	public void getUser(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try
		{
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			User user = userMapper.getUser(2028);
			System.out.println("name : " + user.getName() + " | age : " + user.getAge());
		}
		finally
		{
			sqlSession.close();
		}
	}
	public static void main(String[] args) {
		TestMapperWithoutSpring tm = new TestMapperWithoutSpring();
		tm.testAdd();
		tm.getUser();
		
	}
}
