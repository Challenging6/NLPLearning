package practice;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.tag.Nature;
import com.hankcs.hanlp.seg.CRF.CRFSegment;
import com.hankcs.hanlp.seg.Dijkstra.DijkstraSegment;
import com.hankcs.hanlp.seg.NShort.NShortSegment;
import com.hankcs.hanlp.seg.Other.AhoCorasickDoubleArrayTrieSegment;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.Viterbi.ViterbiSegment;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.*;

import java.util.List;

public class segment {
    public static void main(String[] args) {

        /*标准分词*/
//        System.out.println(HanLP.segment("你好, 欢迎使用HanLP!"));
//        List<Term> termList = HanLP.segment("你好，欢迎使用HanLP！");
//        System.out.println(termList);

        /*NLP分词*/
//        termList = NLPTokenizer.segment("国科学院计算技术研究所的宗成庆教授正在教授自然语言处理课程");
//        System.out.println(termList);

        /*索引分词*/
//        termList = IndexTokenizer.segment("主副食品");
//        for (Term term : termList)
//        {
//            System.out.println(term + " [" + term.offset + ":" + (term.offset + term.word.length()) + "]");
//        }

        /*繁体字分词*/
//        termList = TraditionalChineseTokenizer.segment("大衛貝克漢不僅僅是名著名球員，球場以外，其妻為前辣妹合唱團成員維多利亞·碧咸，亦由於他擁有突出外表、百變髮型及正面的形象，以至自己品牌的男士香水等商品，及長期擔任運動品牌Adidas的代言人，因此對大眾傳播媒介和時尚界等方面都具很大的影響力，在足球圈外所獲得的認受程度可謂前所未見。");
//        System.out.println(termList);

        /*极速词典分词*/
//        String text = "江西鄱阳湖干枯, 中国最大淡水湖变成大草原";
//        System.out.println(SpeedTokenizer.segment(text));
//        long start = System.currentTimeMillis();
//        int pressure = 1000000;
//        for (int i = 0; i < pressure; i++){
//            SpeedTokenizer.segment((text));
//        }
//        double costTime = (System.currentTimeMillis()-start)/(double)1000;
//        System.out.printf("分词速度: %.2f字每秒 ", text.length()*pressure/costTime);

        /*N-最短路径分词*/
//        Segment nShortSegment = new NShortSegment().
//                enableCustomDictionary(false).enablePlaceRecognize(true).enableOrganizationRecognize(true);
//        Segment shortestSegment = new ViterbiSegment().
//                enableCustomDictionary(false).enablePlaceRecognize(true).enableOrganizationRecognize(true);
//        String[] testCase = new String[]{
//                "刘喜杰石国祥会见吴亚琴先进事迹报告团成员",
//                "山东金沙有限公司签约了这个项目"
//        };
//        for (String sentence:testCase){
//            System.out.println("N-最短分词:" + nShortSegment.seg(sentence)+
//                                "\n最短路分词:"+shortestSegment.seg(sentence));
//        }
        /*CRF分词*/
        Segment segment = new CRFSegment();
        segment.enablePartOfSpeechTagging(true);
        List<Term> termList = segment.seg("你看过穆赫兰道吗");
        System.out.println(termList);
        for (Term term: termList){
            if (term.nature == null){
                System.out.println("find a new word:"+term.word);
            }
        }

        /*创建分词器*/
//        Segment segment;
//        segment = new ViterbiSegment();
//        segment = new DijkstraSegment();
//        segment = new NShortSegment();
//        segment = new AhoCorasickDoubleArrayTrieSegment();
//        segment = new CRFSegment();
//        segment = HanLP.newSegment();
//
//        String text = "泽田依子是上外日本文化经济学院的外教";
//        System.out.println(StandardTokenizer.segment(text));
//        StandardTokenizer.SEGMENT.enableAllNamedEntityRecognize(true);
//        System.out.println(StandardTokenizer.segment(text));

    }
}
