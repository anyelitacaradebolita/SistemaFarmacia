/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author Daryelin
 */
public class PanelVidrio extends JPanel {

    private int radio
            = TemaFarmacia.RADIO_GRANDE;

    private Color colorFondo
            = TemaFarmacia.BLANCO;

    private Color colorBorde
            = TemaFarmacia.BORDE_SUAVE;

    private Color colorBrillo
            = new Color(255, 255, 255, 90);

    private boolean mostrarSombra = true;
    private boolean mostrarBrillo = true;

    private float opacidad = 1.0f;

    public PanelVidrio() {

        configurarPanel();
    }

    public PanelVidrio(int radio) {

        this.radio = radio;

        configurarPanel();
    }

    private void configurarPanel() {

        setOpaque(false);
    }

    @Override
    protected void paintComponent(
            Graphics graphics
    ) {

        Graphics2D g2
                = (Graphics2D) graphics.create();

        try {

            activarCalidadGrafica(g2);

            int ancho = getWidth();
            int alto = getHeight();

            if (ancho <= 0 || alto <= 0) {
                return;
            }

            if (mostrarSombra) {

                dibujarSombra(
                        g2,
                        ancho,
                        alto
                );
            }

            dibujarFondo(
                    g2,
                    ancho,
                    alto
            );

            if (mostrarBrillo) {

                dibujarReflejo(
                        g2,
                        ancho,
                        alto
                );
            }

            dibujarBorde(
                    g2,
                    ancho,
                    alto
            );

        } finally {

            g2.dispose();
        }

        super.paintComponent(graphics);
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

    private void dibujarSombra(
            Graphics2D g2,
            int ancho,
            int alto
    ) {

        g2.setColor(
                TemaFarmacia.SOMBRA_SUAVE
        );

        g2.fillRoundRect(
                7,
                9,
                Math.max(0, ancho - 14),
                Math.max(0, alto - 15),
                radio,
                radio
        );

        g2.setColor(
                new Color(
                        TemaFarmacia.SOMBRA_MEDIA.getRed(),
                        TemaFarmacia.SOMBRA_MEDIA.getGreen(),
                        TemaFarmacia.SOMBRA_MEDIA.getBlue(),
                        25
                )
        );

        g2.fillRoundRect(
                5,
                7,
                Math.max(0, ancho - 12),
                Math.max(0, alto - 13),
                radio,
                radio
        );
    }

    private void dibujarFondo(
            Graphics2D g2,
            int ancho,
            int alto
    ) {

        int alpha
                = Math.max(
                        0,
                        Math.min(
                                255,
                                Math.round(
                                        opacidad * 255
                                )
                        )
                );

        Color fondoConOpacidad
                = new Color(
                        colorFondo.getRed(),
                        colorFondo.getGreen(),
                        colorFondo.getBlue(),
                        alpha
                );

        g2.setColor(
                fondoConOpacidad
        );

        g2.fillRoundRect(
                2,
                2,
                Math.max(0, ancho - 12),
                Math.max(0, alto - 12),
                radio,
                radio
        );
    }

    private void dibujarReflejo(
            Graphics2D g2,
            int ancho,
            int alto
    ) {

        int altoReflejo
                = Math.max(
                        20,
                        Math.min(
                                70,
                                alto / 4
                        )
                );

        g2.setColor(
                colorBrillo
        );

        g2.fillRoundRect(
                10,
                7,
                Math.max(0, ancho - 30),
                altoReflejo,
                radio,
                radio
        );
    }

    private void dibujarBorde(
            Graphics2D g2,
            int ancho,
            int alto
    ) {

        g2.setColor(
                colorBorde
        );

        g2.setStroke(
                new BasicStroke(1.0f)
        );

        g2.drawRoundRect(
                2,
                2,
                Math.max(0, ancho - 12),
                Math.max(0, alto - 12),
                radio,
                radio
        );
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(
            int radio
    ) {

        this.radio = radio;
        repaint();
    }

    public Color getColorFondo() {
        return colorFondo;
    }

    public void setColorFondo(
            Color colorFondo
    ) {

        if (colorFondo == null) {
            return;
        }

        this.colorFondo = colorFondo;
        repaint();
    }

    public Color getColorBorde() {
        return colorBorde;
    }

    public void setColorBorde(
            Color colorBorde
    ) {

        if (colorBorde == null) {
            return;
        }

        this.colorBorde = colorBorde;
        repaint();
    }

    public Color getColorBrillo() {
        return colorBrillo;
    }

    public void setColorBrillo(
            Color colorBrillo
    ) {

        if (colorBrillo == null) {
            return;
        }

        this.colorBrillo = colorBrillo;
        repaint();
    }

    public boolean isMostrarSombra() {
        return mostrarSombra;
    }

    public void setMostrarSombra(
            boolean mostrarSombra
    ) {

        this.mostrarSombra = mostrarSombra;
        repaint();
    }

    public boolean isMostrarBrillo() {
        return mostrarBrillo;
    }

    public void setMostrarBrillo(
            boolean mostrarBrillo
    ) {

        this.mostrarBrillo = mostrarBrillo;
        repaint();
    }

    public float getOpacidad() {
        return opacidad;
    }

    public void setOpacidad(
            float opacidad
    ) {

        if (opacidad < 0.0f || opacidad > 1.0f) {

            throw new IllegalArgumentException(
                    "La opacidad debe estar entre 0.0 y 1.0"
            );
        }

        this.opacidad = opacidad;
        repaint();
    }
}
