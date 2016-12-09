package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePhone {
	public static boolean isMobileNum(String phone) {
		Pattern pattern = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
		Matcher matcher = pattern.matcher(phone);
		return matcher.matches();
	}

	public static void main(String[] args) {
		System.out.println(isMobileNum("13148652546"));
	}
}