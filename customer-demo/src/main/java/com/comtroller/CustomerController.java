package com.comtroller;

import com.client.UserClient;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description CustomerController
 * @Author LiXiuXiu
 * @Date 2019/12/26 上午 11:06
 */
//@DefaultProperties(defaultFallback = "defaultFallback")
@RestController
@RequestMapping("customer")
public class CustomerController {
    //@Autowired
    // Eureka客户端，可以获取到服务实例信息,org.springframework.cloud.client.discovery.DiscoveryClient;
    // private DiscoveryClient discoveryClient;
    @Autowired
    //再启动类中声明，可以发送htpp请求
    //Feign中已经自动集成了Ribbon负载均衡，因此我们不需要自己定义RestTemplate了
    private RestTemplate restTemplate;
    //@Autowired
   // private UserClient userClient;

    /*    @GetMapping("/{i}")
        public User getUser(@PathVariable("i") Long id){
          return restTemplate.getForObject("http://localhost:8089/user/"+id,User.class);
       }*/
/*    @GetMapping("/{i}")
   public User getUser(@PathVariable("i") Long id) {
       //获取服务列表
       List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
      //从列表中取出一个服务实例
       ServiceInstance serviceInstance = instances.get(0);
       //获取id地址
       String host = serviceInstance.getHost();
       //获取端口号
       int port = serviceInstance.getPort();
        //活动的地址
       String url="http://"+host+":"+port+"/user/"+id;
        return restTemplate.getForObject(url,User.class);
    }*/
/*    @GetMapping("/{i}")
    public User getUser(@PathVariable("i") Long id) {
        //活动的地址
        String url="http://user-service/user/"+id;
        return restTemplate.getForObject(url,User.class);
    }*/
/*第一种
 @GetMapping("/{i}")
    //用来声明一个降级逻辑的方法
   @HystrixCommand(fallbackMethod = "queryByIdFallback")
    public String getUser(@PathVariable("i") Long id) {
        //活动的地址
        String url = "http://user-service/user/" + id;
        return restTemplate.getForObject(url, String.class);
    }*/
//第二种
  /*  @GetMapping("/{i}")
    //用来声明一个降级逻辑的方法
    @HystrixCommand
    public String getUser(@PathVariable("i") Long id) {
        //活动的地址
        String url = "http://user-service/user/" + id;
        return restTemplate.getForObject(url, String.class);
    }
    //当发生失败，因为熔断的降级逻辑方法必须跟正常逻辑方法保证：相同的参数列表和返回值声明
    public String defaultFallback(){
        return "不好意思，服务器太拥挤了1";
    }*/
    @GetMapping("/{i}")
    public User getUser(@PathVariable("i") Long id) {
       // return userClient.queryUserById(id);
        //活动的地址
        String url = "http://user-service/user/" + id;
        return restTemplate.getForObject(url, User.class);
    }
}
