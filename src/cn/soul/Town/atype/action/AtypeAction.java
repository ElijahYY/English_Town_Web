package cn.soul.Town.atype.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.soul.Town.alevel.service.AlevelService;
import cn.soul.Town.alevel.vo.Alevel;
import cn.soul.Town.article.service.ArticleService;
import cn.soul.Town.article.vo.Article;
import cn.soul.Town.atype.service.AtypeService;
import cn.soul.Town.atype.vo.Atype;

public class AtypeAction extends ActionSupport implements ModelDriven<Atype> {
	private AtypeService atypeService;
    private ArticleService articleService;
    private AlevelService alevelService;
	public void setAlevelService(AlevelService alevelService) {
		this.alevelService = alevelService;
	}
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	public void setAtypeService(AtypeService atypeService) {
		this.atypeService = atypeService;
	}
	private Atype atype = new Atype();
	@Override
	public Atype getModel() {
		// TODO Auto-generated method stub
		return atype;
	}
	
	public String findAtypeArticle(){
		Atype existAtype = atypeService.findByAtid(atype.getAtid());
		System.out.println(existAtype.getAtid());
		List<Article> articles = atypeService.findBytypearticle(existAtype);
		for (Article article : articles) {
			article.setContent(article.getContent().substring(0,200));
			
		}
		List<Atype> atList = atypeService.findall();
		List<Alevel> alList = alevelService.findall();
		ActionContext.getContext().getValueStack().set("alList",alList);
		ActionContext.getContext().getValueStack().set("atList",atList);
		ActionContext.getContext().getValueStack().set("articles",articles);
		return "atype";
		
	}
	public String findallarticle() {
		List<Article> articles = atypeService.findallarticle();
		List<Atype> atList = atypeService.findall();
		List<Alevel> alList = alevelService.findall();
		for (Article article : articles) {
			article.setContent(article.getContent().substring(0,200));
		}
		ActionContext.getContext().getValueStack().set("alList",alList);
		ActionContext.getContext().getValueStack().set("atList",atList);
		ActionContext.getContext().getValueStack().set("articles",articles);
		return "atype";
	}
	
	public String findalltest() {
		List<Article> tests = atypeService.findalltest();
		List<Atype> atList = atypeService.findall();
		List<Alevel> alList = alevelService.findall();
		ActionContext.getContext().getValueStack().set("alList",alList);
		ActionContext.getContext().getValueStack().set("atList",atList);
		ActionContext.getContext().getValueStack().set("tests",tests);
		return "atype";
	}
	
}
