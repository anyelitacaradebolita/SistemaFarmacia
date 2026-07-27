/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import javax.swing.*;


/**
 *
 * @author Anyel
 */
public class Main {
      public static void main(String[] args) {

       
        configurarApariencia();

        SwingUtilities.invokeLater(() -> {

            MainFrame ventana = new MainFrame();

            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
        });
    }

 
    private static void configurarApariencia() {

        try {


            FlatLightLaf.setup();

            configurarComponentesGenerales();
            configurarBotones();
            configurarCamposDeTexto();
            configurarComboBox();
            configurarPestanas();
            configurarTablas();
            configurarBarrasDeDesplazamiento();
            configurarMenus();
            configurarVentanasEmergentes();
            configurarTooltips();

        } catch (Exception ex) {

            System.err.println(
                    "No se pudo aplicar FlatLaf: "
                    + ex.getMessage()
            );
        }
    }


    private static void configurarComponentesGenerales() {

        UIManager.put(
                "defaultFont",
                TemaFarmacia.FUENTE_NORMAL
        );

        UIManager.put(
                "Panel.background",
                TemaFarmacia.FONDO_GENERAL
        );

        UIManager.put(
                "Label.foreground",
                TemaFarmacia.TEXTO_PRINCIPAL
        );

        UIManager.put(
                "Label.font",
                TemaFarmacia.FUENTE_NORMAL
        );

        UIManager.put(
                "Component.arc",
                TemaFarmacia.RADIO_MEDIO
        );

        UIManager.put(
                "Component.focusWidth",
                1
        );

        UIManager.put(
                "Component.innerFocusWidth",
                0
        );

        UIManager.put(
                "Component.focusColor",
                TemaFarmacia.TURQUESA_CLARO
        );

        UIManager.put(
                "Component.borderColor",
                TemaFarmacia.BORDE_SUAVE
        );

        UIManager.put(
                "Component.disabledBorderColor",
                new Color(225, 234, 237)
        );

        UIManager.put(
                "Component.error.borderColor",
                TemaFarmacia.ERROR
        );

        UIManager.put(
                "Component.warning.borderColor",
                TemaFarmacia.ADVERTENCIA
        );

        UIManager.put(
                "Separator.foreground",
                TemaFarmacia.BORDE_SUAVE
        );

        UIManager.put(
                "Separator.background",
                TemaFarmacia.FONDO_GENERAL
        );
    }


    private static void configurarBotones() {

        UIManager.put(
                "Button.arc",
                TemaFarmacia.RADIO_MEDIO
        );

        UIManager.put(
                "Button.font",
                TemaFarmacia.FUENTE_BOTON
        );

        UIManager.put(
                "Button.background",
                TemaFarmacia.TURQUESA_PRINCIPAL
        );

        UIManager.put(
                "Button.foreground",
                TemaFarmacia.BLANCO
        );

        UIManager.put(
                "Button.hoverBackground",
                TemaFarmacia.TURQUESA_OSCURO
        );

        UIManager.put(
                "Button.hoverForeground",
                TemaFarmacia.BLANCO
        );

        UIManager.put(
                "Button.pressedBackground",
                new Color(17, 113, 128)
        );

        UIManager.put(
                "Button.pressedForeground",
                TemaFarmacia.BLANCO
        );

        UIManager.put(
                "Button.focusedBackground",
                TemaFarmacia.TURQUESA_PRINCIPAL
        );

        UIManager.put(
                "Button.disabledBackground",
                new Color(222, 232, 235)
        );

        UIManager.put(
                "Button.disabledText",
                TemaFarmacia.TEXTO_SUAVE
        );

        UIManager.put(
                "Button.borderColor",
                TemaFarmacia.TURQUESA_PRINCIPAL
        );

        UIManager.put(
                "Button.default.background",
                TemaFarmacia.TURQUESA_PRINCIPAL
        );

        UIManager.put(
                "Button.default.foreground",
                TemaFarmacia.BLANCO
        );

        UIManager.put(
                "Button.default.hoverBackground",
                TemaFarmacia.TURQUESA_OSCURO
        );
    }


    private static void configurarCamposDeTexto() {

        UIManager.put(
                "TextComponent.arc",
                TemaFarmacia.RADIO_MEDIO
        );

        UIManager.put(
                "TextField.background",
                TemaFarmacia.CAMPO_FONDO
        );

        UIManager.put(
                "TextField.foreground",
                TemaFarmacia.TEXTO_PRINCIPAL
        );

        UIManager.put(
                "TextField.caretForeground",
                TemaFarmacia.TURQUESA_OSCURO
        );

        UIManager.put(
                "TextField.selectionBackground",
                TemaFarmacia.CAMPO_SELECCION
        );

        UIManager.put(
                "TextField.selectionForeground",
                TemaFarmacia.AZUL_TITULO
        );

        UIManager.put(
                "TextField.placeholderForeground",
                TemaFarmacia.TEXTO_SUAVE
        );

        UIManager.put(
                "TextField.inactiveBackground",
                new Color(242, 247, 248)
        );

        UIManager.put(
                "TextField.disabledBackground",
                new Color(238, 244, 246)
        );

        UIManager.put(
                "TextField.disabledForeground",
                TemaFarmacia.TEXTO_SUAVE
        );

        UIManager.put(
                "FormattedTextField.background",
                TemaFarmacia.CAMPO_FONDO
        );

        UIManager.put(
                "FormattedTextField.foreground",
                TemaFarmacia.TEXTO_PRINCIPAL
        );

        UIManager.put(
                "PasswordField.background",
                TemaFarmacia.CAMPO_FONDO
        );

        UIManager.put(
                "PasswordField.foreground",
                TemaFarmacia.TEXTO_PRINCIPAL
        );

        UIManager.put(
                "TextArea.background",
                TemaFarmacia.CAMPO_FONDO
        );

        UIManager.put(
                "TextArea.foreground",
                TemaFarmacia.TEXTO_PRINCIPAL
        );

        UIManager.put(
                "TextArea.selectionBackground",
                TemaFarmacia.CAMPO_SELECCION
        );

        UIManager.put(
                "TextArea.selectionForeground",
                TemaFarmacia.AZUL_TITULO
        );
    }


    private static void configurarComboBox() {

        UIManager.put(
                "ComboBox.arc",
                TemaFarmacia.RADIO_MEDIO
        );

        UIManager.put(
                "ComboBox.background",
                TemaFarmacia.CAMPO_FONDO
        );

        UIManager.put(
                "ComboBox.foreground",
                TemaFarmacia.TEXTO_PRINCIPAL
        );

        UIManager.put(
                "ComboBox.buttonBackground",
                TemaFarmacia.TURQUESA_MUY_CLARO
        );

        UIManager.put(
                "ComboBox.buttonArrowColor",
                TemaFarmacia.TURQUESA_OSCURO
        );

        UIManager.put(
                "ComboBox.buttonHoverArrowColor",
                TemaFarmacia.TURQUESA_PRINCIPAL
        );

        UIManager.put(
                "ComboBox.selectionBackground",
                TemaFarmacia.TURQUESA_CLARO
        );

        UIManager.put(
                "ComboBox.selectionForeground",
                TemaFarmacia.AZUL_TITULO
        );
    }


    private static void configurarPestanas() {

        UIManager.put(
                "TabbedPane.tabHeight",
                48
        );

        UIManager.put(
                "TabbedPane.tabArc",
                TemaFarmacia.RADIO_MEDIO
        );

        UIManager.put(
                "TabbedPane.tabAreaAlignment",
                "leading"
        );

        UIManager.put(
                "TabbedPane.tabType",
                "card"
        );

        UIManager.put(
                "TabbedPane.showTabSeparators",
                false
        );

        UIManager.put(
                "TabbedPane.tabsOpaque",
                false
        );

        UIManager.put(
                "TabbedPane.background",
                TemaFarmacia.FONDO_SECCION
        );

        UIManager.put(
                "TabbedPane.foreground",
                TemaFarmacia.TEXTO_SECUNDARIO
        );

        UIManager.put(
                "TabbedPane.selectedBackground",
                TemaFarmacia.BLANCO
        );

        UIManager.put(
                "TabbedPane.selectedForeground",
                TemaFarmacia.AZUL_TITULO
        );

        UIManager.put(
                "TabbedPane.hoverColor",
                TemaFarmacia.TURQUESA_MUY_CLARO
        );

        UIManager.put(
                "TabbedPane.focusColor",
                TemaFarmacia.TURQUESA_CLARO
        );

        UIManager.put(
                "TabbedPane.contentAreaColor",
                TemaFarmacia.FONDO_GENERAL
        );

        UIManager.put(
                "TabbedPane.underlineColor",
                TemaFarmacia.TURQUESA_PRINCIPAL
        );

        UIManager.put(
                "TabbedPane.inactiveUnderlineColor",
                TemaFarmacia.BORDE_SUAVE
        );

        UIManager.put(
                "TabbedPane.selectedBackground",
                TemaFarmacia.BLANCO
        );

        UIManager.put(
                "TabbedPane.disabledForeground",
                TemaFarmacia.TEXTO_SUAVE
        );
    }


    private static void configurarTablas() {

        UIManager.put(
                "Table.font",
                TemaFarmacia.FUENTE_TABLA
        );

        UIManager.put(
                "Table.background",
                TemaFarmacia.BLANCO
        );

        UIManager.put(
                "Table.foreground",
                TemaFarmacia.TEXTO_PRINCIPAL
        );

        UIManager.put(
                "Table.selectionBackground",
                TemaFarmacia.TABLA_SELECCION
        );

        UIManager.put(
                "Table.selectionForeground",
                TemaFarmacia.AZUL_TITULO
        );

        UIManager.put(
                "Table.gridColor",
                TemaFarmacia.BORDE_SUAVE
        );

        UIManager.put(
                "Table.rowHeight",
                42
        );

        UIManager.put(
                "Table.showHorizontalLines",
                true
        );

        UIManager.put(
                "Table.showVerticalLines",
                false
        );

        UIManager.put(
                "Table.intercellSpacing",
                new java.awt.Dimension(0, 1)
        );

        UIManager.put(
                "TableHeader.font",
                TemaFarmacia.FUENTE_TABLA_ENCABEZADO
        );

        UIManager.put(
                "TableHeader.background",
                TemaFarmacia.TABLA_ENCABEZADO
        );

        UIManager.put(
                "TableHeader.foreground",
                TemaFarmacia.AZUL_TITULO
        );

        UIManager.put(
                "TableHeader.height",
                44
        );

        UIManager.put(
                "TableHeader.separatorColor",
                TemaFarmacia.BORDE_SUAVE
        );

        UIManager.put(
                "TableHeader.bottomSeparatorColor",
                TemaFarmacia.BORDE_TURQUESA
        );
    }

    private static void configurarBarrasDeDesplazamiento() {

        UIManager.put(
                "ScrollPane.background",
                TemaFarmacia.BLANCO
        );

        UIManager.put(
                "ScrollPane.border",
                null
        );

        UIManager.put(
                "ScrollBar.width",
                11
        );

        UIManager.put(
                "ScrollBar.thumbArc",
                999
        );

        UIManager.put(
                "ScrollBar.trackArc",
                999
        );

        UIManager.put(
                "ScrollBar.thumb",
                TemaFarmacia.BORDE_TURQUESA
        );

        UIManager.put(
                "ScrollBar.hoverThumbColor",
                TemaFarmacia.TURQUESA_PRINCIPAL
        );

        UIManager.put(
                "ScrollBar.pressedThumbColor",
                TemaFarmacia.TURQUESA_OSCURO
        );

        UIManager.put(
                "ScrollBar.track",
                TemaFarmacia.FONDO_SECCION
        );

        UIManager.put(
                "ScrollBar.showButtons",
                false
        );
    }


    private static void configurarMenus() {

        UIManager.put(
                "MenuBar.background",
                TemaFarmacia.BLANCO
        );

        UIManager.put(
                "MenuBar.foreground",
                TemaFarmacia.TEXTO_PRINCIPAL
        );

        UIManager.put(
                "MenuBar.borderColor",
                TemaFarmacia.BORDE_SUAVE
        );

        UIManager.put(
                "Menu.font",
                TemaFarmacia.FUENTE_NORMAL
        );

        UIManager.put(
                "Menu.foreground",
                TemaFarmacia.TEXTO_PRINCIPAL
        );

        UIManager.put(
                "Menu.selectionBackground",
                TemaFarmacia.TURQUESA_MUY_CLARO
        );

        UIManager.put(
                "Menu.selectionForeground",
                TemaFarmacia.AZUL_TITULO
        );

        UIManager.put(
                "MenuItem.font",
                TemaFarmacia.FUENTE_NORMAL
        );

        UIManager.put(
                "MenuItem.background",
                TemaFarmacia.BLANCO
        );

        UIManager.put(
                "MenuItem.foreground",
                TemaFarmacia.TEXTO_PRINCIPAL
        );

        UIManager.put(
                "MenuItem.selectionBackground",
                TemaFarmacia.TURQUESA_MUY_CLARO
        );

        UIManager.put(
                "MenuItem.selectionForeground",
                TemaFarmacia.AZUL_TITULO
        );

        UIManager.put(
                "PopupMenu.background",
                TemaFarmacia.BLANCO
        );

        UIManager.put(
                "PopupMenu.borderColor",
                TemaFarmacia.BORDE_SUAVE
        );
    }


    private static void configurarVentanasEmergentes() {

        UIManager.put(
                "OptionPane.background",
                TemaFarmacia.BLANCO
        );

        UIManager.put(
                "OptionPane.messageForeground",
                TemaFarmacia.TEXTO_PRINCIPAL
        );

        UIManager.put(
                "OptionPane.messageFont",
                TemaFarmacia.FUENTE_NORMAL
        );

        UIManager.put(
                "OptionPane.buttonFont",
                TemaFarmacia.FUENTE_BOTON
        );

        UIManager.put(
                "OptionPane.minimumSize",
                new java.awt.Dimension(360, 160)
        );
    }


    private static void configurarTooltips() {

        UIManager.put(
                "ToolTip.background",
                TemaFarmacia.AZUL_TITULO
        );

        UIManager.put(
                "ToolTip.foreground",
                TemaFarmacia.BLANCO
        );

        UIManager.put(
                "ToolTip.font",
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        UIManager.put(
                "ToolTip.border",
                null
        );
    }
}
