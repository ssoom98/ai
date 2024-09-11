package com.lec.ex2_readerWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex01_reader {
	public static void main(String[] args) {
		Reader reader = null;
		try {
			reader = new FileReader("txtFile/inTest.txt");// 1단계
			while (true) {// 2단계
				int i = reader.read(); // 2바이트 읽기
				if (i == -1)
					break;
				System.out.print((char)i);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일 없을 경우	: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("읽기 권한 오류	: " + e.getMessage());
		}finally {//3단계
			try {
				if(reader !=null) reader.close();
			} catch (Exception e2) {
			}
		}
	}
}
