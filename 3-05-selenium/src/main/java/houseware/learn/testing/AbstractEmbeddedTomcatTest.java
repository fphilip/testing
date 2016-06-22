package houseware.learn.testing;

import org.apache.catalina.LifecycleState;
import org.apache.catalina.startup.Tomcat;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;

import java.io.File;

/**
 * @author fphilip@houseware.es
 */
public abstract class AbstractEmbeddedTomcatTest {

    private static String applicationId;
    private Tomcat tomcat;

    private static String mWorkingDir = System.getProperty("java.io.tmpdir");


    /**
     * Stops the tomcat server.
     *
     * @throws Throwable if anything goes wrong.
     */
    @Before
    public final void setup() throws Throwable {
        System.out.println("Tomcat's base directory : " + mWorkingDir);

        System.out.println("Creates a new server...");
        tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.setBaseDir(mWorkingDir);
        tomcat.getHost().setAppBase(mWorkingDir);
        tomcat.getHost().setAutoDeploy(true);
        tomcat.getHost().setDeployOnStartup(true);

        System.out.println("Prepares and adds the web app");
        String contextPath = "/" + getApplicationId();
        File webApp = new File(mWorkingDir, getApplicationId());


        tomcat.addWebapp(tomcat.getHost(), contextPath, webApp.getAbsolutePath());


        System.out.println("Init users and roles");
        tomcat.addUser("admin", "admin");
        tomcat.addUser("user", "user");
        tomcat.addRole("admin", "admin");
        tomcat.addRole("admin", "user");
        tomcat.addRole("user", "user");

        System.out.println("Start the server...");
        tomcat.start();
    }

    @After
    public final void teardown() throws Throwable {
        System.out.println("Stop the server...");

        if (tomcat.getServer() != null && tomcat.getServer().getState() != LifecycleState.DESTROYED) {
            if (tomcat.getServer().getState() != LifecycleState.STOPPED) {
                tomcat.stop();
            }
            tomcat.destroy();
        }
    }

    protected int getTomcatPort() {
        return tomcat.getConnector().getLocalPort();
    }


    protected String getAppBaseURL() {
        return "http://localhost:" + getTomcatPort() + "/" + getApplicationId();
    }

    public static String getApplicationId() {
        return applicationId;
    }

    public static void setApplicationId(String applicationId) {
        AbstractEmbeddedTomcatTest.applicationId = applicationId;
    }

    public static String getmWorkingDir() {
        return mWorkingDir;
    }

    public Tomcat getTomcat() {
        return tomcat;
    }
}
