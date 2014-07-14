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
	
	   // Ԥ����hashֵ������ϲ����ɢhash���У�����Ͱû�г������
    static int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    // ���ض�Ӧhashֵ������
    static int indexFor(int h, int length) {
        /*****************
         * ����length��2��n���ݣ�����h & (length-1)�൱��h % length��
         * ����length����2���Ʊ�ʾΪ1000...0����ôlength-1Ϊ0111...1��
         * ��ô�����κ�С��length����h����ʽ��������䱾��h��
         * ����h = length����ʽ�������0��
         * ���ڴ���length����h�����0111...1λ�������
         * ��0111...1�߻��߳�����ͬ��λ�����0��
         * �൱�ڼ�ȥj��length����ʽ�����h-j*length��
         * �����൱��h % length��
         * ����һ���ܳ��õ���������h & 1�൱��h % 2��
         * ��Ҳ��Ϊʲôlengthֻ����2��n���ݵ�ԭ��Ϊ���Ż���
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
