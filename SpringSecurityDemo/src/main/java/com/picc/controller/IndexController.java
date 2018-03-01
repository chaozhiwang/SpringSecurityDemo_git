/*package com.picc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.picc.tree.Tree;
import com.picc.util.ReqResult;
import com.picc.util.ReqResultUtil;



@Controller
@RequestMapping("/user2")
public class IndexController {

	@RequestMapping(value = "/findindex")
	public ModelAndView findindex(HttpServletRequest request) {
		ModelAndView view = new ModelAndView("/user.html");
		return view;
	}

	@RequestMapping(value = "/mylist", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public Object mylist() {
		
		
		List<Tree> trees = new ArrayList<Tree>();
		Tree t1 = new Tree();
		t1.setId("_authority_5");
		t1.setParentId("0");
		t1.setText("用户管理");
		t1.setUrl("/user/findindex.do");
		
		
		Tree t2 = new Tree();
		t2.setId("_authority_6");
		t2.setParentId("0");
		t2.setText("角色管理");
		t2.setUrl("/user/findindex.do");
		
		
		Tree t3 = new Tree();
		t3.setId("_authority_7");
		t3.setParentId("0");
		t3.setText("模块管理");
		t3.setUrl("/user/findindex.do");
		
		trees.add(t1);
		trees.add(t2);
		trees.add(t3);
		return trees;
	}
	
	@RequestMapping(value="/list", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
	public ResponseEntity<String> list(){
		ReqResult rst = new ReqResult();
		try{

			List<Tree> trees = new ArrayList<Tree>();
			Tree t1 = new Tree();
			t1.setId("_authority_5");
			t1.setParentId("0");
			t1.setText("用户管理");
			t1.setUrl("views/addressForm.html");
			
			
			Tree t2 = new Tree();
			t2.setId("_authority_6");
			t2.setParentId("0");
			t2.setText("角色管理");
			t2.setUrl("/rb_unsolved_manager2/scheduleJobList.html");
			
			
			Tree t3 = new Tree();
			t3.setId("_authority_7");
			t3.setParentId("0");
			t3.setText("模块管理");
			t3.setUrl("views/personForm.html");
			
			trees.add(t1);
			trees.add(t2);
			trees.add(t3);
			rst.setResultCode(1000);
			rst.setReturnObject(trees);
		}catch(Exception e){
			rst.setResultCode(ReqResult.resultCode_error);
			rst.setReturnObject("删除流量充值订单异常");
		}
		
		return ReqResultUtil.genResultResponse(rst);
	}
	
}
*/