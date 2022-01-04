package cn.objectspace.webssh.controller;

import cn.objectspace.webssh.pojo.CmdDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.*;

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
            BufferedReader read = new BufferedReader(new InputStreamReader(in));
            System.out.println(read.readLine());
            return read.readLine();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
