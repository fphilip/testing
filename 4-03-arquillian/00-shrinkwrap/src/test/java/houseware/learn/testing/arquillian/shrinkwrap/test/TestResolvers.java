package houseware.learn.testing.arquillian.shrinkwrap.test;

import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.jboss.shrinkwrap.resolver.api.maven.MavenResolvedArtifact;
import org.jboss.shrinkwrap.resolver.api.maven.ScopeType;
import org.jboss.shrinkwrap.resolver.api.maven.coordinate.MavenCoordinate;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

/**
 * @author fphilip@houseware.es
 */
public class TestResolvers {

    @Test
    public void view_maven_withoutTransitivity() {
        MavenResolvedArtifact artifact = Maven.resolver()
                .resolve("org.primefaces:showcase:war:5.3")
                .withoutTransitivity()
                .asSingle(MavenResolvedArtifact.class);
        String version = artifact.getResolvedVersion();
        ScopeType scope = artifact.getScope();
        Assert.assertEquals("5.3", version);
    }

    @Test
    public void view_maven() {
//
    }


    @Test
    public void view() {
        System.out.println(Maven.resolver().resolve("org.primefaces:primefaces:5.3").withTransitivity().as(File.class));
        System.out.println(Maven.resolver().resolve("org.primefaces:primefaces:5.3").withTransitivity().as(InputStream.class));
//        System.out.println(Maven.resolver().resolve("org.primefaces:primefaces:5.3").withTransitivity().as(URL.class));
        System.out.println(Maven.resolver().resolve("org.primefaces:showcase:war:5.3").withTransitivity().as(JavaArchive.class));
        System.out.println(Maven.resolver().resolve("org.primefaces:showcase:war:5.3").withoutTransitivity().asSingle(WebArchive.class));
        System.out.println(Maven.resolver().resolve("org.primefaces:showcase:war:5.3").withTransitivity().as(MavenCoordinate.class));
    }
}
