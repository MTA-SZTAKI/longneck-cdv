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
public class CdvConstraint extends AbstractAtomicConstraint {

    private int mod;
    private String coefficients;
    private CdvLogic cdvLogic = new CdvLogic();

    @Override
    public CheckResult check(Record record, VariableSpace scope) {
        // Prepare result variable
        List<CheckResult> results = new ArrayList<>(applyTo.size());
        String details = "CheckDigit not valid." + cdvLogic.toString();

        for (String fieldName : applyTo) {
            String value = BlockUtils.getValue(fieldName, record, scope);
            if (cdvLogic.check(value)) {
                results.add(new CheckResult(this, true, fieldName, value, details));
            } else {
                results.add(new CheckResult(this, false, fieldName, value, details));
                return new CheckResult(this, false, null, null, null, results);
            }
        }
        return new CheckResult(this, true, null, null, null, results);
    }

    @Override
    public CdvConstraint clone() {
        return (CdvConstraint) super.clone();
    }

    public int getMod() {
        return mod;
    }

    public void setMod(int mod) {
        this.mod = mod;
        cdvLogic.setMod(mod);
    }

    public String getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(String coefficients) {
        this.coefficients = coefficients;
        cdvLogic.setCoeffs(coefficients);
    }

}
