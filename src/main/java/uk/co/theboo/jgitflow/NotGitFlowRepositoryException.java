
package uk.co.theboo.jgitflow;

public class NotGitFlowRepositoryException extends GitFlowException {

    public NotGitFlowRepositoryException(String not_initialized_for_gitflow) {
        super(not_initialized_for_gitflow);
    }
    
}
