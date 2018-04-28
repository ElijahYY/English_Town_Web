package cn.soul.Town.index.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.soul.Town.article.service.ArticleService;
import cn.soul.Town.article.vo.Article;
import cn.soul.Town.atype.service.AtypeService;
import cn.soul.Town.atype.vo.Atype;
import cn.soul.Town.user.service.UserService;
import cn.soul.Town.user.vo.User;

public class IndexAction extends ActionSupport {
	
	private AtypeService atypeService;
	
	public void setAtypeService(AtypeService atypeService) {
		this.atypeService = atypeService;
	}

	private ArticleService articleService;
	
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * ִ�еķ�����ҳ�ķ���
	 * 
	 */
	public String execute() {
		//��ѯ����һ������ļ��ϡ�
		List<Atype> atlist = atypeService.findall();
		ActionContext.getContext().getSession().put("atlist", atlist);
		List<Article>	arList = articleService.findnew("��",2);
		for(Article a:arList) {
			a.setContent(a.getContent().substring(0, 200));
		}
		//���浽ֵջ��
		ActionContext.getContext().getValueStack().set("arList",arList);
		List<User> uList = userService.findByHcday();
		List<User> urList = userService.findByr();
		System.out.println(urList.size());
		ActionContext.getContext().getValueStack().set("uList",uList);
		ActionContext.getContext().getValueStack().set("urList",urList);
		return "index";
	}
}
