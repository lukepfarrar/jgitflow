package uk.co.theboo.jgitflow;

import java.io.IOException;
import org.apache.commons.lang.Validate;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.storage.file.FileRepository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

public class GitUtils {

    public static boolean branchExists(Git git, final String branchName) throws GitAPIException {
        Validate.notNull(git, "git param cannot be null.");
        Validate.notNull(branchName, "branchName cannot be null.");
        for (Ref nextRef : git.branchList().call()) {
            if (nextRef.getName().equals("refs/heads/" + branchName)) {
                return true;
            }
        }
        return false;
    }

    public static FileRepository initGitRepository() throws GitFlowException, IOException {
        FileRepositoryBuilder repositoryBuilder = new FileRepositoryBuilder();
        repositoryBuilder.findGitDir();
        if (repositoryBuilder.getGitDir() == null) {            
            throw new GitFlowException("Not in a git repository.");
        }
        return repositoryBuilder.build();
    }
}
