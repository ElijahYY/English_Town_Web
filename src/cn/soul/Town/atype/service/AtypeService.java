package cn.soul.Town.atype.service;

import java.util.List;

import cn.soul.Town.article.vo.Article;
import cn.soul.Town.atype.dao.AtypeDao;
import cn.soul.Town.atype.vo.Atype;

public class AtypeService {
	private AtypeDao atypeDao;

	public void setAtypeDao(AtypeDao atypeDao) {
		this.atypeDao = atypeDao;
	}

	public List<Atype> findall() {
		return atypeDao.findall();
	}

	public Atype findByAtid(int tid) {
		// TODO Auto-generated method stub
		return atypeDao.findByAtid(tid);
	}


	public List<Article> findAtypeArticle(int atid,String istest,int i) {
		return atypeDao.findAtypeArticle(atid,istest,i);
	}

	public List<Article> findallarticle() {
		return atypeDao.findallarticle();
	}

	public List<Article> findBytypearticle(Atype existAtype) {
		// TODO Auto-generated method stub
		return atypeDao.findBytypearticle(existAtype);
	}

	public List<Article> findalltest() {
		// TODO Auto-generated method stub
		return atypeDao.findalltest();
	}


	
	
}
