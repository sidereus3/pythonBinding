import org.jpy.PyLib;
import org.jpy.PyModule;
import org.jpy.PyObject;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by sidereus on 3/31/17.
 */
public class MainTest {

    public static void main(String[] args) throws IOException {
        PyObject pyMod;
        PyObject pyCl;
        JPYplugin pl;

        String home = "/home/sidereus/vcs/git/github_personal/pythonBinding/";
        Properties p = System.getProperties();
        p.setProperty("jpy.jpyLib", home + "lib/jpy.cpython-36m-x86_64-linux-gnu.so");
        p.setProperty("jpy.jdlLib", home + "lib/jdl.cpython-36m-x86_64-linux-gnu.so");
        p.setProperty("jpy.pythonLib", "/usr/lib/libpython3.so");
        p.setProperty("jpy.pythonPrefix", "/usr");
        p.setProperty("jpy.pythonExecutable", "/usr/bin/python");

        String importPath = new File(home + "resources/").getCanonicalPath();
        PyLib.startPython(importPath);

        pyMod = PyModule.importModule("simpleSumNoClass");
        pl = pyMod.createProxy(JPYplugin.class);
        pyMod.setAttribute("a", 4.5, Double.class);
        pyMod.setAttribute("b", 7.3, Double.class);
        pyMod.setAttribute("pf", home + "output/test", String.class);
        pl.execute();
        PyLib.stopPython();
    }
}
