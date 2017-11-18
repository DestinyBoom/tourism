package com.xawl.tourism.controller;

import com.xawl.tourism.utils.Result;
import com.xawl.tourism.utils.ucpaas.Res;
import com.xawl.tourism.utils.ucpaas.rest.client.JsonReqClient;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.regex.Pattern;


@Controller
@RequestMapping("/SendMessage")
public class SendMessageController {

	/**
	 * 注册发送验证码
	 * @param to
	 * @return
     */
	@GetMapping("/registCode.action")
	@ResponseBody
	public Result RegistMessage(String to){//to:发送的手机号

		Pattern phoneRex = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
		if(to == null || to == ""){
			return Result.fail(201, "手机号不能为空");
		}
		if (!phoneRex.matcher(to).matches()){
			return Result.fail(202, "手机号格式错误！");
		}

		//账户id
		String accountSid="d13972dfc25634bc5fb182a279592f87";
		//账户token
		String token="cd5fb91698643800eac25b22a05e6e76";
		//应用的id
		String appId="0b0a2680a2394c9d9d4e0e0474ceafcf";
		//模板的id
		String templateId="233461";

		int param = (int) (Math.random() * 1000000);

		//调用接口发送消息，并接受返回结果
		String result = new JsonReqClient()
			.templateSMS(accountSid, token, appId, templateId, to, String.valueOf(param));
		System.out.println("Response content is: " + result);

		//把json转为bean
		JSONObject jsonObject= JSONObject.fromObject(result);
		Res res=(Res)JSONObject.toBean(jsonObject, Res.class);

		//判断是否发送成功，并向前端返回结果
		if(res.getResp().getRespCode().equals("000000")){
			return Result.success("消息发送成功", String.valueOf(param));
		}else{		
			return Result.fail(500, "消息发送失败");
		}
	}
}
