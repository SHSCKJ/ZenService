package com.lightshell.zen.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.lightshell.zen.common.ResponseData;
import com.lightshell.zen.common.SuperController;
import com.lightshell.zen.entity.ConvenientInformation;
import com.lightshell.zen.service.ConvenientInformationService;

/**
 * @author kevindong
 */
@Controller
@RequestMapping(path = "/v1/convenient-information")
public class ConvenientInformationController extends SuperController {

    @Autowired
    private ConvenientInformationService convenientInformationService;

    @GetMapping(path = "/pagination/{f}/{s}")
    @ResponseBody
    public ResponseData findAll(@PathVariable String f, @MatrixVariable(pathVar = "f") Map<String, Object> filters,
        @PathVariable String s, @MatrixVariable(pathVar = "s") Map<String, String> sorts,
        @RequestParam("offset") Integer offset, @RequestParam("pageSize") Integer pageSize,
        @RequestParam("appid") String appid, @RequestParam("token") String token) {
        if (isAuthorized(appid, token)) {
            ResponseData res;
            try {
                List<ConvenientInformation> data = convenientInformationService.findAll(offset, pageSize);
                long cnt = convenientInformationService.getCount();
                res = new ResponseData<>("200", "success");
                res.setData(data);
                res.setCount(cnt);
                return res;
            } catch (Exception ex) {
                return new ResponseData<>("500", ex.getMessage());
            }
        } else {
            return new ResponseData<>("403", "用戶认证失败");
        }
    }

}
