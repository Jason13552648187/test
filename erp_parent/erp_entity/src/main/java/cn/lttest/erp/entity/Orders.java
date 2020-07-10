package cn.lttest.erp.entity;

import java.util.Date;
import java.util.List;

public class Orders {
	public static  final String STATE_CREATE = "0";//未审核 
	public static  final String STATE_CHECK = "1";//已审核
	public static  final String STATE_START = "2";//已确认
	public static  final String STATE_END = "3";//已入库
	public static  final String TYPE_IN = "1";//这个采购订单
	public static  final String TYPE_OUT = "2";//这是销售订单
	
	private Long uuid;//编号
	private Date createtime;//生成日期
	private String createrName;//下单员
	private Date checktime;//审核日期
	private String checkerName;//审核员
	private Date starttime;//确认日期
	private String staterName;//采购员名称
	private Date endtime;//入库或出库日期
	private String enderName;//库管员
	private String type;//采购  或销售
	private Long creater;//下单员
	private Long checker;//审核员
	private Long starter;//采购员
	private Long ender;//库管员
	private Long supplieruuid;//供应商或客户
	private String supplierName;
	private Double totalmoney;//总金额
	private String state;//采购： 0=为审核   1=已审核     2= 已确认   3=已入库       销售
	private Long waybillsn;//运单号
	private List<OrderDetail> orderDetails;//订单详情
	
	public String getCreaterName() {
		return createrName;
	}
	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}
	public String getCheckerName() {
		return checkerName;
	}
	public void setCheckerName(String checkerName) {
		this.checkerName = checkerName;
	}
	public String getStaterName() {
		return staterName;
	}
	public void setStaterName(String staterName) {
		this.staterName = staterName;
	}
	public String getEnderName() {
		return enderName;
	}
	public void setEnderName(String enderName) {
		this.enderName = enderName;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	@Override
	public String toString() {
		return "Orders [uuid=" + uuid + ", createtime=" + createtime
				+ ", checktime=" + checktime + ", starttime=" + starttime
				+ ", endtime=" + endtime + ", type=" + type + ", creater="
				+ creater + ", checker=" + checker + ", starter=" + starter
				+ ", ender=" + ender + ", supplieruuid=" + supplieruuid
				+ ", totalmoney=" + totalmoney + ", state=" + state
				+ ", waybillsn=" + waybillsn + ", orderDetails=" + orderDetails
				+ "]";
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getUuid() {
		return uuid;
	}
	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getChecktime() {
		return checktime;
	}
	public void setChecktime(Date checktime) {
		this.checktime = checktime;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getCreater() {
		return creater;
	}
	public void setCreater(Long creater) {
		this.creater = creater;
	}
	public Long getChecker() {
		return checker;
	}
	public void setChecker(Long checker) {
		this.checker = checker;
	}
	public Long getStarter() {
		return starter;
	}
	public void setStarter(Long starter) {
		this.starter = starter;
	}
	public Long getEnder() {
		return ender;
	}
	public void setEnder(Long ender) {
		this.ender = ender;
	}
	public Long getSupplieruuid() {
		return supplieruuid;
	}
	public void setSupplieruuid(Long supplieruuid) {
		this.supplieruuid = supplieruuid;
	}
	public Double getTotalmoney() {
		return totalmoney;
	}
	public void setTotalmoney(Double totalmoney) {
		this.totalmoney = totalmoney;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Long getWaybillsn() {
		return waybillsn;
	}
	public void setWaybillsn(Long waybillsn) {
		this.waybillsn = waybillsn;
	}
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	public Orders(Long uuid, Date createtime, Date checktime, Date starttime,
			Date endtime, String type, Long creater, Long checker,
			Long starter, Long ender, Long supplieruuid, Double totalmoney,
			String state, Long waybillsn, List<OrderDetail> orderDetails) {
		super();
		this.uuid = uuid;
		this.createtime = createtime;
		this.checktime = checktime;
		this.starttime = starttime;
		this.endtime = endtime;
		this.type = type;
		this.creater = creater;
		this.checker = checker;
		this.starter = starter;
		this.ender = ender;
		this.supplieruuid = supplieruuid;
		this.totalmoney = totalmoney;
		this.state = state;
		this.waybillsn = waybillsn;
		this.orderDetails = orderDetails;
	}
	
	
	
	
}
