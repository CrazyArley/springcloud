package cn.wengzi.feignclient;

import cn.wengzi.config.DisableHystrixConfiguration;
import cn.wengzi.entity.Student;
import cn.wengzi.logger.InfoFeignLogger;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author wengzi
 * @date 2019/10/27 noon 12:05
 * @description 声明式接口, Feign 声明式服务调用
 * 如果需要回退方法打印错误信息，可以使用fallbackFactory(fallback和fallbackFactory只能使用其中一种)
 * configuration:
 *      InfoFeignLogger.class:配置feign请求日志打印,还需再yml中声明包
 *      DisableHystrixConfiguration.class:关闭Hystrix
 */
@FeignClient(name= "server-provider", path = "/student", configuration = {InfoFeignLogger.class, DisableHystrixConfiguration.class})
public interface FeignProviderClient {

    @GetMapping("/findAll")
    public Collection<Student> findAll();

    @GetMapping("/findById/{id}")
    Student findById(@PathVariable("id") Long id);

    @PostMapping("/save")
    void save(@RequestBody(required = true) Student student);

    @PutMapping("/upd")
    void upd(@RequestBody(required = true) Student student);

    @DeleteMapping("/deleteById/{id}")
    void deleteById(@PathVariable("id") Long id);

    @GetMapping("/getPort")
    String getPort();
}
