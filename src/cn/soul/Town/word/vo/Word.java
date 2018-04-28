package cn.soul.Town.word.vo;

import java.util.HashSet;
import java.util.Set;

import cn.soul.Town.newword.vo.NewWord;

public class Word {
	private int wid;
	private String word;
	private String res;
	private Set<NewWord> newWords = new HashSet<NewWord>();
	
	public Set<NewWord> getNewWords() {
		return newWords;
	}
	public void setNewWords(Set<NewWord> newWords) {
		this.newWords = newWords;
	}
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getRes() {
		return res;
	}
	public void setRes(String res) {
		this.res = res;
	}
	
}
