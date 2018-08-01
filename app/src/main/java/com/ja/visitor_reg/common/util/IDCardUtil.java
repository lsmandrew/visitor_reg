package com.ja.visitor_reg.common.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 二代证工具类
 */

public class IDCardUtil {
    public static Map<String, String> codeNationMap = new HashMap<String, String>();
    public static Map<String, String> nationCodeMap = new HashMap<String, String>();
    public static Map<String, String> codeCountryMap = new HashMap<String, String>();
    public static Map<String, String> countryCodeMap = new HashMap<String, String>();
    public static Map<String, String> cardTypeCode_CN_Map = new HashMap<String, String>();
    public static Map<String, String> codeCardType_CN_Map = new HashMap<String, String>();
    public static Map<String, String> cardTypeCodeMap = new HashMap<String, String>();
    public static Map<String, String> codeCardTypeMap = new HashMap<String, String>();
    public static Map<String, String> sexCodeMap = new HashMap<String, String>();
    public static Map<String, String> codeSexMap = new HashMap<String, String>();
    public static Map<String, String> codeOcrMap = new HashMap<String, String>();
    public static Map<String, String> codeSysMap = new HashMap<String, String>();
    public static Map<String, String> codeOcrToSysMap = new HashMap<String, String>();


    static {
        codeNationMap.put("01", "汉");
        codeNationMap.put("02", "蒙古");
        codeNationMap.put("03", "回");
        codeNationMap.put("04", "藏");
        codeNationMap.put("05", "维吾尔");
        codeNationMap.put("06", "苗");
        codeNationMap.put("07", "彝");
        codeNationMap.put("08", "壮");
        codeNationMap.put("09", "布依");
        codeNationMap.put("10", "朝鲜");
        codeNationMap.put("11", "满");
        codeNationMap.put("12", "侗");
        codeNationMap.put("13", "瑶");
        codeNationMap.put("14", "白");
        codeNationMap.put("15", "土家");
        codeNationMap.put("16", "哈尼");
        codeNationMap.put("17", "哈萨克");
        codeNationMap.put("18", "傣");
        codeNationMap.put("19", "黎");
        codeNationMap.put("20", "傈僳");
        codeNationMap.put("21", "佤");
        codeNationMap.put("22", "畲");
        codeNationMap.put("23", "高山");
        codeNationMap.put("24", "拉祜");
        codeNationMap.put("25", "水");
        codeNationMap.put("26", "东乡");
        codeNationMap.put("27", "纳西");
        codeNationMap.put("28", "景颇");
        codeNationMap.put("29", "柯尔克孜");
        codeNationMap.put("30", "土");
        codeNationMap.put("31", "达斡尔");
        codeNationMap.put("32", "仫佬");
        codeNationMap.put("33", "羌");
        codeNationMap.put("34", "布朗");
        codeNationMap.put("35", "撒拉");
        codeNationMap.put("36", "毛南");
        codeNationMap.put("37", "仡佬");
        codeNationMap.put("38", "锡伯");
        codeNationMap.put("39", "阿昌");
        codeNationMap.put("40", "普米");
        codeNationMap.put("41", "塔吉克");
        codeNationMap.put("42", "怒");
        codeNationMap.put("43", "乌孜别克");
        codeNationMap.put("44", "俄罗斯");
        codeNationMap.put("45", "鄂温克");
        codeNationMap.put("46", "德昂");
        codeNationMap.put("47", "保安");
        codeNationMap.put("48", "裕固");
        codeNationMap.put("49", "京");
        codeNationMap.put("50", "塔塔尔");
        codeNationMap.put("51", "独龙");
        codeNationMap.put("52", "鄂伦春");
        codeNationMap.put("53", "赫哲");
        codeNationMap.put("54", "门巴");
        codeNationMap.put("55", "珞巴");
        codeNationMap.put("56", "基诺");
        codeNationMap.put("99", "其他");
        codeNationMap.put("98", "外国血统中国籍人士");
    }

    static {
        nationCodeMap.put("汉", "01");
        nationCodeMap.put("蒙古", "02");
        nationCodeMap.put("回", "03");
        nationCodeMap.put("藏", "04");
        nationCodeMap.put("维吾尔", "05");
        nationCodeMap.put("苗", "06");
        nationCodeMap.put("彝", "07");
        nationCodeMap.put("壮", "08");
        nationCodeMap.put("布依", "09");
        nationCodeMap.put("朝鲜", "10");
        nationCodeMap.put("满", "11");
        nationCodeMap.put("侗", "12");
        nationCodeMap.put("瑶", "13");
        nationCodeMap.put("白", "14");
        nationCodeMap.put("土家", "15");
        nationCodeMap.put("哈尼", "16");
        nationCodeMap.put("哈萨克", "17");
        nationCodeMap.put("傣", "18");
        nationCodeMap.put("黎", "19");
        nationCodeMap.put("傈僳", "20");
        nationCodeMap.put("佤", "21");
        nationCodeMap.put("畲", "22");
        nationCodeMap.put("高山", "23");
        nationCodeMap.put("拉祜", "24");
        nationCodeMap.put("水", "25");
        nationCodeMap.put("东乡", "26");
        nationCodeMap.put("纳西", "27");
        nationCodeMap.put("景颇", "28");
        nationCodeMap.put("柯尔克孜", "29");
        nationCodeMap.put("土", "30");
        nationCodeMap.put("达斡尔", "31");
        nationCodeMap.put("仫佬", "32");
        nationCodeMap.put("羌", "33");
        nationCodeMap.put("布朗", "34");
        nationCodeMap.put("撒拉", "35");
        nationCodeMap.put("毛南", "36");
        nationCodeMap.put("仡佬", "37");
        nationCodeMap.put("锡伯", "38");
        nationCodeMap.put("阿昌", "39");
        nationCodeMap.put("普米", "40");
        nationCodeMap.put("塔吉克", "41");
        nationCodeMap.put("怒", "42");
        nationCodeMap.put("乌孜别克", "43");
        nationCodeMap.put("俄罗斯", "44");
        nationCodeMap.put("鄂温克", "45");
        nationCodeMap.put("德昂", "46");
        nationCodeMap.put("保安", "47");
        nationCodeMap.put("裕固", "48");
        nationCodeMap.put("京", "49");
        nationCodeMap.put("塔塔尔", "50");
        nationCodeMap.put("独龙", "51");
        nationCodeMap.put("鄂伦春", "52");
        nationCodeMap.put("赫哲", "53");
        nationCodeMap.put("门巴", "54");
        nationCodeMap.put("珞巴", "55");
        nationCodeMap.put("基诺", "56");
        nationCodeMap.put("其他", "99");
        nationCodeMap.put("外国血统中国籍人士", "98");
    }

    static {
        codeCountryMap.put("CHN", "中国");
        codeCountryMap.put("ATA", "南极洲");
        codeCountryMap.put("ARG", "阿根廷");
        codeCountryMap.put("ASM", "美属萨摩亚");
        codeCountryMap.put("AUT", "奥地利");
        codeCountryMap.put("AUS", "澳大利亚");
        codeCountryMap.put("ABW", "阿鲁巴");
        codeCountryMap.put("ALA", "奥兰群岛");
        codeCountryMap.put("AZE", "阿塞拜疆");
        codeCountryMap.put("BIH", "波黑");
        codeCountryMap.put("BRB", "巴巴多斯");
        codeCountryMap.put("BGD", "孟加拉国");
        codeCountryMap.put("BEL", "比利时");
        codeCountryMap.put("BFA", "布基纳法索");
        codeCountryMap.put("BGR", "保加利亚");
        codeCountryMap.put("BHR", "巴林");
        codeCountryMap.put("BDI", "布隆迪");
        codeCountryMap.put("BEN", "贝宁");
        codeCountryMap.put("BMU", "百慕大");
        codeCountryMap.put("BRN", "文莱");
        codeCountryMap.put("BOL", "玻利维亚");
        codeCountryMap.put("BRA", "巴西");
        codeCountryMap.put("BHS", "巴哈马");
        codeCountryMap.put("BTN", "不丹");
        codeCountryMap.put("BVT", "布维岛");
        codeCountryMap.put("BWA", "博茨瓦纳");
        codeCountryMap.put("BLR", "白俄罗斯");
        codeCountryMap.put("BLZ", "伯利兹");
        codeCountryMap.put("CAN", "加拿大");
        codeCountryMap.put("CCK", "科科斯（基林）群岛");
        codeCountryMap.put("COD", "刚果（金）");
        codeCountryMap.put("CAF", "中非");
        codeCountryMap.put("COG", "刚果（布）");
        codeCountryMap.put("CHE", "瑞士");
        codeCountryMap.put("CIV", "科特迪瓦");
        codeCountryMap.put("COK", "库克群岛");
        codeCountryMap.put("CHL", "智利");
        codeCountryMap.put("CMR", "喀麦隆");
        codeCountryMap.put("COL", "哥伦比亚");
        codeCountryMap.put("CRI", "哥斯达黎加");
        codeCountryMap.put("SCG", "塞尔维亚和黑山");
        codeCountryMap.put("CUB", "古巴");
        codeCountryMap.put("CPV", "佛得角");
        codeCountryMap.put("CXR", "圣诞岛");
        codeCountryMap.put("CYP", "塞浦路斯");
        codeCountryMap.put("CZE", "捷克");
        codeCountryMap.put("DEU", "德国");
        codeCountryMap.put("DJI", "吉布提");
        codeCountryMap.put("DNK", "丹麦");
        codeCountryMap.put("DMA", "多米尼克");
        codeCountryMap.put("DOM", "多米尼加共和国");
        codeCountryMap.put("DZA", "阿尔及利亚");
        codeCountryMap.put("ECU", "厄瓜多尔");
        codeCountryMap.put("EST", "爱沙尼亚");
        codeCountryMap.put("EGY", "埃及");
        codeCountryMap.put("ESH", "西撒哈拉");
        codeCountryMap.put("ERI", "厄立特里亚");
        codeCountryMap.put("ESP", "西班牙");
        codeCountryMap.put("ETH", "埃塞俄比亚");
        codeCountryMap.put("FIN", "芬兰");
        codeCountryMap.put("FJI", "斐济");
        codeCountryMap.put("FLK", "福克兰群岛（马尔维纳斯）");
        codeCountryMap.put("FSM", "密克罗尼西亚");
        codeCountryMap.put("FRO", "法罗群岛");
        codeCountryMap.put("FRA", "法国");
        codeCountryMap.put("GAB", "加蓬");
        codeCountryMap.put("GBR", "英国");
        codeCountryMap.put("GRD", "格林纳达");
        codeCountryMap.put("GEO", "格鲁吉亚");
        codeCountryMap.put("GUF", "法属圭亚那");
        codeCountryMap.put("GHA", "加纳");
        codeCountryMap.put("GIB", "直布罗陀");
        codeCountryMap.put("GRL", "格陵兰");
        codeCountryMap.put("GMB", "冈比亚");
        codeCountryMap.put("GIN", "几内亚");
        codeCountryMap.put("WSM", "萨摩亚");
        codeCountryMap.put("YEM", "也门");
        codeCountryMap.put("MYT", "马约特");
        codeCountryMap.put("ZAF", "南非");
        codeCountryMap.put("ZMB", "赞比亚");
        codeCountryMap.put("ZWE", "津巴布韦");
        codeCountryMap.put("GLP", "瓜德罗普");
        codeCountryMap.put("GNQ", "赤道几内亚");
        codeCountryMap.put("GRC", "希腊");
        codeCountryMap.put("SGS", "南乔治亚和南桑德韦奇群岛");
        codeCountryMap.put("GTM", "危地马拉");
        codeCountryMap.put("GUM", "关岛");
        codeCountryMap.put("GNB", "几内亚比绍");
        codeCountryMap.put("GUY", "圭亚那");
        codeCountryMap.put("HKG", "香港");
        codeCountryMap.put("HMD", "赫德岛和麦克唐纳群岛");
        codeCountryMap.put("HND", "洪都拉斯");
        codeCountryMap.put("HRV", "克罗地亚");
        codeCountryMap.put("HTI", "海地");
        codeCountryMap.put("HUN", "匈牙利");
        codeCountryMap.put("IDN", "印度尼西亚");
        codeCountryMap.put("IRL", "爱尔兰");
        codeCountryMap.put("ISR", "以色列");
        codeCountryMap.put("IND", "印度");
        codeCountryMap.put("IOT", "英属印度洋领地");
        codeCountryMap.put("IRQ", "伊拉克");
        codeCountryMap.put("IRN", "伊朗");
        codeCountryMap.put("ISL", "冰岛");
        codeCountryMap.put("ITA", "意大利");
        codeCountryMap.put("JAM", "牙买加");
        codeCountryMap.put("JOR", "约旦");
        codeCountryMap.put("JPN", "日本");
        codeCountryMap.put("KEN", "肯尼亚");
        codeCountryMap.put("KGZ", "吉尔吉斯斯坦");
        codeCountryMap.put("KHM", "柬埔寨");
        codeCountryMap.put("KIR", "基里巴斯");
        codeCountryMap.put("SHN", "圣赫勒拿");
        codeCountryMap.put("SVN", "斯洛文尼亚");
        codeCountryMap.put("SJM", "斯瓦尔巴群岛和扬马延岛");
        codeCountryMap.put("SVK", "斯洛伐克");
        codeCountryMap.put("SLE", "塞拉利昂");
        codeCountryMap.put("SMR", "圣马力诺");
        codeCountryMap.put("SEN", "塞内加尔");
        codeCountryMap.put("SOM", "索马里");
        codeCountryMap.put("SUR", "苏里南");
        codeCountryMap.put("STP", "圣多美和普林西比");
        codeCountryMap.put("SLV", "萨尔瓦多");
        codeCountryMap.put("SYR", "叙利亚");
        codeCountryMap.put("SWZ", "斯威士兰");
        codeCountryMap.put("TCA", "特克斯和凯科斯群岛");
        codeCountryMap.put("TCD", "乍得");
        codeCountryMap.put("ATF", "法属南部领地");
        codeCountryMap.put("TGO", "多哥");
        codeCountryMap.put("THA", "泰国");
        codeCountryMap.put("TJK", "塔吉克斯坦");
        codeCountryMap.put("TKL", "托克劳");
        codeCountryMap.put("TLS", "东帝汶");
        codeCountryMap.put("TKM", "土库曼斯坦");
        codeCountryMap.put("TUN", "突尼斯");
        codeCountryMap.put("TON", "汤加");
        codeCountryMap.put("TUR", "土耳其");
        codeCountryMap.put("TTO", "特立尼达和多巴哥");
        codeCountryMap.put("TUV", "图瓦卢");
        codeCountryMap.put("TWN", "台湾");
        codeCountryMap.put("TZA", "坦桑尼亚");
        codeCountryMap.put("UKR", "乌克兰");
        codeCountryMap.put("UGA", "乌干达");
        codeCountryMap.put("UMI", "美国本土外小岛屿");
        codeCountryMap.put("USA", "美国");
        codeCountryMap.put("URY", "乌拉圭");
        codeCountryMap.put("UZB", "乌兹别克斯坦");
        codeCountryMap.put("VAT", "梵蒂冈");
        codeCountryMap.put("VCT", "圣文森特和格林纳丁斯");
        codeCountryMap.put("VEN", "委内瑞拉");
        codeCountryMap.put("VGB", "英属维尔京群岛");
        codeCountryMap.put("VIR", "美属维尔京群岛");
        codeCountryMap.put("VNM", "越南");
        codeCountryMap.put("VUT", "瓦努阿图");
        codeCountryMap.put("WLF", "瓦利斯和富图纳");
        codeCountryMap.put("AND", "安道尔");
        codeCountryMap.put("ARE", "阿联酋");
        codeCountryMap.put("AFG", "阿富汗");
        codeCountryMap.put("ATG", "安提瓜和巴布达");
        codeCountryMap.put("AIA", "安圭拉");
        codeCountryMap.put("ALB", "阿尔巴尼亚");
        codeCountryMap.put("ARM", "亚美尼亚");
        codeCountryMap.put("ANT", "荷属安的列斯");
        codeCountryMap.put("AGO", "安哥拉");
        codeCountryMap.put("MTQ", "马提尼克");
        codeCountryMap.put("MRT", "毛里塔尼亚");
        codeCountryMap.put("MSR", "蒙特塞拉特");
        codeCountryMap.put("MLT", "马耳他");
        codeCountryMap.put("MUS", "毛里求斯");
        codeCountryMap.put("MDV", "马尔代夫");
        codeCountryMap.put("MWI", "马拉维");
        codeCountryMap.put("MEX", "墨西哥");
        codeCountryMap.put("MYS", "马来西亚");
        codeCountryMap.put("MOZ", "莫桑比克");
        codeCountryMap.put("NAM", "纳米比亚");
        codeCountryMap.put("NCL", "新喀里多尼亚");
        codeCountryMap.put("NER", "尼日尔");
        codeCountryMap.put("NFK", "诺福克岛");
        codeCountryMap.put("NGA", "尼日利亚");
        codeCountryMap.put("NIC", "尼加拉瓜");
        codeCountryMap.put("NLD", "荷兰");
        codeCountryMap.put("NOR", "挪威");
        codeCountryMap.put("NPL", "尼泊尔");
        codeCountryMap.put("NRU", "瑙鲁");
        codeCountryMap.put("NIU", "纽埃");
        codeCountryMap.put("NZL", "新西兰");
        codeCountryMap.put("OMN", "阿曼");
        codeCountryMap.put("PAN", "巴拿马");
        codeCountryMap.put("PER", "秘鲁");
        codeCountryMap.put("PYF", "法属波利尼西亚");
        codeCountryMap.put("PNG", "巴布亚新几内亚");
        codeCountryMap.put("PHL", "菲律宾");
        codeCountryMap.put("PAK", "巴基斯坦");
        codeCountryMap.put("POL", "波兰");
        codeCountryMap.put("SPM", "圣皮埃尔和密克隆群岛");
        codeCountryMap.put("PCN", "皮特凯恩群岛");
        codeCountryMap.put("PRI", "波多黎各");
        codeCountryMap.put("PSE", "巴勒斯坦");
        codeCountryMap.put("PRT", "葡萄牙");
        codeCountryMap.put("PLW", "帕劳");
        codeCountryMap.put("PRY", "巴拉圭");
        codeCountryMap.put("QAT", "卡塔尔");
        codeCountryMap.put("REU", "留尼汪");
        codeCountryMap.put("ROU", "罗马尼亚");
        codeCountryMap.put("RUS", "俄罗斯");
        codeCountryMap.put("RWA", "卢旺达");
        codeCountryMap.put("SAU", "沙特阿拉伯");
        codeCountryMap.put("SLB", "所罗门群岛");
        codeCountryMap.put("SYC", "塞舌尔");
        codeCountryMap.put("SDN", "苏丹");
        codeCountryMap.put("SWE", "瑞典");
        codeCountryMap.put("SGP", "新加坡");
        codeCountryMap.put("GBD", "英国（独立领土公民，出国不用）");
        codeCountryMap.put("GBP", "英国（保护公民，出国不用）");
        codeCountryMap.put("GBS", "英国（隶属，出国不用）");
        codeCountryMap.put("JTN", "约翰斯顿岛");
        codeCountryMap.put("MID", "中途岛");
        codeCountryMap.put("PST", "巴勒斯坦");
        codeCountryMap.put("ROM", "罗马尼亚");
        codeCountryMap.put("SS", "塞班");
        codeCountryMap.put("SX", "锡金");
        codeCountryMap.put("SF", "塞尔维亚");
        codeCountryMap.put("TMP", "东帝汶");
        codeCountryMap.put("UN", "联合国");
        codeCountryMap.put("UNA", "联合国");
        codeCountryMap.put("UNO", "联合国");
        codeCountryMap.put("WAK", "威克岛");
        codeCountryMap.put("XXA", "无国籍（无国籍人）");
        codeCountryMap.put("XXB", "被联合国承认的难民");
        codeCountryMap.put("XXC", "不被联合国承认的难民");
        codeCountryMap.put("XXX", "国籍不明");
        codeCountryMap.put("GBN", "英国（海外国民，出国不用）");
        codeCountryMap.put("YUG", "南斯拉夫");
        codeCountryMap.put("ZAR", "扎伊尔");
        codeCountryMap.put("ZZZ", "国籍不详");
        codeCountryMap.put("GBO", "英国（海外公民，出国不用）");
        codeCountryMap.put("NTZ", "中间地带");
        codeCountryMap.put("EMP", "未知");
        codeCountryMap.put("CI", "锡金");
        codeCountryMap.put("COM", "科摩罗");
        codeCountryMap.put("KNA", "圣基茨和尼维斯");
        codeCountryMap.put("PRK", "朝鲜");
        codeCountryMap.put("KOR", "韩国");
        codeCountryMap.put("KWT", "科威特");
        codeCountryMap.put("CYM", "开曼群岛");
        codeCountryMap.put("KAZ", "哈萨克斯坦");
        codeCountryMap.put("LAO", "老挝");
        codeCountryMap.put("LBN", "黎巴嫩");
        codeCountryMap.put("LCA", "圣卢西亚");
        codeCountryMap.put("LIE", "列支敦士登");
        codeCountryMap.put("LKA", "斯里兰卡");
        codeCountryMap.put("LBR", "利比里亚");
        codeCountryMap.put("LSO", "莱索托");
        codeCountryMap.put("LTU", "立陶宛");
        codeCountryMap.put("LUX", "卢森堡");
        codeCountryMap.put("LVA", "拉脱维亚");
        codeCountryMap.put("LBY", "利比亚");
        codeCountryMap.put("MAR", "摩洛哥");
        codeCountryMap.put("MCO", "摩纳哥");
        codeCountryMap.put("MDA", "摩尔多瓦");
        codeCountryMap.put("MDG", "马达加斯加");
        codeCountryMap.put("MHL", "马绍尔群岛");
        codeCountryMap.put("MKD", "前南马其顿");
        codeCountryMap.put("MLI", "马里");
        codeCountryMap.put("MMR", "缅甸");
        codeCountryMap.put("MNG", "蒙古");
        codeCountryMap.put("MAC", "澳门");
        codeCountryMap.put("MNP", "北马里亚纳群岛");
    }

    static {
        countryCodeMap.put("中国", "CHN");
        countryCodeMap.put("南极洲", "ATA");
        countryCodeMap.put("阿根廷", "ARG");
        countryCodeMap.put("美属萨摩亚", "ASM");
        countryCodeMap.put("奥地利", "AUT");
        countryCodeMap.put("澳大利亚", "AUS");
        countryCodeMap.put("阿鲁巴", "ABW");
        countryCodeMap.put("奥兰群岛", "ALA");
        countryCodeMap.put("阿塞拜疆", "AZE");
        countryCodeMap.put("波黑", "BIH");
        countryCodeMap.put("巴巴多斯", "BRB");
        countryCodeMap.put("孟加拉国", "BGD");
        countryCodeMap.put("比利时", "BEL");
        countryCodeMap.put("布基纳法索", "BFA");
        countryCodeMap.put("保加利亚", "BGR");
        countryCodeMap.put("巴林", "BHR");
        countryCodeMap.put("布隆迪", "BDI");
        countryCodeMap.put("贝宁", "BEN");
        countryCodeMap.put("百慕大", "BMU");
        countryCodeMap.put("文莱", "BRN");
        countryCodeMap.put("玻利维亚", "BOL");
        countryCodeMap.put("巴西", "BRA");
        countryCodeMap.put("巴哈马", "BHS");
        countryCodeMap.put("不丹", "BTN");
        countryCodeMap.put("布维岛", "BVT");
        countryCodeMap.put("博茨瓦纳", "BWA");
        countryCodeMap.put("白俄罗斯", "BLR");
        countryCodeMap.put("伯利兹", "BLZ");
        countryCodeMap.put("加拿大", "CAN");
        countryCodeMap.put("科科斯（基林）群岛", "CCK");
        countryCodeMap.put("刚果（金）", "COD");
        countryCodeMap.put("中非", "CAF");
        countryCodeMap.put("刚果（布）", "COG");
        countryCodeMap.put("瑞士", "CHE");
        countryCodeMap.put("科特迪瓦", "CIV");
        countryCodeMap.put("库克群岛", "COK");
        countryCodeMap.put("智利", "CHL");
        countryCodeMap.put("喀麦隆", "CMR");
        countryCodeMap.put("哥伦比亚", "COL");
        countryCodeMap.put("哥斯达黎加", "CRI");
        countryCodeMap.put("塞尔维亚和黑山", "SCG");
        countryCodeMap.put("古巴", "CUB");
        countryCodeMap.put("佛得角", "CPV");
        countryCodeMap.put("圣诞岛", "CXR");
        countryCodeMap.put("塞浦路斯", "CYP");
        countryCodeMap.put("捷克", "CZE");
        countryCodeMap.put("德国", "DEU");
        countryCodeMap.put("吉布提", "DJI");
        countryCodeMap.put("丹麦", "DNK");
        countryCodeMap.put("多米尼克", "DMA");
        countryCodeMap.put("多米尼加共和国", "DOM");
        countryCodeMap.put("阿尔及利亚", "DZA");
        countryCodeMap.put("厄瓜多尔", "ECU");
        countryCodeMap.put("爱沙尼亚", "EST");
        countryCodeMap.put("埃及", "EGY");
        countryCodeMap.put("西撒哈拉", "ESH");
        countryCodeMap.put("厄立特里亚", "ERI");
        countryCodeMap.put("西班牙", "ESP");
        countryCodeMap.put("埃塞俄比亚", "ETH");
        countryCodeMap.put("芬兰", "FIN");
        countryCodeMap.put("斐济", "FJI");
        countryCodeMap.put("福克兰群岛（马尔维纳斯）", "FLK");
        countryCodeMap.put("密克罗尼西亚", "FSM");
        countryCodeMap.put("法罗群岛", "FRO");
        countryCodeMap.put("法国", "FRA");
        countryCodeMap.put("加蓬", "GAB");
        countryCodeMap.put("英国", "GBR");
        countryCodeMap.put("格林纳达", "GRD");
        countryCodeMap.put("格鲁吉亚", "GEO");
        countryCodeMap.put("法属圭亚那", "GUF");
        countryCodeMap.put("加纳", "GHA");
        countryCodeMap.put("直布罗陀", "GIB");
        countryCodeMap.put("格陵兰", "GRL");
        countryCodeMap.put("冈比亚", "GMB");
        countryCodeMap.put("几内亚", "GIN");
        countryCodeMap.put("萨摩亚", "WSM");
        countryCodeMap.put("也门", "YEM");
        countryCodeMap.put("马约特", "MYT");
        countryCodeMap.put("南非", "ZAF");
        countryCodeMap.put("赞比亚", "ZMB");
        countryCodeMap.put("津巴布韦", "ZWE");
        countryCodeMap.put("瓜德罗普", "GLP");
        countryCodeMap.put("赤道几内亚", "GNQ");
        countryCodeMap.put("希腊", "GRC");
        countryCodeMap.put("南乔治亚和南桑德韦奇群岛", "SGS");
        countryCodeMap.put("危地马拉", "GTM");
        countryCodeMap.put("关岛", "GUM");
        countryCodeMap.put("几内亚比绍", "GNB");
        countryCodeMap.put("圭亚那", "GUY");
        countryCodeMap.put("香港", "HKG");
        countryCodeMap.put("赫德岛和麦克唐纳群岛", "HMD");
        countryCodeMap.put("洪都拉斯", "HND");
        countryCodeMap.put("克罗地亚", "HRV");
        countryCodeMap.put("海地", "HTI");
        countryCodeMap.put("匈牙利", "HUN");
        countryCodeMap.put("印度尼西亚", "IDN");
        countryCodeMap.put("爱尔兰", "IRL");
        countryCodeMap.put("以色列", "ISR");
        countryCodeMap.put("印度", "IND");
        countryCodeMap.put("英属印度洋领地", "IOT");
        countryCodeMap.put("伊拉克", "IRQ");
        countryCodeMap.put("伊朗", "IRN");
        countryCodeMap.put("冰岛", "ISL");
        countryCodeMap.put("意大利", "ITA");
        countryCodeMap.put("牙买加", "JAM");
        countryCodeMap.put("约旦", "JOR");
        countryCodeMap.put("日本", "JPN");
        countryCodeMap.put("肯尼亚", "KEN");
        countryCodeMap.put("吉尔吉斯斯坦", "KGZ");
        countryCodeMap.put("柬埔寨", "KHM");
        countryCodeMap.put("基里巴斯", "KIR");
        countryCodeMap.put("圣赫勒拿", "SHN");
        countryCodeMap.put("斯洛文尼亚", "SVN");
        countryCodeMap.put("斯瓦尔巴群岛和扬马延岛", "SJM");
        countryCodeMap.put("斯洛伐克", "SVK");
        countryCodeMap.put("塞拉利昂", "SLE");
        countryCodeMap.put("圣马力诺", "SMR");
        countryCodeMap.put("塞内加尔", "SEN");
        countryCodeMap.put("索马里", "SOM");
        countryCodeMap.put("苏里南", "SUR");
        countryCodeMap.put("圣多美和普林西比", "STP");
        countryCodeMap.put("萨尔瓦多", "SLV");
        countryCodeMap.put("叙利亚", "SYR");
        countryCodeMap.put("斯威士兰", "SWZ");
        countryCodeMap.put("特克斯和凯科斯群岛", "TCA");
        countryCodeMap.put("乍得", "TCD");
        countryCodeMap.put("法属南部领地", "ATF");
        countryCodeMap.put("多哥", "TGO");
        countryCodeMap.put("泰国", "THA");
        countryCodeMap.put("塔吉克斯坦", "TJK");
        countryCodeMap.put("托克劳", "TKL");
        countryCodeMap.put("东帝汶", "TLS");
        countryCodeMap.put("土库曼斯坦", "TKM");
        countryCodeMap.put("突尼斯", "TUN");
        countryCodeMap.put("汤加", "TON");
        countryCodeMap.put("土耳其", "TUR");
        countryCodeMap.put("特立尼达和多巴哥", "TTO");
        countryCodeMap.put("图瓦卢", "TUV");
        countryCodeMap.put("台湾", "TWN");
        countryCodeMap.put("坦桑尼亚", "TZA");
        countryCodeMap.put("乌克兰", "UKR");
        countryCodeMap.put("乌干达", "UGA");
        countryCodeMap.put("美国本土外小岛屿", "UMI");
        countryCodeMap.put("美国", "USA");
        countryCodeMap.put("乌拉圭", "URY");
        countryCodeMap.put("乌兹别克斯坦", "UZB");
        countryCodeMap.put("梵蒂冈", "VAT");
        countryCodeMap.put("圣文森特和格林纳丁斯", "VCT");
        countryCodeMap.put("委内瑞拉", "VEN");
        countryCodeMap.put("英属维尔京群岛", "VGB");
        countryCodeMap.put("美属维尔京群岛", "VIR");
        countryCodeMap.put("越南", "VNM");
        countryCodeMap.put("瓦努阿图", "VUT");
        countryCodeMap.put("瓦利斯和富图纳", "WLF");
        countryCodeMap.put("安道尔", "AND");
        countryCodeMap.put("阿联酋", "ARE");
        countryCodeMap.put("阿富汗", "AFG");
        countryCodeMap.put("安提瓜和巴布达", "ATG");
        countryCodeMap.put("安圭拉", "AIA");
        countryCodeMap.put("阿尔巴尼亚", "ALB");
        countryCodeMap.put("亚美尼亚", "ARM");
        countryCodeMap.put("荷属安的列斯", "ANT");
        countryCodeMap.put("安哥拉", "AGO");
        countryCodeMap.put("马提尼克", "MTQ");
        countryCodeMap.put("毛里塔尼亚", "MRT");
        countryCodeMap.put("蒙特塞拉特", "MSR");
        countryCodeMap.put("马耳他", "MLT");
        countryCodeMap.put("毛里求斯", "MUS");
        countryCodeMap.put("马尔代夫", "MDV");
        countryCodeMap.put("马拉维", "MWI");
        countryCodeMap.put("墨西哥", "MEX");
        countryCodeMap.put("马来西亚", "MYS");
        countryCodeMap.put("莫桑比克", "MOZ");
        countryCodeMap.put("纳米比亚", "NAM");
        countryCodeMap.put("新喀里多尼亚", "NCL");
        countryCodeMap.put("尼日尔", "NER");
        countryCodeMap.put("诺福克岛", "NFK");
        countryCodeMap.put("尼日利亚", "NGA");
        countryCodeMap.put("尼加拉瓜", "NIC");
        countryCodeMap.put("荷兰", "NLD");
        countryCodeMap.put("挪威", "NOR");
        countryCodeMap.put("尼泊尔", "NPL");
        countryCodeMap.put("瑙鲁", "NRU");
        countryCodeMap.put("纽埃", "NIU");
        countryCodeMap.put("新西兰", "NZL");
        countryCodeMap.put("阿曼", "OMN");
        countryCodeMap.put("巴拿马", "PAN");
        countryCodeMap.put("秘鲁", "PER");
        countryCodeMap.put("法属波利尼西亚", "PYF");
        countryCodeMap.put("巴布亚新几内亚", "PNG");
        countryCodeMap.put("菲律宾", "PHL");
        countryCodeMap.put("巴基斯坦", "PAK");
        countryCodeMap.put("波兰", "POL");
        countryCodeMap.put("圣皮埃尔和密克隆群岛", "SPM");
        countryCodeMap.put("皮特凯恩群岛", "PCN");
        countryCodeMap.put("波多黎各", "PRI");
        countryCodeMap.put("巴勒斯坦", "PSE");
        countryCodeMap.put("葡萄牙", "PRT");
        countryCodeMap.put("帕劳", "PLW");
        countryCodeMap.put("巴拉圭", "PRY");
        countryCodeMap.put("卡塔尔", "QAT");
        countryCodeMap.put("留尼汪", "REU");
        countryCodeMap.put("罗马尼亚", "ROU");
        countryCodeMap.put("俄罗斯", "RUS");
        countryCodeMap.put("卢旺达", "RWA");
        countryCodeMap.put("沙特阿拉伯", "SAU");
        countryCodeMap.put("所罗门群岛", "SLB");
        countryCodeMap.put("塞舌尔", "SYC");
        countryCodeMap.put("苏丹", "SDN");
        countryCodeMap.put("瑞典", "SWE");
        countryCodeMap.put("新加坡", "SGP");
        countryCodeMap.put("英国（独立领土公民，出国不用）", "GBD");
        countryCodeMap.put("英国（保护公民，出国不用）", "GBP");
        countryCodeMap.put("英国（隶属，出国不用）", "GBS");
        countryCodeMap.put("约翰斯顿岛", "JTN");
        countryCodeMap.put("中途岛", "MID");
        countryCodeMap.put("巴勒斯坦", "PST");
        countryCodeMap.put("罗马尼亚", "ROM");
        countryCodeMap.put("塞班", "SS");
        countryCodeMap.put("锡金", "SX");
        countryCodeMap.put("塞尔维亚", "SF");
        countryCodeMap.put("东帝汶", "TMP");
        countryCodeMap.put("联合国", "UN");
        countryCodeMap.put("联合国", "UNA");
        countryCodeMap.put("联合国", "UNO");
        countryCodeMap.put("威克岛", "WAK");
        countryCodeMap.put("无国籍（无国籍人）", "XXA");
        countryCodeMap.put("被联合国承认的难民", "XXB");
        countryCodeMap.put("不被联合国承认的难民", "XXC");
        countryCodeMap.put("国籍不明", "XXX");
        countryCodeMap.put("英国（海外国民，出国不用）", "GBN");
        countryCodeMap.put("南斯拉夫", "YUG");
        countryCodeMap.put("扎伊尔", "ZAR");
        countryCodeMap.put("国籍不详", "ZZZ");
        countryCodeMap.put("英国（海外公民，出国不用）", "GBO");
        countryCodeMap.put("中间地带", "NTZ");
        countryCodeMap.put("未知", "EMP");
        countryCodeMap.put("锡金", "CI");
        countryCodeMap.put("科摩罗", "COM");
        countryCodeMap.put("圣基茨和尼维斯", "KNA");
        countryCodeMap.put("朝鲜", "PRK");
        countryCodeMap.put("韩国", "KOR");
        countryCodeMap.put("科威特", "KWT");
        countryCodeMap.put("开曼群岛", "CYM");
        countryCodeMap.put("哈萨克斯坦", "KAZ");
        countryCodeMap.put("老挝", "LAO");
        countryCodeMap.put("黎巴嫩", "LBN");
        countryCodeMap.put("圣卢西亚", "LCA");
        countryCodeMap.put("列支敦士登", "LIE");
        countryCodeMap.put("斯里兰卡", "LKA");
        countryCodeMap.put("利比里亚", "LBR");
        countryCodeMap.put("莱索托", "LSO");
        countryCodeMap.put("立陶宛", "LTU");
        countryCodeMap.put("卢森堡", "LUX");
        countryCodeMap.put("拉脱维亚", "LVA");
        countryCodeMap.put("利比亚", "LBY");
        countryCodeMap.put("摩洛哥", "MAR");
        countryCodeMap.put("摩纳哥", "MCO");
        countryCodeMap.put("摩尔多瓦", "MDA");
        countryCodeMap.put("马达加斯加", "MDG");
        countryCodeMap.put("马绍尔群岛", "MHL");
        countryCodeMap.put("前南马其顿", "MKD");
        countryCodeMap.put("马里", "MLI");
        countryCodeMap.put("缅甸", "MMR");
        countryCodeMap.put("蒙古", "MNG");
        countryCodeMap.put("澳门", "MAC");
        countryCodeMap.put("北马里亚纳群岛", "MNP");
    }

    static {
        codeCardType_CN_Map.put("11", "身份证");
        codeCardType_CN_Map.put("12", "居住证");
        codeCardType_CN_Map.put("13", "户口本");
        codeCardType_CN_Map.put("90", "军官证");
        codeCardType_CN_Map.put("91", "警官证");
        codeCardType_CN_Map.put("92", "士兵证");
        codeCardType_CN_Map.put("93", "国内护照");
        codeCardType_CN_Map.put("94", "驾照");
        codeCardType_CN_Map.put("95", "港澳通行证");
        codeCardType_CN_Map.put("99", "其他");
    }

    static {
        cardTypeCode_CN_Map.put("身份证", "11");
        cardTypeCode_CN_Map.put("居住证", "12");
        cardTypeCode_CN_Map.put("户口本", "13");
        cardTypeCode_CN_Map.put("军官证", "90");
        cardTypeCode_CN_Map.put("警官证", "91");
        cardTypeCode_CN_Map.put("士兵证", "92");
        cardTypeCode_CN_Map.put("国内护照", "93");
        cardTypeCode_CN_Map.put("驾照", "94");
        cardTypeCode_CN_Map.put("港澳通行证", "95");
        cardTypeCode_CN_Map.put("其他", "99");
    }


    static {
        codeCardTypeMap.put("00", "无证件");
        codeCardTypeMap.put("06", "台湾居民来往大陆通行证（一次有效）");
        codeCardTypeMap.put("09", "居住证");
        codeCardTypeMap.put("10", "身份证");
        codeCardTypeMap.put("11", "外交护照");
        codeCardTypeMap.put("12", "公务护照");
        codeCardTypeMap.put("13", "因公普通护照");
        codeCardTypeMap.put("14", "普通护照");
        codeCardTypeMap.put("15", "中华人民共和国旅行证");
        codeCardTypeMap.put("16", "台湾居民来往大陆通行证");
        codeCardTypeMap.put("17", "海员证");
        codeCardTypeMap.put("18", "机组人员证");
        codeCardTypeMap.put("19", "铁路员工证");
        codeCardTypeMap.put("20", "中华人民共和国入出境通行证");
        codeCardTypeMap.put("21", "往来港澳通行证");
        codeCardTypeMap.put("22", "回美证");
        codeCardTypeMap.put("23", "前往港澳通行证");
        codeCardTypeMap.put("24", "港,澳同胞回乡证");
        codeCardTypeMap.put("25", "大陆居民往来港澳通行证");
        codeCardTypeMap.put("26", "往来香港特别行政区通行证");
        codeCardTypeMap.put("27", "台湾居民身份证");
        codeCardTypeMap.put("28", "华侨回国定居证");
        codeCardTypeMap.put("29", "台湾同胞定居证");
        codeCardTypeMap.put("30", "外国人出入境通行证");
        codeCardTypeMap.put("31", "外国人旅行证件");
        codeCardTypeMap.put("32", "外国人居留证");
        codeCardTypeMap.put("33", "外国人临时居留证");
        codeCardTypeMap.put("34", "外国人永久居留证");
        codeCardTypeMap.put("35", "入籍证书");
        codeCardTypeMap.put("36", "出籍证件");
        codeCardTypeMap.put("37", "复籍证书");
        codeCardTypeMap.put("38", "暂住证");
        codeCardTypeMap.put("3E", "特区旅游签证");
        codeCardTypeMap.put("3P", "普通签证");
        codeCardTypeMap.put("3T", "团队签证");
        codeCardTypeMap.put("40", "出海渔船民证");
        codeCardTypeMap.put("41", "临时出海渔船民证");
        codeCardTypeMap.put("42", "出海船舶户口簿");
        codeCardTypeMap.put("43", "出海船舶户口证");
        codeCardTypeMap.put("44", "粤港澳流动渔民证");
        codeCardTypeMap.put("45", "粤港澳临时流动渔民证");
        codeCardTypeMap.put("46", "粤港澳流动渔船户口簿");
        codeCardTypeMap.put("47", "搭靠台轮许可证");
        codeCardTypeMap.put("48", "劳务人员登轮作业证");
        codeCardTypeMap.put("49", "台湾居民登陆证");
        codeCardTypeMap.put("50", "贸易证");
        codeCardTypeMap.put("52", "外交官员证");
        codeCardTypeMap.put("53", "领事官员证");
        codeCardTypeMap.put("60", "港澳居民来往内地通行证");
        codeCardTypeMap.put("61", "深圳市过境耕作证");
        codeCardTypeMap.put("70", "香港特别行政区护照");
        codeCardTypeMap.put("71", "澳门特别行政区护照");
        codeCardTypeMap.put("72", "港澳特区通行证（高官证）");
        codeCardTypeMap.put("73", "港澳特区通行证（普通证）");
        codeCardTypeMap.put("74", "港澳证贴纸签注");
        codeCardTypeMap.put("75", "大陆证贴纸签注");
        codeCardTypeMap.put("76", "台湾居民居留贴纸签注");
        codeCardTypeMap.put("77", "台湾居民来往贴纸签注");
        codeCardTypeMap.put("78", "护照贴纸备注");
        codeCardTypeMap.put("81", "缅甸中国通行证");
        codeCardTypeMap.put("82", "云南边境地区境外边民入出境证");
        codeCardTypeMap.put("90", "中朝边境地区出入境通行证");
        codeCardTypeMap.put("91", "朝中边境地区居民过境通行证");
        codeCardTypeMap.put("92", "鸭绿江、图门江水文作业证");
        codeCardTypeMap.put("93", "中朝流筏固定代表证");
        codeCardTypeMap.put("94", "中朝鸭绿江图们江航行船舶船员证");
        codeCardTypeMap.put("95", "中朝边境地区公安总代表证");
        codeCardTypeMap.put("96", "中朝边境地区公安副总代表证");
        codeCardTypeMap.put("97", "中朝边境地区公安代表证");
        codeCardTypeMap.put("98", "遗失证件");
        codeCardTypeMap.put("99", "其它证件");
        codeCardTypeMap.put("ZZ", "无证件");
    }

    static {
        cardTypeCodeMap.put("无证件", "00");
        cardTypeCodeMap.put("台湾居民来往大陆通行证（一次有效）", "06");
        cardTypeCodeMap.put("居住证", "09");
        cardTypeCodeMap.put("身份证", "10");
        cardTypeCodeMap.put("外交护照", "11");
        cardTypeCodeMap.put("公务护照", "12");
        cardTypeCodeMap.put("因公普通护照", "13");
        cardTypeCodeMap.put("普通护照", "14");
        cardTypeCodeMap.put("中华人民共和国旅行证", "15");
        cardTypeCodeMap.put("台湾居民来往大陆通行证", "16");
        cardTypeCodeMap.put("海员证", "17");
        cardTypeCodeMap.put("机组人员证", "18");
        cardTypeCodeMap.put("铁路员工证", "19");
        cardTypeCodeMap.put("中华人民共和国入出境通行证", "20");
        cardTypeCodeMap.put("往来港澳通行证", "21");
        cardTypeCodeMap.put("回美证", "22");
        cardTypeCodeMap.put("前往港澳通行证", "23");
        cardTypeCodeMap.put("港,澳同胞回乡证", "24");
        cardTypeCodeMap.put("大陆居民往来港澳通行证", "25");
        cardTypeCodeMap.put("往来香港特别行政区通行证", "26");
        cardTypeCodeMap.put("台湾居民身份证", "27");
        cardTypeCodeMap.put("华侨回国定居证", "28");
        cardTypeCodeMap.put("台湾同胞定居证", "29");
        cardTypeCodeMap.put("外国人出入境通行证", "30");
        cardTypeCodeMap.put("外国人旅行证件", "31");
        cardTypeCodeMap.put("外国人居留证", "32");
        cardTypeCodeMap.put("外国人临时居留证", "33");
        cardTypeCodeMap.put("外国人永久居留证", "34");
        cardTypeCodeMap.put("入籍证书", "35");
        cardTypeCodeMap.put("出籍证件", "36");
        cardTypeCodeMap.put("复籍证书", "37");
        cardTypeCodeMap.put("暂住证", "38");
        cardTypeCodeMap.put("特区旅游签证", "3E");
        cardTypeCodeMap.put("普通签证", "3P");
        cardTypeCodeMap.put("团队签证", "3T");
        cardTypeCodeMap.put("出海渔船民证", "40");
        cardTypeCodeMap.put("临时出海渔船民证", "41");
        cardTypeCodeMap.put("出海船舶户口簿", "42");
        cardTypeCodeMap.put("出海船舶户口证", "43");
        cardTypeCodeMap.put("粤港澳流动渔民证", "44");
        cardTypeCodeMap.put("粤港澳临时流动渔民证", "45");
        cardTypeCodeMap.put("粤港澳流动渔船户口簿", "46");
        cardTypeCodeMap.put("搭靠台轮许可证", "47");
        cardTypeCodeMap.put("劳务人员登轮作业证", "48");
        cardTypeCodeMap.put("台湾居民登陆证", "49");
        cardTypeCodeMap.put("贸易证", "50");
        cardTypeCodeMap.put("外交官员证", "52");
        cardTypeCodeMap.put("领事官员证", "53");
        cardTypeCodeMap.put("港澳居民来往内地通行证", "60");
        cardTypeCodeMap.put("深圳市过境耕作证", "61");
        cardTypeCodeMap.put("香港特别行政区护照", "70");
        cardTypeCodeMap.put("澳门特别行政区护照", "71");
        cardTypeCodeMap.put("港澳特区通行证（高官证）", "72");
        cardTypeCodeMap.put("港澳特区通行证（普通证）", "73");
        cardTypeCodeMap.put("港澳证贴纸签注", "74");
        cardTypeCodeMap.put("大陆证贴纸签注", "75");
        cardTypeCodeMap.put("台湾居民居留贴纸签注", "76");
        cardTypeCodeMap.put("台湾居民来往贴纸签注", "77");
        cardTypeCodeMap.put("护照贴纸备注", "78");
        cardTypeCodeMap.put("缅甸中国通行证", "81");
        cardTypeCodeMap.put("云南边境地区境外边民入出境证", "82");
        cardTypeCodeMap.put("中朝边境地区出入境通行证", "90");
        cardTypeCodeMap.put("朝中边境地区居民过境通行证", "91");
        cardTypeCodeMap.put("鸭绿江、图门江水文作业证", "92");
        cardTypeCodeMap.put("中朝流筏固定代表证", "93");
        cardTypeCodeMap.put("中朝鸭绿江图们江航行船舶船员证", "94");
        cardTypeCodeMap.put("中朝边境地区公安总代表证", "95");
        cardTypeCodeMap.put("中朝边境地区公安副总代表证", "96");
        cardTypeCodeMap.put("中朝边境地区公安代表证", "97");
        cardTypeCodeMap.put("遗失证件", "98");
        cardTypeCodeMap.put("其它证件", "99");
        cardTypeCodeMap.put("无证件", "ZZ");
    }

    static {
        sexCodeMap.put("男", "1");
        sexCodeMap.put("女", "2");
        sexCodeMap.put("不详", "3");
    }

    static {
        codeSexMap.put("1", "男");
        codeSexMap.put("2", "女");
        codeSexMap.put("3", "不详");
    }

    static {
        codeOcrMap.put("2", "居民身份证-照片页");
        codeOcrMap.put("3", "居民身份证-签发机关页");
        codeOcrMap.put("4", "临时居民身份证");
        codeOcrMap.put("5", "机动车驾驶证");
        codeOcrMap.put("6", "机动车行驶证");
        codeOcrMap.put("7", "军官证 1998 版");
        codeOcrMap.put("8", "士兵证 1998 版");
        codeOcrMap.put("9", "往来港澳通行证2005版护照幅面");
        codeOcrMap.put("10", "台湾居民来往大陆通行证 1992 版-照片页");
        codeOcrMap.put("11", "大陆居民往来台湾通行证 1992 版-照片页");
        codeOcrMap.put("12", "签证");
        codeOcrMap.put("13", "护照");
        codeOcrMap.put("14", "港澳居民来往内地通行证-照片页");
        codeOcrMap.put("15", "港澳居民来往内地通行证-机读码页");
        codeOcrMap.put("16", "常住人口登记卡");
        codeOcrMap.put("17", "海员证 2009 版-照片页");
        codeOcrMap.put("18", "军官证 1998 版-照片页（电子护照设备支持）");
        codeOcrMap.put("19", "军官证 1998 版-信息页（电子护照设备支持）");
        codeOcrMap.put("20", "警官证 2006 版-照片页");
        codeOcrMap.put("21", "警官证 2006 版-信息页");
        codeOcrMap.put("22", "往来港澳通行证 2014 版-照片页");
        codeOcrMap.put("23", "边境地区出入境通行证 2014 版-照片页 ");
        codeOcrMap.put("24", "中国人民解放军车辆驾驶证 2010 版 ");
        codeOcrMap.put("25", "台湾居民来往大陆通行证 2015 版-照片页");
        codeOcrMap.put("26", "台湾居民来往大陆通行证 2015 版-机读码页");
        codeOcrMap.put("27", "中国人民解放军行车执照 2012 版 ");
        codeOcrMap.put("29", "往来台湾通行证 2017 版-照片页");
        codeOcrMap.put("1000", "居住证（广东、广西、东莞）-照片页");
        codeOcrMap.put("1001", "香港居民身份证 2003 版 -照片页");
        codeOcrMap.put("1002", "登机牌（拍照设备目前不支持登机牌的识别）");
        codeOcrMap.put("1003", "边境地区出入境通行证 2005 版-照片页）");
        codeOcrMap.put("1004", "边境地区出入境通行证 2005 版-信息页");
        codeOcrMap.put("1005", "澳门居民身份证-照片页 ");
        codeOcrMap.put("1006", "领取凭证(扫描仪支持) ");
        codeOcrMap.put("1007", "律师执业证-签发机关页");
        codeOcrMap.put("1008", "律师执业证-照片页");
        codeOcrMap.put("1009", "中华人民共和国道路运输证 IC 卡");
        codeOcrMap.put("1010", "名片");
        codeOcrMap.put("1011", "组织机构代码证");
        codeOcrMap.put("1013", "深圳经济特区居住证-2015 版-照片页");
        codeOcrMap.put("1018", "内蒙古自治区人民法院工作证  ");
        codeOcrMap.put("1019", "内蒙古自治区检察机关工作证 ");
        codeOcrMap.put("1021", "社会保障卡（北京、重庆）-照片页");
        codeOcrMap.put("1022", "海船船员健康证书-照片页");
        codeOcrMap.put("1023", "海船船员健康证书-签发机关页");
        codeOcrMap.put("1024", "海船船员培训合格证书-照片页");
        codeOcrMap.put("1025", "海船船员培训合格证书-签发机关页");
        codeOcrMap.put("1026", "海船船员适任证书-照片页");
        codeOcrMap.put("1027", "海船船员适任证书-签发机关页");
        codeOcrMap.put("1029", "浙江省临时居住证-照片页");
        codeOcrMap.put("1030", "全民健康保险卡");
        codeOcrMap.put("1031", "台湾地区身份证-照片页");
        codeOcrMap.put("1032", "台湾地区身份证-条码页");
        codeOcrMap.put("1035", "English Name ");
        codeOcrMap.put("1037", "神煤集团工作证");
        codeOcrMap.put("1039", "厦门市社会保障卡-照片页");
        codeOcrMap.put("1040", "台湾地区驾驶证");
        codeOcrMap.put("2001", "马来西亚身份证-照片页");
        codeOcrMap.put("2002", "美国加利福利亚驾驶证");
        codeOcrMap.put("2003", "新西兰驾驶证");
        codeOcrMap.put("2004", "新加坡身份证 2004 版");
        codeOcrMap.put("2005", "新加坡身份证 2005 版");
        codeOcrMap.put("2006", "TD-2 型机读旅行证件 ");
        codeOcrMap.put("2009", "TD-1 型机读旅行证件");
        codeOcrMap.put("2010", "印度尼西亚居民身份证");
        codeOcrMap.put("2011", "泰国国民身份证");
        codeOcrMap.put("2012", "泰国驾驶证");
        codeOcrMap.put("2013", "墨西哥选民证-照片页");
        codeOcrMap.put("2014", "墨西哥选民证-机读码页");
        codeOcrMap.put("2020", "瑞典驾驶证");
    }


    static {
        codeSysMap.put("11", "身份证");
        codeSysMap.put("12", "居住证");
        codeSysMap.put("14", "普通护照");
        codeSysMap.put("16", "台湾居民来往大陆通行证");
        codeSysMap.put("17", "海员证");
        codeSysMap.put("27", "台湾居民身份证");
        codeSysMap.put("60", "港澳居民来往内地通行证");
        codeSysMap.put("90", "军官证");
        codeSysMap.put("91", "警官证");
        codeSysMap.put("92", "士兵证");
        codeSysMap.put("94", "驾照");
        codeSysMap.put("95", "港澳通行证");
        codeSysMap.put("99", "其他");
    }


    static {
        codeOcrToSysMap.put("2", "11"); // 居民身份证-照片页	: 身份证
        codeOcrToSysMap.put("3", "11"); // 居民身份证-签发机关页	: 身份证
        codeOcrToSysMap.put("4", "11"); // 临时居民身份证	: 临时身份证
        codeOcrToSysMap.put("5", "94"); // 机动车驾驶证	: 驾照
        codeOcrToSysMap.put("6", "99"); // 机动车行驶证	: 其他
        codeOcrToSysMap.put("7", "90"); // 军官证 1998 版	: 军官证
        codeOcrToSysMap.put("8", "92"); // 士兵证 1998 版	: 士兵证
        codeOcrToSysMap.put("9", "95"); // 往来港澳通行证2005版护照幅面	: 港澳通行证
        codeOcrToSysMap.put("10", "16"); // 台湾居民来往大陆通行证 1992 版-照片页	: 台湾居民来往大陆通行证
        codeOcrToSysMap.put("11", "99"); // 大陆居民往来台湾通行证 1992 版-照片页	: 其他
        codeOcrToSysMap.put("12", "14"); // 签证	: 普通护照
        codeOcrToSysMap.put("13", "14"); // 护照	: 普通护照
        codeOcrToSysMap.put("14", "60"); // 港澳居民来往内地通行证-照片页	: 港澳居民来往内地通行证
        codeOcrToSysMap.put("15", "60"); // 港澳居民来往内地通行证-机读码页	: 港澳居民来往内地通行证
        codeOcrToSysMap.put("16", "99"); // 常住人口登记卡	: 其他
        codeOcrToSysMap.put("17", "17"); // 海员证 2009 版-照片页	: 海员证
        codeOcrToSysMap.put("18", "90"); // 军官证 1998 版-照片页（电子护照设备支持）	: 军官证
        codeOcrToSysMap.put("19", "90"); // 军官证 1998 版-信息页（电子护照设备支持）	: 军官证
        codeOcrToSysMap.put("20", "91"); // 警官证 2006 版-照片页	: 警官证
        codeOcrToSysMap.put("21", "91"); // 警官证 2006 版-信息页	: 警官证
        codeOcrToSysMap.put("22", "95"); // 往来港澳通行证 2014 版-照片页	: 港澳通行证
        codeOcrToSysMap.put("23", "99"); // 边境地区出入境通行证 2014 版-照片页 	: 其他
        codeOcrToSysMap.put("24", "99"); // 中国人民解放军车辆驾驶证 2010 版 	: 其他
        codeOcrToSysMap.put("25", "16"); // 台湾居民来往大陆通行证 2015 版-照片页	: 台湾居民来往大陆通行证
        codeOcrToSysMap.put("26", "16"); // 台湾居民来往大陆通行证 2015 版-机读码页	: 台湾居民来往大陆通行证
        codeOcrToSysMap.put("27", "99"); // 中国人民解放军行车执照 2012 版 	: 其他
        codeOcrToSysMap.put("29", "99"); // 往来台湾通行证 2017 版-照片页	: 其他
        codeOcrToSysMap.put("1000", "12"); // 居住证（广东、广西、东莞）-照片页	: 居住证
        codeOcrToSysMap.put("1001", "99"); // 香港居民身份证 2003 版 -照片页	: 其他
        codeOcrToSysMap.put("1002", "99"); // 登机牌（拍照设备目前不支持登机牌的识别）	: 其他
        codeOcrToSysMap.put("1003", "99"); // 边境地区出入境通行证 2005 版-照片页）	: 其他
        codeOcrToSysMap.put("1004", "99"); // 边境地区出入境通行证 2005 版-信息页	: 其他
        codeOcrToSysMap.put("1005", "99"); // 澳门居民身份证-照片页 	: 其他
        codeOcrToSysMap.put("1006", "99"); // 领取凭证(扫描仪支持) 	: 其他
        codeOcrToSysMap.put("1007", "99"); // 律师执业证-签发机关页	: 其他
        codeOcrToSysMap.put("1008", "99"); // 律师执业证-照片页	: 其他
        codeOcrToSysMap.put("1009", "99"); // 中华人民共和国道路运输证 IC 卡	: 其他
        codeOcrToSysMap.put("1010", "99"); // 名片	: 其他
        codeOcrToSysMap.put("1011", "99"); // 组织机构代码证	: 其他
        codeOcrToSysMap.put("1013", "12"); // 深圳经济特区居住证-2015 版-照片页	: 居住证
        codeOcrToSysMap.put("1018", "99"); // 内蒙古自治区人民法院工作证  	: 其他
        codeOcrToSysMap.put("1019", "99"); // 内蒙古自治区检察机关工作证 	: 其他
        codeOcrToSysMap.put("1021", "99"); // 社会保障卡（北京、重庆）-照片页	: 其他
        codeOcrToSysMap.put("1022", "99"); // 海船船员健康证书-照片页	: 其他
        codeOcrToSysMap.put("1023", "99"); // 海船船员健康证书-签发机关页	: 其他
        codeOcrToSysMap.put("1024", "99"); // 海船船员培训合格证书-照片页	: 其他
        codeOcrToSysMap.put("1025", "99"); // 海船船员培训合格证书-签发机关页	: 其他
        codeOcrToSysMap.put("1026", "99"); // 海船船员适任证书-照片页	: 其他
        codeOcrToSysMap.put("1027", "99"); // 海船船员适任证书-签发机关页	: 其他
        codeOcrToSysMap.put("1029", "12"); // 浙江省临时居住证-照片页	: 居住证
        codeOcrToSysMap.put("1030", "99"); // 全民健康保险卡	: 其他
        codeOcrToSysMap.put("1031", "27"); // 台湾地区身份证-照片页	: 台湾居民身份证
        codeOcrToSysMap.put("1032", "27"); // 台湾地区身份证-条码页	: 台湾居民身份证
        codeOcrToSysMap.put("1035", "99"); // English Name 	: 其他
        codeOcrToSysMap.put("1037", "99"); // 神煤集团工作证	: 其他
        codeOcrToSysMap.put("1039", "99"); // 厦门市社会保障卡-照片页	: 其他
        codeOcrToSysMap.put("1040", "99"); // 台湾地区驾驶证	: 其他
        codeOcrToSysMap.put("2001", "99"); // 马来西亚身份证-照片页	: 其他
        codeOcrToSysMap.put("2002", "99"); // 美国加利福利亚驾驶证	: 其他
        codeOcrToSysMap.put("2003", "99"); // 新西兰驾驶证	: 其他
        codeOcrToSysMap.put("2004", "99"); // 新加坡身份证 2004 版	: 其他
        codeOcrToSysMap.put("2005", "99"); // 新加坡身份证 2005 版	: 其他
        codeOcrToSysMap.put("2006", "99"); // TD-2 型机读旅行证件 	: 其他
        codeOcrToSysMap.put("2009", "99"); // TD-1 型机读旅行证件	: 其他
        codeOcrToSysMap.put("2010", "99"); // 印度尼西亚居民身份证	: 其他
        codeOcrToSysMap.put("2011", "99"); // 泰国国民身份证	: 其他
        codeOcrToSysMap.put("2012", "99"); // 泰国驾驶证	: 其他
        codeOcrToSysMap.put("2013", "99"); // 墨西哥选民证-照片页	: 其他
        codeOcrToSysMap.put("2014", "99"); // 墨西哥选民证-机读码页	: 其他
        codeOcrToSysMap.put("2020", "99"); // 瑞典驾驶证	: 其他
    }

    /**
     * 获取民族名称
     *
     * @param code 民族代码
     **/
    public static String getNationByCode(String code) {
        return codeNationMap.get(code);
    }

    /**
     * 获取民族代码
     *
     * @param nation 民族名称
     **/
    public static String getCodeByNation(String nation) {
        return nationCodeMap.get(nation);
    }


    /**
     * 获取国家名称
     *
     * @param code 国家代码
     **/
    public static String getCountryByCode(String code) {
        return codeCountryMap.get(code);
    }

    /**
     * 获取国家代码
     *
     * @param country 国家名称
     **/
    public static String getCodeByCountry(String country) {
        return countryCodeMap.get(country);
    }

    /**
     * 获取国内(CN)证件名称
     *
     * @param code 证件代码
     **/
    public static String getCardTypeByCode_CN(String code) {
        return cardTypeCode_CN_Map.get(code);
    }

    /**
     * 获取国内(CN)证件代码
     *
     * @param cardType 证件名称
     **/
    public static String getCodeByCardType_CN(String cardType) {
        return codeCardType_CN_Map.get(cardType);
    }

    /**
     * 获取国外证件名称
     *
     * @param code 证件代码
     **/
    public static String getCardTypeByCode(String code) {
        return cardTypeCodeMap.get(code);
    }

    /**
     * 获取国外证件代码
     *
     * @param cardType 证件名称
     **/
    public static String getCodeByCardType(String cardType) {
        return codeCardTypeMap.get(cardType);
    }


    /**
     * 获取性别名称
     *
     * @param code 性别代码
     **/
    public static String getSexByCode(String code) {
        return codeSexMap.get(code);
    }

    /**
     * 获取性别代码
     *
     * @param sex 性别名称
     **/
    public static String getCodeBySex(String sex) {
        return sexCodeMap.get(sex);
    }


    /**
     * 根据证件扫描仪识别证件code获取系统对应的字典编号(中安OCR)
     **/
    public static String getDicCodeByOcr(int code) {
        return codeOcrToSysMap.get(String.valueOf(code));
    }

    /**
     * 根据sys证件code获取名称
     **/
    public static String getSysByCode(int code) {
        return codeSysMap.get(String.valueOf(code));
    }

    /**
     * 根据证件扫描仪识别证件名称获取code(中安OCR)
     **/
    public static String getOcrByCode(int code) {
        return codeOcrMap.get(String.valueOf(code));
    }


}
