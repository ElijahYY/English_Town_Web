package cn.soul.Town.article.action;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.mail.imap.protocol.UID;

import cn.soul.Town.article.service.ArticleService;
import cn.soul.Town.article.vo.Article;
import cn.soul.Town.atype.service.AtypeService;
import cn.soul.Town.atype.vo.Atype;
import cn.soul.Town.record.service.RecordService;
import cn.soul.Town.record.vo.Record;
import cn.soul.Town.user.service.UserService;
import cn.soul.Town.user.vo.User;

public class ArticleAction extends ActionSupport implements ModelDriven<Article> {
	private Article article = new Article();
	@Override
	public Article getModel() {
		// TODO Auto-generated method stub
		return article;
	}
	private ArticleService articleService;
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	private AtypeService atypeService;
	public void setAtypeService(AtypeService atypeService) {
		this.atypeService = atypeService;
	}
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	private RecordService recordService;
	
	public void setRecordService(RecordService recordService) {
		this.recordService = recordService;
	}
	private int uid;
	
	private String readtime;
	
	public void setArticle(Article article) {
		this.article = article;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public void setReadtime(String readtime) {
		this.readtime = readtime;
	}
	
	public String findByAtid() {
		Article existarticle = articleService.findByAtid(article.getAid(),"否");
		if(existarticle!=null) {
			Atype atype = atypeService.findByAtid(existarticle.getAtype().getAtid());
			String content = existarticle.getContent();
			String con[] = content.split(" ");
			List<String> conlist = new ArrayList<String>();
			for(int i =0;i<con.length;i++) {
				if((con[i].charAt(0)+"").equals("\"")) {
					conlist.add("\"");
					conlist.add(con[i].substring(1, con[i].length()-1));
				}else {
					if((con[i].charAt(con[i].length()-1)+"").equals("\"")) {
						conlist.add(con[i].substring(0, con[i].length()-2));
						conlist.add("\"");
					}else {
						conlist.add(con[i]);
					}
				}
			}
			ActionContext.getContext().getValueStack().set("atype",atype);
			ActionContext.getContext().getValueStack().set("existarticle",existarticle);
			ActionContext.getContext().getValueStack().set("conlist",conlist);
			return "article";
		}
		return NONE;
	}
	public String findtestByaid() {
		System.out.println(article.getAid()+"------------------------------");
		Article test = articleService.findByAtid(article.getAid(), "是");
		ActionContext.getContext().getValueStack().set("test",test);
		return "test";
	}
	
	public String addtest() {
		String useran = article.getAnswer();
		Article datearticle = articleService.findByAtid(article.getAid(), "是");
		int cnum = 0;
		String an = datearticle.getAnswer();
		for(int i =0;i<5;i++) {
			if((an.charAt(i)+"").equals(""+useran.charAt(i))) {
				cnum++;
			}
		}
		System.out.println(an+"-----------------------------------datean");
		String rtime[] = readtime.split(":");
		User u = userService.findByUid(uid);
		//计算出了正确个数，存记录
		Record newrecord = new Record();
		newrecord.setUser(u);
		newrecord.setArticle(datearticle);
		newrecord.setCorrectnum(cnum);
		newrecord.setTime(new Date(System.currentTimeMillis()));
		newrecord.setReadtime(Integer.valueOf(rtime[1]));
		recordService.save(newrecord);
		
		//保存用户的正确率
		u.setTestcount(u.getTestcount()+5);
		int testcount = u.getTestcount();
		int scnum = u.getCnum()+cnum;
		u.setCnum(scnum);
		int cr = scnum*100/testcount;
		u.setCorrectrate(cr);
		userService.update(u);
		String re = "答对了"+cnum+"个,总正确率为：百分之"+cr+"";
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().println(re);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return NONE;
	}
}
