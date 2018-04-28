package cn.soul.Town.article.service;

import java.util.List;

import cn.soul.Town.article.dao.ArticleDao;
import cn.soul.Town.article.vo.Article;

public class ArticleService {

	private ArticleDao articleDao;
	
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	public List<Article> findnew(String istest,int count) {
		return articleDao.findnew(istest,count);
	}

	public Article findByAtid(int aid,String istest) {
		return articleDao.findByAtid(aid,istest);
	}

}
