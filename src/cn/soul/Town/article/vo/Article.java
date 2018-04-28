package cn.soul.Town.article.vo;

import java.util.Date;

import cn.soul.Town.alevel.vo.Alevel;
import cn.soul.Town.atype.vo.Atype;

public class Article {
	private int aid;
	private String title;
	private String content;
	private Date inday;
	
	private String istest;
	private String answer;
	private String img;
	//所属的分类。存的对象。
	private Atype atype;
	private Alevel alevel;
	public Atype getAtype() {
		return atype;
	}
	public void setAtype(Atype atype) {
		this.atype = atype;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getInday() {
		return inday;
	}
	public void setInday(Date inday) {
		this.inday = inday;
	}
	
	
	public Alevel getAlevel() {
		return alevel;
	}
	public void setAlevel(Alevel alevel) {
		this.alevel = alevel;
	}
	public String getIstest() {
		return istest;
	}
	public void setIstest(String istest) {
		this.istest = istest;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
}
