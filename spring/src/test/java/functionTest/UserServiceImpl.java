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

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;


/**
 * 
 * @author Smile
 */
public class UserServiceImpl implements UserService {

	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/* (non-Javadoc)
	 * @see functionTest.UserService#save(functionTest.User)
	 */
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("insert into user(name, age, sex) values(?, ?, ?)", 
				new Object[]{user.getName(), user.getAge(), user.getSex()}, 
				new int[]{java.sql.Types.VARCHAR,
					java.sql.Types.INTEGER, java.sql.Types.VARCHAR});
	}

	/* (non-Javadoc)
	 * @see functionTest.UserService#getUsers()
	 */
	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		List<User> list = jdbcTemplate.query("select * from user", new UserRowMapper());
		return list;
	}

}
