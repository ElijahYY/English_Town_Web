package cn.soul.Town.alevel.service;

import java.util.List;

import cn.soul.Town.alevel.dao.AlevelDao;
import cn.soul.Town.alevel.vo.Alevel;
import cn.soul.Town.article.vo.Article;

public class AlevelService {
	private static AlevelDao alevelDao;

	public void setAlevelDao(AlevelDao alevelDao) {
		this.alevelDao = alevelDao;
	}
	
	public List<Alevel> findall() {
		return alevelDao.findall();
	}

	public List<Article> findByAlevel(int alid,String istest) {
		// TODO Auto-generated method stub
		return alevelDao.findByAlevel(alid,istest);
	}
}
