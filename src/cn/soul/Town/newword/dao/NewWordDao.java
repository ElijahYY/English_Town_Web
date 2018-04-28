package cn.soul.Town.newword.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.soul.Town.newword.vo.NewWord;
import cn.soul.Town.user.vo.User;
import cn.soul.Town.word.vo.Word;

public class NewWordDao extends HibernateDaoSupport{

	public void save(NewWord newWord) {
		this.getHibernateTemplate().save(newWord);
	}

	public NewWord find(Word word, User user) {
		String hql="from NewWord nword where nword.word.word = ? and nword.user.uid = ?";
		System.out.println("dao查询即将开始");
		List<NewWord> list = this.getHibernateTemplate().find(hql,word.getWord(),user.getUid());
		System.out.println("dao查询结束");
		if(list!=null&&list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	public void update(NewWord nw) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(nw);
	}
	
}
