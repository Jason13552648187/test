package cn.lttest.erp.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.lttest.erp.biz.IBaseBiz;
import cn.lttest.erp.entity.Emp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.opensymphony.xwork2.ActionContext;

public class BaseAction<T> {

	private IBaseBiz baseBiz;
	public IBaseBiz getBaseBiz() {
		return baseBiz;
	}

	public void setBaseBiz(IBaseBiz baseBiz) {
		this.baseBiz = baseBiz;
		
	}

	private T t1;
	private T t2;
	private Object param;
	private int page;
	private T t;
	private Long id;
	
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	private int rows;
	
	
	
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public Object getParam() {
		return param;
	}

	public void setParam(Object param) {
		this.param = param;
	}

	public T getT2() {
		return t2;
	}

	public void setT2(T t2) {
		this.t2 = t2;
	}

	public T getT1() {
		return t1;
	}

	public void setT1(T t1) {
		this.t1 = t1;
	}

	/**
	 * 部门删除
	 */
	public void delete(){
		
		try {
			baseBiz.delete(id);
			write(ajaxReturn(true, "删除成功！"));
		} catch (Exception e) {
			e.printStackTrace();
			write(ajaxReturn(false, "删除失败！"));
		}
		
	}
	
	
	
	
	
	/**
	 * 分页查询
	 */
	public void listByPage(){
		/*
		 * 每页显示6
		 * 1      0 ~ 5
		 * 2      6 ~ 11
		 * (page - 1) * rows
		 */
		
		int firstResult = (page - 1)*rows;
		List<T> list = baseBiz.getListByPage(t1, t2, param, firstResult, rows);
		Long total = baseBiz.getCount(t1, t2, param);
		Map map = new HashMap();
		map.put("total", total);
		map.put("rows", list);
		
		//将部门集合转换成json字符串
		String json = JSON.toJSONString(map,SerializerFeature.DisableCircularReferenceDetect);
	
		write(json);
	}
	
	/**
	 * 部门新增方法
	 */
	public void add(){
		//{"message":"失败",success:false}
		
		try {
			baseBiz.add(t);
			write(ajaxReturn(true,"新增成功！"));
		} catch (Exception e) {
			e.printStackTrace();
			write(ajaxReturn(false,"新增失败！"));
		}
		
	}
	
	public String ajaxReturn(boolean bool,String message){
		Map map = new HashMap();
		map.put("success", bool);
		map.put("message", message);
		return JSON.toJSONString(map);
	}
	
	
	
	public void get(){
		T t = (T) baseBiz.get(id);
		
		String jsonString = JSON.toJSONString(t);
		
		write(mapJson(jsonString,"t."));
		//{"t.name":"管理组","t.tele":"123456"}
	}
	
	
	public String mapJson(String jsonstring,String prefix){
		//json --> map{t.name="管理组",t.tele="123456"}
		//将json数据转换成map集合
		Map<String,Object> map = JSON.parseObject(jsonstring);
		Map<String,Object> newmap = new HashMap<String,Object>();
		for(String key :  map.keySet()){
			newmap.put(prefix + key, map.get(key));
		}
		
		return JSON.toJSONString(newmap);
		
	}
	
	
	/**
	 * 部门更新
	 */
	public void update(){
		try {
			baseBiz.update(t);
			write(ajaxReturn(true, "修改成功！"));
		} catch (Exception e) {
			e.printStackTrace();
			write(ajaxReturn(false, "修改失败！"));
		}
	}
	
	
	public void list(){
		
		List<T> list = baseBiz.getList(t1,t2,param);
		//将部门集合转换成json字符串:关闭循环引用，作用的是禁止循环序列化
		String json = JSON.toJSONString(list,SerializerFeature.DisableCircularReferenceDetect);
	
		write(json);
	}
	
	/**
	 * 
	 * json写出
	 * @param jsonstring
	 */
	public void write(String jsonstring){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().print(jsonstring);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Emp getUser(){
		return (Emp)ActionContext.getContext().getSession().get("loginUser");
	}
	
	
	

	
}
