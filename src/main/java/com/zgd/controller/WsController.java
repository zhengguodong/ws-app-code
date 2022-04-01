package com.zgd.controller;


import com.zgd.entity.Ws;
import com.zgd.service.WsService;
import com.zgd.utils.result;
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
@RequestMapping
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
        return 1;

    }
}
