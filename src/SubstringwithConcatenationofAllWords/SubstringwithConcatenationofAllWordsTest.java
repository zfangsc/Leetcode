package SubstringWithConcatenationOfAllWords;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Author: fangzhou
 * Date:   9/5/14.
 */
public class SubstringwithConcatenationofAllWordsTest {
    @Test
    public void testFindSubstring() throws Exception {
        Solution s = new Solution();
        String ss = "barfoothefoobarman";
        String[] l = new String[] {"foo", "bar"};
        List<Integer> ll = s.findSubstring(ss, l);
        Assert.assertEquals(ll.size(), 2);
        Assert.assertEquals((Integer)ll.get(0), Integer.valueOf(0));
        Assert.assertEquals((Integer)ll.get(1), Integer.valueOf(9));

    }
}
