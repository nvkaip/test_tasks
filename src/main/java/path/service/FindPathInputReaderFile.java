package path.service;

import org.apache.log4j.Logger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FindPathInputReaderFile extends AbstractFindPathInputReader{
    private static final Logger LOGGER = Logger.getLogger(FindPathInputReaderFile.class);
    private List<String> maze;

    @Override
    public List<String> getMaze(){
        return this.maze;
    }

    @Override
    public void setMaze() {
        maze = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("maze.txt"))) {
            while (true) {
                String mazeRow = reader.readLine();
                if (mazeRow == null){
                    break;
                }
                maze.add(mazeRow);
            }
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }
}
