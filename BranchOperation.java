package vcs;

import utils.OperationType;

import java.util.ArrayList;

public final class BranchOperation extends VcsOperation {
	public BranchOperation(OperationType type, ArrayList<String> operationArgs) {
		super(type, operationArgs);
		}

	@Override
	public int execute(Vcs vcs){
		return 0;
		}
}