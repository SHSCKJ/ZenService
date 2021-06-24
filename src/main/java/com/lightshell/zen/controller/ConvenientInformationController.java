package com.lightshell.zen.controller;

import java.util.List;
import java.util.Map;

import com.lightshell.zen.common.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.lightshell.zen.common.AbstractController;
import com.lightshell.zen.common.ResponseData;
import com.lightshell.zen.entity.ConvenientInformation;
import com.lightshell.zen.service.ConvenientInformationServiceImpl;

/**
 * @author kevindong
 */
@Controller
@RequestMapping(path = "/v1/convenient-information")
public class ConvenientInformationController extends AbstractController {

    @Autowired
    private ConvenientInformationServiceImpl convenientInformationServiceImpl;

    @GetMapping(path = "/pagination/{f}/{s}")
    @ResponseBody
    public ResponseData findAll(@PathVariable String f,
        @MatrixVariable(pathVar = "f", required = false) Map<String, Object> filters, @PathVariable String s,
        @MatrixVariable(pathVar = "s", required = false) Map<String, String> sorts,
        @RequestParam("offset") Integer offset, @RequestParam("pageSize") Integer pageSize,
        @RequestParam("appid") String appid, @RequestParam("token") String token) {
        if (isAuthorized(appid, token)) {
            ResponseData res;
            try {
                List<ConvenientInformation> data =
                    convenientInformationServiceImpl.findAll(filters, offset, pageSize, sorts);
                long cnt = convenientInformationServiceImpl.getCount();
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
    @PostMapping()
    @ResponseBody
    public ResponseMessage add(@RequestBody ConvenientInformation entity,@RequestParam String appid
            , @RequestParam String token) {
        try {
            convenientInformationServiceImpl.save(entity);
            return new ResponseMessage("201","新增成功");
        } catch (Exception ex) {
            return new ResponseMessage("500",ex.getMessage());
        }
    }

}
