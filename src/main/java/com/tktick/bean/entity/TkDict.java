package com.tktick.bean.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.tktick.bean.model.TreeModel;

/**
 * 字典表
 * @author user
 *
 */
@Entity
@Table(name = "tk_dict")
public class TkDict extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@Id
	private String dictNo;
	private String dictFno;
	private String dictNm;
	private String dictDesc;
	private Short dictState;
	private Integer dictSeq;
	private String dictIcon;
	private String dictPar;
	
	/**
	 * 获取树形结构数据
	 * @param list
	 * @param fno
	 * @return
	 */
	public static List<TreeModel> listToTree(List<TkDict> list, String fno){
		if(fno == null)
			return null;
		List<TreeModel> res = new ArrayList<TreeModel>();
		TreeModel model = null;
		for (TkDict dict : list) {
			if(fno == null){
				if(StringUtils.isNotEmpty((String) dict.getDictFno()))//这是一级菜单
					continue;
			}else{
				if(!fno.equals(dict.getDictFno()))
					continue;
			}
			model = new TreeModel();
			model.setId(dict.getDictNo());
			model.setText(dict.getDictNm());
        	model.setChildren(listToTree(list, dict.getDictNo()));
        	res.add(model);
		}
		return res;
	}
	
	public String getDictNo() {
		return dictNo;
	}
	public void setDictNo(String dictNo) {
		this.dictNo = dictNo;
	}
	public String getDictFno() {
		return dictFno;
	}
	public void setDictFno(String dictFno) {
		this.dictFno = dictFno;
	}
	public String getDictNm() {
		return dictNm;
	}
	public void setDictNm(String dictNm) {
		this.dictNm = dictNm;
	}
	public String getDictDesc() {
		return dictDesc;
	}
	public void setDictDesc(String dictDesc) {
		this.dictDesc = dictDesc;
	}
	public Short getDictState() {
		return dictState;
	}
	public void setDictState(Short dictState) {
		this.dictState = dictState;
	}
	public Integer getDictSeq() {
		return dictSeq;
	}
	public void setDictSeq(Integer dictSeq) {
		this.dictSeq = dictSeq;
	}
	public String getDictIcon() {
		return dictIcon;
	}
	public void setDictIcon(String dictIcon) {
		this.dictIcon = dictIcon;
	}
	public String getDictPar() {
		return dictPar;
	}
	public void setDictPar(String dictPar) {
		this.dictPar = dictPar;
	}

	public static void main(String[] args) {
		List<TkDict> dicts = new ArrayList<>();
		TkDict dict = new TkDict();
		dict.setDictNo("D001");
		dict.setDictNm("01");
		dicts.add(dict);
		dict = new TkDict();
		dict.setDictNo("D00101");
		dict.setDictNm("0101");
		dict.setDictFno("D001");
		dicts.add(dict);
		dict = new TkDict();
		dict.setDictNo("D00102");
		dict.setDictNm("0102");
		dict.setDictFno("D001");
		dicts.add(dict);
		
		System.err.println(JSON.toJSONString(listToTree(dicts, "D001")));
	}
}
