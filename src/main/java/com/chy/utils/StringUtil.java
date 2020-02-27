package com.chy.utils;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Random;

/**
 * @author chy
 * 	字符串工具类
 *@时间 2020年2月26日
 */
public class StringUtil {
	
	
	//判断字符串是否为空
	public static boolean isEmpty(String str) {
							//先去空格再判断长度
		return str ==null || str.trim().length()<=0;
	}
	
	//判断是否为手机号
	public static boolean isPhoneNum(String str) {
		//用正则
		String reg ="1[3|5|6|7|8]\\d{9}";
		return str.matches(reg);
	}
	
	//判断是否为邮箱
	public static boolean isEmail(String str) {
		String reg ="\\w+@\\w+(.com|.cn|.com.cn)";
		return str.matches(reg);
	}
	
	//判断是否全部为字母
	public static boolean isString(String str) {
		String reg = "[A-z]+";
		return str.matches(reg);
	}
	
	//判断是否为纯数字
	public static boolean isNum(String str) {
		String reg = "\\d+";
		return str.matches(reg);
	}
	
	//判断是否为小数
	public static boolean isDouble(String str) {
			String reg = "^\\d+\\.\\d+$";
			return str.matches(reg);
	}
	
	//获取n位随机英文字符串
	public static String getRandomString(int num) {
		//获取随机数对象
		Random rm = new Random();
		
		char[] r = {'a','b','c','d','e','f','g','h','i','j','k'
				,'l','m','n','o','p','q','r','s','t','u','v',
				'w','x','y','z'};
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < num; i++) {
			//获取0-25的下标
			int index = rm.nextInt(26);
			String str = r[index]+"";
			if(index%2 == 0) {
				 str = str.toUpperCase();
			}
			sb.append(str);
		}
		return sb.toString();
	}
	
	//获取随机字符串
	public static String getRandomStrings(int num) {
		/**
		 * 48-57： 0-9
		 * 65-90 A-Z
		 * 97-122：a-z
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
	 * 获取n个随机中文字符串
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
		System.out.println(isEmpty("")+"--判断是否为空");
		System.out.println(isPhoneNum("18500321926")+"--判断是否为手机号");
		System.out.println(isEmail("415841254@qq.com")+"判断是否为邮箱");
		System.out.println(isString("asdasd")+"--判断是否全部为字母");
		System.out.println(isNum("12312")+"--判断是否全部为数字");
		System.out.println(isDouble("123.2")+"--判断是否全部为小数");
		System.out.println(getRandomString(6)+"--随机英文字符串");
		System.out.println(getRandomStrings(8)+"--随机字符串");
		System.out.println(getAChinese(8)+"--随机中文");
		
	}
}
