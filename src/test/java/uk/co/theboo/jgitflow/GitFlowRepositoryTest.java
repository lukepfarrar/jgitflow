package uk.co.theboo.jgitflow;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GitFlowRepositoryTest {

    private GitFlowRepository gitFlowInstance;
    private File tmpDir;

    @Before
    public void setUp() throws Exception {
        tmpDir = File.createTempFile(FileUtils.getTempDirectoryPath(), "jgitflow");
        if (!tmpDir.delete()) {
            throw new IOException("Failed to delete tmpDir file.");
        }
        if (!tmpDir.mkdir()) {
            throw new IOException("Failed to make tmpDir.");
        }

        gitFlowInstance = new GitFlowRepository(GitUtils.initGitRepository());

    }

    @After
    public void tearDown() throws Exception {
        if (!tmpDir.delete()) {
            tmpDir.deleteOnExit();
        }
    }

    /**
     * Test of getReleasePrefix method, of class GitFlowRepository.
     */
    @Test(expected = GitFlowException.class)
    public void testGitFlowRepository() throws IOException, GitFlowException, GitAPIException {
        new GitFlowRepository(new FileRepositoryBuilder().setWorkTree(tmpDir).build());
    }

    @Test
    public void testGetReleasePrefix() {
        assertEquals("release/", gitFlowInstance.getReleasePrefix());
    }

    @Test
    public void testGetDevelopBranchName() {
        assertEquals("develop", gitFlowInstance.getDevelopBranchName());
    }

    @Test
    public void testGetMasterBranchName() {
        assertEquals("master", gitFlowInstance.getMasterBranchName());
    }

    @Test
    public void testGetHotfixPrefix() {
        assertEquals("hotfix/", gitFlowInstance.getHotfixPrefix());
    }

    @Test
    public void testGetFeaturePrefix() {
        assertEquals("feature/", gitFlowInstance.getFeaturePrefix());
    }

    @Test
    public void testGetSupportPrefix() {
        assertEquals("support/", gitFlowInstance.getSupportPrefix());
    }

    /**
     * Test of git method, of class GitFlowRepository.
     */
    public void testGit() {
        System.out.println("git");
        GitFlowRepository instance = null;
        Git expResult = null;
        Git result = instance.git();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createReleaseBranch method, of class GitFlowRepository.
     */
    public void testCreateReleaseBranch() throws Exception {
        System.out.println("createReleaseBranch");
        String releaseVersion = "";
        GitFlowRepository instance = null;
        instance.createReleaseBranch(releaseVersion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasConsistentState method, of class GitFlowRepository.
     */
    public void testHasConsistentState() throws Exception {
        System.out.println("hasConsistentState");
        GitFlowRepository instance = null;
        boolean expResult = false;
        boolean result = instance.hasConsistentState();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkoutDevelop method, of class GitFlowRepository.
     */
    public void testCheckoutDevelop() throws Exception {
        System.out.println("checkoutDevelop");
        GitFlowRepository instance = null;
        instance.checkoutDevelop();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReleaseBranchNames method, of class GitFlowRepository.
     */
    public void testGetReleaseBranchNames() throws Exception {
        System.out.println("getReleaseBranchNames");
        GitFlowRepository instance = null;
        List expResult = null;
        List result = instance.getReleaseBranchNames();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isOnMaster method, of class GitFlowRepository.
     */
    public void testIsOnMaster() throws Exception {
        System.out.println("isOnMaster");
        GitFlowRepository instance = null;
        boolean expResult = false;
        boolean result = instance.isOnMaster();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isOnDevelop method, of class GitFlowRepository.
     */
    public void testIsOnDevelop() throws Exception {
        System.out.println("isOnDevelop");
        GitFlowRepository instance = null;
        boolean expResult = false;
        boolean result = instance.isOnDevelop();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
