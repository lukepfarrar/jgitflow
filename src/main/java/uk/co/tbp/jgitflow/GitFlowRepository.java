package uk.co.tbp.jgitflow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.Status;
import org.eclipse.jgit.api.errors.*;
import org.eclipse.jgit.errors.NoWorkTreeException;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.RepositoryState;
import org.eclipse.jgit.lib.StoredConfig;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.storage.file.FileRepository;

public class GitFlowRepository {

    private final Git git;
    private final static String GIT_FLOW = "gitflow";

    public GitFlowRepository(FileRepository repository) throws GitFlowException, GitAPIException {
        git = new Git(repository);

        String masterBranchName = getMasterBranchName();

        if (masterBranchName == null || !GitUtils.branchExists(git, masterBranchName)) {
            throw new GitFlowException("Not initialized for gitflow.");
        }

    }

    private String getPrefix(final String configKey) {
        return getConfig().getString(GIT_FLOW, "prefix", configKey);
    }

    private String getBranchName(final String configKey) {
        return getConfig().getString(GIT_FLOW, "branch", configKey);
    }

    public String getReleasePrefix() {

        return getPrefix("release");
    }

    public String getDevelopBranchName() {
        return getBranchName("develop");
    }

    public String getMasterBranchName() {
        return getBranchName("master");
    }

    public String getHotfixPrefix() {
        return getPrefix("hotfix");
    }

    public String getFeaturePrefix() {
        return getPrefix("feature");
    }

    public String getSupportPrefix() {
        return getPrefix("support");
    }

    private StoredConfig getConfig() {
        return git.getRepository().getConfig();
    }

    public Git git() {
        return git;
    }

    public void createReleaseBranch(String releaseVersion) throws GitFlowException {
        try {
            ObjectId developHeadObjectId = git.getRepository().getRef("refs/heads/" + getDevelopBranchName()).getObjectId();
            RevWalk walk = new RevWalk(git.getRepository());
            git.branchCreate().setStartPoint(walk.parseCommit(developHeadObjectId)).setName(getReleasePrefix() + releaseVersion).call();
        } catch (GitAPIException ex) {
            throw new GitFlowException(ex);
        } catch (IOException ex) {
            throw new GitFlowException(ex);
        }
    }

    public boolean ready() throws GitFlowException {
        RepositoryState repositoryState = git.getRepository().getRepositoryState();
        Status status;
        try {
            status = git.status().call();
            return repositoryState.canCheckout()
                    && repositoryState.canCommit()
                    && repositoryState.canResetHead()
                    && status.getRemoved().isEmpty()
                    && status.getAdded().isEmpty()
                    && status.getChanged().isEmpty()
                    && status.getModified().isEmpty()
                    && status.getMissing().isEmpty();
        } catch (GitAPIException ex) {
            throw new GitFlowException(ex);
        } catch (NoWorkTreeException ex) {
            throw new GitFlowException(ex);
        }

    }

    public void checkoutDevelop() throws GitAPIException {
        git.checkout().setName(getDevelopBranchName()).call();
    }

    public List<String> getReleaseBranchNames() throws GitAPIException {
        List<String> releaseBranchNames = new ArrayList<String>();
        for (Ref nextRef : git.branchList().call()) {
            System.out.println(nextRef.getName() + ":" + getReleasePrefix());
            if (nextRef.getName().startsWith("refs/heads/" + getReleasePrefix())) {
                releaseBranchNames.add(nextRef.getName());
                System.out.println("here");
            }
        }
        return releaseBranchNames;
    }
}
