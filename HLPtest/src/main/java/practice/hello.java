package practice;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.NLPTokenizer;

import java.util.List;

public class hello {
    public static void main(String[] args) {
        //System.out.println(HanLP.segment("你好, 欢迎使用HanLP!"));
        List<Term> termList = HanLP.segment("你好，欢迎使用HanLP！");
        System.out.println(termList);
        termList = NLPTokenizer.segment("国科学院计算技术研究所的宗成庆教授正在教授自然语言处理课程");
        System.out.println(termList);
    }
}
