package com.tktick.controller.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tktick.annotation.Permission;
import com.tktick.annotation.Validator;
import com.tktick.bean.entity.TkDeliver;
import com.tktick.bean.entity.TkSetKeeper;
import com.tktick.bean.enums.ResultMessageEnum;
import com.tktick.bean.model.ResultModel;
import com.tktick.service.TkDeliverService;
import com.tktick.service.TkSetKeeperService;

/**
 * 投递记录控制器
 * @author user
 *
 */
@RestController
@RequestMapping("/deli")
public class DeliverController extends WebBaseController {
	
	@Autowired
	private TkDeliverService deliverService;
	@Autowired
	private TkSetKeeperService keeperService;
	/**
	 * 审核投递
	 * @param name
	 * @return
	 */
	@RequestMapping("/audit.json")
	@Permission
	@Validator
	public ResultModel audit(@Valid TkDeliver deliver, BindingResult binding){
		//审核:当前用户必须是该合集的管理员
		Integer uid = getCurrentUser().getUserId();
		TkSetKeeper keeper = new TkSetKeeper();
		keeper.setSetId(deliver.getSetId());
		keeper.setUserId(uid);
		ResultModel model = new ResultModel();
		if(keeperService.query(keeper) == null)//当前用户不是该合集的管理员不能审核
			model = new ResultModel(ResultMessageEnum.OPTION_FORBIDDEN);
		
		if(!deliverService.modify(deliver))//修改失败
			model = new ResultModel(ResultMessageEnum.OPTION_EXCEPTION);
		return model;
	}
}
