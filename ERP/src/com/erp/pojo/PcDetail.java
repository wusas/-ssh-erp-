package com.erp.pojo;

/**
 * PcDetail entity. @author MyEclipse Persistence Tools
 */

public class PcDetail implements java.io.Serializable {

	// Fields

	private Long pcDetailId;
	private Goods goods;
	private Purchase purchase;
	private Double pcDetailPrice;
	private Integer pcDetailNum;
	private Integer pcDetailDel;

	// Constructors

	/** default constructor */
	public PcDetail() {
	}

	/** full constructor */
	public PcDetail(Goods goods, Purchase purchase, Double pcDetailPrice, Integer pcDetailNum, Integer pcDetailDel) {
		this.goods = goods;
		this.purchase = purchase;
		this.pcDetailPrice = pcDetailPrice;
		this.pcDetailNum = pcDetailNum;
		this.pcDetailDel = pcDetailDel;
	}

	// Property accessors

	public Long getPcDetailId() {
		return this.pcDetailId;
	}

	public void setPcDetailId(Long pcDetailId) {
		this.pcDetailId = pcDetailId;
	}

	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Purchase getPurchase() {
		return this.purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public Double getPcDetailPrice() {
		return this.pcDetailPrice;
	}

	public void setPcDetailPrice(Double pcDetailPrice) {
		this.pcDetailPrice = pcDetailPrice;
	}

	public Integer getPcDetailNum() {
		return this.pcDetailNum;
	}

	public void setPcDetailNum(Integer pcDetailNum) {
		this.pcDetailNum = pcDetailNum;
	}

	public Integer getPcDetailDel() {
		return this.pcDetailDel;
	}

	public void setPcDetailDel(Integer pcDetailDel) {
		this.pcDetailDel = pcDetailDel;
	}

}