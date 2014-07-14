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

import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import edu.emory.mathcs.backport.java.util.concurrent.locks.ReentrantLock;


/**
 * 
 * @author Smile
 */
public class Test1 {
	
	   // 预处理hash值，避免较差的离散hash序列，导致桶没有充分利用
    static int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    // 返回对应hash值得索引
    static int indexFor(int h, int length) {
        /*****************
         * 由于length是2的n次幂，所以h & (length-1)相当于h % length。
         * 对于length，其2进制表示为1000...0，那么length-1为0111...1。
         * 那么对于任何小于length的数h，该式结果都是其本身h。
         * 对于h = length，该式结果等于0。
         * 对于大于length的数h，则和0111...1位与运算后，
         * 比0111...1高或者长度相同的位都变成0，
         * 相当于减去j个length，该式结果是h-j*length，
         * 所以相当于h % length。
         * 其中一个很常用的特例就是h & 1相当于h % 2。
         * 这也是为什么length只能是2的n次幂的原因，为了优化。
         */
        return h & (length-1);
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ReentrantLock lock = new ReentrantLock();
		lock.lock();
		// TODO Auto-generated method stub
		ApplicationContext ctx = new FileSystemXmlApplicationContext("bean.xml");
		Action action = (Action)ctx.getBean("TheAction");
		System.out.println(action.execute(" Zhonglin"));
		for(int i = 0; i < 16; i++)
		{
			String it = "dkfjdkfj" + i;
			System.out.println("hash code is " + Test1.hash(it.hashCode()));
			System.out.println("index is " + Test1.indexFor(Test1.hash(it.hashCode()), 16));
			
		}
		
		ArrayList l  = new ArrayList();
		
		Vector v = new Vector();
		
		System.out.println(8>>1);
		
		lock.unlock();
		
		ReentrantReadWriteLock rw = new ReentrantReadWriteLock();
		
	}
	


}
