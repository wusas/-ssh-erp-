package com.erp.pojo;

/**
 * TbvNewDetail entity. @author MyEclipse Persistence Tools
 */

public class TbvNewDetail implements java.io.Serializable {

	// Fields

	private TbvNewDetailId id;

	// Constructors

	/** default constructor */
	public TbvNewDetail() {
	}

	/** full constructor */
	public TbvNewDetail(TbvNewDetailId id) {
		this.id = id;
	}

	// Property accessors

	public TbvNewDetailId getId() {
		return this.id;
	}

	public void setId(TbvNewDetailId id) {
		this.id = id;
	}

}