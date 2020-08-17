package com.neuedu.print.model;

import java.io.Serializable;
import java.util.Date;
/**
 * 信息实体类Department：
 * 作用：存储数据、在层与层之间负责数据传递
 * 实现序列化接口Serializable：实现序列化接口，可以保证数据在传递时的安全性和稳定性
 * @author steve
 *
 */
public class Orders  implements Serializable{
	private static final long serialVersionUID = -2452763468120461613L;
    private Integer id;

    private Integer orderno;

    private Date paytime;

    private Integer paymoney;

    private Integer paystate;

    private String receiveaddress;

    private String receivername;

    private Integer receiverphone;

    private String remark;
    //去掉id
    public Orders( Integer orderno, Date paytime, Integer paymoney, Integer paystate, String receiveaddress, String receivername, Integer receiverphone, String remark) {
        this.orderno = orderno;
        this.paytime = paytime;
        this.paymoney = paymoney;
        this.paystate = paystate;
        this.receiveaddress = receiveaddress;
        this.receivername = receivername;
        this.receiverphone = receiverphone;
        this.remark = remark;
    }
    public Orders(Integer id, Integer orderno, Date paytime, Integer paymoney, Integer paystate, String receiveaddress, String receivername, Integer receiverphone, String remark) {
        this(orderno,paytime,paymoney,paystate,receiveaddress,receivername,receiverphone,remark);
    	this.id = id;
    }

    public Orders() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderno() {
        return orderno;
    }

    public void setOrderno(Integer orderno) {
        this.orderno = orderno;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public Integer getPaymoney() {
        return paymoney;
    }

    public void setPaymoney(Integer paymoney) {
        this.paymoney = paymoney;
    }

    public Integer getPaystate() {
        return paystate;
    }

    public void setPaystate(Integer paystate) {
        this.paystate = paystate;
    }

    public String getReceiveaddress() {
        return receiveaddress;
    }

    public void setReceiveaddress(String receiveaddress) {
        this.receiveaddress = receiveaddress == null ? null : receiveaddress.trim();
    }

    public String getReceivername() {
        return receivername;
    }

    public void setReceivername(String receivername) {
        this.receivername = receivername == null ? null : receivername.trim();
    }

    public Integer getReceiverphone() {
        return receiverphone;
    }

    public void setReceiverphone(Integer receiverphone) {
        this.receiverphone = receiverphone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}