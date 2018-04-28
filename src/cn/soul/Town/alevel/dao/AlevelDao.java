package cn.soul.Town.alevel.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.soul.Town.alevel.vo.Alevel;
import cn.soul.Town.article.vo.Article;

public class AlevelDao extends HibernateDaoSupport{

	public List<Alevel> findall() {
		String hql = "from Alevel ";
		List<Alevel> list = this.getHibernateTemplate().find(hql);
		if(list!=null&&list.size()>0) {
			return list;
		}
		return null;
	}

	public List<Article> findByAlevel(int alid,String istest) {
		String hql="from Article where alid = ? and istest = ?";
		List<Article> list = this.getHibernateTemplate().find(hql,alid,istest);
		if(list!=null&&list.size()>0) {
			return list;
		}
		return null;
	}

}
