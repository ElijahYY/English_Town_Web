package cn.soul.Town.word.service;

import cn.soul.Town.word.dao.WordDao;
import cn.soul.Town.word.vo.Word;

public class WordService {
	private WordDao wordDao;

	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}

	public void save(Word word) {
		wordDao.save(word);
	}

	public Word findByWord(String word) {
		return wordDao.findByWord(word);
	}
	
}
