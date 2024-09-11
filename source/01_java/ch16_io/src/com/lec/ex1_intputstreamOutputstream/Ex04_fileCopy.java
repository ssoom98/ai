package com.lec.ex1_intputstreamOutputstream;

import java.io.*;

//bts_7. mp4 =>~/bts_7_copy.mp4 (7,460,545 byte)
public class Ex04_fileCopy {
	public static void main(String[] args) {
		long start = System.currentTimeMillis(); // 1970.1.1부터 시작시점까지의 밀리세컨
		InputStream is = null;
		OutputStream os = null;
		try {
			File originalFile = new File("C:/Users/4545/Desktop/01_java/bts_7.mp4");
			is = new FileInputStream("C:/Users/4545/Desktop/01_java/bts_7.mp4");
			os = new FileOutputStream("C:\\Users\\4545\\Desktop\\01_java\\bts_copy1.mp4");
			
			byte[] bs = new byte[(int) originalFile.length()];//배열크기를 파일 크기만큼
			
			int cnt = 0;
			while (true) {// read &write
				int readByteCount = is.read(bs);//파일크기만큼 읽고 복사
				if (readByteCount == -1)
					break;
				os.write(bs);
				cnt++;
			}
			System.out.println("파일 복사 완료");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(is!=null) is.close();
				if(os!=null) os.close();
			} catch (IOException e2) {
				System.out.println(e2.getMessage());
			}
		}

		long end = System.currentTimeMillis(); // 1970.1.1부터 종료시점까지의 밀리세컨
		System.out.println((end - start) / 1000.0 + "초 걸림");
	}
}
