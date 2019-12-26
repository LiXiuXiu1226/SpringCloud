package com.comtroller;

import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Description CustomerController
 * @Author LiXiuXiu
 * @Date 2019/12/26 上午 11:06
 */
@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    // Eureka客户端，可以获取到服务实例信息,org.springframework.cloud.client.discovery.DiscoveryClient;
    private DiscoveryClient discoveryClient;
    @Autowired
    //再启动类中声明，可以发送htpp请求
    private RestTemplate restTemplate;

    //@GetMapping("/{i}")
//    public User getUser(@PathVariable("i") Long id){
//      return restTemplate.getForObject("http://localhost:8089/user/"+id,User.class);
//   }
//    @GetMapping("/{i}")
////    public User getUser(@PathVariable("i") Long id) {
////        //获取服务列表
////        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
////        //从列表中取出一个服务实例
////        ServiceInstance serviceInstance = instances.get(0);
////        //获取id地址
////        String host = serviceInstance.getHost();
////        //获取端口号
////        int port = serviceInstance.getPort();
////        //活动的地址
////        String url="http://"+host+":"+port+"/user/"+id;
////        return restTemplate.getForObject(url,User.class);
////    }
    @GetMapping("/{i}")
    public User getUser(@PathVariable("i") Long id) {

        //活动的地址
        String url="http://user-service/user/"+id;
        return restTemplate.getForObject(url,User.class);
    }
}
