package com.opzpy123.webssh.controller;

import com.opzpy123.webssh.config.SshConfig;
import com.opzpy123.webssh.pojo.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class RouterController {

    @Resource
    private SshConfig sshConfig;

    @RequestMapping("/")
    public String websshpage() {
        return "webssh";
    }

    @ResponseBody
    @GetMapping("/config/ssh")
    public ApiResponse<SshConfig> getSshConfig() {
        return ApiResponse.ofSuccess(sshConfig);
    }
}
