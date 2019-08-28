package path.service;

import path.model.Step;

import java.util.List;

public abstract class AbstractFindPathInputReader {

    private String[][] maze;

    public abstract List<String> getMaze();

    public abstract void setMaze();

    public String solve() {
        convertMaze();
        int startY = 0;
        int startX = 0;
        for (int y = 0; y < maze.length; y++) {
            for (int x = 0; x < maze[y].length; x++) {
                if (maze[y][x].equals("S")) {
                    startY = y;
                    startX = x;
                    break;
                }
            }
        }
        Step startPosition = new Step(startX, startY, null, "S");
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[startY][startX] = true;
        Step step = explore(visited, startPosition);
        StringBuilder path = new StringBuilder();
        if (step.isSolved()) {
            while (step.hasPrevious()) {
                path.append(step.getDirection()).append(" ,");
                step = step.getPrevStep();
            }
            return path.reverse().substring(2);
        } else {
            return "Maze is unsolved";
        }
    }

    private Step explore(boolean[][] visited, Step currentStep) {
        int x = currentStep.getPositionX();
        int y = currentStep.getPositionY();
        if (maze[y][x].equals("X")) {
            currentStep.setSolved(true);
        } else {
            if (x + 1 < maze[y].length && !maze[y][x + 1].equals("#") && !visited[y][x + 1]) {
                x++;
                Step nextStep = new Step(x, y, currentStep, "r");
                visited[y][x] = true;
                return explore(visited, nextStep);
            }
            if (x - 1 >= 0 && !maze[y][x - 1].equals("#") && !visited[y][x - 1]) {
                x--;
                Step nextStep = new Step(x, y, currentStep, "l");
                visited[y][x] = true;
                return explore(visited, nextStep);
            }
            if (y + 1 < maze.length && !maze[y + 1][x].equals("#") && !visited[y + 1][x]) {
                y++;
                Step nextStep = new Step(x, y, currentStep, "d");
                visited[y][x] = true;
                return explore(visited, nextStep);
            }
            if (y - 1 >= 0 && !maze[y - 1][x].equals("#") && !visited[y - 1][x]) {
                y--;
                Step nextStep = new Step(x, y, currentStep, "u");
                visited[y][x] = true;
                return explore(visited, nextStep);
            }
            if (currentStep.hasPrevious()) {
                return explore(visited, currentStep.getPrevStep());
            }
        }
        return currentStep;
    }

    private void convertMaze() {
        List<String> mazeRows = getMaze();
        int rows = mazeRows.size();
        int columns = mazeRows.get(0).length();
        this.maze = new String[rows][columns];
        for (int y = 0; y < maze.length; y++) {
            for (int x = 0; x < maze[y].length; x++) {
                maze[y][x] = String.valueOf(mazeRows.get(y).charAt(x));
                System.out.print(maze[y][x]);
            }
            System.out.println();
        }
    }
}
