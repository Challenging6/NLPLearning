##词典

>词典主要有如下几个常用函数:
```
添加一个词, 如果词典中存在, 就添加失败(不覆盖)
CustomDictionary.add("凤凰");

强制添加一个词, 会覆盖原来的词
CustomDictionary.insert("凤凰");

移除一个词
CustomDictionary.remove("哈哈");

```
>词典不会每次加载时都构建,会生成bin格式的缓存. 如果想要添加词典, 要先删除缓存
可以开启HanLP.Config.enableDebug()来查看是否添加成功
其中添加方法可以有:
* HanLP.Config.[各种Path]= String[]{path1, path2}
* 修改配置文件 HanLP.properties 可以放在resources文件夹下.
* 直接修改源代码


