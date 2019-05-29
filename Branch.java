package vcs;

import filesystem.FileSystemOperation;
import utils.OperationType;
import utils.OutputWriter;

import java.util.ArrayList;

public class Branch {
	String branchName;
	ArrayList<Commit> commitList = new ArrayList<>();
	ArrayList<FileSystemOperation> stagedChanges = new ArrayList<FileSystemOperation>();

	public Branch(String branchName) {
		this.branchName = branchName;
	}

	public ArrayList<FileSystemOperation> getStagedChanges() {
		return stagedChanges;
	}

	/*public void branchStatus() {
		outputWriter.write("On Branch: " + branchName);
		outputWriter.write("Staged changes: ");
		for (FileSystemOperation operation : stagedChanges) {
			outputWriter.write(stagedChange(operation.getType(), operation.getOperationArgs()));
		}
	}*/

	public String stagedChange(OperationType type, ArrayList<String> operationArgs) {
		switch (type) {
			case CHANGEDIR:
				return "Changed directory to " + operationArgs.get(0);
			case MAKEDIR:
				return "Created directory " + operationArgs.get(0);
			case REMOVE:
				return "Removed " + operationArgs.get(0);
			case TOUCH:
				return "\tCreated file " + operationArgs.get(1);
			case WRITETOFILE:
				return "Added " + operationArgs.get(1) + "to file" + operationArgs.get(0);
			default:
				return null;
		}
	}

	/*public void setBranchName(String branchName) {
		this.branchName = branchName;
	}*/
}
