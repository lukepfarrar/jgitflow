package uk.co.theboo.jgitflow;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.eclipse.jgit.api.Git;
import org.apache.commons.io.FileUtils;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
    @Test(expected=GitFlowException.class)
    public void testGitFlowRepository() throws IOException, GitFlowException, GitAPIException {
       new GitFlowRepository(new FileRepositoryBuilder().setWorkTree(tmpDir).build());
    }

    @Test
    public void testGetReleasePrefix() {
        assertEquals("release/", gitFlowInstance.getReleasePrefix());
    }

    /**
     * Test of getDevelopBranchName method, of class GitFlowRepository.
     */
    public void testGetDevelopBranchName() {
        assertEquals("develop", gitFlowInstance.getDevelopBranchName());
    }

    /**
     * Test of getMasterBranchName method, of class GitFlowRepository.
     */
    public void testGetMasterBranchName() {
       assertEquals("master", gitFlowInstance.getMasterBranchName());
    }

    /**
     * Test of getHotfixPrefix method, of class GitFlowRepository.
     */
    public void testGetHotfixPrefix() {
        System.out.println("getHotfixPrefix");
        GitFlowRepository instance = null;
        String expResult = "";
        String result = instance.getHotfixPrefix();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFeaturePrefix method, of class GitFlowRepository.
     */
    public void testGetFeaturePrefix() {
        System.out.println("getFeaturePrefix");
        GitFlowRepository instance = null;
        String expResult = "";
        String result = instance.getFeaturePrefix();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSupportPrefix method, of class GitFlowRepository.
     */
    public void testGetSupportPrefix() {
        System.out.println("getSupportPrefix");
        GitFlowRepository instance = null;
        String expResult = "";
        String result = instance.getSupportPrefix();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
