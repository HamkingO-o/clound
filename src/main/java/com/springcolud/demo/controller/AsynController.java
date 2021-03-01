package com.springcolud.demo.controller;

import com.springcolud.demo.service.AsynService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class AsynController {

    @Autowired
    private AsynService asynService;
    @GetMapping("/open/somthing")
    @SneakyThrows
    public String something() throws InterruptedException {
        CompletableFuture<String> createOrder = asynService.doSomething1("create order");
        CompletableFuture<String> reduceAccount = asynService.doSomething2("reduce account");
       // CompletableFuture<String> saveLog = asynService.doSomething3("save log");

        // 等待所有任务都执行完
        CompletableFuture.allOf(createOrder, reduceAccount).join();
        // 获取每个任务的返回结果
        String result = createOrder.get() + reduceAccount.get() ;
        return result;
    }
}
