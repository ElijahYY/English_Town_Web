package cn.soul.Town.user.service;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import cn.soul.Town.user.dao.UserDao;
import cn.soul.Town.user.vo.User;
import cn.soul.Town.util.MailUtils;
import cn.soul.Town.util.UUIDUtil;

public class UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	//�����ѯ
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
		
	}
	//ҵ�������û�ע��ķ���
	public void save(User user) {
		// TODO Auto-generated method stub
		user.setHcuseday(0);
		user.setUseday(0);
		user.setCuseday(0);
		user.setState(0);
		String Code = UUIDUtil.getUUID()+UUIDUtil.getUUID();
		user.setCode(Code);
		userDao.save(user);
		System.out.println(user.getEmail()+"------------------email");
		//���ͼ����ʼ�
		try {
			MailUtils.sendMail(user.getEmail(), Code);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public User findByCode(String code) {
		
		return userDao.findByCode(code);
	}

	public void update(User existuser) {
		userDao.update(existuser);
	}
	/**
	 * �û���½�ķ���
	 * @param user
	 * @return
	 */
	public User login(User user) {
		
		return userDao.login(user);
	}

	public List<User> findByHcday() {
		return userDao.findByHcday();
	}

	public User findByUid(int uid) {
		return userDao.findByUid(uid);
	}

	public List<User> findByr() {
		return userDao.findByr();
	}
	
}
