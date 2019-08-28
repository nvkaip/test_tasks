package path.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class FindPathInputReaderStdIn extends AbstractFindPathInputReader {

    private static final Logger LOGGER = Logger.getLogger(FindPathInputReaderStdIn.class);
    private List<String> maze;

    @Override
    public List<String> getMaze(){
        return this.maze;
    }

    @Override
    public void setMaze() {
        maze = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String mazeRow = reader.readLine();
                if (mazeRow.equals("")){
                    break;
                }
                maze.add(mazeRow);
            }
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }
}
