package com.sc.dao.impl;



import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sc.dao.ReaderDao;
import com.sc.domain.Reader;
import com.sc.domain.ReaderType;
import com.sc.utils.HibernateUtils;

public class ReaderDaoImpl implements ReaderDao
{

	@Override
	public Reader login(Reader reader)
	{
		Session session= HibernateUtils.getCurrentSession();
		Transaction tr=session.beginTransaction();
		
		//与数据库交互验证用户名密码
		Query query=session.createQuery("from Reader where rd_name=? and rd_pwd=?");
		query.setParameter(0, reader.getRd_name());
		query.setParameter(1, reader.getRd_pwd());
		Reader checkReader=(Reader)query.uniqueResult();
	
		tr.commit();
		return checkReader;
	}

	@Override
	public String add(Reader reader, Integer rd_type)
	{
		Session session=HibernateUtils.getCurrentSession();
		Transaction tr=session.beginTransaction();
		
		ReaderType readerType=session.get(ReaderType.class,rd_type);
		reader.setReaderType(readerType);
		//设置读者默认参数
		reader.setRd_status("有效");
		reader.setRd_pwd("123456");
		reader.setRd_adminRoles(0);
		reader.setRd_borrowQty(0);
		reader.setRd_dateReg(new Timestamp(System.currentTimeMillis()));
		session.save(reader);
		
		tr.commit();
		return "编号为"+reader.getRd_id()+"办理成功！";
	}

	@Override
	public List<Reader> select(Reader reader)
	{
		Session session=HibernateUtils.getCurrentSession();
		Transaction tr=session.beginTransaction();
		
		List<Reader> listReaders=new ArrayList<Reader>();
		if(reader.getRd_id()==null&&reader.getRd_name()!=null)
		{
			Query queryName=session.createQuery("from Reader where rd_name=?");
			queryName.setParameter(0, reader.getRd_name());
			listReaders=queryName.list();
		}
		if(reader.getRd_id()!=null)
		{
			Query queryName=session.createQuery("from Reader where rd_id=?");
			queryName.setParameter(0, reader.getRd_id());
			listReaders=queryName.list();
		}
		
		tr.commit();
		
		return listReaders;
	}

	@Override
	public Reader edit(Reader reader,Integer readerType)
	{
		Session session=HibernateUtils.getCurrentSession();
		Transaction tr=session.beginTransaction();
		Reader giveReader=session.get(Reader.class,reader.getRd_id());
		giveReader.setRd_name(reader.getRd_name());
		giveReader.setRd_dept(reader.getRd_dept());
		giveReader.setRd_sex(reader.getRd_sex());
		giveReader.setRd_phone(reader.getRd_phone());
		giveReader.setRd_email(reader.getRd_email());
		giveReader.setRd_pwd(reader.getRd_pwd());
		ReaderType giveReaderType=session.get(ReaderType.class, readerType);
		giveReader.setReaderType(giveReaderType);
		session.save(giveReader);
		tr.commit();
		return giveReader;
	}

	@Override
	public Reader operation(Reader editReader, int number)
	{
		Session session=HibernateUtils.getCurrentSession();
		Transaction tr=session.beginTransaction();
		//挂失
		if(number==1)
		{
			editReader.setRd_status("挂失");
		}
		if(number==2)
			editReader.setRd_status("有效");
		if(number==3)
			editReader.setRd_status("注销");
		if(number==4)
		{
			Query query=session.createQuery("delete Reader where rd_id=?");
			query.setParameter(0, editReader.getRd_id());
			query.executeUpdate();
			editReader.setRd_id(null);
			editReader.setRd_status("有效");
			session.save(editReader);
		}
		session.update(editReader);
		
		tr.commit();
		
		return editReader;
	}

}
