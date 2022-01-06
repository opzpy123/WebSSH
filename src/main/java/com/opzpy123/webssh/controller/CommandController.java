package com.opzpy123.webssh.controller;

import com.opzpy123.webssh.pojo.ApiResponse;
import com.opzpy123.webssh.pojo.CmdDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.nio.charset.Charset;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("cmd")
public class CommandController {

    @PostMapping("/exec")
    @ResponseBody
    public ApiResponse<String> execCmd(@RequestBody CmdDTO cmd) throws IOException, InterruptedException {
//        Process process = Runtime.getRuntime().exec(new String[]{"/bin/sh", "-c", cmd.getCmd()});
        Process process = Runtime.getRuntime().exec(cmd.getCmd());
        String res = null;
        process.waitFor();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), Charset.forName("GBK")))) {
            String collect = reader.lines().collect(Collectors.joining("\n"));
            log.info(collect);
            res = collect;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResponse.ofSuccess(res);
    }
}
