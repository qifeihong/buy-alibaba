package com.sale.buyalibaba.aliyun;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 * @Auther: qfh
 * @Date: 2022/5/6 17:10
 * @Description:
 */
public class ChatbotService {

    public static void main(String[] args) throws Exception {
        String accountAccessAK = "LTAI5tJQ53A9Am2LkQfVqiaX";
        String accountAccessSK = "y2BNjXBhfIbUtM1wR1O8uOLpvWS0QN";
        String popRegion = "cn-shanghai";
        String popProduct = "Chatbot";
        String popDomain = "chatbot.cn-shanghai.aliyuncs.com";
        DefaultProfile.addEndpoint(popRegion, popProduct, popDomain);
        IClientProfile profile = DefaultProfile.getProfile(popRegion, accountAccessAK, accountAccessSK);
        DefaultAcsClient client = new DefaultAcsClient(profile);
        //固定入参
        CommonRequest commonRequest = new CommonRequest();
        commonRequest.setSysProduct("Chatbot");
        commonRequest.setSysMethod(MethodType.GET);
        //根据API会有变化
        commonRequest.setSysAction("Chat");
        commonRequest.setSysVersion("2017-10-11");
        commonRequest.putQueryParameter("Utterance", "你好");
        //机器人id
        commonRequest.putQueryParameter("InstanceId", "chatbot-cn-BYfUJvqEfa");
        CommonResponse commonResponse = client.getCommonResponse(commonRequest);
        System.out.println(commonResponse.getData());
    }

//    public static void main(String[] args) {
//        ChatbotUtil chat;
//        static{
//            /*
//             * 参数说明
//             * accessKeyId 阿里云的 Access Key Id
//             * accessKeySecret 阿里云的 Access Key Secret
//             * chatbotUrl 云小蜜接口地址，传入如： https://chatbot.cn-shanghai.aliyuncs.com/   如果不懂，固定传入这个url即可
//             * chatbotInstanceId 云小蜜的机器人ID，如： chatbot-cn-1234567890 。机器人实例ID。登录云小蜜控制台，左侧面板选择开发者->基本配置，查看机器人示例信息，可获得该实例ID。
//             */
//            chat = new ChatbotUtil("LTA1234567890", "dTuD12345678901234567890", "https://chatbot.cn-shanghai.aliyuncs.com/", "chatbot-cn-1234567890");
//        }
//        public static void main(String[] args) throws IOException {
//
//            //chat创建后，可多次使用
//            System.out.println(chat.question("你好").getText());
//            System.out.println(chat.question("发票").getText());
//
//        }
//    }


}
