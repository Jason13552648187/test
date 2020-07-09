package cn.lttest.erp.biz.impl;

import java.util.Date;
import java.util.List;

import cn.lttest.erp.biz.IReportBiz;
import cn.lttest.erp.dao.IReportDao;

public class ReportBiz  implements IReportBiz {
	private IReportDao reportDao;

	public IReportDao getReportDao() {
		return reportDao;
	}

	public void setReportDao(IReportDao reportDao) {
		this.reportDao = reportDao;
	}

	public List orderReport(Date startDate, Date endDate) {
		return reportDao.orderReport(startDate, endDate);
	}

	

}
