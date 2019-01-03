package com.sc.service;

import java.util.List;

import com.sc.domain.Borrow;
import com.sc.domain.Reader;

public interface BorrowService
{

	public String borrow(Reader reader, Integer bk_id,String operationName);

	public String back(Reader reader, Integer bk_id,String operationName);

	public String renewal(Reader reader, Integer bk_id,String operationName);

	public List<Borrow> compBw(Integer rd_id,Integer bk_id);

	public String givePunishMoney(Integer rd_id,Integer bk_id,Double punishMoney);



}
