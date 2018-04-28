package cn.soul.Town.atype.vo;

import java.util.HashSet;
import java.util.Set;

import cn.soul.Town.article.vo.Article;

public class Atype {
	private int atid;
	private String type;
	
	private Set<Article> articles = new HashSet<Article>();
	
	public Set<Article> getArticles() {
		return articles;
	}
	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}
	public int getAtid() {
		return atid;
	}
	public void setAtid(int atid) {
		this.atid = atid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
