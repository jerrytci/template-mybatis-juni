package remix.chen.dao.impl;

import org.springframework.stereotype.Repository;
import remix.chen.dao.OrderDao;
import remix.chen.domain.Order;

import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao{

	@Override
	public int deleteOrderById(int deleteId) {
		return 0;
	}

	@Override
	public int deleteOrderByIds(List<Integer> deleteIds) {
		return 0;
	}

	@Override
	public int insertOrder(Order Order) {
		return 0;
	}

	@Override
	public int insertOrders(List<Order> Orders) {
		return 0;
	}

	@Override
	public Order selectOrderById(int id) {
		return null;
	}

	@Override
	public Order selectOrderByIdNestedQuery(int id) {
		return null;
	}

	@Override
	public List<Order> selectOrderByIds(List<Integer> ids) {
		return null;
	}

	@Override
	public List<Order> selectOrderByIdsNQ(List<Integer> ids) {
		return null;
	}

	@Override
	public int updateOrder(Order Order) {
		return 0;
	}

	@Override
	public int updateOrders(List<Order> Orders) {
		return 0;
	}
}
