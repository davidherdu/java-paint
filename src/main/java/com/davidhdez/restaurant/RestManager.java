package com.davidhdez.restaurant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class RestManager {

	private List<Table> listTables;
	private final LinkedHashSet<ClientsGroup> groupQueue = new LinkedHashSet<ClientsGroup>();
	private Map<Integer, List<Table>> restaurant; // The key is the number of seats available in a table.

	public RestManager(List<Table> tables) {
		this.listTables = tables;
		this.restaurant = new HashMap<Integer, List<Table>>();

		for (Table table : listTables) {
			addTable(table);
		}
	}
	
	// new client(s) show up
	public void onArrive(ClientsGroup group) {
		Table table = searchTableAvailable(group);
		if (table != null) {
			sitGroup(table, group);
		} else {
			groupQueue.add(group);
		}
	}

	// client(s) leave, either served or simply abandoning the queue
	public void onLeave(ClientsGroup group) {
		Table table = lookup(group);
		if (table == null) {
			groupQueue.remove(group);
		} else {
			int key = table.seatAvailable();
			restaurant.get(key).remove(table);
			table.removeGroup(group);
			group.setTable(-1);
			addTable(table);
			
			// when a client(s) leaves its table we see if any group of the queue can sit down in that table
			for (ClientsGroup groupTmp : groupQueue) {
				if (table.seatAvailable() >= groupTmp.size) {
					sitGroup(table, groupTmp);
					groupQueue.remove(groupTmp);
					return;
				}
			}
		}
	}

	// return table where a given client group is seated,
	// or null if it is still queuing or has already left
	public Table lookup(ClientsGroup group) {
		int tableHashCode = group.getTable();
		if (tableHashCode == -1) {
			return null;
		} else {
			for (Table table : listTables) {
				if (tableHashCode == table.hashCode())
					return table;
			}			
		}
		return null;
	}
	
	private void addTable(Table table) {
		int key = table.seatAvailable();
		List<Table> tables = restaurant.get(key);
		if (tables != null) {
			tables.add(table);
			restaurant.replace(key, tables);
		} else {
			restaurant.put(key, new ArrayList<Table>(Arrays.asList(table)));
		}
	}

	private void sitGroup(Table table, ClientsGroup group) {
		int key = table.seatAvailable();
		restaurant.get(key).remove(table);
		table.setClientGroup(group);
		group.setTable(table.hashCode());
		addTable(table);
	}

	private Table searchTableAvailable(ClientsGroup group) {
		int max = 0;
		for (int key : restaurant.keySet()) {
			if (key > max) {
				max = key;
			}
		}

		Table tableAux = null;
		for (int key = group.size; key <= max; key++) {
			List<Table> tables = restaurant.get(key);
			if (tables != null) {
				for (Table table : tables) {
					if (table.isEmpty()) {
						return table;
					} else if (table.seatAvailable() >= group.size) {
						tableAux = table;
					}
				}
			}
		}
		
		return tableAux;
	}
}