package cn.soul.Town.newword.action;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.soul.Town.article.service.ArticleService;
import cn.soul.Town.newword.service.NewWordService;
import cn.soul.Town.newword.vo.NewWord;
import cn.soul.Town.user.service.UserService;
import cn.soul.Town.user.vo.User;
import cn.soul.Town.word.service.WordService;
import cn.soul.Town.word.vo.Word;

public class NewWordAction extends ActionSupport implements ModelDriven<Word>{
	private NewWordService newWordService;
	private WordService wordService;
	private ArticleService articleService;
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	private int uid;
	public void setUid(int uid) {
		this.uid = uid;
	}
	private int aid;
	public void setAid(int aid) {
		this.aid = aid;
	}
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	public void setWordService(WordService wordService) {
		this.wordService = wordService;
	}
	public void setWord(Word word) {
		this.word = word;
	}
	private Word word = new Word();
	@Override
	public Word getModel() {
		// TODO Auto-generated method stub
		return word;
	}
	public void setNewWordService(NewWordService newWordService) {
		this.newWordService = newWordService;
	}
	
	public String addRecord() throws IOException {
		//创建生词项
		NewWord newWord = new NewWord();
		newWord.setIntime(new Date(System.currentTimeMillis()));
		newWord.setLevel(0);
		newWord.setArticle(articleService.findByAtid(aid, "否"));
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("existuser");
		System.out.println(user.getUid());
		newWord.setUser(user);
		Word existword = wordService.findByWord(word.getWord());
		if(existword==null) {
			wordService.save(word);
			existword = wordService.findByWord(word.getWord());
		}
		//设置单词
		newWord.setWord(existword);
		//设置完毕-存储记录
		NewWord existNewWord = newWordService.find(word,user);
		String reString = "";
		if(existNewWord==null) {
			newWordService.save(newWord);
			reString="添加成功";
		}else {
			reString="已存在该生词";
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println(reString);
		return NONE;
	}
	
	public String words() {
		//获取到了uid，查询用户
		User u = userService.findByUid(uid);
		List<Word> nwList = new ArrayList<>();
		for (NewWord str : u.getNewWords()) {  
			nwList.add(str.getWord());
			System.out.println(str.getWord().getWord());
		} 
		ActionContext.getContext().getValueStack().set("newwords",nwList);
		return "word";
	}
	
}
