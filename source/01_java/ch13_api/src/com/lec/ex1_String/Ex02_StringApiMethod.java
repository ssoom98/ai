package com.lec.ex1_String;

public class Ex02_StringApiMethod {
	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = "AbCXabc";
		String str3 = "    ja va    ";
		System.out.println("1. " + str1.concat(str2)); // abcXabcAbCXabc
		System.out.println("2. " + str1.substring(3)); // n번째 글자부터 끝까지 추출
		System.out.println("3. " + str1.substring(3, 5)); // 3번째 부터 5번째 앞까지
		System.out.println("4. " + str1.length()); //문자열의 길이
		System.out.println("5. " + str1.toUpperCase());// 모두 대문자로
		System.out.println("6. " + str1.toLowerCase());// 모두 소문자로
		System.out.println("7. " + str1.charAt(3)); // n번째 인덱스 글자
		System.out.println("8. " + str1.indexOf("bc")); // 해당 문자가 처음오는 index를 반환
		
		String str4= "abcXabcXabc";
		System.out.println("9. " + str4.indexOf("bc",2)); // 해당 문자를 2번째부터 검색
		System.out.println("10. "+ str4.lastIndexOf("bc")); // 마지막부터 해당 문자열을 검색
		System.out.println("11. "+ str4.indexOf("@"));// 없는 문자는 -1로 출력
		System.out.println("12. "+ str1.equals(str2)); // false:비교
		System.out.println("13. "+ str1.equalsIgnoreCase(str2)); //true: 대소문자구분없이 비교
		//문자열.replace("바꿀문자열"(oldStr), "새문자열"(newStr))
		//문자열.repalceAll(oldStr정규표현식, newStr)
		System.out.println("14. "+ str3.trim()); // 앞뒤스페이스 제거 중간 스페이서 제거x
		System.out.println("15. "+ str1.replace("abc", "바꿔")); //바꿔 x 바꿔
		String str5 = "반가워요. ㅋㅋ 또봐요 ㅎㅎ zz";
		System.out.println("16. "+ str5.replaceAll("[ㄱ-ㅎz0-9]", " "));//해당정규표현식 문자 삭제 
		
		
		System.out.println("str1 =" + str1);
		System.out.println("str2 =" + str2);
	}
}
