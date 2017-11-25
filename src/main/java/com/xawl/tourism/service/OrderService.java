package com.xawl.tourism.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xawl.tourism.dao.OrderMapper;
import com.xawl.tourism.dao.UserTicketMapper;
import com.xawl.tourism.pojo.Order;
import com.xawl.tourism.pojo.OrderVo;
import com.xawl.tourism.pojo.UserTicket;
import com.xawl.tourism.pojo.UserTicketList;
import com.xawl.tourism.utils.Result;
import com.xawl.tourism.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.Date;
import java.util.List;

/**
 * Created by DT on 2017/11/17.
 */
@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    DataSourceTransactionManager transactionManager;
    @Autowired
    UserTicketMapper userTicketMapper;

    public Result findOrder(Order order, Integer page, Integer num) {
        try {
            PageHelper.startPage (page, num);
            List<Order> list = orderMapper.select (order);
            PageInfo<Order> pageInfo = new PageInfo<Order> (list);
            return Result.success (pageInfo);
        } catch (Exception e) {
            e.printStackTrace ();
            return Result.fail ("查询失败");
        }
    }

    public Result createOrder(String uid, String bid, UserTicketList userTickets, float totalprice) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition ();
        def.setPropagationBehavior (TransactionDefinition.PROPAGATION_REQUIRES_NEW); // 事物隔离级别，开启新事务，这样会比较安全些。
        TransactionStatus status = transactionManager.getTransaction (def); // 获得事务状态
        try {
            OrderVo orderVo = new OrderVo ();
            Order order = new Order ();
            order.setStatus ((short) 0);//默认订单未付款0
            order.setBid (bid);
            order.setCreateTime (new Date ());
            String oid = UUIDUtils.createUUID ();
            order.setOid (oid);//生成订单号
            order.setUid (uid);
            order.setTotalprice (totalprice);
            orderVo.setOrder (order);
            orderMapper.insertSelective (order);
            for (UserTicket userTicket : userTickets.getUserTicket ()) {
                userTicket.setOid (oid);
                userTicket.setIsUse (false);
                userTicket.setCode (UUIDUtils.createUUID ());
                //userTicket.setUseTime (new Date ());
                userTicket.setUseDate (new Date ());
                userTicketMapper.insertSelective (userTicket);
            }
            orderVo.setUserTicketLists (userTickets.getUserTicket ());
            transactionManager.commit (status);
            return Result.success (orderVo);
        } catch (Exception e) {
            e.printStackTrace ();
            transactionManager.rollback (status);
            return Result.fail ("创建订单失败");
        }
    }

    public Result payOrder(String oid) {
        try {
            Order order = new Order ();
            order.setOid (oid);
            order.setStatus ((short) 1);
            order.setPayTime (new Date ());
            System.out.println (order);
            orderMapper.updateByPrimaryKeySelective (order);
            return Result.success ("支付成功");
        } catch (Exception e) {
            e.printStackTrace ();
            return Result.fail ("支付失败");
        }
    }
}
