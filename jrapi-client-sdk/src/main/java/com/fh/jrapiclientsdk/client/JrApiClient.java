package com.fh.jrapiclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.fh.jrapiclientsdk.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static com.fh.jrapiclientsdk.utils.SignUtils.genSign;

/**
 * 调用第三方接口的客户端
 *
 */
public class JrApiClient {

    private static final String GATEWAY_HOST = "http://localhost:8090";

    private static String accessKey;

    private static String secretKey;
    // 创建url和对应接口的映射关系
    private static HashMap<String, Function<Object,Object>> urlWithFunction;

    public JrApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    /**
     * 将各个接口的url地址和对应的函数都保存到urlWithFunction中
     */
    static {
        urlWithFunction = new HashMap<>();
        urlWithFunction.put(GATEWAY_HOST + "/api/name/user", JrApiClient::getUsernameByPost);
    }

    /**
     * 按url地址来调用对应接口
     * @param url
     * @param requestBody
     * @return
     */
    public Object getInterfaceByUrl(String url, Object requestBody){
        return urlWithFunction.get(url).apply(requestBody);
    }

    private static Map<String, String> getHeaderMap(String body) {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("accessKey", accessKey);
        // 一定不能直接发送
//        hashMap.put("secretKey", secretKey);
        hashMap.put("nonce", RandomUtil.randomNumbers(4));
        hashMap.put("body", body);
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("sign", genSign(body, secretKey));
        return hashMap;
    }

    public static String getUsernameByPost(Object user) {
        String json = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST + "/api/name/user")
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute();
        System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }
}
