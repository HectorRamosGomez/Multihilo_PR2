package procesos_evaluable2;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ExploradorArchivos extends JFrame {
    private JTextArea textArea;
    private JButton btnFinalizar;
    private Thread hiloEscaneo;
    private volatile boolean detenido = false;

    public ExploradorArchivos() {

        //Titulo de la ventana
        setTitle("Escáner de Unidad C:");
        //Tamaño de la ventana
        setSize(600, 400);
        //Cuando cierres el programa se cerrara
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Organizador de componentes
        setLayout(new BorderLayout());

        //Crear la pantalla en blanco para que se pueda escribir
        textArea = new JTextArea();
        //Evita que el usuario pueda escribir en la pantalla
        textArea.setEditable(false);
        //Agrega una barra de desplazamiento a la pantalla
        JScrollPane scrollPane = new JScrollPane(textArea);
        //Agrega la pantalla con la barra de desplazamiento a la ventana
        add(scrollPane, BorderLayout.CENTER);

        //Boton para finalizar el programa
        btnFinalizar = new JButton("Finalizar Programa");
        btnFinalizar.addActionListener(e -> {
            detenido = true;
            System.exit(0);
        });
        //Agrega el boton a la ventana
        add(btnFinalizar, BorderLayout.SOUTH);

        //Hilo para escanear los archivos
        iniciarEscaneo();
    }

}