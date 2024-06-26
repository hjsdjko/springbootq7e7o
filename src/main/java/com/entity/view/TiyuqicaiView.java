package com.entity.view;

import com.entity.TiyuqicaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 体育器材
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-08 15:45:47
 */
@TableName("tiyuqicai")
public class TiyuqicaiView  extends TiyuqicaiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TiyuqicaiView(){
	}
 
 	public TiyuqicaiView(TiyuqicaiEntity tiyuqicaiEntity){
 	try {
			BeanUtils.copyProperties(this, tiyuqicaiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
