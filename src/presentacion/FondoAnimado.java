/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Daryelin
 */
public class FondoAnimado {
     private final Timer temporizador;

    private double desplazamiento = 0.0;
    private boolean animacionActiva = true;

    public FondoAnimado() {

        configurarPanel();

        temporizador = new Timer(
                45,
                evento -> actualizarAnimacion()
        );

        temporizador.start();
    }

    
    private void configurarPanel() {

        setOpaque(true);

        setBackground(
                TemaFarmacia.FONDO_GENERAL
        );
    }

    private void actualizarAnimacion() {

        if (!animacionActiva) {
            return;
        }

        desplazamiento += 0.008;

        repaint();
    }

    @Override
    protected void paintComponent(
            Graphics graphics
    ) {

        super.paintComponent(graphics);

        Graphics2D g2
                = (Graphics2D) graphics.create();

        try {

            activarCalidadGrafica(g2);

            dibujarFondoDegradado(g2);
            dibujarFormasDecorativas(g2);
            dibujarBrilloSuperior(g2);

        } finally {

            g2.dispose();
        }
    }

   
    private void activarCalidadGrafica(
            Graphics2D g2
    ) {

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        g2.setRenderingHint(
                RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY
        );

        g2.setRenderingHint(
                RenderingHints.KEY_ALPHA_INTERPOLATION,
                RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY
        );
    }


    private void dibujarFondoDegradado(
            Graphics2D g2
    ) {

        int ancho = getWidth();
        int alto = getHeight();

        GradientPaint degradado
                = new GradientPaint(
                        0,
                        0,
                        new Color(
                                248,
                                253,
                                254
                        ),
                        ancho,
                        alto,
                        TemaFarmacia.FONDO_GENERAL
                );

        g2.setPaint(
                degradado
        );

        g2.fillRect(
                0,
                0,
                ancho,
                alto
        );
    }


    private void dibujarFormasDecorativas(
            Graphics2D g2
    ) {

        int ancho = getWidth();
        int alto = getHeight();

        double movimientoHorizontal
                = Math.sin(desplazamiento) * 22;

        double movimientoVertical
                = Math.cos(desplazamiento * 0.8) * 16;


        dibujarCirculoSuave(
                g2,
                -90 + movimientoHorizontal,
                -80 + movimientoVertical,
                280,
                new Color(
                        31,
                        166,
                        184,
                        28
                )
        );


        dibujarCirculoSuave(
                g2,
                ancho - 220 - movimientoHorizontal,
                -60 - movimientoVertical,
                300,
                new Color(
                        80,
                        174,
                        205,
                        24
                )
        );


        dibujarCirculoSuave(
                g2,
                -70 - movimientoHorizontal,
                alto - 180 + movimientoVertical,
                260,
                new Color(
                        90,
                        205,
                        205,
                        22
                )
        );


        dibujarCirculoSuave(
                g2,
                ancho - 190 + movimientoHorizontal,
                alto - 170 - movimientoVertical,
                250,
                new Color(
                        52,
                        160,
                        180,
                        20
                )
        );


        dibujarCirculoSuave(
                g2,
                ancho * 0.18,
                alto * 0.30,
                42,
                new Color(
                        31,
                        166,
                        184,
                        18
                )
        );

        dibujarCirculoSuave(
                g2,
                ancho * 0.82,
                alto * 0.42,
                34,
                new Color(
                        72,
                        180,
                        196,
                        20
                )
        );

        dibujarCirculoSuave(
                g2,
                ancho * 0.68,
                alto * 0.82,
                48,
                new Color(
                        31,
                        166,
                        184,
                        16
                )
        );
    }


    private void dibujarCirculoSuave(
            Graphics2D g2,
            double x,
            double y,
            double tamano,
            Color color
    ) {

        int capas = 8;

        for (int i = capas; i >= 1; i--) {

            double escala
                    = i / (double) capas;

            double diametro
                    = tamano * escala;

            int transparencia
                    = Math.max(
                            2,
                            color.getAlpha()
                            / (capas - i + 1)
                    );

            g2.setColor(
                    new Color(
                            color.getRed(),
                            color.getGreen(),
                            color.getBlue(),
                            transparencia
                    )
            );

            g2.fill(
                    new Ellipse2D.Double(
                            x + (tamano - diametro) / 2,
                            y + (tamano - diametro) / 2,
                            diametro,
                            diametro
                    )
            );
        }
    }


    private void dibujarBrilloSuperior(
            Graphics2D g2
    ) {

        int ancho = getWidth();

        GradientPaint brillo
                = new GradientPaint(
                        0,
                        0,
                        new Color(
                                255,
                                255,
                                255,
                                180
                        ),
                        0,
                        180,
                        new Color(
                                255,
                                255,
                                255,
                                0
                        )
                );

        g2.setPaint(
                brillo
        );

        g2.fillRect(
                0,
                0,
                ancho,
                180
        );
    }


    public void detenerAnimacion() {

        animacionActiva = false;

        temporizador.stop();
    }


    public void iniciarAnimacion() {

        animacionActiva = true;

        if (!temporizador.isRunning()) {
            temporizador.start();
        }
    }
}
