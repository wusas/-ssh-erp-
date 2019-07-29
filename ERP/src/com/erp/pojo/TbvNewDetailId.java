package com.erp.pojo;

import java.math.BigDecimal;

/**
 * TbvNewDetailId entity. @author MyEclipse Persistence Tools
 */

public class TbvNewDetailId implements java.io.Serializable {

	// Fields

	private Long goodsId;
	private BigDecimal detail;
	private String goodsName;

	// Constructors

	/** default constructor */
	public TbvNewDetailId() {
	}

	/** full constructor */
	public TbvNewDetailId(Long goodsId, BigDecimal detail, String goodsName) {
		this.goodsId = goodsId;
		this.detail = detail;
		this.goodsName = goodsName;
	}

	// Property accessors

	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public BigDecimal getDetail() {
		return this.detail;
	}

	public void setDetail(BigDecimal detail) {
		this.detail = detail;
	}

	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TbvNewDetailId))
			return false;
		TbvNewDetailId castOther = (TbvNewDetailId) other;

		return ((this.getGoodsId() == castOther.getGoodsId()) || (this.getGoodsId() != null
				&& castOther.getGoodsId() != null && this.getGoodsId().equals(castOther.getGoodsId())))
				&& ((this.getDetail() == castOther.getDetail()) || (this.getDetail() != null
						&& castOther.getDetail() != null && this.getDetail().equals(castOther.getDetail())))
				&& ((this.getGoodsName() == castOther.getGoodsName()) || (this.getGoodsName() != null
						&& castOther.getGoodsName() != null && this.getGoodsName().equals(castOther.getGoodsName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getGoodsId() == null ? 0 : this.getGoodsId().hashCode());
		result = 37 * result + (getDetail() == null ? 0 : this.getDetail().hashCode());
		result = 37 * result + (getGoodsName() == null ? 0 : this.getGoodsName().hashCode());
		return result;
	}

}