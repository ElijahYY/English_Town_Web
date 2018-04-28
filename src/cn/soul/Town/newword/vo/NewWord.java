package cn.soul.Town.newword.vo;


import java.sql.Date;

import cn.soul.Town.article.vo.Article;
import cn.soul.Town.user.vo.User;
import cn.soul.Town.word.vo.Word;

public class NewWord {
	private int nwid;
	private int level;
	private Date intime;
	
	
	public Date getIntime() {
		return intime;
	}
	public void setIntime(Date intime) {
		this.intime = intime;
	}
	private User user;//Íâ¼ü
	private Word word;//Íâ¼ü
	private Article article;//Íâ¼ü
	public int getNwid() {
		return nwid;
	}
	public void setNwid(int nwid) {
		this.nwid = nwid;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Word getWord() {
		return word;
	}
	public void setWord(Word word) {
		this.word = word;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	
}
