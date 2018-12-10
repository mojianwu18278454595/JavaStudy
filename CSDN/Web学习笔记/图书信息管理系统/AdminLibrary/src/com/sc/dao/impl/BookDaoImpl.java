package com.sc.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.sc.dao.BookDao;
import com.sc.domain.Book;
import com.sc.domain.Reader;
import com.sc.utils.HibernateUtils;

public class BookDaoImpl implements BookDao
{

	@Override
	public String add(Book book)
	{
		Session session=HibernateUtils.getCurrentSession();
		Transaction tr=session.beginTransaction();
		book.setBk_dateIn(new Timestamp(System.currentTimeMillis()));
		session.save(book);
		
		tr.commit();
		
		return "图书录入成功！";
	}

	@Override
	public List<Book> select(Book book)
	{
		Session session=HibernateUtils.getCurrentSession();
		Transaction tr=session.beginTransaction();
		
		Criteria ciriteria=session.createCriteria(Book.class);
		if(!book.getBk_code().equals(""))
		{
			ciriteria.add(Restrictions.like("bk_code", book.getBk_code(),MatchMode.START));
			List<Book> books=ciriteria.list();
			tr.commit();
			return books;
		}
		if(!book.getBk_author().equals(""))
		{
			ciriteria.add(Restrictions.like("bk_author", book.getBk_author(),MatchMode.START));
			List<Book> books=ciriteria.list();
			tr.commit();
			return books;
		}
		if(!book.getBk_name().equals(""))
		{
			ciriteria.add(Restrictions.like("bk_name", book.getBk_name(),MatchMode.START));
			List<Book> books=ciriteria.list();
			tr.commit();
			return books;
		}
		tr.commit();
		
		return null;
	}

	@Override
	public Book giveBook(Book book)
	{
		Session session=HibernateUtils.getCurrentSession();
		Transaction tr=session.beginTransaction();
		
		Book giveBook =session.get(Book.class, book.getBk_id());
		tr.commit();
		
		return giveBook;
	}

	@Override
	public String edit(Book book)
	{
		Session session=HibernateUtils.getCurrentSession();
		Transaction tr=session.beginTransaction();
		
		Book curBook =session.get(Book.class, book.getBk_id());
		curBook.setBk_code(book.getBk_code());
		curBook.setBk_author(book.getBk_author());
		curBook.setBk_brief(book.getBk_brief());
		curBook.setBk_datePress(book.getBk_datePress());
		curBook.setBk_ISBN(book.getBk_ISBN());
		curBook.setBk_language(book.getBk_language());
		curBook.setBk_name(book.getBk_name());
		curBook.setBk_pages(book.getBk_pages());
		curBook.setBk_press(book.getBk_press());
		curBook.setBk_price(book.getBk_price());
		//curBook.setBk_status(book.getBk_status());
		tr.commit();
		return "当前图书维护完成！";
	}

	@Override
	public String delete(Integer bk_id)
	{
		Session session=HibernateUtils.getCurrentSession();
		Transaction tr=session.beginTransaction();
		Book book=session.get(Book.class, bk_id);
		session.delete(book);
		tr.commit();
		return "图书已经移除！";
	}

}
