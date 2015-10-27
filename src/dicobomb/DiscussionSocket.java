package oui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Attente extends Thread {
    private DiscussionSocket discussion;

    Attente(DiscussionSocket discussion) {
        this.discussion = discussion;
        start();
    }

    public void run() {
        String texte;

        try {
            while(true)
            {
                if (discussion.getEntree() == null) return;
                texte = discussion.getEntree().readLine();
                if (texte.equals("*****")) {
                    synchronized(discussion) {
                        discussion.setConnecte(true);
                    }
                    continue;
                }
                if ((texte.equals("fermer"))) {
                    discussion.deconnexion();
                    discussion.getIhm().getConnecter().setEnabled(true);
                    break;
                }
                else discussion.getIhm().getTexteRecu().setText(texte);
            }
        }
        catch (SocketException exc) {}
        catch (Exception exc) {
            exc.printStackTrace();
        }

    }
}

class Recepteur extends Thread {
    ServerSocket receptionniste;
    DiscussionSocket discussion;
    Recepteur(DiscussionSocket discussion) {
        this.discussion = discussion;
        try {
            setDaemon(true);
            receptionniste = new ServerSocket(discussion.getIhm().getPortEcoute());
            start();
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
    }

    public void run() {
        try {
            while(true) {
                discussion.reponseDemandeConnexion(receptionniste.accept());
                discussion.getIhm().getConnecter().setEnabled(false);
                discussion.getIhm().getEnvoyer().setEnabled(true);
            }
        }
        catch(IOException exc){
            exc.printStackTrace();
        }
    }
}

@SuppressWarnings("serial")
class IHMDiscussion extends JPanel implements ActionListener {
    private JButton ecouter = new JButton("Ecouter");
    private JButton connecter = new JButton("Connecter");
    private JButton envoyer = new JButton("Envoyer");
    private JButton nettoyer = new JButton("Nettoyer le texte d'envoi");
    private JButton quitter = new JButton("Quitter");
    private JTextField portEcouteDestinataire = new JTextField(6);
    private JTextField portEcoute = new JTextField(6);
    private JTextField correspondant = new JTextField(14);
    private JTextField texteRecu = new JTextField("");
    private JTextField texteEnvoye = new JTextField("");
    private JLabel commentaire = new JLabel("Attente de connexion");
    private DiscussionSocket discussion;

    IHMDiscussion(DiscussionSocket discussion) {
        this.discussion = discussion;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel panneauEcoute = new JPanel();
        panneauEcoute.add(new JLabel("Port d'ecoute pour la connexion"));
        panneauEcoute.add(portEcoute);
        panneauEcoute.add(ecouter);
        add(panneauEcoute);

        JPanel panneauConnexion = new JPanel();
        panneauConnexion.add(new JLabel("Machine du correspondant"));
        panneauConnexion.add(correspondant);
        panneauConnexion.add(new JLabel("Port d'ecoute du destinataire"));
        panneauConnexion.add(portEcouteDestinataire);
        panneauConnexion.add(connecter);
        add(panneauConnexion);

        JPanel boutons = new JPanel();
        boutons.add(envoyer);
        boutons.add(nettoyer);
        boutons.add(quitter);
        add(boutons);

        add(Box.createVerticalStrut(10));
        add(new JLabel("Texte du message a envoyer : "));
        add(texteEnvoye);
        add(Box.createVerticalStrut(10));
        add(new JLabel("Reception du mesage :"));
        texteRecu.setEditable(false);
        add(texteRecu);
        add(Box.createVerticalStrut(10));

        add(commentaire);

        ecouter.addActionListener(this);
        connecter.addActionListener(this);
        envoyer.addActionListener(this);
        nettoyer.addActionListener(this);
        quitter.addActionListener(this);
        texteEnvoye.addActionListener(this);

        envoyer.setEnabled(false);
    }

    public int getPortEcoute() {
        return Integer.parseInt(portEcoute.getText());
    }


    public int getPortEcouteDestinataire() {
        try {
            return Integer.parseInt(portEcouteDestinataire.getText());
        }
        catch (Exception exc) {}
        return 0;
    }

    public JButton getConnecter() {
        return connecter;
    }

    public JLabel getCommentaire() {
        return commentaire;
    }

    public JTextField getCorrespondant() {
        return correspondant;
    }

    public JTextField getTexteRecu() {
        return texteRecu;
    }

    public JButton getEnvoyer() {
        return envoyer;
    }

    public void actionPerformed(ActionEvent evt)
    {
        try {
            if (evt.getSource() == ecouter) {
                new Recepteur(discussion);
                ecouter.setEnabled(false);
            }
            if (evt.getSource() == connecter) {
                int port = getPortEcouteDestinataire();
                String nomMachine = correspondant.getText();
                discussion.initiativeConnexion(nomMachine, port);
            }
            if ((evt.getSource() == envoyer) || (evt.getSource() == texteEnvoye)) {
                if (!discussion.isConnecte()) {
                    int port = Integer.parseInt(portEcouteDestinataire.getText());
                    String nomMachine = correspondant.getText();
                    discussion.initiativeConnexion(nomMachine, port);
                    new Recepteur(discussion);
                }
                discussion.getSortie().println(texteEnvoye.getText());
            }
            else if (evt.getSource() == nettoyer)
            {
                texteEnvoye.setText("");
            }
            else if (evt.getSource() == quitter)
            {
                discussion.deconnexion();
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}

class DiscussionSocket {
    private Socket socket;
    private BufferedReader entree;
    private PrintStream sortie;
    private boolean connecte;
    private IHMDiscussion ihm = new IHMDiscussion(this);
    private int portEmetteur;

    public IHMDiscussion getIhm() {
        return ihm;
    }

    public PrintStream getSortie() {
        return sortie;
    }

    public int getPortEmetteur() {
        return portEmetteur;
    }

    public void setPortEmetteur(int portEmetteur) {
        this.portEmetteur = portEmetteur;
    }

    DiscussionSocket() {
        JFrame cadre = new JFrame();
        cadre.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                deconnexion();
                System.exit(0);
            }
        });
        cadre.setContentPane(ihm);
        cadre.pack();
        cadre.setLocation(100, 100);
        cadre.setVisible(true);
    }

    public boolean isConnecte() {
        return connecte;
    }

    public void setConnecte(boolean connecte) {
        this.connecte = connecte;
    }

    public BufferedReader getEntree() {
        return entree;
    }

    synchronized void initiativeConnexion(String machine, int port) {
        try {
            if ((machine == null) || machine.equals("")) {
                ihm.getCommentaire().setText("Indiquer un nom de machine");
                return;
            }
            if (port == 0) {
                ihm.getCommentaire().setText("Indiquer un numero de port");
                return;
            }
            socket = new Socket(machine, port);
            connexion();
            ihm.getEnvoyer().setEnabled(true);
            ihm.getConnecter().setEnabled(true);
            ihm.getCommentaire().setText("connexion");
        }
        catch (Exception exc) {
            System.out.println("peut-etre le correspondant n'est pas a l'ecoute");
        }
    }

    synchronized void reponseDemandeConnexion(Socket nouvelleSocket)  {
        try {
            socket = nouvelleSocket;
            ihm.getCorrespondant().setText(socket.getInetAddress().getHostName());
            connexion();
            ihm.getEnvoyer().setEnabled(true);
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    synchronized void connexion() {
        try {
            entree = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            sortie = new PrintStream(socket.getOutputStream());
            sortie.println("*****");
            ihm.getCommentaire().setText("connexion");
            new Attente(this);
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    synchronized void deconnexion() {
        try {
            if (!connecte) return;
            if (sortie != null) {
                sortie.println("fermer");
                sortie.close();
                sortie = null;
            }
            if (entree != null) {
                entree.close();
                entree = null;
            }
            socket.close();
            ihm.getCommentaire().setText("deconnexion");
            ihm.getConnecter().setEnabled(true);
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public static void main(String[] argv) {
        new DiscussionSocket();
    }
}