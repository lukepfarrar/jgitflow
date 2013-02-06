package uk.co.theboo.jgitflow;

import java.io.IOException;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.storage.file.FileRepository;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GitUtilsTest {

    private FileRepository fileRepository;
    private Git git;

    @Before
    public void setup() throws GitFlowException, IOException {
        fileRepository = GitUtils.initGitRepository();
        git = new Git(fileRepository);
    }

    @Test
    public void testMasterBranchExists() throws GitAPIException {
        assertTrue(GitUtils.branchExists(git, "master"));
    }

    @Test
    public void testDevelopBranchExists() throws GitAPIException {
        assertTrue(GitUtils.branchExists(git, "develop"));
    }

    @Test
    public void testNonsenseBranchDoesNotExist() throws GitAPIException {
        assertFalse(GitUtils.branchExists(git, "does not exist"));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testBranchExistsNullGit() throws Exception {
        GitUtils.branchExists(null, "develop");
    }

    @Test(expected=IllegalArgumentException.class)
    public void testBranchExistsNullBranch() throws Exception {
        GitUtils.branchExists(git, null);
    }

    @Test
    public void testInitGitRepository() throws Exception, GitFlowException, IOException {
        FileRepository result = GitUtils.initGitRepository();
        assertNotNull(result);  // works because *this* is a git repository.
    }
}
