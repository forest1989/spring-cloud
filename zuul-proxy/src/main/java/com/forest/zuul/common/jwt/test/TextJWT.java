package com.forest.zuul.common.jwt.test;

import com.forest.zuul.common.jwt.api.TokenMgr;

public class TextJWT {

	public static void main(String[] args) {
		try {
			//System.out.println(TokenMgr.createJWT("78sawdff5", Constant.JWT_ISS,"forest", 1 * 60 * 10000));
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println(System.currentTimeMillis());
		
		String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJhYThmNTZkZWY0MmQ0ZjViOTZmOTdkZDlmMDA5ZDc5MCIsImlzcyI6Imp3dC1sZXRzIiwic3ViIjoie1widXNlcklkXCI6XCI3MjE0NGY3MTZlZjc0YTFlYWFlMTdiZjA3OWIyZjZhOFwiLFwidXNlck5hbWVcIjpcImZvcmVzdFwifSIsImlhdCI6MTU0MDAwODY0OSwiZXhwIjoxNTQwMDE1ODQ5fQ.I-Mgev4izDNZl-VQ85W8jwzgxcna27kJOjI7Vee-Jy0";
		try {
			System.out.println(TokenMgr.parseJWT(jwt));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
