package com.zb.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016102500759674";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCgQ0cFgpIdgPEry1bCTbbL+OWneON7OeIGMz51Xa0xrsgdH7OBdnE4fpVeakY775z+TAvNjcK86K8aPGvU1huZ2ldOyBGBRFEpeCJB6aeQOC60xWQq2gH3ZT8zsbV7Z8vQCtUj/irJJlmTh/+nuIoVZPUaoMCPANbnlwHEn5tJ9VBJ5JRq85laDK0PJUfgRTsT8svUjO22i1RPMRuBjZ4h2NRvNMgZEuy4tv9VR8Zbjb7DPS0rHrJRgnTVOF/qiGF6wn6rZB0y/J0jivpAdHFR4EFF4da3uclX1MH5YLprM73ckZaT/L2oB5sdBcfBBbKlw9cynwfKYPKc+mgN7mvJAgMBAAECgf9Lv4DSGeT2DPvwtytKq3C69+mUPo9GrxUl2RKsZpp14Sa0nUc66cCZ8zqmZZTMv3R0vXzWqypgH5qjy+srrgddsNWTZvzfHGtALogCn22TvPpWdvXhSymixTgaNuSQb37l1jjnyjpu2LF+CcnMfGzHr/AppdFdxgfNbpJnXQkI6yWETVtARFKd0POaipDRlrC/8cCRmM2iwZ1rQAmyqi8SiQkg7Uk6hCOqcSIcyNykfUdBzkqpS22oVvSu6Dy/mfXOc00dsoS/iUX7abs7l9+/CwUbU8EsaB73VL01RA7fBUYEZDieVNSFpUTzk1fmiz+jVMz/EyUGLWYNZK513wECgYEA/qexfSMWvhCniWXnxpN9YKeo4dYtp4DLxvAkQx/NNqjX/PMEWf6YJSOHRpUacFE3eE+3isQREVv2WuJDaxICLfKHnWAXt9nrPRNYw1buzXBEwdTupq9bkvUz/sV46PSVAl2mDbRsQJmYkk+OZiZGOslTTBhJK4CVNpo2ON//RmkCgYEAoRv2APQIEoqwGk9WiQBJ8xhu70FWBj8kk1j9EZ2ezZUaAGT+5ED7DyG1b6TYwyc2tQEYkpq0lF21HiHKz33j6J6iUlf+41jztbXibI3cKHPEMNfiji4cALQvI2JwxphOB5TJLeCC2Fd6DeLzlX1d1JEpy/8YNPBBUb1jbNgjDmECgYEAubYt2CaoxT98DtWEa+rPupdKsDfz334sHg6vQ0yD6eLEcTIA8GidKCh61NyUBWkVXOY14jsOf2xjgvATXpgpgrymbfzQD0IbLdVYHEzfpm7Dld/lkyW7ULcFjj0Q6kLEEI+fM8tqTso03C6smI49FU4RMyNa6SDCsKlR9bRVhFECgYA2Ve7O/X6nejzQcseVpxJJuYjYimmP68XTKCUZxtYjMdE2JtnMc5n4zX6aq7crglMyEq+N6j1S+JO4GN+EwUmXT8EhEmp1lK+FLlWyFNoWjoyxiG3xU92/4wUu4ul0ITPX3LdJELowarhQbKWIWmLF6Tt2gI9Sc2EkR0J8GB0ioQKBgQCF+0xY12DsdEVOGEvxrJKKbqolWdE2bBwmkXE73sKcxxi+V7nFF4jE1xDFhZunqDSAIjlzFsLsjuro2/Eo5d6G5xTiMNhbRyMnq6Taii0hIqFpTUy3GXJ1ck7c41GbIu+CDJ4R+LskPXaI9cSlxHAA/BmZ2KvClpXIaBseTAN6WA==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoENHBYKSHYDxK8tWwk22y/jlp3jjezniBjM+dV2tMa7IHR+zgXZxOH6VXmpGO++c/kwLzY3CvOivGjxr1NYbmdpXTsgRgURRKXgiQemnkDgutMVkKtoB92U/M7G1e2fL0ArVI/4qySZZk4f/p7iKFWT1GqDAjwDW55cBxJ+bSfVQSeSUavOZWgytDyVH4EU7E/LL1IzttotUTzEbgY2eIdjUbzTIGRLsuLb/VUfGW42+wz0tKx6yUYJ01Thf6ohhesJ+q2QdMvydI4r6QHRxUeBBReHWt7nJV9TB+WC6azO93JGWk/y9qAebHQXHwQWypcPXMp8HymDynPpoDe5ryQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "localhost:8080/yonghe_project/paysuccess";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "localhost:8080/yonghe_project/paysuccess.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

