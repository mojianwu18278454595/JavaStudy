package com.sc.service.impl;

import java.util.List;

import com.sc.dao.BookDao;
import com.sc.dao.impl.BookDaoImpl;
import com.sc.domain.Book;
import com.sc.domain.Reader;
import com.sc.service.BookService;

public class BookServiceImpl implements BookService
{

	@Override
	public String add(Book book)
	{
		BookDao bookDao=new BookDaoImpl();
		String result=bookDao.add(book);
		
		return result;
	}

	@Override
	public List<Book> select(Book book)
	{
		BookDao bookDao=new BookDaoImpl();
		List<Book> result=bookDao.select(book);
		
		return result;
	}

	@Override
	public String edit(Book book)
	{
		BookDao bookDao=new BookDaoImpl();
		String result=bookDao.edit(book);
		return result;
	}

	@Override
	public String delete(Integer bk_id)
	{
		BookDao bookDao=new BookDaoImpl();
		String result=bookDao.delete(bk_id);
		return result;
	}

	

}
