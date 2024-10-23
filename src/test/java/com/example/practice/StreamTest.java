package com.example.practice;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.netty.util.HashedWheelTimer;
import org.apache.logging.log4j.util.Strings;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        JSONArray jsonArray = JSONArray.parseArray("[{\"n\":7373,\"d\":[1103,1122,1124,1123,1135],\"t\":1,\"l\":false},{\"n\":7374,\"d\":[1200,1303,1396,1437,1407],\"t\":1,\"l\":false},{\"n\":7375,\"d\":[1111],\"t\":1,\"l\":false}]");
        List<Object> flatJsonList = jsonArray.stream().flatMap(item->{JSONArray jarray = ((JSONObject)item).getJSONArray("d");if(Objects.isNull(jarray)){return Stream.empty();} return jarray.stream();}).collect(Collectors.toList());

        String mapStream = "[{\"contentId\":1,\"textSource\":\"null\",\"booleanField\":true},{\"contentId\":2,\"textSource\":\"本地文本\"},{\"contentId\":3,\"textSource\":\"abc\"}]";
        JSONArray array = JSONArray.parseArray(mapStream);
        Map<Object,Object> map = array.stream().collect(Collectors.toMap(item->{JSONObject jsonObj = JSONObject.parseObject(JSONObject.toJSONString(item));return jsonObj.get("booleanField");}, Function.identity(),(item1,item2)->item1));
        array.stream().anyMatch(item->{JSONObject jsonObj = JSONObject.parseObject(JSONObject.toJSONString(item));return jsonObj.getBoolean("booleanField");});
        Boolean flag = array.stream().anyMatch(item->{JSONObject jsonObj = JSONObject.parseObject(JSONObject.toJSONString(item));return 1==jsonObj.getLong("contentId")&&Objects.nonNull(jsonObj.get("textSource"));});
        List<Long> arrayLongs = array.stream().filter(item-> Strings.isEmpty(((JSONObject) item).getString("textSource"))).map(item->((JSONObject) item).getLong("contentId")).collect(Collectors.toList());
        System.out.println(JSONObject.toJSONString(arrayLongs));
        System.out.println(!CollectionUtils.isEmpty(arrayLongs));
        Boolean bool = array.stream().anyMatch(item-> Strings.isEmpty(((JSONObject) item).getString("textSource")));
        System.out.println(bool);
        int[] intArr = new int[]{3,1,2,0,20};
        OptionalInt first = Arrays.stream(intArr).max();
        List<Integer> integerList = new ArrayList<>();
        integerList.add(3);
        integerList.add(1);
        integerList.add(2);
        integerList.add(20);
        integerList.add(0);
        integerList.add(null);// 这句会引起Comparator.reverseOrder()的NPE
        Optional<Integer> first1 = integerList.stream().sorted(Comparator.reverseOrder()).findFirst();
        System.out.println(first1.get());
        System.out.println(InnerClass.class);

        String[] abc = {"12","23","1111234","34","35"};
        String str = Arrays.stream(abc).filter(item->"twp".equals(item.equals(item))).findAny().get();
        Optional<String> optional = Arrays.stream(abc).filter(item->"twp".equals(item.equals(item))).findAny();
        Arrays.stream(abc).peek(item-> System.out.println(Short.valueOf(item))).collect(Collectors.toList());
//        for(String abcd : abc){
//            System.out.println(abcd);
//        }
    }

    public class InnerClass{
        private int a;
        public int test(){
            return 1;
        }
    }

    // 复制 InputStream 内容到一个字节数组中
    public static byte[] copyInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            byteArrayOutputStream.write(buffer, 0, length);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static void printInputStreamContent(InputStream inputStream) throws IOException {
        // 使用 BufferedReader 读取 InputStream 内容
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line;

        // 按行读取
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line).append(System.lineSeparator());
        }

        // 打印流中的内容
        System.out.println("InputStream Content:");
        System.out.println(stringBuilder.toString());
    }

}
