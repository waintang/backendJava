import com.example.practice.Sjh;
import lombok.Builder;
import lombok.Data;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChineseToPinyin {
    public static String toPinyin(String chinese) {
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

        StringBuilder sb = new StringBuilder();
        char[] chars = chinese.toCharArray();
        for (char ch : chars) {
            if (Character.isWhitespace(ch)) {
                continue;
            }
            if (ch > 128) {
                try {
                    String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(ch, format);
                    if (pinyinArray != null) {
                        sb.append(pinyinArray[0]);
                    } else {
                        sb.append(ch);
                    }
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main1(String[] args) {
        String chinese = "郑小艳"; // 郑小燕 郑小艳
        String pinyin = toPinyin(chinese);
        System.out.println(pinyin); // zhongwen 或者 zhong wen 取决于HanyuPinyinToneType设置
    }
    public static void main(String[] args) {
        String chinese = "郑小艳"; // 郑小燕 郑小艳
        String pinyin = toPinyin(chinese);
        Sjh sjh1 = Sjh.builder().mobile("").name("").signNumber("").build();
        List<Sjh> sjhs = new ArrayList<>();
        // 同手机号 不同名字
        Map<String, List<String>> map = new HashMap<>();
//        for(Sjh sjh :sjhs){
//            map.put(sjh.getMobile());
//            sjh.getName()
//        }
        System.out.println(pinyin); // zhongwen 或者 zhong wen 取决于HanyuPinyinToneType设置
    }
}