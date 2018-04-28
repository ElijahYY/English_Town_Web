package cn.soul.Town.record.vo;

import java.sql.Date;

import cn.soul.Town.article.vo.Article;
import cn.soul.Town.user.vo.User;

public class Record {
	private int rid;
	private Date time; 
	private int correctnum;
	private int readtime;
	private String content;
	
	private User user;//Íâ¼ü
	private Article article;//Íâ¼ü
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getCorrectnum() {
		return correctnum;
	}
	public void setCorrectnum(int correctnum) {
		this.correctnum = correctnum;
	}
	public int getReadtime() {
		return readtime;
	}
	public void setReadtime(int readtime) {
		this.readtime = readtime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
