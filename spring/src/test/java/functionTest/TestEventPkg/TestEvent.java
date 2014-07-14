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

package functionTest.TestEventPkg;

import org.springframework.context.ApplicationEvent;


/**
 * 
 * @author Smile
 */
public class TestEvent extends ApplicationEvent {

	String msg;
	
	/**
	 * @param source
	 */
	public TestEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param source
	 */
	public TestEvent(Object source, String msg) {
		super(source);
		this.msg = msg;
		// TODO Auto-generated constructor stub
	}
	
	public void print(){
		System.out.println(msg);
	}
}
