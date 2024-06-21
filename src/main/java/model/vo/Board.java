package model.vo;

import java.sql.Date;

public class Board {

	int no;
	String writeId;
	String title;
	String body;
	Date writeAt;
	int readCnt;
	String category;

	public Board() {
		super();
	}

	public Board(int no, String writeId, String title, String body, Date writeAt, int readCnt, String category) {
		super();
		this.no = no;
		this.writeId = writeId;
		this.title = title;
		this.body = body;
		this.writeAt = writeAt;
		this.readCnt = readCnt;
		this.category = category;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getWriteId() {
		return writeId;
	}

	public void setWriteId(String writeId) {
		this.writeId = writeId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getWriteAt() {
		return writeAt;
	}

	public void setWriteAt(Date writeAt) {
		this.writeAt = writeAt;
	}

	public int getReadCnt() {
		return readCnt;
	}

	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
