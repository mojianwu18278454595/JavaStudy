package com.sc.dao.impl;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sc.dao.BorrowDao;
import com.sc.domain.Book;
import com.sc.domain.Borrow;
import com.sc.domain.Reader;
import com.sc.utils.HibernateUtils;

public class BorrowDaoImpl implements BorrowDao
{

	@Override
	public String borrow(Reader reader, Integer bk_id,String operationName)
	{
		Session session=HibernateUtils.getCurrentSession();
		Transaction tr=session.beginTransaction();
		//借书
		Reader bwReader=session.get(Reader.class,reader.getRd_id());
		Book bwBook=session.get(Book.class,bk_id);
		Set<Book> books=bwReader.getBooks();
		if(bwReader.getRd_status().equals("有效")&&bwBook.getBk_status().equals("在馆"))
		{
			if(books.size()<bwReader.getReaderType().getType_canLendQty().intValue())
			{
				bwBook.setBk_status("借出");
				books.add(bwBook);
				bwReader.setBooks(books);
				bwReader.setRd_borrowQty(bwReader.getRd_borrowQty()+1);
				session.update(bwReader);
				//记录下借书信息
				Query query=session.createQuery("from Borrow where bw_rd_id=? and bw_bk_id=?");
				query.setParameter(0, bwReader.getRd_id());
				query.setParameter(1, bk_id);
				Borrow borrow =(Borrow) query.uniqueResult();
				Timestamp dateOut=new Timestamp(System.currentTimeMillis());
				borrow.setBw_idDateOut(dateOut);//借书日期
				Calendar cal=Calendar.getInstance();
				cal.add(Calendar.DATE,bwReader.getReaderType().getType_canLendQty().intValue());
				Timestamp retPlan=new Timestamp(cal.getTime().getTime());
				borrow.setBw_idDateRetPlan(retPlan);//应还书日期
				borrow.setBw_isHasReturn("未还");
				borrow.setBw_idContinueTimes(0);//初始化续借此书为0
				borrow.setBw_idOverDay(0);
				borrow.setBw_operatorLend(operationName);//借书操作员
			}else
				return "您当前总借书数"+bwReader.getReaderType().getType_canLendQty().intValue()
						+"为最大借阅数，无法再借阅！";
		}else
			return bwBook.getBk_status().equals("在馆")?"当前借书证为"+bwReader.getRd_status()
					+"，无法借阅！":"此书已被借！";
		
		
		tr.commit();
		return "用户（"+bwReader.getRd_name()+"）借阅成功！";
	}

	@Override
	public String back(Reader reader, Integer bk_id,String operationName)
	{
		Session session=HibernateUtils.getCurrentSession();
		Transaction tr=session.beginTransaction();
		//还书
		boolean flag=true;
		BigDecimal overMoney=new BigDecimal(0);
		Reader bwReader=session.get(Reader.class,reader.getRd_id());
		Book bwBook=session.get(Book.class,bk_id);
		Set<Book> books=bwReader.getBooks();
		for (Book book : books)
		{
			if(book.getBk_id().equals(bk_id))
			{
				System.out.println("当前用户借书存在！");
				
				bwBook.setBk_status("在馆");
				
				
				//记录还书信息
				Query query=session.createQuery("from Borrow where bw_rd_id=? and bw_bk_id=?");
				query.setParameter(0, bwReader.getRd_id());
				query.setParameter(1, bk_id);
				Borrow borrow =(Borrow) query.uniqueResult();
				Timestamp dateRetAct=new Timestamp(System.currentTimeMillis());
				borrow.setBw_isHasReturn("已还");
				borrow.setBw_idDateRetAct(dateRetAct);//实际还书日期
				borrow.setBw_operatorRet(operationName);//还书操作员
				if(dateRetAct.compareTo(borrow.getBw_idDateRetPlan())>0)
				{
					bwReader.setRd_status("欠费");
					Calendar cal1=Calendar.getInstance();
					Calendar cal2=Calendar.getInstance();
					cal1.setTime(dateRetAct);
					cal2.setTime(borrow.getBw_idDateRetPlan());
					long diffDay=(cal1.getTimeInMillis()-cal2.getTimeInMillis())/(1000 * 60 * 60 * 24);
					
					overMoney=BigDecimal.valueOf(bwReader.getReaderType().getType_punishRate().doubleValue()*diffDay);
					overMoney=overMoney.setScale(2,BigDecimal.ROUND_HALF_UP);
					borrow.setBw_idOverMoney(overMoney);
					BigDecimal punish=BigDecimal.valueOf(0);
					punish=punish.setScale(2,BigDecimal.ROUND_HALF_UP);
					borrow.setBw_idPunishMoney(punish);
				}
				flag=false;
				break;
			}
		}

		tr.commit();
		if(flag)
			return "亲，当前用户没有借阅此书哟！";
		
		if(overMoney.doubleValue()>0)
			return "用户（"+bwReader.getRd_name()+"）还书成功！还书逾期罚款"+overMoney+"元，请尽快缴费！";
		return "用户（"+bwReader.getRd_name()+"）还书成功！";
	}

	@Override
	public String renewal(Reader reader, Integer bk_id,String operationName)
	{
		Session session=HibernateUtils.getCurrentSession();
		Transaction tr=session.beginTransaction();
		//续借
		Reader bwReader =session.get(Reader.class,reader.getRd_id());
		Book bwBook=session.get(Book.class,bk_id);
		Query query=session.createQuery("from Borrow where bw_rd_id=? and bw_bk_id=?");
		query.setParameter(0, reader.getRd_id());
		query.setParameter(1, bk_id);
		Borrow borrow =(Borrow) query.uniqueResult();
		if(borrow==null)
			return "您的输入有误，此用户未借此书！";
		if(bwReader.getRd_status().equals("有效"))
		{
			if(borrow.getBw_idContinueTimes()<bwReader.getReaderType().getType_canContinueTimes())
			{
				Timestamp dateOut=new Timestamp(System.currentTimeMillis());
				borrow.setBw_idDateOut(dateOut);//更新借书日期
				Calendar cal=Calendar.getInstance();
				cal.add(Calendar.DATE,bwReader.getReaderType().getType_canLendQty().intValue());
				Timestamp retPlan=new Timestamp(cal.getTime().getTime());
				borrow.setBw_idDateRetPlan(retPlan);//更新应还书日期
				borrow.setBw_idContinueTimes(borrow.getBw_idContinueTimes()+1);//更新续借次数
				borrow.setBw_operatorLend(operationName);//借书操作员
				session.update(borrow);
			}else
				return "用户（"+bwReader.getRd_name()+"）已达最大续借次数，续借失败！";
		}else
			return "用户（"+bwReader.getRd_name()+"）当前借书证状态（"+bwReader.getRd_status()+"）";
		
		tr.commit();
		return "用户（"+bwReader.getRd_name()+"）续借成功！";
	}

	@Override
	public List<Borrow> compBw(Integer rd_id, Integer bk_id)
	{
		List<Borrow> compBws= new ArrayList<Borrow>();
		
		Session session =HibernateUtils.getCurrentSession();
		Transaction tr=session.beginTransaction();
		if(rd_id==0)
		{
			Query query=session.createQuery("from Borrow where bw_bk_id=?");
			query.setParameter(0, bk_id);
			compBws=query.list();
		}else
		{
			Query query= session.createQuery("from Borrow where bw_rd_id=?");
			query.setParameter(0, rd_id);
			compBws=query.list();
		}
		
		tr.commit();
		return compBws;
	}

	@Override
	public String givePunishMoney(Integer rd_id,Integer bk_id,Double punishMoney)
	{
		String result=new String();
		Reader reader=null;
		Session session =HibernateUtils.getCurrentSession();
		Transaction tr=session.beginTransaction();
		Query query =session.createQuery("from Borrow where bw_rd_id=? and bw_bk_id=?");
		query.setParameter(0, rd_id);
		query.setParameter(1, bk_id);
		Borrow borrow=(Borrow)query.uniqueResult();
		
		BigDecimal plan=borrow.getBw_idPunishMoney();
		BigDecimal punish=BigDecimal.valueOf(punishMoney+plan.doubleValue());
		punish=punish.setScale(2,BigDecimal.ROUND_HALF_UP);
		borrow.setBw_idPunishMoney(punish);//记录实际缴费
		reader =session.get(Reader.class, borrow.getBw_rd_id());
		if(punish.compareTo(borrow.getBw_idOverMoney())==0)
		{
			reader.setRd_status("有效");
			result="当前用户（"+reader.getRd_name()+"）缴费成功!全部缴清！";
		}else
		{
			Double over=borrow.getBw_idOverMoney().doubleValue();
			BigDecimal diffMoney=BigDecimal.valueOf(over-borrow.getBw_idPunishMoney().doubleValue());
			diffMoney =diffMoney.setScale(2,BigDecimal.ROUND_HALF_UP);
			result="当前用户（"+reader.getRd_name()+")缴费成功！还需缴费"+diffMoney+"元";
		}
			
		tr.commit();
				
		return result;
	}

}
