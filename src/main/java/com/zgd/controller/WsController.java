package com.zgd.controller;


import com.zgd.entity.Ws;
import com.zgd.service.WsService;
import com.zgd.utils.result;
import com.zgd.vo.info;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2022-03-21
 */
@RestController
public class WsController {
    @Resource
    private WsService wsService;
//更换头像
    @PostMapping({"/update"})
    public Object updateUserPic(@RequestParam("file") MultipartFile avatorFile, @RequestParam("id") int id) throws FileNotFoundException {
        if (avatorFile.isEmpty()) {
            return result.fail();
        } else {
            String fileName = System.currentTimeMillis() + avatorFile.getOriginalFilename();
            String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "img";
            File file1 = new File(filePath);
            if (!file1.exists()) {
                file1.mkdir();
            }

            File dest = new File(filePath + System.getProperty("file.separator") + fileName);
            String storeAvatorPath = "/img/" + fileName;

            try {
                avatorFile.transferTo(dest);
                Ws ws=new Ws();
                ws.setId(id);
                ws.setPortrait(storeAvatorPath);
                boolean res = wsService.updatetx(ws);
                if (res) {
                    return result.success(storeAvatorPath);
                } else {

                    return result.fail();
                }
            } catch (IOException e) {
                return result.fail();
            }
        }
    }
//    登录
    @PostMapping("/login")
    public Object login(@RequestBody Map<String,Object> map){
        String username=map.get("username").toString();
        String password=map.get("password").toString();
        Ws ws=wsService.checklogin(username,password);
        if(ws!=null){
            return result.success(ws);
        }else{
            return result.fail();
        }


    }
//   注册
    @PostMapping("/register")
    public Object register(@RequestBody Map<String,Object> map){
        String username=map.get("username").toString();
        String password=map.get("password").toString();
        String gender=map.get("gender").toString();
        String email=map.get("email").toString();
        Ws w=new Ws();
        w.setUsername(username);
        w.setPassword(password);
        w.setEmail(email);
        w.setGender(gender);
        int num=wsService.register(w);
        if(num==1){
            return result.success();
        }else if(num==2){
            return result.fail(300,"用户重复！");
        }else{
            return result.fail();
        }

    }
//    个人信息修改
    @PostMapping("/setInfo")
    public Object setInfo(@RequestBody info i){
        return wsService.updateinfo(i)?result.success():result.fail();
    }
//    获取个人数据
    @PostMapping("/getdata")
    public Object getdata(@RequestBody Map<String,Integer> map){
        int id=map.get("id");
        return wsService.getById(id);
    }
}
