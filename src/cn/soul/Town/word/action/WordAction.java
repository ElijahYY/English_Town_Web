package cn.soul.Town.word.action;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.soul.Town.newword.service.NewWordService;
import cn.soul.Town.newword.vo.NewWord;
import cn.soul.Town.user.service.UserService;
import cn.soul.Town.user.vo.User;
import cn.soul.Town.word.service.WordService;
import cn.soul.Town.word.vo.Word;

public class WordAction extends ActionSupport{
	private WordService wordService;
	private NewWordService newWordService;
	public void setNewWordService(NewWordService newWordService) {
		this.newWordService = newWordService;
	}
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	private int uid;
	private String word;
	private int isornot;

	public void setUid(int uid) {
		this.uid = uid;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public void setIsornot(int isornot) {
		this.isornot = isornot;
	}
	public void setWordService(WordService wordService) {
		this.wordService = wordService;
	}
	public String reword() {
		Word w = wordService.findByWord(word);
		//word,user, 在 newwords表中，isornot
		User u = userService.findByUid(uid);
		NewWord nw = newWordService.find(w, u);
		
		nw.setIntime(new Date(System.currentTimeMillis()));
		nw.setLevel(nw.getLevel()+isornot);
		newWordService.update(nw);
		//nw.setLevel();
		String re = "保存成功--"+isornot+"";
		System.out.println(re);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().println(re);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NONE;
	}
}
