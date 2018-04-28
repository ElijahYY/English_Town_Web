package cn.soul.Town.alevel.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.soul.Town.alevel.service.AlevelService;
import cn.soul.Town.alevel.vo.Alevel;
import cn.soul.Town.article.vo.Article;
import cn.soul.Town.atype.service.AtypeService;
import cn.soul.Town.atype.vo.Atype;

public class AlevelAction extends ActionSupport implements ModelDriven<Alevel>{
	
	private Alevel alevel = new Alevel();
	@Override
	public Alevel getModel() {
		return alevel;
	}
	private AlevelService alevelService;
	private AtypeService atypeService;
	

	public AtypeService getAtypeService() {
		return atypeService;
	}

	public void setAtypeService(AtypeService atypeService) {
		this.atypeService = atypeService;
	}

	public void setAlevelService(AlevelService alevelService) {
		this.alevelService = alevelService;
	}
	
	public String findByalevel() {
		List<Atype> atList = atypeService.findall();
		List<Alevel> alList = alevelService.findall();
		ActionContext.getContext().getValueStack().set("alList",alList);
		ActionContext.getContext().getValueStack().set("atList",atList);
		List<Article> articles = alevelService.findByAlevel(alevel.getAlid(),"·ñ");
		for (Article article : articles) {
			article.setContent(article.getContent().substring(0,200));
		}
		ActionContext.getContext().getValueStack().set("articles",articles);
		return "alevel";
	}
	public String findBytestalevel() {
		List<Atype> atList = atypeService.findall();
		List<Alevel> alList = alevelService.findall();
		ActionContext.getContext().getValueStack().set("alList",alList);
		ActionContext.getContext().getValueStack().set("atList",atList);
		
		List<Article> tests = alevelService.findByAlevel(alevel.getAlid(),"ÊÇ");
		System.out.println(tests.size()+"----------------------------");
		ActionContext.getContext().getValueStack().set("tests",tests);
		return "alevel";
	}
}
