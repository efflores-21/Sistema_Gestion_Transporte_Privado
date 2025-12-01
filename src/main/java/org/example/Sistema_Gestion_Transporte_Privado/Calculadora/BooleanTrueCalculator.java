package org.example.Sistema_Gestion_Transporte_Privado.Calculadora;

import org.openxava.calculators.ICalculator;

public class BooleanTrueCalculator implements ICalculator {
    @Override
    public Object calculate() {
        return Boolean.TRUE;
    }
}
