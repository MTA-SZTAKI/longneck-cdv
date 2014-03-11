package hu.sztaki.ilab.longneck.process.constraint;

import hu.sztaki.ilab.longneck.Record;
import hu.sztaki.ilab.longneck.process.VariableSpace;
import hu.sztaki.ilab.longneck.process.block.BlockUtils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Molnár Péter <molnarp@ilab.sztaki.hu>
 */
public class CvdConstraint extends AbstractAtomicConstraint {

    @Override
    public CheckResult check(Record record, VariableSpace scope) {
        // Prepare result variable
        List<CheckResult> results = new ArrayList<CheckResult>(applyTo.size());
        
        for (String fieldName : applyTo) {
            String s = BlockUtils.getValue(fieldName, record, scope);
        }
        return new CheckResult(this, true, null, null, null, results);
    }

    @Override
    public CvdConstraint clone() {
        return (CvdConstraint) super.clone();
    }
}
