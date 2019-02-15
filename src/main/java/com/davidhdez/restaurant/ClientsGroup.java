package com.davidhdez.restaurant;

public class ClientsGroup {
	
	public final int size; // number of clients
	private int table;
	
	public ClientsGroup(int size) {
		this.size = size;
		this.table = -1; // value -1 means that group has not table
	}

	public int getTable() {
		return table;
	}

	public void setTable(int table) {
		this.table = table;
	}
}