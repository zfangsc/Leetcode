package ImplementstrStr;

import org.junit.Assert;
import org.junit.Test;

/**
 * Author: fangzhou
 * Date:   9/7/14.
 */
public class ImplementstrStrTest {
    @Test
    public void testStrStr() throws Exception {
        Solution s = new Solution();
        Assert.assertNull(s.strStr("mississippi", "issipi"));
        Assert.assertEquals(s.strStr("etqbbbbbbaabaabaabbbbababbbababbaaababbbabaabbaaabbbba", "bbbaa"), "bbbaabaabaabbbbababbbababbaaababbbabaabbaaabbbba");
        Assert.assertEquals(s.strStr("acace", "ace"), "ace");
        Assert.assertEquals(s.strStr("eacade", "ade"), "ade");
        Assert.assertEquals(s.strStr("abeabeac", "abeac"), "abeac");
        Assert.assertEquals(s.strStr("abababce", "abce"), "abce");
    }
}
