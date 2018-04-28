package cn.soul.Town.record.action;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.bcel.internal.generic.InstructionTargeter;

import cn.soul.Town.article.service.ArticleService;
import cn.soul.Town.article.vo.Article;
import cn.soul.Town.record.service.RecordService;
import cn.soul.Town.record.vo.Record;
import cn.soul.Town.user.service.UserService;
import cn.soul.Town.user.vo.User;

public class RecordAction extends ActionSupport implements ModelDriven<Record>{
	private Record record = new Record();
	private int uid;
	private int aid;
	private String rtime;
	public void setRtime(String rtime) {
		this.rtime = rtime;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	@Override
	public Record getModel() {
		return record;
	}
	private RecordService recordService;
	private ArticleService articleService;
	private UserService userService;
	
	
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setRecord(Record record) {
		this.record = record;
	}
	public void setRecordService(RecordService recordService) {
		this.recordService = recordService;
	}
	
	public String addRecord() {
		String ti[] = rtime.split(":");
		//获取到了用户id，文章id，时间，笔记。
		Article wenzhang = articleService.findByAtid(aid, "否");
		User u = userService.findByUid(uid);
		System.out.println(u.getLastday());
		if(u.getLastday().toString().equals(new Date(System.currentTimeMillis()).toString())) {
			//最近打卡日期和今天的相同，不做操作
		}else {
			//最近打卡日期和今天不相同，打卡天数+1，
			u.setUseday(u.getUseday()+1);
			String strtime[] = u.getLastday().toString().split("-");
			strtime[2]= strtime[2].substring(0, 2);
			String nowtime[] = new Date(System.currentTimeMillis()).toString().split("-");
			nowtime[2]= nowtime[2].substring(0, 2);
			//昨天打卡
			if(Integer.valueOf(strtime[2])+1==Integer.valueOf(nowtime[2])&&Integer.valueOf(strtime[1])==Integer.valueOf(nowtime[1])&&Integer.valueOf(strtime[0])==Integer.valueOf(nowtime[0])) {
				u.setCuseday(u.getCuseday()+1);
				if(u.getCuseday()>u.getHcuseday()) {
					u.setHcuseday(u.getCuseday());
				}
			}else {
				u.setCuseday(1);
			}
		}
		record.setArticle(wenzhang);
		record.setUser(u);
		record.setReadtime(Integer.valueOf(ti[1]));
		record.setCorrectnum(-1);
		record.setTime(new Date(System.currentTimeMillis()));
		recordService.save(record);
		String re = "打卡成功";
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
