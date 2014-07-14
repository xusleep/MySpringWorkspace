package functionTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestTransient {
     public static void main(String[] args) {
         UserInfo userInfo = new UserInfo("����", "123456");
         System.out.println(userInfo);
         try {
             // ���л���������Ϊtransient������û�б����л�
             ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(
                     "UserInfo.out"));
             o.writeObject(userInfo);
             o.close();
         } catch (Exception e) {
             // TODO: handle exception
             e.printStackTrace();
         }
         try {
             // ���¶�ȡ����
             ObjectInputStream in = new ObjectInputStream(new FileInputStream(
                     "UserInfo.out"));
             UserInfo readUserInfo = (UserInfo) in.readObject();
             //��ȡ��psw������Ϊnull
             System.out.println(readUserInfo.toString());
         } catch (Exception e) {
             // TODO: handle exception
             e.printStackTrace();
         }
     }
 }