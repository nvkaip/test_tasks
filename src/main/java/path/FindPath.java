package path;

import path.service.AbstractFindPathInputReader;
import path.service.FindPathInputReaderFile;
import path.service.FindPathInputReaderStdIn;

public class FindPath {

    public static void main(String[] args) {

        AbstractFindPathInputReader findPathInputReader = new FindPathInputReaderFile();
        findPathInputReader.setMaze();
        System.out.println(findPathInputReader.solve());
    }
}
