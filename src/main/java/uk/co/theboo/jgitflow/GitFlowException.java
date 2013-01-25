
package uk.co.theboo.jgitflow;

public class GitFlowException extends Exception {

    GitFlowException(String message) {
        super(message);
    }

    GitFlowException(Throwable throwable) {
        super(throwable);
    }
}
