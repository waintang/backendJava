package com.example.practice.web.generic.controller;


import com.huaweicloud.sdk.core.auth.ICredential;
import com.huaweicloud.sdk.core.auth.BasicCredentials;
import com.huaweicloud.sdk.core.exception.ConnectionException;
import com.huaweicloud.sdk.core.exception.RequestTimeoutException;
import com.huaweicloud.sdk.core.exception.ServiceResponseException;
import com.huaweicloud.sdk.functiongraph.v2.region.FunctionGraphRegion;
import com.huaweicloud.sdk.functiongraph.v2.*;
import com.huaweicloud.sdk.functiongraph.v2.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuaweiFuncController {

    // app_user01   S9DOXWK1IY5DQGUCOMTY   AnMDxKUM9vM3Z6KPmhm3DETugVHaz105vr1sAQV5
    // hw_008615386046280_01	UWS8JPL2PFSQEO4ZUXJB	zoXyTxuwgxi1QwkEbFhLfvgjFFt1rBucNWLvjn6J
    public static void main(String[] args) {
        String ak = "UWS8JPL2PFSQEO4ZUXJB";
        String sk = "zoXyTxuwgxi1QwkEbFhLfvgjFFt1rBucNWLvjn6J";

        ICredential auth = new BasicCredentials()
                .withAk(ak)
                .withSk(sk);

        FunctionGraphClient client = FunctionGraphClient.newBuilder()
                .withCredential(auth)
                .withRegion(FunctionGraphRegion.valueOf("cn-east-3"))
                .build();
        InvokeFunctionRequest request = new InvokeFunctionRequest();


//        CreateEventRequest eventRequest = new CreateEventRequest();
//        eventRequest.withFunctionUrn("urn:fss:cn-east-3:0cd9d5cd9100f4be2f4ac01958a78834:function:default:TWP_DealFile:latest");
//        CreateEventRequestBody eventBody = new CreateEventRequestBody();
////        eventBody.setContent("{'a':'a1','b':'b1'}");
//        eventBody.setContent("asagfasdfdsfasdf");
//        eventRequest.withBody(eventBody);
//        CreateEventResponse eventResponse = client.createEvent(eventRequest);
//        System.out.println(eventResponse.toString());

//        request.withFunctionUrn("urn:fss:<region>:<project_id>:function:default:<func_name>:<version>");
//        request.withFunctionUrn("urn:fss:cn-east-3:576cf8cfd5e84a99bcc6fc5f1b55161c:function:default:TWP_DealFile:latest");
        request.withFunctionUrn("urn:fss:cn-east-3:0cd9d5cd9100f4be2f4ac01958a78834:function:default:TWP_DealFile:latest");
        Map<String,Object> reqInfo = new HashMap<>();
        reqInfo.put("targetFileKey","targetFileKey.zip");
        List<String> srcFileKeys = new ArrayList<>();
        srcFileKeys.add("oc-base/(SK4h6fYhblg=)软件销售服务合同-模板的副本.docx");
        reqInfo.put("srcFileKeys",srcFileKeys);
        request.setBody(reqInfo);
        try {
            InvokeFunctionResponse response = client.invokeFunction(request);
            System.out.println(response.toString());
        } catch (ConnectionException e) {
            e.printStackTrace();
        } catch (RequestTimeoutException e) {
            e.printStackTrace();
        } catch (ServiceResponseException e) {
            e.printStackTrace();
            System.out.println(e.getHttpStatusCode());
            System.out.println(e.getErrorCode());
            System.out.println(e.getErrorMsg());
        }
    }
}
