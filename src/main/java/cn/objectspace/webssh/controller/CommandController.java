package cn.objectspace.webssh.controller;

import cn.objectspace.webssh.pojo.CmdDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Controller
@RequestMapping("cmd")
public class CommandController {
    InputStream in = null;

    @PostMapping("/exec")
    @ResponseBody
    public String execCmd(@RequestBody CmdDTO cmd) {
        System.out.println(cmd);
        try {
            Process pro = Runtime.getRuntime().exec(cmd.getCmd());
            pro.waitFor();
            in = pro.getInputStream();
            BufferedReader read = new BufferedReader(new InputStreamReader(in, "GBK"));
            StringBuilder sb = new StringBuilder();
            sb.append("命令执行结果:\n");
            while (read.ready()) {
                String s = read.readLine();
                sb.append(s);
                System.out.println(s);
            }
            return sb.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
