package com.lightshell.zen.controller;

import com.lightshell.zen.common.ResponseObject;
import com.lightshell.zen.common.SuperController;
import com.lightshell.zen.common.ZenLogin;
import com.lightshell.zen.entity.SystemUser;
import com.lightshell.zen.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/user")
public class SystemUserController extends SuperController {

    @Autowired
    private SystemUserService systemUserService;

    @PostMapping(path = "/login")
    @ResponseBody
    public ResponseObject loginYun(@RequestBody ZenLogin entity, @RequestParam("appid") String appid,
                                   @RequestParam("token") String token) {
        if (isAuthorized(appid, token)) {
            ResponseObject res = null;
            String userid, pwd, type;
            userid = entity.getUserName();
            pwd = entity.getPassword();
            type = entity.getType();
            ZenLogin login = new ZenLogin();
            try {
                SystemUser user = systemUserService.findByUserid(userid);
                if (user == null) {
                    login.setStatus("error");
                    return new ResponseObject<>("404", "此用戶不存在", login);
                }
                login.setUserName(userid);
                login.setStatus("success");
                login.setType(type);
                login.getCurrentAuthority().add("admin");
                res = new ResponseObject<>("200", "验证成功", login);
            } catch (Exception ex) {
                login.setStatus("error");
                login.setType(type);
                res = new ResponseObject<>("401", ex.getMessage(), login);
            }
            return res;
        } else {
            return new ResponseObject<>("403", "用戶认证失败", null);
        }
    }

    @GetMapping(path = "/fetch")
    @ResponseBody
    public ResponseObject fetchYun(@RequestParam("userid") String userid, @RequestParam("appid") String appid,
                                   @RequestParam("token") String token) {
        if (isAuthorized(appid, token)) {
            ResponseObject res;
            SystemUser su = systemUserService.findByUserid(userid);
            if (su != null) {
                HashMap<String, Object> yu = new HashMap<>();
                yu.put("userid", su.getUserid());
                yu.put("name", su.getUsername());
                yu.put("avatar", "https://gw.alipayobjects.com/zos/antfincdn/XAosXuNZyF/BiazfanxmamNRoxxVxka.png");
                yu.put("email", su.getEmail());
                yu.put("deptno", "开发部");
                yu.put("group", "灵犀相通");
                yu.put("title", "斗师");
                yu.put("phone", su.getPhone());
                yu.put("address", "灵溪大道");
                List<Map<String, String>> tags = new ArrayList<>();
                Map<String, String> tag;
                tag = new HashMap<>();
                tag.put("key", "0");
                tag.put("label", "系统顾问");
                tags.add(tag);
                tag = new HashMap<>();
                tag.put("key", "1");
                tag.put("label", "Java架构师");
                tags.add(tag);
                tag = new HashMap<>();
                tag.put("key", "3");
                tag.put("label", "React先行者");
                tags.add(tag);
                yu.put("tags", tags);

                try {
                    // 首页雷达图数据
                    List<Map<String, Object>> radarData = new ArrayList<>();
                    Map<String, Object> chart;

                    chart = new HashMap<>();
                    chart.put("name", "个人");
                    chart.put("label", "技术");
                    chart.put("value", 10);
                    radarData.add(chart);

                    chart = new HashMap<>();
                    chart.put("name", "个人");
                    chart.put("label", "口碑");
                    chart.put("value", 8);
                    radarData.add(chart);

                    chart = new HashMap<>();
                    chart.put("name", "个人");
                    chart.put("label", "产量");
                    chart.put("value", 4);
                    radarData.add(chart);

                    chart = new HashMap<>();
                    chart.put("name", "个人");
                    chart.put("label", "贡献");
                    chart.put("value", 5);
                    radarData.add(chart);

                    chart = new HashMap<>();
                    chart.put("name", "个人");
                    chart.put("label", "热度");
                    chart.put("value", 7);
                    radarData.add(chart);

                    chart = new HashMap<>();
                    chart.put("name", "部门");
                    chart.put("label", "技术");
                    chart.put("value", 5);
                    radarData.add(chart);

                    chart = new HashMap<>();
                    chart.put("name", "部门");
                    chart.put("label", "口碑");
                    chart.put("value", 7);
                    radarData.add(chart);

                    chart = new HashMap<>();
                    chart.put("name", "部门");
                    chart.put("label", "产量");
                    chart.put("value", 10);
                    radarData.add(chart);

                    chart = new HashMap<>();
                    chart.put("name", "部门");
                    chart.put("label", "贡献");
                    chart.put("value", 5);
                    radarData.add(chart);

                    chart = new HashMap<>();
                    chart.put("name", "部门");
                    chart.put("label", "热度");
                    chart.put("value", 2);
                    radarData.add(chart);

                    res = new ResponseObject<>("200", "success", yu);
                    res.getExtData().put("menu", null);
                    res.getExtData().put("radarData", radarData);
                    res.getExtData().put("authorization", null);

                    return res;
                } catch (Exception ex) {
                    return new ResponseObject<>("500", "系统错误", ex.getMessage());
                }
            } else {
                return new ResponseObject<>("404", "此用戶不存在", null);
            }
        } else {
            return new ResponseObject<>("403", "用戶认证失败", null);
        }
    }


}
