package functionTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestBeansWithProfile {

	public static void main(String[] args) {
		System.setProperty("spring.profiles.active", "dev");
		// TODO Auto-generated method stub
		ApplicationContext ctx = new FileSystemXmlApplicationContext("beansWithProfile.xml");
		Action action = (Action)ctx.getBean("TheAction");
		System.out.println(action.execute(" Zhonglin"));
	}

}
