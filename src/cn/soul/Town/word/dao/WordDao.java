package cn.soul.Town.word.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.soul.Town.word.vo.Word;

public class WordDao extends HibernateDaoSupport{

	public void save(Word word) {
		this.getHibernateTemplate().save(word);
		
	}

	public Word findByWord(String word) {
		String hql = "from Word where word = ?";
		List<Word> list = this.getHibernateTemplate().find(hql,word);
		if(list!=null&&list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	
}
