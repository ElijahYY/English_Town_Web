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
 * �û�ģ���Action
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
			//��ѯ���˸��û� �û����Ѿ�����
			response.getWriter().println("<font color = 'red' >�û����Ѿ�����</font>");
			System.out.println("��Ϣ�Ѿ�����");
		}else {
			//û�鵽���û�������ʹ�á�
			response.getWriter().println("<font color = 'green' >�û�������ʹ��</font>");
		}
		return NONE;
	}

	public String regist() {
		//�û�ע��
		user.setImg("IMG_0352.JPG");
		user.setCnum(0);
		user.setTestcount(0);
		user.setCorrectrate(0);
		user.setLastday(new Date(System.currentTimeMillis()));
		userService.save(user);
		this.addActionMessage("ע��ɹ�,��ȥ���伤��.");
		return "msg";
	}
	/**
	 * �û�����ķ���
	 */
	public String active() {
		String code = user.getCode();
		User existuser = userService.findByCode(code);
		if(existuser==null) {
			//���������
			this.addActionMessage("����ʧ��,���������!");
			return "msg";
		}else {
			//����ɹ�
			existuser.setState(1);
			existuser.setCode(null);
			userService.update(existuser);
			this.addActionMessage("����ɹ�,��ȥ��½!");
			return "msg";
		}
	}
	
	/**
	 * ��½�ķ���
	 */
	public String login() {
		User existuser = userService.login(user);
		if(existuser==null) {
			//��½ʧ�ܡ�
			this.addActionError("��½ʧ��,�û������������������û�δ����");
			return LOGIN;
		}else {
			//��½�ɹ�
			//���û���Ϣ����Session��
			ServletActionContext.getRequest().getSession().setAttribute("existuser", existuser);
			//ҳ����ת
			return "loginSuccess";
		}	
	}
	public String quit() {
		//����session
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
	
	public String userinformation() {
		return "userinfo";
	}
	//�����û�����
	public String update() {
		System.out.println(user.getUid());
		System.out.println(user.getSex());
		System.out.println(user.getSignature());
		User newuser = userService.findByUid(user.getUid());
		newuser.setSex(user.getSex());
		newuser.setSignature(user.getSignature());
		newuser.setUsername(user.getUsername());
		userService.update(newuser);
		String re = "�޸ĳɹ�";
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
