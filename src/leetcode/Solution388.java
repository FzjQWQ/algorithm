package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 388. 文件的最长绝对路径
 *
 * @author roy f
 * @date 2022/4/20
 */
public class Solution388 {
    public int lengthLongestPath(String input) {
        int ans = 0;
        int lengthCount[] = new int[100000];
        String[] path = input.split("\n");
        for (int i = 0; i < path.length; i++) {
            int count = countTabs(path[i]);
            lengthCount[count + 1] = lengthCount[count] + path[i].length() - count;
            if (path[i].contains(".")) {
                ans = Math.max(ans, lengthCount[count + 1] + count);
            }
        }
        return ans;
    }

    public int countTabs(String s) {
        //计算字符串前边的“\t”的数量
        int start = 0;
        while (start < s.length() && s.charAt(start) == '\t') {
            start++;
        }
        return start;
    }

    public static void main(String[] args) {
        Solution388 solution388 = new Solution388();
        System.out.println(solution388.lengthLongestPath("skd\n\talskjv\n\t\tlskjf\n\t\t\tklsj.slkj\n\t\tsdlfkj.sdlkjf\n\t\tslkdjf.sdfkj\n\tsldkjf\n\t\tlskdjf\n\t\t\tslkdjf.sldkjf\n\t\t\tslkjf\n\t\t\tsfdklj\n\t\t\tlskjdflk.sdkflj\n\t\t\tsdlkjfl\n\t\t\t\tlskdjf\n\t\t\t\t\tlskdjf.sdlkfj\n\t\t\t\t\tlsdkjf\n\t\t\t\t\t\tsldkfjl.sdlfkj\n\t\t\t\tsldfjlkjd\n\t\t\tsdlfjlk\n\t\t\tlsdkjf\n\t\tlsdkjfl\n\tskdjfl\n\t\tsladkfjlj\n\t\tlskjdflkjsdlfjsldjfljslkjlkjslkjslfjlskjgldfjlkfdjbljdbkjdlkjkasljfklasjdfkljaklwejrkljewkljfslkjflksjfvsafjlgjfljgklsdf.a"));
    }
}
