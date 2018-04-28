package cn.soul.Town.record.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.soul.Town.record.vo.Record;
import cn.soul.Town.user.vo.User;

public class RecordDao extends HibernateDaoSupport{

	public List<Record> findByUser(User user) {
		String hql = "from Record where user = ?";
		List<Record> list = this.getHibernateTemplate().find(hql,user);
		return list;
	}

	public void save(Record record) {
		this.getHibernateTemplate().save(record);
	}
	
}
