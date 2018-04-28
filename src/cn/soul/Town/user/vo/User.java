package cn.soul.Town.user.vo;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import cn.soul.Town.newword.vo.NewWord;
import cn.soul.Town.record.vo.Record;

public class User {
	private int uid;
	private String email;
	private String username;
	private String password;
	private String sex;
	private int useday;
	private int hcuseday;
	private int cuseday;
	private String img;
	private String signature;
	private int state;
	private String code;
	private Date lastday;
	private int testcount;
	private int cnum;
	private int correctrate;
	public int getCorrectrate() {
		return correctrate;
	}
	public void setCorrectrate(int correctrate) {
		this.correctrate = correctrate;
	}
	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	
	public int getTestcount() {
		return testcount;
	}
	public void setTestcount(int testcount) {
		this.testcount = testcount;
	}
	private Set<NewWord> newWords = new HashSet<NewWord>();
	
	private Set<Record> records = new HashSet<Record>();
	
	public Set<Record> getRecords() {
		return records;
	}
	public void setRecords(Set<Record> records) {
		this.records = records;
	}
	public Set<NewWord> getNewWords() {
		return newWords;
	}
	public void setNewWords(Set<NewWord> newWords) {
		this.newWords = newWords;
	}
	public Date getLastday() {
		return lastday;
	}
	public void setLastday(Date lastday) {
		this.lastday = lastday;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getUseday() {
		return useday;
	}
	public void setUseday(int useday) {
		this.useday = useday;
	}
	public int getHcuseday() {
		return hcuseday;
	}
	public void setHcuseday(int hcuseday) {
		this.hcuseday = hcuseday;
	}
	public int getCuseday() {
		return cuseday;
	}
	public void setCuseday(int cuseday) {
		this.cuseday = cuseday;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
