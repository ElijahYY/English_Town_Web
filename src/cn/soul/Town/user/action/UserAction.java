package cn.soul.Town.user.action;

import java.io.IOException;
import java.sql.Date;

import javax.jws.soap.SOAPBinding.Use;
import javax.mail.Session;
import javax.servlet.Servlet;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.soul.Town.record.service.RecordService;
import cn.soul.Town.record.vo.Record;
import cn.soul.Town.user.service.UserService;
import cn.soul.Town.user.vo.User;
/**
 * 用户模块的Action
 * @author kING
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User user =new User();
	
	public void setUser(User user) {
		this.user = user;
	}

	
	

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String registPage() {
		return "registPage";
	}
	public String loginPage() {
		return "loginPage";
	}
	
	private RecordService recordService;
	
	public void setRecordService(RecordService recordService) {
		this.recordService = recordService;
	}

	public String findByEmail() throws IOException {
		
		User exituser = userService.findByEmail(user.getEmail());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		if(exituser!=null) {
			//查询到了该用户 用户名已经存在
			response.getWriter().println("<font color = 'red' >用户名已经存在</font>");
			System.out.println("信息已经发出");
		}else {
			//没查到该用户，可以使用。
			response.getWriter().println("<font color = 'green' >用户名可以使用</font>");
		}
		return NONE;
	}

	public String regist() {
		//用户注册
		user.setImg("IMG_0352.JPG");
		user.setCnum(0);
		user.setTestcount(0);
		user.setCorrectrate(0);
		user.setLastday(new Date(System.currentTimeMillis()));
		userService.save(user);
		this.addActionMessage("注册成功,请去邮箱激活.");
		return "msg";
	}
	/**
	 * 用户激活的方法
	 */
	public String active() {
		String code = user.getCode();
		User existuser = userService.findByCode(code);
		if(existuser==null) {
			//激活码错误
			this.addActionMessage("激活失败,激活码错误!");
			return "msg";
		}else {
			//激活成功
			existuser.setState(1);
			existuser.setCode(null);
			userService.update(existuser);
			this.addActionMessage("激活成功,请去登陆!");
			return "msg";
		}
	}
	
	/**
	 * 登陆的方法
	 */
	public String login() {
		User existuser = userService.login(user);
		if(existuser==null) {
			//登陆失败。
			this.addActionError("登陆失败,用户名或者密码错误或者用户未激活");
			return LOGIN;
		}else {
			//登陆成功
			//将用户信息存入Session中
			ServletActionContext.getRequest().getSession().setAttribute("existuser", existuser);
			//页面跳转
			return "loginSuccess";
		}	
	}
	public String quit() {
		//销毁session
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
	
	public String userinformation() {
		return "userinfo";
	}
	//更新用户资料
	public String update() {
		System.out.println(user.getUid());
		System.out.println(user.getSex());
		System.out.println(user.getSignature());
		User newuser = userService.findByUid(user.getUid());
		newuser.setSex(user.getSex());
		newuser.setSignature(user.getSignature());
		newuser.setUsername(user.getUsername());
		userService.update(newuser);
		String re = "修改成功";
		ServletActionContext.getRequest().getSession().setAttribute("existuser",newuser );
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().println(re);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "update";
	}
}
