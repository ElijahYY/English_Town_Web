package cn.soul.Town.article.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.soul.Town.article.vo.Article;

public class ArticleDao extends HibernateDaoSupport{

	public List<Article> findnew(String istest,int count) {
		//¿Îœﬂ≤È—Ø°£
		DetachedCriteria criteria = DetachedCriteria.forClass(Article.class);
		criteria.addOrder(Order.desc("inday"));
		criteria.add(Restrictions.eq("istest", istest));
		List<Article> list = this.getHibernateTemplate().findByCriteria(criteria,0,count);
		return list;
	}

	public Article findByAtid(int aid,String istest) {
		String hql ="from Article where aid = ? and istest=?";
		List<Article> list = this.getHibernateTemplate().find(hql,aid,istest);
		if(list!=null&&list.size()>0) {
			return list.get(0);
		}
		return null;
	}

}
