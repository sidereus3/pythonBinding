package testJEP;

import jep.Jep;
import jep.JepConfig;
import jep.JepException;
import sun.misc.FloatingDecimal;

import java.io.IOException;

/**
 * Created by sidereus on 5/28/17.
 */
public class JepImpl {

    private static String cleanFromComments(String line) {
        int offset = line.indexOf("#");
        return (-1 != offset) ? line.substring(0, offset) : line;
    }

    public static void main(String[] args) throws IOException, JepException {
        String home = "./resources/simpleSumNoClass.py";
        JepConfig config = new JepConfig();
        config.setIncludePath("/home/sidereus/vcs/git/github_personal/pythonBinding/lib");
        // Path path = Paths.get(home);
        // List<String> lines = Files.readAllLines(path);
        // StringBuilder strBuild = new StringBuilder();
        try(Jep jep = new Jep(config)) {
        //     for (String line : lines) {
        //         line = cleanFromComments(line);
        //         if (line.equals("a"))
                    jep.set("a", 3.3);
        //         else if (line.equals("b"))
                    jep.set("b", 6.6);
        //         else if (line.equals("pf"))
                    jep.set("pf", "./out.txt");
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
            Float fprod = ((Double) prod).floatValue();
            Double dprod = Double.valueOf(Float.valueOf(fprod).toString());
            System.out.println(fprod);
            System.out.println(dprod);
        } catch (JepException e) {
            throw new JepException(e.getMessage(), e.getCause());
        }
    }
}
