import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Prob4 {
    public static void main(String[] args) {
        // Exemplu cu numere complexe
        Complex tt = new Complex(1, 6);
        Complex tttt = (Complex) tt.def(new Complex(2, -1));
        System.out.println(tttt);

        ComplexPolynom pol = new ComplexPolynom(5);
        for (int i = 0; i < pol.length; i++) {
            pol.setComplexPolynom(i, (int) (Math.random() * 10), (int) (Math.random() * 10),
                    (int) (Math.random() * 10));
        }

        ComplexPolynom pol2 = new ComplexPolynom(3);
        for (int i = 0; i < pol2.length; i++) {
            pol2.setComplexPolynom(i, (int) (Math.random() * 10), (int) (Math.random() * 10),
                    (int) (Math.random() * 10));
        }

        ComplexPolynom pol1 = (ComplexPolynom) pol.def(pol2);
        System.out.println(pol.toStringAll());
        System.out.println(pol2.toStringAll());
        System.out.println(pol1.toStringAll());

        // Exemplu cu fracții
        FractionArray frArray = new FractionArray(3);
        frArray.setFraction(0, 1, 2);
        frArray.setFraction(1, 1, 3);
        frArray.setFraction(2, 1, 4);
        FractionArray frArray2 = new FractionArray(2);
        frArray2.setFraction(0, 1, 5);
        frArray2.setFraction(1, 1, 6);

        FractionArray frArray1 = (FractionArray) frArray.adun(frArray2);
        System.out.println(frArray.toString());
        System.out.println(frArray2.toString());
        System.out.println(frArray1.toString());

        ComPolFram fram = new ComPolFram();
        fram.setVisible(true);
    }
}

class ComPolFram extends JFrame {
    public ComPolFram() {
        this.setTitle("Complex Poligon");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 500);
        this.setLocation(300, 200);
        Box Hbox1 = Box.createHorizontalBox();
        Hbox1.add(new JLabel("n="));
        nn = new JTextField(10);
        nn.setMaximumSize(nn.getPreferredSize());
        Hbox1.add(nn);
        butmac("add", Hbox1);
        butmac("+", Hbox1);
        butmac("-", Hbox1);
        Hbox2 = Box.createHorizontalBox();
        Hbox3 = Box.createHorizontalBox();
        Hbox4 = Box.createHorizontalBox();
        Hbox5 = Box.createHorizontalBox();
        Hbox6 = Box.createHorizontalBox();
        Box Vbox = Box.createVerticalBox();
        Vbox.add(Hbox1);
        Vbox.add(Hbox2);
        Vbox.add(Hbox3);
        Vbox.add(Hbox4);
        Vbox.add(Hbox5);
        Vbox.add(Hbox6);
        add(Vbox, BorderLayout.CENTER);
    }

    private JTextField nn;
    private JTextField[] n1, n2, n3;
    private JTextField[] m1, m2, m3;
    private Box Hbox2, Hbox3, Hbox4, Hbox5, Hbox6;

    private void butmac(String s, Box b) {
        JButton but = new JButton(s);
        but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand());

                int n = Integer.parseInt(nn.getText());

                if (e.getActionCommand().equals("add")) {
                    Hbox2.removeAll();
                    Hbox3.removeAll();
                    n1 = new JTextField[n];
                    n2 = new JTextField[n];
                    n3 = new JTextField[n];
                    m1 = new JTextField[n];
                    m2 = new JTextField[n];
                    m3 = new JTextField[n];
                    for (int i = 0; i < n; i++) {
                        n1[i] = new JTextField(3);
                        n1[i].setMaximumSize(nn.getPreferredSize());
                        n2[i] = new JTextField(3);
                        n2[i].setMaximumSize(nn.getPreferredSize());
                        n3[i] = new JTextField(3);
                        n3[i].setMaximumSize(nn.getPreferredSize());
                        m1[i] = new JTextField(3);
                        m1[i].setMaximumSize(nn.getPreferredSize());
                        m2[i] = new JTextField(3);
                        m2[i].setMaximumSize(nn.getPreferredSize());
                        m3[i] = new JTextField(3);
                        m3[i].setMaximumSize(nn.getPreferredSize());
                        Hbox2.add(new JLabel("(r="));
                        Hbox2.add(n1[i]);
                        Hbox2.add(new JLabel("i="));
                        Hbox2.add(n2[i]);
                        Hbox2.add(new JLabel("b="));
                        Hbox2.add(n3[i]);
                        Hbox2.add(new JLabel(") "));
                        Hbox3.add(new JLabel("(r="));
                        Hbox3.add(m1[i]);
                        Hbox3.add(new JLabel("i="));
                        Hbox3.add(m2[i]);
                        Hbox3.add(new JLabel("b="));
                        Hbox3.add(m3[i]);
                        Hbox3.add(new JLabel(") "));
                    }
                    pack();
                } else if (e.getActionCommand().equals("+") || e.getActionCommand().equals("-")) {
                    Hbox4.removeAll();
                    Hbox5.removeAll();
                    Hbox6.removeAll();

                    FractionArray frArray1 = new FractionArray(n);
                    for (int i = 0; i < n; i++) {
                        frArray1.setFraction(i, Integer.parseInt(n1[i].getText()), Integer.parseInt(n2[i].getText()));
                    }

                    FractionArray frArray2 = new FractionArray(n);
                    for (int i = 0; i < n; i++) {
                        frArray2.setFraction(i, Integer.parseInt(m1[i].getText()), Integer.parseInt(m2[i].getText()));
                    }

                    FractionArray frArray3;
                    if (e.getActionCommand().equals("+")) {
                        frArray3 = (FractionArray) frArray1.adun(frArray2);
                    } else {
                        frArray3 = (FractionArray) frArray1.def(frArray2);
                    }

                    Hbox4.add(new JLabel("(" + frArray1.toString() + ")"));
                    Hbox5.add(new JLabel("+" + "(" + frArray2.toString() + ")"));
                    Hbox6.add(new JLabel("=" + "(" + frArray3.toString() + ")"));

                    pack();
                }
            }
        });
        b.add(but);
    }
}

abstract class Scadere {
    abstract public Object adun(Object t);
    abstract public Object invers();

    public Object def(Object t) {
        Scadere tt = (Scadere) t;
        return adun(tt.invers());
    }
}

class Complex extends Scadere {
    public Complex() {
        real = 0;
        img = 0;
    }

    public Complex(double Real, double Img) {
        real = Real;
        img = Img;
    }

    public void setComplex(double Real, double Img) {
        real = Real;
        img = Img;
    }

    public String toString() {
        return real + (img > 0 ? "+" : "") + (img != 0 ? img + "i" : "");
    }

    public Complex adun(Object t) {
        Complex tt = (Complex) t;
        Complex ret = new Complex();
        ret.img = img + tt.img;
        ret.real = real + tt.real;
        return ret;
    }

    public Complex clone() {
        Complex temp = new Complex();
        temp.img = img;
        temp.real = real;
        return temp;
    }

    public Complex invers() {
        Complex temp = this.clone();
        temp.img = temp.img * (-1);
        temp.real = temp.real * (-1);
        return temp;
    }

    protected double real, img;
}

class ComplexPolynom extends Complex {
    public ComplexPolynom() {
        super();
        pol = new ComplexPolynom[1];
        pol[0] = this;
        baz = 0;
        put = 0;
        length = 1;
    }

    public ComplexPolynom(int n) {
        super();
        pol = new ComplexPolynom[n];
        pol[0] = this;
        for (int i = 1; i < pol.length; i++) {
            pol[i] = new ComplexPolynom();
        }
        length = n;
    }

    public void setComplexPolynom(int n, double Real, double Img, double Baz) {
        pol[n].baz = Baz;
        pol[n].put = n;
        pol[n].setComplex(Real, Img);
    }

    public ComplexPolynom getComplexPolynom(int n) {
        return pol[n];
    }

    public String toString() {
        return (baz >= 0 ? "+" : "") + baz + "(" + super.toString() + ")^" + put;
    }

    public String toStringAll() {
        StringBuilder output = new StringBuilder();
        for (ComplexPolynom temp : pol) {
            output.append(temp);
        }
        return output.toString();
    }

    public ComplexPolynom adun(Object t) {
        ComplexPolynom tt = (ComplexPolynom) t;
        int maxl = tt.length > length ? tt.length : length;
        ComplexPolynom ret = new ComplexPolynom(maxl);
        for (int i = 0; i < maxl; i++) {
            if (tt.length > i) {
                ret.pol[i].baz = tt.pol[i].baz;
                ret.pol[i].img = tt.pol[i].img;
                ret.pol[i].real = tt.pol[i].real;
            }
            if (length > i) {
                ret.pol[i].baz += pol[i].baz;
                ret.pol[i].img += pol[i].img;
                ret.pol[i].real += pol[i].real;
            }
            ret.pol[i].put = i;
        }
        return ret;
    }

    public ComplexPolynom invers() {
        ComplexPolynom temp = new ComplexPolynom(length);
        for (int i = 0; i < length; i++) {
            temp.pol[i].baz = pol[i].baz * (-1);
            temp.pol[i].put = pol[i].put;
            temp.pol[i].img = pol[i].img * (-1);
            temp.pol[i].real = pol[i].real * (-1);
        }
        return temp;
    }

    public ComplexPolynom clone() {
        ComplexPolynom temp = new ComplexPolynom(length);
        for (int i = 0; i < length; i++) {
            temp.pol[i].baz = pol[i].baz;
            temp.pol[i].put = pol[i].put;
            temp.pol[i].img = pol[i].img;
            temp.pol[i].real = pol[i].real;
        }
        return temp;
    }

    public int length;
    private double baz, put;
    private ComplexPolynom[] pol;
}

// Clasa Fraction
class Fraction extends Scadere {
    private int numerator;
    private int denominator;

    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public void setFraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public Fraction adun(Object t) {
        Fraction tt = (Fraction) t;
        Fraction result = new Fraction();
        result.numerator = this.numerator * tt.denominator + tt.numerator * this.denominator;
        result.denominator = this.denominator * tt.denominator;
        return result;
    }

    @Override
    public Fraction invers() {
        Fraction result = new Fraction(-this.numerator, this.denominator);
        return result;
    }

    @Override
    public Fraction clone() {
        Fraction result = new Fraction(this.numerator, this.denominator);
        return result;
    }
}

// Clasa FractionArray
class FractionArray extends Scadere {
    private Fraction[] fractions;

    public FractionArray(int length) {
        this.fractions = new Fraction[length];
        for (int i = 0; i < length; i++) {
            this.fractions[i] = new Fraction();
        }
    }

    public void setFraction(int index, int numerator, int denominator) {
        this.fractions[index].setFraction(numerator, denominator);
    }

    public Fraction getFraction(int index) {
        return this.fractions[index];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Fraction fraction : this.fractions) {
            sb.append(fraction.toString()).append(" ");
        }
        return sb.toString();
    }

    @Override
    public Fraction adun(Object t) {
        FractionArray tt = (FractionArray) t;
        int maxLength = Math.max(this.fractions.length, tt.fractions.length);
        FractionArray result = new FractionArray(maxLength);
        for (int i = 0; i < maxLength; i++) {
            Fraction a = i < this.fractions.length ? this.fractions[i] : new Fraction();
            Fraction b = i < tt.fractions.length ? tt.fractions[i] : new Fraction();
            result.fractions[i] = a.adun(b);
        }
        return result;
    }

    @Override
    public Fraction invers() {
        FractionArray result = new FractionArray(this.fractions.length);
        for (int i = 0; i < this.fractions.length; i++) {
            result.fractions[i] = this.fractions[i].invers();
        }
        return result;
    }

    @Override
    public Fraction clone() {
        FractionArray result = new FractionArray(this.fractions.length);
        for (int i = 0; i < this.fractions.length; i++) {
            result.fractions[i] = this.fractions[i].clone();
        }
        return result;
    }
}

abstract class Scadere {
    abstract public Object adun(Object t);
    abstract public Object invers();

    public Object def(Object t) {
        Scadere tt = (Scadere) t;
        return adun(tt.invers());
    }
}
