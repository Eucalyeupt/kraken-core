package fun.bigtable.kraken.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class XssEscapeUtils {

    public static List<Pattern> patternList = new ArrayList<>();

    static {
        patternList.add(Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE));
        patternList.add(Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
        patternList.add(Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
        patternList.add(Pattern.compile("</script>", Pattern.CASE_INSENSITIVE));
        patternList.add(Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
        patternList.add(Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
        patternList.add(Pattern.compile("expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
        patternList.add(Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE));
        patternList.add(Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE));
        patternList.add(Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
        patternList.add(Pattern.compile("<iframe>(.*?)</iframe>", Pattern.CASE_INSENSITIVE));
        patternList.add(Pattern.compile("</iframe>", Pattern.CASE_INSENSITIVE));
        patternList.add(Pattern.compile("<iframe(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
    }


    public static String escape(String s)
    {
        StringBuilder sb = new StringBuilder(s.length() + 16);
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            switch (c)
            {
                case '>':
                    sb.append('＞');// 全角大于号
                    break;
                case '<':
                    sb.append('＜');// 全角小于号
                    break;
                case '\'':
                    sb.append('‘');// 全角单引号
                    break;
                case '\\':
                    sb.append('＼');// 全角斜线
                    break;
                case '%':
                    sb.append('％'); // 全角冒号
                    break;
                default:
                    sb.append(c);
                    break;
            }

        }
        return sb.toString();
    }
    public static String stripXSS(String value)
    {
        if (value != null)
        {
            for (Pattern pattern : patternList) {
                pattern.matcher(value).replaceAll("");
            }
        }
        return value;
    }

    public static boolean checkXSS(String value)
    {
        if (value != null)
        {
            for (Pattern pattern : patternList) {
                if(pattern.matcher(value).matches()) return true;
            }
        }
        return false;
    }
}
