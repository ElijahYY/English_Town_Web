package cn.soul.Town.newword.service;

import cn.soul.Town.newword.dao.NewWordDao;
import cn.soul.Town.newword.vo.NewWord;
import cn.soul.Town.user.vo.User;
import cn.soul.Town.word.vo.Word;

public class NewWordService {
	private NewWordDao newWordDao;

	public void setNewWordDao(NewWordDao newWordDao) {
		this.newWordDao = newWordDao;
	}

	public void save(NewWord newWord) {
		newWordDao.save(newWord);
	}

	public NewWord find(Word word, User user) {
		return newWordDao.find(word,user);
	}

	public void update(NewWord nw) {
		newWordDao.update(nw);
	}

	
	
}
