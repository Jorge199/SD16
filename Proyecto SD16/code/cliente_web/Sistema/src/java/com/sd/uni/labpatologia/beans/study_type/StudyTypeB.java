package com.sd.uni.labpatologia.beans.study_type;

/**
 * @author Alex Jiñes
 */

import com.sd.uni.labpatologia.beans.base.BaseBean;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
public class StudyTypeB extends BaseBean{

    private static final long serialVersionUID = 1L;
    private String _name;
    private String _description;
    
    public StudyTypeB(Map<String, String> params){
	super(params);
    }
    
    public String getName(){
        return _name;
    }
    
    public void setName(String name){
        _name = name;
    }
    
    public String getDescription(){
        return _description;
    }
    
    public void setDescription(String description){
        _description = description;
    }
    
    @Override
    protected void create(Map<String, String> params) {
        if (!StringUtils.isBlank(params.get("id"))) {
            setId(Integer.valueOf(params.get("id")));
	}
	setName(params.get("name"));
	setDescription(params.get("description"));
    }

}
