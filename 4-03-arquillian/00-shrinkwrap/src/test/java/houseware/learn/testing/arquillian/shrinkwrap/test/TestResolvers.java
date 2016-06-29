package houseware.learn.testing.arquillian.shrinkwrap.test;

import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.jboss.shrinkwrap.resolver.api.maven.MavenArtifactInfo;
import org.jboss.shrinkwrap.resolver.api.maven.MavenResolvedArtifact;
import org.jboss.shrinkwrap.resolver.api.maven.ScopeType;
import org.jboss.shrinkwrap.resolver.api.maven.coordinate.MavenCoordinate;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author fphilip@houseware.es
 */
public class TestResolvers {

    @Test
    public void view_maven() {
        MavenResolvedArtifact artifact = Maven.resolver()
                .resolve("org.primefaces:showcase:war:5.3")
                .withoutTransitivity()
                .asSingle(MavenResolvedArtifact.class);
        MavenCoordinate coordinates = artifact.getCoordinate();
        MavenArtifactInfo[] dependencies = artifact.getDependencies();
        for (MavenArtifactInfo dependency : dependencies) {
            System.err.println(dependency);
        }
        String version = artifact.getResolvedVersion();
        ScopeType scope = artifact.getScope();

        Assert.assertEquals("5.3", version);
    }
}
