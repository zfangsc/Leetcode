package TextJustification;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: fangzhou
 * Date:   9/4/14.
 */
public class TextJustificationTest {
    @Test
    public void testFullJustify() throws Exception {
        Solution s = new Solution();
        String[] words = new String[] {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> result = s.fullJustify(words, 16);
        Assert.assertEquals(result.get(0), "This    is    an");
        Assert.assertEquals(result.get(1), "example  of text");
        Assert.assertEquals(result.get(2), "justification.  ");

    }

    @Test
    public void testFullJustifyEmptyString() throws Exception {
        Solution s = new Solution();
        String[] words = new String[] {""};
        List<String> result = s.fullJustify(words, 0);
        Assert.assertEquals(result.get(0), "");

    }

    @Test
    public void testProcess() throws Exception {
        Solution s = new Solution();
        List<String> buf = new ArrayList<String>();
        buf.add("ab");
        buf.add("cd");
        Assert.assertEquals(s.process(buf, 8), "ab    cd");
    }

    @Test
    public void testReleaseLast() throws Exception {
        Solution s = new Solution();
        List<String> buf = new ArrayList<String>();
        buf.add("ab");
        buf.add("cd.");
        List<String> result = new ArrayList<String>();
        result.add(s.process(buf, 8));
        s.releaseLast(result, 8);
        Assert.assertEquals(result.get(result.size()-1), "ab cd.  ");
    }
}
