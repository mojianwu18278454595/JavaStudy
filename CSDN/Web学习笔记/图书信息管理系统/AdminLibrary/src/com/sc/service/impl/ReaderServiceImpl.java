package com.sc.service.impl;

import java.util.List;

import com.sc.dao.ReaderDao;
import com.sc.dao.impl.ReaderDaoImpl;
import com.sc.domain.Reader;
import com.sc.service.ReaderService;

public class ReaderServiceImpl implements ReaderService
{

	@Override
	public Reader login(Reader reader)
	{
		ReaderDao readerDao=new ReaderDaoImpl();
		return readerDao.login(reader);
	}

	@Override
	public String add(Reader reader, Integer rd_type)
	{
		ReaderDao readerDao=new ReaderDaoImpl();

		return readerDao.add(reader,rd_type);
	}

	@Override
	public List<Reader> select(Reader reader)
	{
		ReaderDao readerDao=new ReaderDaoImpl();
		List<Reader>readers=readerDao.select(reader);
		return readers;
	}

	@Override
	public Reader edit(Reader reader,Integer readerType)
	{
		ReaderDao readerDao=new ReaderDaoImpl();
		Reader editReader=readerDao.edit(reader,readerType);
		return editReader;
	}

	@Override
	public Reader operation(Reader editReader,int number)
	{
		ReaderDao readerDao=new ReaderDaoImpl();
		Reader result=readerDao.operation(editReader,number);
		return result;
	}

}
