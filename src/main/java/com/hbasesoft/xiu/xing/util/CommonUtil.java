//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hbasesoft.xiu.xing.util;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CommonUtil {
    public static String messageFormat(String message, Object... params) {
        return params != null && params.length != 0 ? MessageFormat.format(message, params) : message;
    }

    public static String getTransactionID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String getRandomCode() {
        return Long.toUnsignedString(Long.parseUnsignedLong(UUID.randomUUID().toString().substring(24), 16), 36);
    }

    public static String getRandomNumber(int size) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for(int i = 0; i < size; ++i) {
            sb.append((char)(48 + random.nextInt(10)));
        }

        return sb.toString();
    }

    public static String getRandomChar(int size) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for(int i = 0; i < size; ++i) {
            switch(random.nextInt(10) % 3) {
            case 0:
                sb.append((char)(48 + random.nextInt(10)));
                break;
            case 1:
                sb.append((char)(97 + random.nextInt(26)));
                break;
            case 2:
                sb.append((char)(65 + random.nextInt(26)));
            }
        }

        return sb.toString();
    }

    public static String getString(Object obj) {
        String result = null;
        if (obj != null) {
            result = obj instanceof String ? (String)obj : obj.toString();
        }

        return result;
    }

    public static String notNullStr(String str) {
        return StringUtils.isEmpty(str) ? "" : str;
    }

    public static Date getDate(Long time) {
        return time != null ? new Date(time) : null;
    }

    public static final Integer[] splitId(String idStr, String splitor) {
        Integer[] ids = null;
        if (StringUtils.isNotEmpty(idStr)) {
            String[] strs = StringUtils.split(idStr, splitor);
            ids = new Integer[strs.length];

            for(int i = 0; i < strs.length; ++i) {
                ids[i] = Integer.valueOf(strs[i]);
            }
        }

        return ids;
    }

    public static final Long[] splitIdsByLong(String idStr, String splitor) {
        Long[] ids = null;
        if (StringUtils.isNotEmpty(idStr)) {
            String[] strs = StringUtils.split(idStr, splitor);
            ids = new Long[strs.length];

            for(int i = 0; i < strs.length; ++i) {
                ids[i] = Long.valueOf(strs[i]);
            }
        }

        return ids;
    }

    public static final Integer[] splitId(String idStr) {
        return splitId(idStr, ",");
    }

    public static boolean wildcardMatch(Collection<String> rules, String matchValue) {
        Iterator var2 = rules.iterator();

        String rule;
        do {
            if (!var2.hasNext()) {
                return false;
            }

            rule = (String)var2.next();
        } while(!wildcardMatch(rule, matchValue));

        return true;
    }

    public static boolean wildcardMatch(String rule, String matchValue) {
        rule = org.apache.commons.lang3.StringUtils.replaceEach(org.apache.commons.lang3.StringUtils.replaceEach(rule, new String[]{"\\", ".", "^", "$"}, new String[]{"\\\\", "\\.", "\\^", "\\$"}), new String[]{"*", "?"}, new String[]{".*", ".?"});
        Pattern pp = Pattern.compile(rule);
        Matcher m = pp.matcher(matchValue);
        return m.matches();
    }

    public static boolean match(String rule, String matchValue) {
        boolean ismatch = false;
        if (StringUtils.isNotEmpty(rule) && StringUtils.isNotEmpty(matchValue)) {
            if ("*".equals(rule)) {
                ismatch = true;
            } else if (rule.startsWith("NOT:")) {
                rule = rule.substring(4);
                ismatch = rule.indexOf(",") == -1 ? !rule.equals(matchValue) : (new StringBuilder()).append(",").append(rule).append(",").indexOf("," + matchValue + ",") == -1;
            } else {
                ismatch = rule.indexOf(",") == -1 ? rule.equals(matchValue) : (new StringBuilder()).append(",").append(rule).append(",").indexOf("," + matchValue + ",") != -1;
            }
        }

        return ismatch;
    }

    public static String removeAllSymbol(String str) {
        return StringUtils.isNotEmpty(str) ? str.replaceAll("[\\pP\\p{Punct}]", "") : "";
    }

    public static String replaceAllBlank(String str) {
        String dest = "";
        if (StringUtils.isNotEmpty(str)) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }

        return dest;
    }

    public static String replaceRedundantBlank(String str) {
        String dest = "";
        if (StringUtils.isNotEmpty(str)) {
            Pattern p = Pattern.compile("\\s{1,}|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll(" ");
        }

        return StringUtils.trim(dest);
    }

    public static <T> boolean isNotEmpty(T[] paramTypes) {
        return !ArrayUtils.isEmpty(paramTypes);
    }

    public static <T> boolean isEmpty(T[] paramTypes) {
        return ArrayUtils.isEmpty(paramTypes);
    }

    private CommonUtil() {
    }
}
