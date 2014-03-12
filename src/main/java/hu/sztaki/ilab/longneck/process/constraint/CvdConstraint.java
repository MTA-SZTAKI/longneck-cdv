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

    private String mod;
    private String coefficients;
    private CvdLogic cvdLogic = new CvdLogic();

    @Override
    public CheckResult check(Record record, VariableSpace scope) {
        // Prepare result variable
        List<CheckResult> results = new ArrayList<>(applyTo.size());
        String details = coefficients + " " + mod;

        for (String fieldName : applyTo) {
            String value = BlockUtils.getValue(fieldName, record, scope);
            if (cvdLogic.check(value, coefficients, mod)) {
                results.add(new CheckResult(this, true, fieldName, value, details));
            } else {
                results.add(new CheckResult(this, false, fieldName, value, details));
                return new CheckResult(this, false, null, null, null, results);
            }
        }
        return new CheckResult(this, true, null, null, null, results);
    }

    public String getMod() {
        return mod;
    }

    public void setMod(String mod) {
        this.mod = mod;
    }

    public String getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(String coefficients) {
        this.coefficients = coefficients;
    }

    @Override
    public CvdConstraint clone() {
        return (CvdConstraint) super.clone();
    }
}
