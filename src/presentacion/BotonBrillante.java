/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 *
 * @author Daryelin
 */
public class BotonBrillante extends JButton{
     private Color colorBase
            = TemaFarmacia.TURQUESA_PRINCIPAL;

    private Color colorHover
            = TemaFarmacia.TURQUESA_OSCURO;

    private Color colorPresionado
            = new Color(18, 108, 123);

    private Color colorTexto
            = TemaFarmacia.BLANCO;

    private Color colorBorde
            = TemaFarmacia.TURQUESA_PRINCIPAL;

    private boolean mouseEncima;
    private boolean presionado;

    private int radio
            = TemaFarmacia.RADIO_MEDIO;

    public BotonBrillante(String texto) {

        super(texto);

        configurarBoton();
        configurarEventosMouse();
    }

    private void configurarBoton() {

        setFont(
                TemaFarmacia.FUENTE_BOTON
        );

        setForeground(
                colorTexto
        );

        setCursor(
                Cursor.getPredefinedCursor(
                        Cursor.HAND_CURSOR
                )
        );

        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);

        setPreferredSize(
                new Dimension(
                        145,
                        TemaFarmacia.ALTURA_BOTON
                )
        );
    }

   
    private void configurarEventosMouse() {

        addMouseListener(
                new MouseAdapter() {

            @Override
            public void mouseEntered(
                    MouseEvent evento
            ) {

                mouseEncima = true;
                repaint();
            }

            @Override
            public void mouseExited(
                    MouseEvent evento
            ) {

                mouseEncima = false;
                presionado = false;
                repaint();
            }

            @Override
            public void mousePressed(
                    MouseEvent evento
            ) {

                if (isEnabled()) {
                    presionado = true;
                    repaint();
                }
            }

            @Override
            public void mouseReleased(
                    MouseEvent evento
            ) {

                presionado = false;
                repaint();
            }
        });
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

            int desplazamiento
                    = presionado ? 2 : 0;

            dibujarSombra(
                    g2,
                    ancho,
                    alto,
                    desplazamiento
            );

            dibujarFondo(
                    g2,
                    ancho,
                    alto,
                    desplazamiento
            );

            dibujarBorde(
                    g2,
                    ancho,
                    alto,
                    desplazamiento
            );

            dibujarTexto(
                    g2,
                    ancho,
                    alto,
                    desplazamiento
            );

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
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON
        );
    }

    /**
     * Dibuja una sombra suave bajo el botón.
     */
    private void dibujarSombra(
            Graphics2D g2,
            int ancho,
            int alto,
            int desplazamiento
    ) {

        if (!isEnabled()) {
            return;
        }

        g2.setColor(
                TemaFarmacia.SOMBRA_MEDIA
        );

        g2.fillRoundRect(
                4,
                6 + desplazamiento,
                Math.max(0, ancho - 8),
                Math.max(0, alto - 10),
                radio,
                radio
        );
    }

    /**
     * Dibuja el fondo principal.
     */
    private void dibujarFondo(
            Graphics2D g2,
            int ancho,
            int alto,
            int desplazamiento
    ) {

        g2.setColor(
                obtenerColorActual()
        );

        g2.fillRoundRect(
                2,
                2 + desplazamiento,
                Math.max(0, ancho - 7),
                Math.max(0, alto - 9),
                radio,
                radio
        );

        /*
         * Reflejo superior muy suave.
         */
        if (isEnabled()) {

            g2.setColor(
                    new Color(
                            255,
                            255,
                            255,
                            mouseEncima ? 45 : 28
                    )
            );

            g2.fillRoundRect(
                    7,
                    5 + desplazamiento,
                    Math.max(0, ancho - 17),
                    Math.max(0, alto / 3),
                    radio,
                    radio
            );
        }
    }

    /**
     * Dibuja el borde del botón.
     */
    private void dibujarBorde(
            Graphics2D g2,
            int ancho,
            int alto,
            int desplazamiento
    ) {

        Color bordeActual;

        if (!isEnabled()) {

            bordeActual
                    = TemaFarmacia.BORDE_SUAVE;

        } else if (mouseEncima) {

            bordeActual
                    = TemaFarmacia.TURQUESA_OSCURO;

        } else {

            bordeActual
                    = colorBorde;
        }

        g2.setColor(
                bordeActual
        );

        g2.setStroke(
                new BasicStroke(
                        mouseEncima ? 1.5f : 1.0f
                )
        );

        g2.drawRoundRect(
                2,
                2 + desplazamiento,
                Math.max(0, ancho - 7),
                Math.max(0, alto - 9),
                radio,
                radio
        );
    }

    /**
     * Dibuja el texto centrado.
     */
    private void dibujarTexto(
            Graphics2D g2,
            int ancho,
            int alto,
            int desplazamiento
    ) {

        g2.setFont(
                getFont()
        );

        if (isEnabled()) {

            g2.setColor(
                    colorTexto
            );

        } else {

            g2.setColor(
                    TemaFarmacia.TEXTO_SUAVE
            );
        }

        FontMetrics metricas
                = g2.getFontMetrics();

        int posicionX
                = (
                        ancho
                        - metricas.stringWidth(
                                getText()
                        )
                ) / 2;

        int posicionY
                = (
                        alto
                        - metricas.getHeight()
                ) / 2
                + metricas.getAscent()
                - 3
                + desplazamiento;

        g2.drawString(
                getText(),
                posicionX,
                posicionY
        );
    }

    
    private Color obtenerColorActual() {

        if (!isEnabled()) {

            return new Color(
                    224,
                    232,
                    235
            );
        }

        if (presionado) {

            return colorPresionado;
        }

        if (mouseEncima) {

            return colorHover;
        }

        return colorBase;
    }

    public Color getColorBase() {
        return colorBase;
    }

    public void setColorBase(
            Color colorBase
    ) {

        this.colorBase = colorBase;
        repaint();
    }

    public Color getColorHover() {
        return colorHover;
    }

    public void setColorHover(
            Color colorHover
    ) {

        this.colorHover = colorHover;
        repaint();
    }

    public Color getColorPresionado() {
        return colorPresionado;
    }

    public void setColorPresionado(
            Color colorPresionado
    ) {

        this.colorPresionado
                = colorPresionado;

        repaint();
    }

    public Color getColorTexto() {
        return colorTexto;
    }

    public void setColorTexto(
            Color colorTexto
    ) {

        this.colorTexto = colorTexto;

        setForeground(
                colorTexto
        );

        repaint();
    }

    public Color getColorBorde() {
        return colorBorde;
    }

    public void setColorBorde(
            Color colorBorde
    ) {

        this.colorBorde = colorBorde;
        repaint();
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

   
    public void detenerAnimacion() {
            }

    public void iniciarAnimacion() {
        
    }

}
