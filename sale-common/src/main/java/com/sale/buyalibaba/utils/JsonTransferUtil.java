package com.sale.buyalibaba.utils;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import io.swagger.annotations.ApiModelProperty;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author qfh
 * @Description: JSON转换器
 */
public class JsonTransferUtil {

    /**
     * 对key的汉字描述进行切割, 为了达到美观
     */
    private static final String CN_NAME_SPLIT = "[\\:|\\ |\\.|\\,]";
    /**
     * 单位缩进字符串。
     */
    private static final String SPACE = "    ";


    /**
     * 将对象的Json的英文名称转为中文名称
     * 默认返回格式化json
     *
     * @param originJson 原始json
     * @param clazz      转换类
     * @return
     */
    public static String transferObjCnName(String originJson, Class<? extends Object> clazz) {
        String newJson = objEnToCn(originJson, clazz);
        return formatJson(newJson);
    }

    /**
     * 将对象的Json的英文名称转为中文名称
     * 可指定是否进行格式化返回
     *
     * @param originJson 原始json
     * @param clazz      转换类
     * @param formatJson 是否需要进行格式化处理, 即:展开
     * @return
     */
    public static String transferObjCnName(String originJson, Class<? extends Object> clazz, boolean formatJson) {
        String newJson = objEnToCn(originJson, clazz);
        return formatJson ? formatJson(newJson) : newJson;
    }

    /**
     * 将数组的Json的英文名称转为中文名称
     * 默认返回格式化的json
     *
     * @param originJson 原始json
     * @param clazz      转换类
     * @return
     */
    public static String transferArrayCnName(String originJson, Class<? extends Object> clazz) {
        return arrayEnToCn(originJson, clazz, true);
    }

    /**
     * 将数组的Json的英文名称转为中文名称
     * 可指定是否进行格式化返回
     *
     * @param originJson 原始json
     * @param clazz      转换类
     * @param formatJson 是否需要进行格式化处理, 即:展开
     * @return
     */
    public static String transferArrayCnName(String originJson, Class<? extends Object> clazz, boolean formatJson) {
        return arrayEnToCn(originJson, clazz, formatJson);
    }


    private static String arrayEnToCn(String originJson, Class<? extends Object> clazz, boolean formatJson) {
        String newJson = null;
        try {
            if (isArray(originJson)) {
                JSONArray jsonArray = JSONUtil.parseArray(originJson);
                for (int i = 0; i < jsonArray.size(); i++) {
                    Object index = jsonArray.get(i);
                    String indexJson = arrayEnToCn(index.toString(), clazz, formatJson);
                    jsonArray.remove(i);
                    jsonArray.put(i, isBean(indexJson) ? JSONUtil.parseObj(indexJson) : indexJson);
                }
                return formatJson ? jsonArray.toStringPretty() : jsonArray.toString();
            } else {
                newJson = objEnToCn(originJson, clazz);
            }
        } catch (Exception e) {
            e.printStackTrace();
            newJson = originJson;
        }
        return newJson;
    }


    private static String objEnToCn(String json, Class<? extends Object> clazz) {
        String newJson;
        try {
            newJson = finalEnToCn(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            newJson = json;
        }
        return newJson;
    }

    private static String finalEnToCn(String json, Class<? extends Object> clazz) {
        if (!isBean(json)) {
            return json;
        }
        JSONObject jsonObject = JSONUtil.parseObj(json);
        List<Field> fieldList = new ArrayList<>();
        Class<? extends Object> tempClass = clazz;
        while (tempClass != null) {
            fieldList.addAll(Arrays.asList(tempClass.getDeclaredFields()));
            tempClass = tempClass.getSuperclass();
        }

        Field[] fields = fieldList.toArray(new Field[]{});

        for (Field field : fields) {
            String enName = field.getName();
            String cnName = null;
            if (jsonObject.containsKey(enName)) {
                ApiModelProperty apiModelProperty = field.getAnnotation(ApiModelProperty.class);
                if (apiModelProperty != null && !apiModelProperty.hidden()) {
                    cnName = apiModelProperty.value();
                    cnName = cnName.split(CN_NAME_SPLIT)[0];
                }
                if (cnName != null) {
                    Object childObj = jsonObject.get(enName);

                    if (isArray(childObj)) {
                        Type t = field.getGenericType();
                        ParameterizedType pt = (ParameterizedType) t;
                        Class arrClazz = (Class) pt.getActualTypeArguments()[0];
                        // 数组
                        JSONArray array = JSONUtil.parseArray(childObj);

                        for (int i = 0; i < array.size(); i++) {
                            String childJson = objEnToCn(array.get(i).toString(), arrClazz);
                            array.remove(i);
                            array.put(i, JSONUtil.parseObj(childJson));
                        }
                        jsonObject.putOnce(cnName, array);
                        jsonObject.remove(enName);
                    } else if (isBean(childObj)) {
                        String childJson = objEnToCn(childObj.toString(), field.getType());
                        jsonObject.putOnce(cnName, JSONUtil.parseObj(childJson));
                        jsonObject.remove(enName);
                    } else {
                        jsonObject.putOnce(cnName, childObj);
                        jsonObject.remove(enName);
                    }

                }
            }
        }
        return jsonObject.toString();
    }

    private static boolean isArray(Object obj) {
        return JSONUtil.isJsonArray(obj.toString());
    }

    private static boolean isBean(Object obj) {
        return JSONUtil.isJsonObj(obj.toString());
    }


    /**
     * 返回格式化JSON字符串。
     *
     * @param json 未格式化的JSON字符串。
     * @return 格式化的JSON字符串。
     */
    public static String formatJson(String json) {
        StringBuffer result = new StringBuffer();
        int length = json.length();
        int number = 0;
        char key = 0;
        for (int i = 0; i < length; i++) {
            key = json.charAt(i);
            if ((key == '[') || (key == '{')) {
                if ((i - 1 > 0) && (json.charAt(i - 1) == ':')) {
                    result.append('\n');
                    result.append(indent(number));
                }
                result.append(key);
                result.append('\n');
                number++;
                result.append(indent(number));
                continue;
            }
            if ((key == ']') || (key == '}')) {
                result.append('\n');
                number--;
                result.append(indent(number));
                result.append(key);
                if (((i + 1) < length) && (json.charAt(i + 1) != ',')) {
                    result.append('\n');
                }
                continue;
            }
            if ((key == ',')) {
                result.append(key);
                result.append('\n');
                result.append(indent(number));
                continue;
            }
            result.append(key);
        }
        return result.toString();
    }

    /**
     * 返回指定次数的缩进字符串。每一次缩进三个空格，即SPACE。
     *
     * @param number 缩进次数。
     * @return 指定缩进次数的字符串。
     */
    private static String indent(int number) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < number; i++) {
            result.append(SPACE);
        }
        return result.toString();
    }

}
