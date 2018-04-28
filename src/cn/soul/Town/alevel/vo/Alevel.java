package cn.soul.Town.alevel.vo;

import java.util.HashSet;
import java.util.Set;

import cn.soul.Town.article.vo.Article;

public class Alevel {
	private int alid;
	private String level;
	private Set<Article> articles = new HashSet<Article>();
	
	public int getAlid() {
		return alid;
	}
	public void setAlid(int alid) {
		this.alid = alid;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Set<Article> getArticles() {
		return articles;
	}
	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}
}
