package remix.chen.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import remix.chen.domain.Order;

@Repository
public interface OrderService {
	
	//insert
	public int insertOrder(Order Order);
	public int insertOrders(List<Order> Orders);
	public void insertOrderRelate(Order Order);
	public void insertOrdersRelate(List<Order> Orders);
	
	//select
//	public List<Order> selectAllOrderNR();
	
	//update
	public int updateOrder(Order Order);
	public int updateOrders(List<Order> Orders);
}
