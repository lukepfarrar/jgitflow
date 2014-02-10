
package uk.co.theboo.jgitflow;

public class NotGitFlowRepositoryException extends GitFlowException {

    public NotGitFlowRepositoryException() {
        super("Repository has not been initialized for gitflow.");
    }
    
}
