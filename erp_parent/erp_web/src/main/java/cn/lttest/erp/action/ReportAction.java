package cn.lttest.erp.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;

import cn.lttest.erp.biz.IReportBiz;

public class ReportAction{
	
	private IReportBiz reportBiz;
	private Date startDate;
	private Date endDate;
	
	
	
	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public IReportBiz getReportBiz() {
		return reportBiz;
	}
	

	public void setReportBiz(IReportBiz reportBiz){
		this.reportBiz = reportBiz;
	}
	
	public void orderReport(){
		System.out.println(startDate 
				+ "-----------" + endDate);
		List list = reportBiz.orderReport(startDate, endDate);
		
		write(JSON.toJSONString(list));
	}
	
	 public void write(String mapString) {
	        //返回对象
	        HttpServletResponse res = ServletActionContext.getResponse();
	        res.setContentType("text/html;charset=utf-8");
	        res.setCharacterEncoding("utf-8");

	        try {
	            //输出给页面
	            res.getWriter().write(mapString);
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }

	
	
	
	
	
	
}
