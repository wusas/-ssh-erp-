package com.erp.pojo;

/**
 * SaleDetail entity. @author MyEclipse Persistence Tools
 */

public class SaleDetail implements java.io.Serializable {

	// Fields

	private Long saleDetailId;
	private Sale sale;
	private Goods goods;
	private Double saleDetailPrice;
	private Integer saleDetailNum;
	private Integer saleDetailDel;

	// Constructors

	/** default constructor */
	public SaleDetail() {
	}

	/** full constructor */
	public SaleDetail(Sale sale, Goods goods, Double saleDetailPrice, Integer saleDetailNum, Integer saleDetailDel) {
		this.sale = sale;
		this.goods = goods;
		this.saleDetailPrice = saleDetailPrice;
		this.saleDetailNum = saleDetailNum;
		this.saleDetailDel = saleDetailDel;
	}

	// Property accessors

	public Long getSaleDetailId() {
		return this.saleDetailId;
	}

	public void setSaleDetailId(Long saleDetailId) {
		this.saleDetailId = saleDetailId;
	}

	public Sale getSale() {
		return this.sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Double getSaleDetailPrice() {
		return this.saleDetailPrice;
	}

	public void setSaleDetailPrice(Double saleDetailPrice) {
		this.saleDetailPrice = saleDetailPrice;
	}

	public Integer getSaleDetailNum() {
		return this.saleDetailNum;
	}

	public void setSaleDetailNum(Integer saleDetailNum) {
		this.saleDetailNum = saleDetailNum;
	}

	public Integer getSaleDetailDel() {
		return this.saleDetailDel;
	}

	public void setSaleDetailDel(Integer saleDetailDel) {
		this.saleDetailDel = saleDetailDel;
	}

}