package jep;

import jep.python.PyModule;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by sidereus on 5/28/17.
 */
public class JepImpl {

    private static String cleanFromComments(String line) {
        int offset = line.indexOf("#");
        return (-1 != offset) ? line.substring(0, offset) : line;
    }

    public static void main(String[] args) throws IOException {
        String home = "/home/sidereus/vcs/git/github_personal/pythonBinding/resources/simpleSumNoClass.py";
        // Path path = Paths.get(home);
        // List<String> lines = Files.readAllLines(path);
        // StringBuilder strBuild = new StringBuilder();
        try(Jep jep = new Jep(false)) {
        //     for (String line : lines) {
        //         line = cleanFromComments(line);
        //         if (line.equals("a"))
                    jep.set("a", 3.3);
        //         else if (line.equals("b"))
                    jep.set("b", 6.6);
        //         else if (line.equals("pf"))
                    jep.set("pf", "/home/sidereus/out.txt");
        //         else if (line.equals("summ"))
                    //jep.set("summ", 0.0);
        //         else if (line.equals("prod"))
                    //jep.set("prod", 0.0);
        //        else
        //             strBuild.append(line);
        //    }
            jep.runScript(home);
            jep.eval("execute()");
            Object sum = jep.getValue("summ");
            System.out.println(((Double) sum).floatValue());
            Object prod = jep.getValue("prod");
            System.out.println(((Double) prod).floatValue());
        } catch (JepException e) {
            e.printStackTrace();
        }
    }
}
