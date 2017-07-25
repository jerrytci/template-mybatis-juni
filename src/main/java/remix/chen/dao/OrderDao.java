package remix.chen.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import remix.chen.domain.Order;

@Repository
public interface OrderDao {
	
	public int deleteOrderById(int deleteId);
	public int deleteOrderByIds(List<Integer> deleteIds);
	
	public int insertOrder(Order Order);
	public int insertOrders(List<Order> Orders);
	
//	public List<Order> selectAllOrderNR();
	public Order selectOrderById(int id);
	public Order selectOrderByIdNestedQuery(int id);
//	public Order selectOrderByIdNestedResults(int id);
	public List<Order> selectOrderByIds(List<Integer> ids);
	public List<Order> selectOrderByIdsNQ(List<Integer> ids);
//	public List<Order> selectOrderByIdsNR(List<Integer> ids);
	
	public int updateOrder(Order Order);
	public int updateOrders(List<Order> Orders);

}
