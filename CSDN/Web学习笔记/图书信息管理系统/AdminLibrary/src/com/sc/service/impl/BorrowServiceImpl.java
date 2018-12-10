package com.sc.service.impl;

import java.util.List;

import com.sc.dao.BorrowDao;
import com.sc.dao.impl.BorrowDaoImpl;
import com.sc.domain.Borrow;
import com.sc.domain.Reader;
import com.sc.service.BorrowService;

public class BorrowServiceImpl implements BorrowService
{
	private BorrowDao borrowDao= new BorrowDaoImpl();
	@Override
	public String borrow(Reader reader, Integer bk_id,String operationName)
	{
		String result=borrowDao.borrow(reader,bk_id, operationName);
		return result;
	}

	@Override
	public String back(Reader reader, Integer bk_id,String operationName)
	{
		String result=borrowDao.back(reader,bk_id,operationName);
		return result;
	}

	@Override
	public String renewal(Reader reader, Integer bk_id,String operationName)
	{
		String result=borrowDao.renewal(reader,bk_id, operationName);
		return result;
	}

	@Override
	public List<Borrow> compBw(Integer rd_id,Integer bk_id)
	{
		
		return borrowDao.compBw(rd_id,bk_id);
	}

	@Override
	public String givePunishMoney(Integer rd_id,Integer bk_id,Double punishMoney)
	{
		return borrowDao.givePunishMoney(rd_id,bk_id,punishMoney);
	}

	

}
