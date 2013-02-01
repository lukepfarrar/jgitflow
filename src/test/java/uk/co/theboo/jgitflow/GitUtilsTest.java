
package uk.co.theboo.jgitflow;

import java.io.IOException;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.storage.file.FileRepository;
import org.junit.Test;
import static org.junit.Assert.*;


public class GitUtilsTest {

    public GitUtilsTest() {
    }

    public void setUp() throws Exception {
    }

    public void tearDown() throws Exception {
    }

    @Test
    public void testBranchExists() throws Exception {
       
        Git git = new Git(GitUtils.initGitRepository());
        
        assertTrue(GitUtils.branchExists(git, "master"));
        assertFalse(GitUtils.branchExists(git, "does not exist"));
        assertTrue(GitUtils.branchExists(git, "develop"));
        
    }

    @Test
    public void testInitGitRepository() throws Exception, GitFlowException, IOException {
        FileRepository result = GitUtils.initGitRepository();
        assertNotNull(result);  // works because *this* is a git repository.
    }
}
