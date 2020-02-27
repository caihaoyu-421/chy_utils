package com.chy.utils;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Random;

/**
 * @author chy
 * 	�ַ���������
 *@ʱ�� 2020��2��26��
 */
public class StringUtil {
	
	
	//�ж��ַ����Ƿ�Ϊ��
	public static boolean isEmpty(String str) {
							//��ȥ�ո����жϳ���
		return str ==null || str.trim().length()<=0;
	}
	
	//�ж��Ƿ�Ϊ�ֻ���
	public static boolean isPhoneNum(String str) {
		//������
		String reg ="1[3|5|6|7|8]\\d{9}";
		return str.matches(reg);
	}
	
	//�ж��Ƿ�Ϊ����
	public static boolean isEmail(String str) {
		String reg ="\\w+@\\w+(.com|.cn|.com.cn)";
		return str.matches(reg);
	}
	
	//�ж��Ƿ�ȫ��Ϊ��ĸ
	public static boolean isString(String str) {
		String reg = "[A-z]+";
		return str.matches(reg);
	}
	
	//�ж��Ƿ�Ϊ������
	public static boolean isNum(String str) {
		String reg = "\\d+";
		return str.matches(reg);
	}
	
	//�ж��Ƿ�ΪС��
	public static boolean isDouble(String str) {
			String reg = "^\\d+\\.\\d+$";
			return str.matches(reg);
	}
	
	//��ȡnλ���Ӣ���ַ���
	public static String getRandomString(int num) {
		//��ȡ���������
		Random rm = new Random();
		
		char[] r = {'a','b','c','d','e','f','g','h','i','j','k'
				,'l','m','n','o','p','q','r','s','t','u','v',
				'w','x','y','z'};
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < num; i++) {
			//��ȡ0-25���±�
			int index = rm.nextInt(26);
			String str = r[index]+"";
			if(index%2 == 0) {
				 str = str.toUpperCase();
			}
			sb.append(str);
		}
		return sb.toString();
	}
	
	//��ȡ����ַ���
	public static String getRandomStrings(int num) {
		/**
		 * 48-57�� 0-9
		 * 65-90 A-Z
		 * 97-122��a-z
		 */
		Random rm = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < num; i++) {
			int k = rm.nextInt(123);
			if((k>=48 && k<=57) || (k>=65 && k<=90) || (k>=97 && k<=123)) {
				String str = (char)k+"";
				sb.append(str);
			}else {
				i--;
			}
		}
		return sb.toString();
	}
	
	/**
	 * ��ȡn����������ַ���
	 * @return
	 */
	public static String getAChinese(int length) {
        StringBuilder str = new StringBuilder();
        int hs = 0 ;
        int ls = 0; 
        Random random = new Random();
        for(int i = 0 ; i < length ; i++){
	        hs = (176 + Math.abs(random.nextInt(39))); 
	        ls = (161 + Math.abs(random.nextInt(93)));
	        byte[] b = new byte[2];
	        b[0] = (new Integer(hs).byteValue());
	        b[1] = (new Integer(ls).byteValue());
	        try {
	          str.append(new String(b, "GBk")); 
	        } catch (UnsupportedEncodingException e) {
	          e.printStackTrace();
	        }
        }
        return str.toString();
  }
	
	public static void main(String[] args) {
		System.out.println(isEmpty("")+"--�ж��Ƿ�Ϊ��");
		System.out.println(isPhoneNum("18500321926")+"--�ж��Ƿ�Ϊ�ֻ���");
		System.out.println(isEmail("415841254@qq.com")+"�ж��Ƿ�Ϊ����");
		System.out.println(isString("asdasd")+"--�ж��Ƿ�ȫ��Ϊ��ĸ");
		System.out.println(isNum("12312")+"--�ж��Ƿ�ȫ��Ϊ����");
		System.out.println(isDouble("123.2")+"--�ж��Ƿ�ȫ��ΪС��");
		System.out.println(getRandomString(6)+"--���Ӣ���ַ���");
		System.out.println(getRandomStrings(8)+"--����ַ���");
		System.out.println(getAChinese(8)+"--�������");
		
	}
}
