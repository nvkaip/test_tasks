package path.service;

import org.junit.Assert;
import org.junit.Test;

public class FindPathInputReaderFileTest {

    @Test
    public void solve() {
        String expected = "r, d, d, l, l";

        AbstractFindPathInputReader findPathInputReader = new FindPathInputReaderFile();
        findPathInputReader.setMaze();
        String actual = findPathInputReader.solve();

        Assert.assertEquals(expected, actual);
    }
}