package cn.liuboyi.util;

import java.util.Random;

/**
 * Description: 随机码/数-工具类
 *
 * @author: boyi.liu
 * Date: 2019/10/30 18:16
 */
public class RandomUtil {

	/**
	 * 获取指定位数的随机码
	 *
	 * @param number 位数
	 * @return: java.lang.String 随机码
	 *
	 * 随机字符由26位大小写字母与10位数字组成，共62位。若number为3，则可能的组合有：62*62*62=238328种
	 *
	 */
	public static String getRandom(int number) {
		char[] ch = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
				'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
				'j', 'k','l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		return getRandomByCharList(ch, number);
	}

	/**
	 * 获取指定位数的随机码
	 *
	 * @param number 位数
	 * @return: java.lang.String 随机数字
	 */
	public static String getRandomNumber(int number) {
		char[] ch = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		return getRandomByCharList(ch, number);
	}

	/**
	 * 获取指定随机元素集与随机位数的随机码
	 *
	 * @param ch 随机元素数组
	 * @param number 位数
	 * @return: java.lang.String 随机码
	 */
	public static String getRandomByCharList(char[] ch, int number) {
		StringBuffer buf = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < number; i++){
			char num = ch[random.nextInt(ch.length)];
			buf.append(num);
		}
		return buf.toString();
	}

}
