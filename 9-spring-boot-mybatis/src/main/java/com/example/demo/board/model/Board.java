package com.example.demo.board.model;

import java.util.Date;

import lombok.Data;

//	CREATE TABLE BOARD (
//		ID BIGINT IDENTITY NOT NULL PRIMARY KEY,
//		WRITER VARCHAR(100) DEFAULT NULL,
//		TITLE VARCHAR(255) DEFAULT NULL,
//		CONTENT CLOB DEFAULT NULL,
//		REG_DATE TIMESTAMP DEFAULT NULL,
//		HIT_COUNT BIGINT DEFAULT 0
//	);
@Data
public class Board {
	private int id;
	private String writer;
	private String title;
	private String content;
	private Date regDate;
	private int hitCount;
	
	public static int seekOffset(int page, int size) {
		if (page > 0) {
			return (page - 1) * size;
		}
		return 0;
	}
}
