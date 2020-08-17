package com.neuedu.print.model;

import java.io.Serializable;

/**
 * 实体类Management
 *
 */
public class Management implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -838066978791038330L;

	private Integer id;

    private String password;

    private String name;

    public Management(String password, String name) {
		super();
		this.password = password;
		this.name = name;
	}

	public Management(Integer id, String password, String name) {
		this(password, name);
        this.id = id;
    }

    public Management() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}
