package com.davidhdez.restaurant;

import java.util.ArrayList;
import java.util.List;

public class Table {
	
	public final int size; // number of chairs
	private final List<ClientsGroup> listClientsGroup;
	private int numPeople;
	
	public Table(int size) {
		this.size = size;
		this.listClientsGroup = new ArrayList<ClientsGroup>(size);
		this.numPeople = 0;
	}
	
	public void setClientGroup(ClientsGroup clientsGroup) {		
		listClientsGroup.add(clientsGroup);
		numPeople += clientsGroup.size;
	}
	
	public void removeGroup(ClientsGroup group) {
		numPeople -= group.size;
		listClientsGroup.remove(group);
	}
	
	public boolean isComplete() {
		return seatAvailable() == 0;
	}
	
	public int seatAvailable() {
		return size - numPeople;
	}
	
	public boolean isEmpty() {
		return numPeople == 0;
	}
}