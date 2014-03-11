package hu.sztaki.ilab.longneck.process.constraint;

import hu.sztaki.ilab.longneck.Record;
import hu.sztaki.ilab.longneck.process.VariableSpace;
import hu.sztaki.ilab.longneck.process.block.BlockUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Geszler Döme <gdome@ilab.sztaki.hu>
 */
public class CvdConstraint extends AbstractAtomicConstraint {

    @Override
    public CheckResult check(Record record, VariableSpace scope) {
        // Prepare result variable
        List<CheckResult> results = new ArrayList<CheckResult>(applyTo.size());

        for (String fName : applyTo) {
            results.add(new CheckResult(this, false, fName, BlockUtils
                .getValue(fName, record, scope), "Generated an error"));
        }
        return new CheckResult(this, false, null, null, null, results);
    }

    @Override
    public CvdConstraint clone() {
        return (CvdConstraint) super.clone();
    }
}
