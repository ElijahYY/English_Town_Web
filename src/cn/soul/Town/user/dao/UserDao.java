package cn.soul.Town.user.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.soul.Town.article.vo.Article;
import cn.soul.Town.user.vo.User;

public class UserDao extends HibernateDaoSupport{
	//按照邮箱查询是否有邮箱
	public User findByEmail(String email) {
		String hql = "from User where email = ?";
		List<User> list = this.getHibernateTemplate().find(hql,email);
		if(list!=null&&list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	//持久层存入数据库
	public void save(User user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(user);
	}
	//根据激活码查询用户
	public User findByCode(String code) {
		List<User> list = this.getHibernateTemplate().find("from User where code = ?",code);
		if(list!=null&&list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	public void update(User existuser) {
		this.getHibernateTemplate().update(existuser);
	}
	/**
	 * 用户登陆
	 * @param user
	 * @return
	 */
	public User login(User user) {
		String hql = "from User where email = ? and password = ? and state = ?";
		List<User> list = this.getHibernateTemplate().find(hql,user.getEmail(),user.getPassword(),1);
		if(list!=null&&list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	public List<User> findByHcday() {
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.addOrder(Order.desc("hcuseday"));
		List<User> list = this.getHibernateTemplate().findByCriteria(criteria,0,3);
		return list;
	}
	public User findByUid(int uid) {
		String hql = "from User where uid = ?";
		List<User> list = this.getHibernateTemplate().find(hql,uid);
		if(list!=null&&list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	public List<User> findByr() {
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.addOrder(Order.desc("correctrate"));
		List<User> list = this.getHibernateTemplate().findByCriteria(criteria,0,3);
		return list;
	}
}
