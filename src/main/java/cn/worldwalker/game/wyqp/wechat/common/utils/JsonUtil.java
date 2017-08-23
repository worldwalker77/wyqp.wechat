package cn.worldwalker.game.wyqp.wechat.common.utils;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@SuppressWarnings("unchecked")
public class JsonUtil {
	
	private final static Log log = LogFactory.getLog(JsonUtil.class);
	
	private final static ObjectMapper objectMapper = new ObjectMapper();
	
	/**
     * javaBean,list,array convert to json string
     */
    public static String toJson(Object obj){
    	String result = null;
		try {
			result = objectMapper.writeValueAsString(obj);
		} catch (JsonGenerationException e) {
			log.error("obj2json JsonGenerationException error", e);
		} catch (JsonMappingException e) {
			log.error("obj2json JsonMappingException error", e);
		} catch (IOException e) {
			log.error("obj2json IOException error", e);
		}
        return result;
    }

    /**
     * json string convert to javaBean
     */
    public static <T> T toObject(String jsonStr, Class<T> clazz){
    	T result = null;
    	try {
			result = objectMapper.readValue(jsonStr, clazz);
		} catch (Exception e) {
			log.error("json2pojo Exception error", e);
		}
        return result;
    }

    /**
     * json string convert to map
     */
	public static <T> Map<String, Object> toMap(String jsonStr) {
		Map<String, Object> map = null;
		try {
			map = objectMapper.readValue(jsonStr, Map.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return map;
    }

    /**
     * json string convert to map with javaBean
     */
//    public static <T> Map<String, T> json2map(String jsonStr, Class<T> clazz)
//            throws Exception {
//        Map<String, Map<String, Object>> map = objectMapper.readValue(jsonStr,
//                new TypeReference<Map<String, T>>() {
//                });
//        Map<String, T> result = new HashMap<String, T>();
//        for (Entry<String, Map<String, Object>> entry : map.entrySet()) {
//            result.put(entry.getKey(), map2pojo(entry.getValue(), clazz));
//        }
//        return result;
//    }

    /**
     * json array string convert to list with javaBean
     */
//    public static <T> List<T> json2list(String jsonArrayStr, Class<T> clazz)
//            throws Exception {
//        List<Map<String, Object>> list = objectMapper.readValue(jsonArrayStr,
//                new TypeReference<List<T>>() {
//                });
//        List<T> result = new ArrayList<T>();
//        for (Map<String, Object> map : list) {
//            result.add(map2pojo(map, clazz));
//        }
//        return result;
//    }

    /**
     * map convert to javaBean
     */
    @SuppressWarnings("rawtypes")
	public static <T> T map2pojo(Map map, Class<T> clazz) {
        return objectMapper.convertValue(map, clazz);
    }
	
	
}
