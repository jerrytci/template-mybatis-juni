package remix.chen.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import remix.chen.domain.Order;
import remix.chen.service.OrderService;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service
public class OrderServiceImpl implements OrderService {
	
	@Resource
	private OrderService orderService;

	public int insertOrder(Order Order) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertOrders(List<Order> Orders) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void insertOrderRelate(Order Order) {
		// TODO Auto-generated method stub
		
	}

	public void insertOrdersRelate(List<Order> Orders) {
		// TODO Auto-generated method stub
		
	}

	public int updateOrder(Order Order) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateOrders(List<Order> Orders) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
