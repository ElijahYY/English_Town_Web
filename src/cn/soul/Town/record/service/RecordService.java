package cn.soul.Town.record.service;

import java.util.List;

import cn.soul.Town.record.dao.RecordDao;
import cn.soul.Town.record.vo.Record;
import cn.soul.Town.user.vo.User;

public class RecordService {
	private RecordDao recordDao;

	public RecordDao getRecordDao() {
		return recordDao;
	}

	public void setRecordDao(RecordDao recordDao) {
		this.recordDao = recordDao;
	}

	public List<Record> findByUser(User user) {
		
		return recordDao.findByUser(user);
	}

	public void save(Record record) {
		recordDao.save(record);
	}
	
}
