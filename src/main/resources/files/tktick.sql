/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50715
Source Host           : 127.0.0.1:3306
Source Database       : tktick

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2017-07-13 17:43:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tk_article
-- ----------------------------
DROP TABLE IF EXISTS `tk_article`;
CREATE TABLE `tk_article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `art_title` varchar(100) NOT NULL COMMENT '文章标题',
  `art_desc` varchar(200) DEFAULT '' COMMENT '文章摘要',
  `clz_id` int(11) DEFAULT '0' COMMENT '文章分类',
  `user_id` int(11) NOT NULL COMMENT '文章作者FK',
  `add_time` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `edit_time` bigint(20) NOT NULL DEFAULT '0' COMMENT '最后修改时间',
  `art_state` tinyint(4) NOT NULL DEFAULT '1' COMMENT '文章状态: 1正常 -1软删除',
  `art_auth` tinyint(4) NOT NULL DEFAULT '1' COMMENT '文章权限: 0:仅自己可见 1: 所有人可见 2:部分可见(另外一张表配合)',
  `art_cont` text COMMENT '文章内容',
  `art_imgs` varchar(4000) DEFAULT '' COMMENT '文章中的图片地址，每张图片之间用";"隔开',
  `art_tag_nms` varchar(200) DEFAULT '' COMMENT '文章标签名","隔开',
  `art_tag_ids` varchar(100) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 COMMENT='文章表';

-- ----------------------------
-- Records of tk_article
-- ----------------------------
INSERT INTO `tk_article` VALUES ('50', '去清迈跑马拉松：和突突车抢道，一场泰北的马拉松大冒险', '', '0', '10000', '1495624329480', '1495624329480', '-1', '1', '时至今日，仍有争论当年邓丽君小姐的《小城故事》，到底是哪个“小城”,作为主题曲，电影<小城故事>的拍摄地在彰化鹿港；影片讲的则是苗栗县三义，作词作曲者也特地去当地采风以完成创作；而邓丽君的拥趸们坚信清迈才是最符合的小城，“…看似一幅画/听像一首歌/人生境界真善美这里已包括”唱的一定是清迈，不然为何走过那么多地方，邓丽君最爱的还是清迈、时不时故地重游呢？（1995年4月，邓丽君故地重游，原本打算住几天返回法国，不料5月8日突发哮喘，在酒店房外的走廊辞世，享年42岁。邓丽君在清迈一直住美萍酒店，如今当年她常住的那间房间照常营业，无人入住时则可参观游览。抵达清迈第二天中午我们便去美萍酒店吃了顿午饭。）今年恰逢清迈建城720年，清迈马拉松也正好走完第一个十年。比赛和这座小城一样，故事很多。如果说东京马拉松像冬日里的寿喜锅，内容温暖又丰富，那清迈马拉松就是一碗冬阴功了，味道浓郁辛辣。穿古城墙夜奔离城、沿着高低斜坡公路体验清迈郊区风情、在反复的折返里和汽车争分夺秒、辛苦完赛后的补给却出人意料的丰盛……喜欢的人乐在其中，不对味的就只有叫苦连天了。在离开清迈时回忆比赛，评价变得非常困难。赛事的组织很“泰国”，组织上的漏洞明显，但参赛者可以在里面找到很多乐趣。对比国内不少可以说是戒备森严的马拉松，跑清迈有点像学生时代偷偷去网吧的快感，这和正儿八经在家玩电脑完全两种体验。', '', '清迈,邓丽君', '2,10');
INSERT INTO `tk_article` VALUES ('51', '去清迈跑马拉松：和突突车抢道，一场泰北的马拉松大冒险', '', '0', '10000', '1495624358714', '1495624358714', '1', '1', '时至今日，仍有争论当年邓丽君小姐的《小城故事》，到底是哪个“小城”,作为主题曲，电影<小城故事>的拍摄地在彰化鹿港；影片讲的则是苗栗县三义，作词作曲者也特地去当地采风以完成创作；而邓丽君的拥趸们坚信清迈才是最符合的小城，“…看似一幅画/听像一首歌/人生境界真善美这里已包括”唱的一定是清迈，不然为何走过那么多地方，邓丽君最爱的还是清迈、时不时故地重游呢？（1995年4月，邓丽君故地重游，原本打算住几天返回法国，不料5月8日突发哮喘，在酒店房外的走廊辞世，享年42岁。邓丽君在清迈一直住美萍酒店，如今当年她常住的那间房间照常营业，无人入住时则可参观游览。抵达清迈第二天中午我们便去美萍酒店吃了顿午饭。）今年恰逢清迈建城720年，清迈马拉松也正好走完第一个十年。比赛和这座小城一样，故事很多。如果说东京马拉松像冬日里的寿喜锅，内容温暖又丰富，那清迈马拉松就是一碗冬阴功了，味道浓郁辛辣。穿古城墙夜奔离城、沿着高低斜坡公路体验清迈郊区风情、在反复的折返里和汽车争分夺秒、辛苦完赛后的补给却出人意料的丰盛……喜欢的人乐在其中，不对味的就只有叫苦连天了。在离开清迈时回忆比赛，评价变得非常困难。赛事的组织很“泰国”，组织上的漏洞明显，但参赛者可以在里面找到很多乐趣。对比国内不少可以说是戒备森严的马拉松，跑清迈有点像学生时代偷偷去网吧的快感，这和正儿八经在家玩电脑完全两种体验。', '', '清迈,邓丽君', '2,10');
INSERT INTO `tk_article` VALUES ('52', '去清迈跑马拉松：和突突车抢道，一场泰北的马拉松大冒险', '', '0', '10000', '1495701794857', '1495701794857', '1', '1', '时至今日，仍有争论当年邓丽君小姐的《小城故事》，到底是哪个“小城”,作为主题曲，电影<小城故事>的拍摄地在彰化鹿港；影片讲的则是苗栗县三义，作词作曲者也特地去当地采风以完成创作；而邓丽君的拥趸们坚信清迈才是最符合的小城，“…看似一幅画/听像一首歌/人生境界真善美这里已包括”唱的一定是清迈，不然为何走过那么多地方，邓丽君最爱的还是清迈、时不时故地重游呢？（1995年4月，邓丽君故地重游，原本打算住几天返回法国，不料5月8日突发哮喘，在酒店房外的走廊辞世，享年42岁。邓丽君在清迈一直住美萍酒店，如今当年她常住的那间房间照常营业，无人入住时则可参观游览。抵达清迈第二天中午我们便去美萍酒店吃了顿午饭。）今年恰逢清迈建城720年，清迈马拉松也正好走完第一个十年。比赛和这座小城一样，故事很多。如果说东京马拉松像冬日里的寿喜锅，内容温暖又丰富，那清迈马拉松就是一碗冬阴功了，味道浓郁辛辣。穿古城墙夜奔离城、沿着高低斜坡公路体验清迈郊区风情、在反复的折返里和汽车争分夺秒、辛苦完赛后的补给却出人意料的丰盛……喜欢的人乐在其中，不对味的就只有叫苦连天了。在离开清迈时回忆比赛，评价变得非常困难。赛事的组织很“泰国”，组织上的漏洞明显，但参赛者可以在里面找到很多乐趣。对比国内不少可以说是戒备森严的马拉松，跑清迈有点像学生时代偷偷去网吧的快感，这和正儿八经在家玩电脑完全两种体验。', '', '清迈,邓丽君', '2,10');
INSERT INTO `tk_article` VALUES ('53', '6月起，四川这些地方够你玩整年！美的一塌糊涂…', '', '0', '10000', '1495702271434', '1495702271434', '1', '1', '入夏之后中国西南的蜀地切换成天堂的样子一朵花、一片云、一座山、一湖水都美的像一幅幅世外桃源画卷6月开始的四川，足够你玩一整年碧草蓝天、七色花海、弯弯河流，这里就是俄木塘，每年六七月间，方圆万亩草原是一片花的海洋美不胜收，因此被誉为“最美的草原花海”。*推荐自驾路线：成都→蜀西路→都汶高速→G213→S301→九寨沟。松坪沟是镶嵌在成都至九寨沟干线上的一颗明珠，海子、森林、群山、民俗风情让人恋恋不舍。同一水面呈现墨绿、深蓝、翡翠色彩，阳光照射林木，群峰倒映，水色变幻，令人如痴如醉。松坪沟有九景：芳草海、鱼儿寨海、上白蜡海、下白蜡海、珍珠瀑、白石海、墨海、五彩池、长海，景景撩人，别有洞天！*推荐自驾路线：成都(成灌)→都江堰(都汶)→汶川→茂县→\"6回头\"的第一个弯倒左手→松坪沟景区。有人说，稻城亚丁是“水蓝色星球上的最后一片净土”，这里蓝色的海子，让人一见倾心；纯白的雪山，遗世绝美；翠绿的草原上小溪划过,春意盎然!亚丁的每一种色彩都是纯粹的，每一处景色都是绝美的。美国地理学家约瑟夫洛克曾于1928年美国《国家地理》上说“世界上还有什么地方，景致如此完美，等待着探险家、摄影家们。这真是美丽的香格里拉”。*推荐自驾路线：成都→都江堰→映秀→四姑娘山→雅江→理塘→稻城亚丁。“奶子沟”距成都310公里，在藏语里是美丽富饶、幸福安宁之意。奶子沟八十里彩林风情谷因身处深谷独享清幽雅静的奶子沟而得名，又以美甲天下的彩林世界而闻名，洋洋洒洒长达八十里，蔚为壮观。*推荐自驾路线：成都→汶川→茂县→卡龙沟→黑水县。11月的光雾山，漫山红叶如火如荼，层林尽染、万山红遍、五彩缤纷，曾被誉为中国红叶第一山，也是中国最好的彩林之一。光雾山红叶有面积大、色彩多、周期长等几大特点，800多平方公里的景区有500多平方公里为红叶景观带，而景观带又分蓝、绿、黄、橙、红等色调，红叶周期可达一个月，从五彩斑斓看到漫山红透，颇为壮观。*推荐自驾路线：成都→广元→汉中→光雾山。米仓山在四川省和山西省边境，森林公园面积达401.6平方公里，其中就有300多平方公里几种连片的红叶景观，07年被评为“中国红叶之乡”。同光雾山国家重点风景名胜区相邻。*推荐自驾路线：成都→广元→汉中→米仓山。12月海螺沟贡嘎雪峰脚下的海螺沟，是青藏高原东缘的极高山地，以低海拔现代冰川著称于世。海螺沟有五绝：日照金山、冰川倾泄、雪谷温泉、原始森林和康巴藏族风情。冬天的海螺沟雪花漫天，这里有温泉数十处，可来此洗温泉浴赏雪景，实在美妙。*推荐自驾路线：成都→成雅高速→雅安→雅西高速→石棉→海螺沟。大美四川今年就照着一个个去走遍吧', '', '成都,推荐', '11,12');
INSERT INTO `tk_article` VALUES ('54', '6月起，四川这些地方够你玩整年！美的一塌糊涂…', '', '0', '10000', '1495702350080', '1495702350080', '1', '1', '入夏之后中国西南的蜀地切换成天堂的样子一朵花、一片云、一座山、一湖水都美的像一幅幅世外桃源画卷6月开始的四川，足够你玩一整年碧草蓝天、七色花海、弯弯河流，这里就是俄木塘，每年六七月间，方圆万亩草原是一片花的海洋美不胜收，因此被誉为“最美的草原花海”。*推荐自驾路线：成都→蜀西路→都汶高速→G213→S301→九寨沟。松坪沟是镶嵌在成都至九寨沟干线上的一颗明珠，海子、森林、群山、民俗风情让人恋恋不舍。同一水面呈现墨绿、深蓝、翡翠色彩，阳光照射林木，群峰倒映，水色变幻，令人如痴如醉。松坪沟有九景：芳草海、鱼儿寨海、上白蜡海、下白蜡海、珍珠瀑、白石海、墨海、五彩池、长海，景景撩人，别有洞天！*推荐自驾路线：成都(成灌)→都江堰(都汶)→汶川→茂县→\"6回头\"的第一个弯倒左手→松坪沟景区。有人说，稻城亚丁是“水蓝色星球上的最后一片净土”，这里蓝色的海子，让人一见倾心；纯白的雪山，遗世绝美；翠绿的草原上小溪划过,春意盎然!亚丁的每一种色彩都是纯粹的，每一处景色都是绝美的。美国地理学家约瑟夫洛克曾于1928年美国《国家地理》上说“世界上还有什么地方，景致如此完美，等待着探险家、摄影家们。这真是美丽的香格里拉”。*推荐自驾路线：成都→都江堰→映秀→四姑娘山→雅江→理塘→稻城亚丁。“奶子沟”距成都310公里，在藏语里是美丽富饶、幸福安宁之意。奶子沟八十里彩林风情谷因身处深谷独享清幽雅静的奶子沟而得名，又以美甲天下的彩林世界而闻名，洋洋洒洒长达八十里，蔚为壮观。*推荐自驾路线：成都→汶川→茂县→卡龙沟→黑水县。11月的光雾山，漫山红叶如火如荼，层林尽染、万山红遍、五彩缤纷，曾被誉为中国红叶第一山，也是中国最好的彩林之一。光雾山红叶有面积大、色彩多、周期长等几大特点，800多平方公里的景区有500多平方公里为红叶景观带，而景观带又分蓝、绿、黄、橙、红等色调，红叶周期可达一个月，从五彩斑斓看到漫山红透，颇为壮观。*推荐自驾路线：成都→广元→汉中→光雾山。米仓山在四川省和山西省边境，森林公园面积达401.6平方公里，其中就有300多平方公里几种连片的红叶景观，07年被评为“中国红叶之乡”。同光雾山国家重点风景名胜区相邻。*推荐自驾路线：成都→广元→汉中→米仓山。12月海螺沟贡嘎雪峰脚下的海螺沟，是青藏高原东缘的极高山地，以低海拔现代冰川著称于世。海螺沟有五绝：日照金山、冰川倾泄、雪谷温泉、原始森林和康巴藏族风情。冬天的海螺沟雪花漫天，这里有温泉数十处，可来此洗温泉浴赏雪景，实在美妙。*推荐自驾路线：成都→成雅高速→雅安→雅西高速→石棉→海螺沟。大美四川今年就照着一个个去走遍吧', '', '成都,推荐', '11,12');
INSERT INTO `tk_article` VALUES ('55', '6月起，四川这些地方够你玩整年！美的一塌糊涂…', '', '0', '10000', '1495702421467', '1495702421467', '1', '1', '入夏之后中国西南的蜀地切换成天堂的样子一朵花、一片云、一座山、一湖水都美的像一幅幅世外桃源画卷6月开始的四川，足够你玩一整年碧草蓝天、七色花海、弯弯河流，这里就是俄木塘，每年六七月间，方圆万亩草原是一片花的海洋美不胜收，因此被誉为“最美的草原花海”。*推荐自驾路线：成都→蜀西路→都汶高速→G213→S301→九寨沟。松坪沟是镶嵌在成都至九寨沟干线上的一颗明珠，海子、森林、群山、民俗风情让人恋恋不舍。同一水面呈现墨绿、深蓝、翡翠色彩，阳光照射林木，群峰倒映，水色变幻，令人如痴如醉。松坪沟有九景：芳草海、鱼儿寨海、上白蜡海、下白蜡海、珍珠瀑、白石海、墨海、五彩池、长海，景景撩人，别有洞天！*推荐自驾路线：成都(成灌)→都江堰(都汶)→汶川→茂县→\"6回头\"的第一个弯倒左手→松坪沟景区。有人说，稻城亚丁是“水蓝色星球上的最后一片净土”，这里蓝色的海子，让人一见倾心；纯白的雪山，遗世绝美；翠绿的草原上小溪划过,春意盎然!亚丁的每一种色彩都是纯粹的，每一处景色都是绝美的。美国地理学家约瑟夫洛克曾于1928年美国《国家地理》上说“世界上还有什么地方，景致如此完美，等待着探险家、摄影家们。这真是美丽的香格里拉”。*推荐自驾路线：成都→都江堰→映秀→四姑娘山→雅江→理塘→稻城亚丁。“奶子沟”距成都310公里，在藏语里是美丽富饶、幸福安宁之意。奶子沟八十里彩林风情谷因身处深谷独享清幽雅静的奶子沟而得名，又以美甲天下的彩林世界而闻名，洋洋洒洒长达八十里，蔚为壮观。*推荐自驾路线：成都→汶川→茂县→卡龙沟→黑水县。11月的光雾山，漫山红叶如火如荼，层林尽染、万山红遍、五彩缤纷，曾被誉为中国红叶第一山，也是中国最好的彩林之一。光雾山红叶有面积大、色彩多、周期长等几大特点，800多平方公里的景区有500多平方公里为红叶景观带，而景观带又分蓝、绿、黄、橙、红等色调，红叶周期可达一个月，从五彩斑斓看到漫山红透，颇为壮观。*推荐自驾路线：成都→广元→汉中→光雾山。米仓山在四川省和山西省边境，森林公园面积达401.6平方公里，其中就有300多平方公里几种连片的红叶景观，07年被评为“中国红叶之乡”。同光雾山国家重点风景名胜区相邻。*推荐自驾路线：成都→广元→汉中→米仓山。12月海螺沟贡嘎雪峰脚下的海螺沟，是青藏高原东缘的极高山地，以低海拔现代冰川著称于世。海螺沟有五绝：日照金山、冰川倾泄、雪谷温泉、原始森林和康巴藏族风情。冬天的海螺沟雪花漫天，这里有温泉数十处，可来此洗温泉浴赏雪景，实在美妙。*推荐自驾路线：成都→成雅高速→雅安→雅西高速→石棉→海螺沟。大美四川今年就照着一个个去走遍吧', '', '成都,推荐', '11,12');
INSERT INTO `tk_article` VALUES ('56', '6月起，四川这些地方够你玩整年！美的一塌糊涂…', '', '0', '10000', '1498810783120', '1498810783120', '1', '1', '入夏之后中国西南的蜀地切换成天堂的样子一朵花、一片云、一座山、一湖水都美的像一幅幅世外桃源画卷6月开始的四川，足够你玩一整年碧草蓝天、七色花海、弯弯河流，这里就是俄木塘，每年六七月间，方圆万亩草原是一片花的海洋美不胜收，因此被誉为“最美的草原花海”。*推荐自驾路线：成都→蜀西路→都汶高速→G213→S301→九寨沟。松坪沟是镶嵌在成都至九寨沟干线上的一颗明珠，海子、森林、群山、民俗风情让人恋恋不舍。同一水面呈现墨绿、深蓝、翡翠色彩，阳光照射林木，群峰倒映，水色变幻，令人如痴如醉。松坪沟有九景：芳草海、鱼儿寨海、上白蜡海、下白蜡海、珍珠瀑、白石海、墨海、五彩池、长海，景景撩人，别有洞天！*推荐自驾路线：成都(成灌)→都江堰(都汶)→汶川→茂县→\"6回头\"的第一个弯倒左手→松坪沟景区。有人说，稻城亚丁是“水蓝色星球上的最后一片净土”，这里蓝色的海子，让人一见倾心；纯白的雪山，遗世绝美；翠绿的草原上小溪划过,春意盎然!亚丁的每一种色彩都是纯粹的，每一处景色都是绝美的。美国地理学家约瑟夫洛克曾于1928年美国《国家地理》上说“世界上还有什么地方，景致如此完美，等待着探险家、摄影家们。这真是美丽的香格里拉”。*推荐自驾路线：成都→都江堰→映秀→四姑娘山→雅江→理塘→稻城亚丁。“奶子沟”距成都310公里，在藏语里是美丽富饶、幸福安宁之意。奶子沟八十里彩林风情谷因身处深谷独享清幽雅静的奶子沟而得名，又以美甲天下的彩林世界而闻名，洋洋洒洒长达八十里，蔚为壮观。*推荐自驾路线：成都→汶川→茂县→卡龙沟→黑水县。11月的光雾山，漫山红叶如火如荼，层林尽染、万山红遍、五彩缤纷，曾被誉为中国红叶第一山，也是中国最好的彩林之一。光雾山红叶有面积大、色彩多、周期长等几大特点，800多平方公里的景区有500多平方公里为红叶景观带，而景观带又分蓝、绿、黄、橙、红等色调，红叶周期可达一个月，从五彩斑斓看到漫山红透，颇为壮观。*推荐自驾路线：成都→广元→汉中→光雾山。米仓山在四川省和山西省边境，森林公园面积达401.6平方公里，其中就有300多平方公里几种连片的红叶景观，07年被评为“中国红叶之乡”。同光雾山国家重点风景名胜区相邻。*推荐自驾路线：成都→广元→汉中→米仓山。12月海螺沟贡嘎雪峰脚下的海螺沟，是青藏高原东缘的极高山地，以低海拔现代冰川著称于世。海螺沟有五绝：日照金山、冰川倾泄、雪谷温泉、原始森林和康巴藏族风情。冬天的海螺沟雪花漫天，这里有温泉数十处，可来此洗温泉浴赏雪景，实在美妙。*推荐自驾路线：成都→成雅高速→雅安→雅西高速→石棉→海螺沟。大美四川今年就照着一个个去走遍吧', '', '', '');

-- ----------------------------
-- Table structure for tk_article_clz
-- ----------------------------
DROP TABLE IF EXISTS `tk_article_clz`;
CREATE TABLE `tk_article_clz` (
  `clz_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `clz_nm` varchar(20) NOT NULL DEFAULT '' COMMENT '分类名称',
  `clz_state` tinyint(4) NOT NULL DEFAULT '1' COMMENT '-1:软删除 1:正常',
  `clz_seq` smallint(6) DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`clz_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章分类';

-- ----------------------------
-- Records of tk_article_clz
-- ----------------------------

-- ----------------------------
-- Table structure for tk_comment
-- ----------------------------
DROP TABLE IF EXISTS `tk_comment`;
CREATE TABLE `tk_comment` (
  `comt_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comt_time` bigint(20) NOT NULL DEFAULT '0' COMMENT '评论时间',
  `comt_cont` varchar(500) NOT NULL DEFAULT '' COMMENT '评论内容，140字以内',
  `user_id` int(11) NOT NULL COMMENT '评论人',
  `art_id` bigint(1) NOT NULL COMMENT '被评论的文章',
  `comt_state` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态: 1:正常 -1:软删除',
  PRIMARY KEY (`comt_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='评论表';

-- ----------------------------
-- Records of tk_comment
-- ----------------------------
INSERT INTO `tk_comment` VALUES ('1', '0', 'cehsi1', '10000', '50', '1');
INSERT INTO `tk_comment` VALUES ('2', '0', 'ceshi2', '10000', '50', '1');
INSERT INTO `tk_comment` VALUES ('3', '0', 'ceshi3', '10000', '51', '1');
INSERT INTO `tk_comment` VALUES ('4', '0', 'ceshi4', '10000', '51', '1');

-- ----------------------------
-- Table structure for tk_deliver
-- ----------------------------
DROP TABLE IF EXISTS `tk_deliver`;
CREATE TABLE `tk_deliver` (
  `dver_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '投稿编号',
  `art_id` bigint(20) NOT NULL COMMENT '文章id',
  `set_id` int(11) NOT NULL COMMENT '合集id',
  `dver_time` bigint(20) DEFAULT '0' COMMENT '投递时间',
  `dver_state` tinyint(4) DEFAULT '0' COMMENT '投递状态: -1:软删除 0:未被处理, 1:已处理且被收录 2:已处理但被退回 3:撤回投递',
  PRIMARY KEY (`dver_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='投稿记录';

-- ----------------------------
-- Records of tk_deliver
-- ----------------------------

-- ----------------------------
-- Table structure for tk_reply
-- ----------------------------
DROP TABLE IF EXISTS `tk_reply`;
CREATE TABLE `tk_reply` (
  `reply_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `reply_time` bigint(20) NOT NULL DEFAULT '0' COMMENT '回复时间',
  `reply_cont` varchar(500) NOT NULL DEFAULT '' COMMENT '回复内容，140字以内',
  `comt_id` bigint(20) NOT NULL COMMENT '被回复的评论',
  `user_id` int(20) NOT NULL COMMENT '回复人',
  `reply_state` tinyint(4) NOT NULL DEFAULT '1' COMMENT '回复状态: 1:正常 -1:软删除',
  PRIMARY KEY (`reply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='回复表';

-- ----------------------------
-- Records of tk_reply
-- ----------------------------
INSERT INTO `tk_reply` VALUES ('1', '0', 'huifuceshi1', '1', '10000', '1');
INSERT INTO `tk_reply` VALUES ('2', '0', 'huifuceshi2', '1', '10000', '1');
INSERT INTO `tk_reply` VALUES ('3', '0', 'huifuceshi3', '2', '10000', '1');
INSERT INTO `tk_reply` VALUES ('4', '0', 'hfcs4', '4', '10000', '1');

-- ----------------------------
-- Table structure for tk_set
-- ----------------------------
DROP TABLE IF EXISTS `tk_set`;
CREATE TABLE `tk_set` (
  `set_id` int(11) NOT NULL AUTO_INCREMENT,
  `set_title` varchar(100) NOT NULL DEFAULT '' COMMENT '合集名称',
  `art_num` int(11) DEFAULT '0' COMMENT '收录的文章数量，使用触发器操作',
  `add_time` bigint(20) DEFAULT '0' COMMENT '创建时间',
  `edit_time` bigint(20) DEFAULT '0' COMMENT '修改时间',
  `set_desc` varchar(2000) DEFAULT '' COMMENT '合集简介',
  PRIMARY KEY (`set_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='合集表';

-- ----------------------------
-- Records of tk_set
-- ----------------------------
INSERT INTO `tk_set` VALUES ('1', '测试', '0', '0', '0', '测试描述');

-- ----------------------------
-- Table structure for tk_set_keeper
-- ----------------------------
DROP TABLE IF EXISTS `tk_set_keeper`;
CREATE TABLE `tk_set_keeper` (
  `kpr_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `set_id` int(11) NOT NULL COMMENT '合集id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `kpr_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '管理员分类:  1:创建者 0:其他管理员',
  PRIMARY KEY (`kpr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='合集管理员表';

-- ----------------------------
-- Records of tk_set_keeper
-- ----------------------------

-- ----------------------------
-- Table structure for tk_tag
-- ----------------------------
DROP TABLE IF EXISTS `tk_tag`;
CREATE TABLE `tk_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_nm` varchar(50) NOT NULL DEFAULT '' COMMENT '标签名,主键',
  `art_num` int(11) NOT NULL DEFAULT '0' COMMENT '该标签下文章数量，触发器控制',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQUE_TK_TAG_TAG_NM` (`tag_nm`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='标签表';

-- ----------------------------
-- Records of tk_tag
-- ----------------------------
INSERT INTO `tk_tag` VALUES ('1', '丹霞', '0');
INSERT INTO `tk_tag` VALUES ('2', '清迈', '3');
INSERT INTO `tk_tag` VALUES ('10', '邓丽君', '3');
INSERT INTO `tk_tag` VALUES ('11', '成都', '3');
INSERT INTO `tk_tag` VALUES ('12', '推荐', '3');

-- ----------------------------
-- Table structure for tk_tag_art
-- ----------------------------
DROP TABLE IF EXISTS `tk_tag_art`;
CREATE TABLE `tk_tag_art` (
  `tag_id` int(11) NOT NULL,
  `art_id` bigint(20) NOT NULL COMMENT '文章id',
  PRIMARY KEY (`tag_id`,`art_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章标签关联表';

-- ----------------------------
-- Records of tk_tag_art
-- ----------------------------
INSERT INTO `tk_tag_art` VALUES ('2', '50');
INSERT INTO `tk_tag_art` VALUES ('2', '51');
INSERT INTO `tk_tag_art` VALUES ('2', '52');
INSERT INTO `tk_tag_art` VALUES ('10', '50');
INSERT INTO `tk_tag_art` VALUES ('10', '51');
INSERT INTO `tk_tag_art` VALUES ('10', '52');
INSERT INTO `tk_tag_art` VALUES ('11', '53');
INSERT INTO `tk_tag_art` VALUES ('11', '54');
INSERT INTO `tk_tag_art` VALUES ('11', '55');
INSERT INTO `tk_tag_art` VALUES ('12', '53');
INSERT INTO `tk_tag_art` VALUES ('12', '54');
INSERT INTO `tk_tag_art` VALUES ('12', '55');

-- ----------------------------
-- Table structure for tk_theme
-- ----------------------------
DROP TABLE IF EXISTS `tk_theme`;
CREATE TABLE `tk_theme` (
  `thm_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`thm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专题表';

-- ----------------------------
-- Records of tk_theme
-- ----------------------------

-- ----------------------------
-- Table structure for tk_topic
-- ----------------------------
DROP TABLE IF EXISTS `tk_topic`;
CREATE TABLE `tk_topic` (
  `top_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`top_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='话题表';

-- ----------------------------
-- Records of tk_topic
-- ----------------------------

-- ----------------------------
-- Table structure for tk_user
-- ----------------------------
DROP TABLE IF EXISTS `tk_user`;
CREATE TABLE `tk_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT '' COMMENT '登录名',
  `user_pwd` varchar(32) NOT NULL COMMENT '用户密码',
  `user_salt` varchar(10) NOT NULL COMMENT '加密用字符串',
  `user_phone` bigint(11) DEFAULT '0' COMMENT '用户电话号码，可用于登录',
  `user_email` varchar(100) DEFAULT '' COMMENT '用户邮箱，可用于登录',
  `user_state` tinyint(4) DEFAULT '1' COMMENT '状态: -1：删除，0：限制登陆，1：正常',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `INX_TK_USER_USER_NAME` (`user_name`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of tk_user
-- ----------------------------
INSERT INTO `tk_user` VALUES ('10000', 'tktick', 'BB855C106B50CEA148E553154E3DF151', 'yang', '13408458790', 'y825y@qq.com', '1');

-- ----------------------------
-- Table structure for tk_user_info
-- ----------------------------
DROP TABLE IF EXISTS `tk_user_info`;
CREATE TABLE `tk_user_info` (
  `user_id` int(11) NOT NULL,
  `user_avatar` varchar(200) DEFAULT '' COMMENT '用户头像',
  `user_intro` varchar(500) DEFAULT '' COMMENT '用户简介',
  `nick_name` varchar(100) DEFAULT '' COMMENT '用户昵称',
  `user_sex` tinyint(4) DEFAULT '1' COMMENT '用户性别: 1: 男  0:女',
  `login_time` bigint(20) DEFAULT '0' COMMENT '上次登录时间',
  `login_ip` varchar(50) DEFAULT '' COMMENT '上次登录ip,另外一张表使用触发器自动记录登录时间与ip',
  `reg_time` bigint(20) DEFAULT '0' COMMENT '注册时间',
  `err_count` tinyint(20) DEFAULT '0' COMMENT '连续登录错误次数',
  `stop_time` bigint(20) DEFAULT '0' COMMENT '限制登录开始时间，24小时候才能再次登录并清空'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户详情表';

-- ----------------------------
-- Records of tk_user_info
-- ----------------------------
INSERT INTO `tk_user_info` VALUES ('10000', '', '第一个用户', 'TkTick', '1', '1499851682024', '127.0.0.1', '0', '0', '1495517899241');
DROP TRIGGER IF EXISTS `t_after_insert_on_tk_tag_art`;
DELIMITER ;;
CREATE TRIGGER `t_after_insert_on_tk_tag_art` AFTER INSERT ON `tk_tag_art` FOR EACH ROW BEGIN
	UPDATE tk_tag SET art_num = art_num + 1 WHERE id = new.tag_id;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `t_after_delete_on_tk_tag_art`;
DELIMITER ;;
CREATE TRIGGER `t_after_delete_on_tk_tag_art` AFTER DELETE ON `tk_tag_art` FOR EACH ROW BEGIN
	update tk_tag set art_num = art_num - 1 where id = old.tag_id and art_num > 0;
END
;;
DELIMITER ;
