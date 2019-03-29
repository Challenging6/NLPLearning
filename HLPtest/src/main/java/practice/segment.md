###HanLP分词

han LP的分词工具分为两类:  
* 静态工具类的分词工具
* 动态创建的分词工具

####静态工具常用的有:  
```
String = "我是一个NLP学习者";
1.标准分词
HanLp.segment(string);

2.NLP分词, 会执行所有命名实体识别和词性标注
List<Term> termList =  NLPTokenizer.segment(string);

3.索引分词, 面向搜索引擎的分词器, 能够对长词全切分,并可以通过term.offset来获取单词的偏移量
List<Term> termList = IndexTokenizer.segment(string);

4.繁体分词
TraditionalChineseTokenizer.segment(string);

5.极速词典分词, 词典最长分词, 速度快, 精度一般, 在相对固定的业务场景下效果好
SpeedTokenizer.segment(string);
```

####动态工具常用的有:
```
1.N-最短路径分词
Segment segment1 = new NShortSegment();
Segment segment2 = new ViterbiSegment();
其中N-最短路算法精确度要高一些,但是速度相比最短路算法慢几倍.

2.CRF分词
segment = new CRFSegment();
对新词的识别特别好,但是不能使用自定义的词典,也不支持命名实体识别,应用场景仅限于新词识别.

3.DijkstraSegment()
同样是最短路径算法, 速度比viterbi慢, 但是调试信息更加丰富.

4.AhoCorasickSegment()
使用AhoCorasickDoubleArrayTrie实现的最长分词器, 应该是速度最快的词典分词了.
```

####分词器的配置
```
/**
 * 设为索引模式
 *
 * @return
 */
public Segment enableIndexMode(boolean enable)

/**
 * 开启词性标注
 * @param enable
 * @return
 */
public Segment enablePartOfSpeechTagging(boolean enable)

/**
 * 开启人名识别
 * @param enable
 * @return
 */
public Segment enableNameRecognize(boolean enable)

/**
 * 开启地名识别
 * @param enable
 * @return
 */
public Segment enablePlaceRecognize(boolean enable)

/**
 * 开启机构名识别
 * @param enable
 * @return
 */
public Segment enableOrganizationRecognize(boolean enable)

/**
 * 是否启用用户词典
 *
 * @param enable
 */
public Segment enableCustomDictionary(boolean enable)

/**
 * 是否启用音译人名识别
 *
 * @param enable
 */
public Segment enableTranslatedNameRecognize(boolean enable)

/**
 * 是否启用日本人名识别
 *
 * @param enable
 */
public Segment enableJapaneseNameRecognize(boolean enable)

/**
 * 是否启用偏移量计算（开启后Term.offset才会被计算）
 * @param enable
 * @return
 */
public Segment enableOffset(boolean enable)

/**
 * 是否启用所有的命名实体识别
 * @param enable
 * @return
 */
public Segment enableAllNamedEntityRecognize(boolean enable)

```
上边是动态分词器的配置方式.
对于工具类的分词器, 可以使用其暴露出来的成员对其进行配置
```
String text = "泽田依子是上外日本文化经济学院的外教";
System.out.println(StandardTokenizer.segment(text));
StandardTokenizer.SEGMENT.enableAllNameEntityRecognize(true);
System.out.println(StandardTokenizer.segment(text));
```

以上方法都是线程安全的