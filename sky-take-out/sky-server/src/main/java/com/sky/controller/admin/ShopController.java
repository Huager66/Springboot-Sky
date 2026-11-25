package com.sky.controller.admin;

import com.sky.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController("adminShopController")
@RequestMapping("/admin/shop")
public class ShopController {
    public static final String Key = "SHOP_STATUS";
    @Autowired
    private RedisTemplate redisTemplate;
    @PutMapping ("/{status}")
    public Result setStatus( @PathVariable Integer status) {
        log.info("修改店铺状态为：{}", status);
        redisTemplate.opsForValue().set(Key, status);
        return Result.success();
    }
    @GetMapping("/status")
    public Result<Integer> getStatus() {
        Integer status = (Integer) redisTemplate.opsForValue().get(Key);
        log.info("获取店铺状态：{}", status);
        return Result.success(status);
    }
}
