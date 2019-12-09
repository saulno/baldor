package org.drools.workshop.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.text.DecimalFormat;

import javax.xml.bind.annotation.XmlRootElement;

public class Problema {
    String instruccion;
    String ecuacion;
    String respuesta;
    private Map<Character, Integer> variable;
    static Random random = new Random();
    static DecimalFormat decFormat = new DecimalFormat("#.00");

    public String getInstruccion() {
        return instruccion;
    }

    public void setInstruccion(String instruccion) {
        this.instruccion = instruccion;
    }

    public String getEcuacion() {
        return ecuacion;
    }

    public void setEcuacion(String ecuacion) {
        String ecuacionOriginal = ecuacion;
        String ecuacionFinal = ecuacion;

        int posicionSigno = 0;
        // Reemplazar coeficientes por numeros y guardar sus valores
        for (int i = 0; i < ecuacionOriginal.length(); i++) {
            if (Character.isUpperCase(ecuacionOriginal.charAt(i))) {
                int valor = 0;
                while (valor == 0) {
                    valor = random.nextInt(10); // 1...9
                }
                if (random.nextInt(2) == 0 && posicionSigno != 0) {
                    valor *= -1;
                    ecuacionOriginal = ecuacionOriginal.substring(0, posicionSigno) + '-' + ecuacionOriginal.substring(posicionSigno +1);
                    ecuacionFinal = ecuacionFinal.substring(0, posicionSigno) + '-' + ecuacionFinal.substring(posicionSigno +1);
                }
                variable.put(ecuacionOriginal.charAt(i), valor); 
                ecuacionFinal = ecuacionFinal.replaceAll(String.valueOf(ecuacionOriginal.charAt(i)), Integer.toString(Math.abs(valor)));
            } else if (ecuacionOriginal.charAt(i) == '+') {
                posicionSigno = i;
            }
        }
        this.ecuacion = ecuacionFinal;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void actualizar() {
        setEcuacion(this.ecuacion);
        setRespuesta(this.respuesta);
    }

    public void setRespuesta(String solucionConEspacios) {
        // Reemplazar coeficientes de la respuesta para obtenerla
        String solucionOriginal = solucionConEspacios.replaceAll(" ", "");
        String solucionFinal = solucionConEspacios.replaceAll(" ", "");
        for (int i = 0; i < solucionOriginal.length(); i++) {
            String coeficiente = solucionOriginal.charAt(i) + "";
            if (Character.isUpperCase(solucionOriginal.charAt(i))) {
                solucionFinal = solucionFinal.replaceAll(coeficiente, Integer.toString(variable.get(solucionOriginal.charAt(i))));
            }
        }

        String resultado = "";
        // Evaluar el resultado final de cada variable de la ecuacion
        for (String varEcuacion: solucionFinal.split(",")) {
            // a = 2 + 3 (coeficientes)
            String var = varEcuacion.substring(0, 3);
            var = var.replaceAll("\\^1", "");
            double coeficiente = evaluar(varEcuacion.substring(4));

            if (coeficiente > 0 && !resultado.equals("")) {
                resultado += " + ";
            } else if (coeficiente < 0) {
                resultado += " - ";
            }
            
            if (coeficiente == 1) {
                resultado += String.valueOf(var) + " ";
            } else if (coeficiente == 0) {

            } else {
                resultado += decFormat.format(Math.abs(coeficiente)) + " * " + String.valueOf(var) + " ";
            }
        }

        this.respuesta = resultado;
    }

    @Override
    public String toString() {
        return "Problema{" +    "\ninstruccion=" + instruccion + 
                                "\necuacion=" + ecuacion +
                                "\nrespuesta=" + respuesta +
        "}";
    }

    public Problema() {
        variable = new HashMap<Character, Integer>();
    }

    private double evaluar(final String str) {
        return new Object() {
            int pos = -1, ch;
    
            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }
    
            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }
    
            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }
    
            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor
    
            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }
    
            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }
    
            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus
    
                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }
    
                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation
    
                return x;
            }
        }.parse();
    }
}