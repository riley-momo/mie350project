package model;

public class Restaurant {
	private RestaurantOwner owner ;
	private Menu menu ;
	
	public void Restaurant() {
		this.menu = new Menu();
		this.owner = new RestaurantOwner(); 
	}
	public Menu getMenu() {
		return this.menu;
	}

	public RestaurantOwner getOwner() {
		return this.owner ;
	}

	public void setMenu(Menu m){
		this.menu = m ;
	}
	
	public void setOwner(RestaurantOwner o){
		this.owner = o ;
	}
}
