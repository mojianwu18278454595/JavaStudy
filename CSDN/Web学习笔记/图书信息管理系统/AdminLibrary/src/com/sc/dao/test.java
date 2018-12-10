package com.sc.dao;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sc
 */
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.sc.domain.Book;
import com.sc.domain.Borrow;
import com.sc.domain.Reader;
import com.sc.domain.ReaderType;
import com.sc.utils.FileUtils;
import com.sc.utils.HibernateUtils;

public class test
{
	@Test
	public void demo1()
	{
		Session session=HibernateUtils.getCurrentSession();
		Transaction tr=session.beginTransaction();
		
		Timestamp curTime=new Timestamp(System.currentTimeMillis());
		Borrow borrow =session.get(Borrow.class,1l);
		borrow.setBw_idDateRetAct(curTime);
		if(curTime.compareTo(borrow.getBw_idDateRetPlan())>0)
			System.out.println("成功Q！");
		tr.commit();
		
	}
}
