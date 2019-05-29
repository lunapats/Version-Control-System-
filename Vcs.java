package vcs;

import filesystem.FileSystemOperation;
import filesystem.FileSystemSnapshot;
import utils.OperationType;
import utils.OutputWriter;
import utils.Visitor;

import java.lang.reflect.Array;
import java.util.ArrayList;

public final class Vcs implements Visitor {
    private final OutputWriter outputWriter;
    private FileSystemSnapshot activeSnapshot;
    private Branch headBranch = new Branch("master");
    private ArrayList<Branch> branchList = new ArrayList<>();

    /**
     * Vcs constructor.
     *
     * @param outputWriter the output writer
     */
    public Vcs(OutputWriter outputWriter) {
        this.outputWriter = outputWriter;
    }

    /**
     * Does initialisations.
     */
    public void init() {
        this.activeSnapshot = new FileSystemSnapshot(outputWriter);

        //TODO other initialisations
    }

    /**
     * Visits a file system operation.
     *
     * @param fileSystemOperation the file system operation
     * @return the return code
     */
    public int visit(FileSystemOperation fileSystemOperation) {
        return fileSystemOperation.execute(this.activeSnapshot);
    }

    /**
     * Visits a vcs operation.
     *
     * @param vcsOperation the vcs operation
     * @return return code
     */
    @Override
    public int visit(VcsOperation vcsOperation) {
        //TODO
	    return vcsOperation.execute(this);
        //return 0;
    }

    //TODO methods through which vcs operations interact with this

	public Branch getBranch() {
    	return headBranch;
	}

	public void branchStatus(Branch branch) {
		outputWriter.write("On branch: " + branch.branchName + "\n");
		outputWriter.write("Staged changes:" + "\n");
		for (FileSystemOperation operation : branch.stagedChanges) {
			outputWriter.write(branch.stagedChange(operation.getType(),
					operation.getOperationArgs()) + "\n");
		}
	}
}
