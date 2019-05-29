package vcs;

import utils.ErrorCodeManager;
import utils.OperationType;

import java.util.ArrayList;

public final class StatusOperation extends VcsOperation {
	public StatusOperation(OperationType type, ArrayList<String> operationArgs) {
		super(type, operationArgs);
	}
	@Override
	public int execute(Vcs vcs) {
			 vcs.branchStatus(vcs.getBranch());
			 return ErrorCodeManager.OK;
		}
	}