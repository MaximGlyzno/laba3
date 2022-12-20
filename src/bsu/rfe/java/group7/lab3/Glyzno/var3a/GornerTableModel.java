package bsu.rfe.java.group7.lab3.Glyzno.var3a;

import javax.swing.table.AbstractTableModel;
import java.lang.Math;
@SuppressWarnings("serial")
public class GornerTableModel extends AbstractTableModel {
    private Double[] coefficients;
    private Double from;
    private Double to;
    private Double step;

    public GornerTableModel(Double from, Double to, Double step,
                            Double[] coefficients) {
        this.from = from;
        this.to = to;
        this.step = step;
        this.coefficients = coefficients;
    }

    public Double getFrom() {
        return from;
    }

    public Double getTo() {
        return to;
    }

    public Double getStep() {
        return step;
    }

    public int getColumnCount() {
// В данной модели два столбца
        return 3;
    }

    public int getRowCount() {
// Вычислить количество точек между началом и концом отрезка
// исходя из шага табулирования
        return (int) (Math.ceil((to - from) / step)) + 1;
    }

    public Object getValueAt(int row, int col) {
        double x = from + step * row;
        double result = 0.0;
        int temp = 0;
        if (col == 0) {
// Если запрашивается значение 1-го столбца, то это X
            return x;
        } else if (col == 1) {
            int i = 0;
            result = result * x;
            result = result + x * coefficients[i++];

            return result;
        }
        else {
            int i = 0;
            result = result * x;
            result = result + x * coefficients[i++];
            int k = (int) result;
            if(result - k == 0)
            {
                return true;
            }
            return false;
        }


    }


    public String getColumnName(int col) {
        switch (col) {
            case 0: return "Значение х";
            case 1: return "Значение многочлена";
            case 2: return "Точное значение?";
        }
        return "";
    }
    public Class<?> getColumnClass(int col) {
        if (col != 2)
            return Double.class;
        else {
            return Boolean.class;
        }
    }
}
