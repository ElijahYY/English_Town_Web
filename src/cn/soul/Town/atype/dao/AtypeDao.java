package cn.soul.Town.atype.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.soul.Town.article.vo.Article;
import cn.soul.Town.atype.vo.Atype;

public class AtypeDao extends HibernateDaoSupport{

	public List<Atype> findall() {
		String hql = "from Atype";
		return this.getHibernateTemplate().find(hql);
	}

	public Atype findByAtid(int tid) {
		String hql = "from Atype where atid = ? ";
		List<Atype> list = this.getHibernateTemplate().find(hql,tid);
		if(list!=null&&list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	public List<Article> findAtypeArticle(int atid,String istest,int i) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Article.class);
		criteria.add(Restrictions.eq("istest", istest));
		criteria.add(Restrictions.eq("atid", atid));
		criteria.addOrder(Order.desc("inday"));
		List<Article> list = this.getHibernateTemplate().findByCriteria(criteria,0,i);
		return list;
	}

	public List<Article> findallarticle() {
		String hql = "from Article where istest = ?";
		List<Article> list = this.getHibernateTemplate().find(hql,"·ñ");
		return list;
	}

	public List<Article> findBytypearticle(Atype existAtype) {
		String hql = "from Article where atype = ? and istest = ?";
		List<Article> list = this.getHibernateTemplate().find(hql,existAtype,"·ñ");
		if(list!=null&&list.size()>0) {
			return list;
		}
		return null;
	}

	public List<Article> findalltest() {
		String hql = "from Article where istest = ?";
		List<Article> list = this.getHibernateTemplate().find(hql,"ÊÇ");
		return list;
	}
}
