package main;

import java.util.ArrayList;

public interface ManagerInterface {
	public  void addItem();
	public  void delItem();
	public  ArrayList<?> getItems();
	public  boolean itemExist();
}
