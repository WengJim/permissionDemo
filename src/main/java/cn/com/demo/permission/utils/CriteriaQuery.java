package cn.com.demo.permission.utils;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import tk.mybatis.mapper.entity.Example;

public class CriteriaQuery {

    /**
     * 模糊查询
     * @param param
     * @param criteria
     * @return
     */
    public static  Example.Criteria likeTo(Object param, Example.Criteria criteria) {
        MetaObject metaObject = SystemMetaObject.forObject(param);
        String[] properties = metaObject.getGetterNames();
        String[] varPropertie = properties;
        for(int i = 0; i < properties.length; ++i) {
            String property = varPropertie[i];
            Object value = metaObject.getValue(property);
            if (value != null) {
                criteria.andLike(property,"%"+String.valueOf(value)+"%");
            }
        }
        return criteria;
    }
}
