package com.lec.ex1_intputstreamOutputstream;

import java.io.*;

//(1)파일을 연다(스트림객체생성) (2)데이터를 읽는다(read메소드사용) (3)파일을 닫는다(close메소드사용)
public class Ex02_InputStreamByteArray {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("txtFile/inTest.txt");
			byte[] bs = new byte[10];// 10byte씩 bs에 읽어오는 용도
			// (2)
			while (true) {
				int readByteCount = is.read(bs);
				if(readByteCount ==-1)break;
				for(int i=0; i<readByteCount ; i++) {
					System.out.print((char)bs[i]);
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {//3. 파일 닫기
				if(is!=null) is.close();
			} catch (IOException e2) {
				System.out.println(e2.getMessage());
			}
		}
	}
}
