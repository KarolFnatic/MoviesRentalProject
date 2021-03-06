package pl.KarolGrabowski;


import pl.KarolGrabowski.Exceptions.MovieAlreadyExistsException;
import pl.KarolGrabowski.Exceptions.NullCustomerException;
import pl.KarolGrabowski.Exceptions.NullMovieException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Date;

public class AddMovieWindow extends JFrame {
    private MovieRental movieRental;
    private MovieRentalWindow movieRentalWindow;
    private Movie movieToEdit;

    public AddMovieWindow(MovieRental movieRental, MovieRentalWindow movieRentalWindow, Movie movieToEdit) throws HeadlessException {
        this.movieRental = movieRental;
        this.movieRentalWindow = movieRentalWindow;
        this.movieToEdit = movieToEdit;

        setSize(600, 400);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setTitle("Dodaj/edytuj film");

        JLabel lblMovieID = new JLabel("ID filmu");
        add(lblMovieID);

        JTextField txtMovieID = new JTextField();
        txtMovieID.setPreferredSize(new Dimension(200, 50));
        add(txtMovieID);

        JLabel lblMovieTitle = new JLabel("Tytuł");
        add(lblMovieTitle);

        JTextField txtMovieTitle = new JTextField();
        txtMovieTitle.setPreferredSize(new Dimension(200, 50));
        add(txtMovieTitle);

        JLabel lblMovieGenre = new JLabel("Gatunek");
        add(lblMovieGenre);

        JTextField txtMovieGenre = new JTextField();
        txtMovieGenre.setPreferredSize(new Dimension(200, 50));
        add(txtMovieGenre);

        JLabel lblMovieDescription = new JLabel("Opis");
        add(lblMovieDescription);

        JTextField txtMovieDescription = new JTextField();
        txtMovieDescription.setPreferredSize(new Dimension(200, 50));
        add(txtMovieDescription);

        JButton button = new JButton("Dodaj/Edytuj Film");
        add(button);

        if (movieToEdit != null) {
            txtMovieID.setText(String.valueOf(movieToEdit.getId()));
            txtMovieTitle.setText(movieToEdit.getTitle());
            txtMovieGenre.setText(movieToEdit.getGenre());
            txtMovieDescription.setText(movieToEdit.getDescription());
        }

        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String movieID = txtMovieID.getText();
                String movieTitle = txtMovieTitle.getText();
                String movieGenre = txtMovieGenre.getText();
                String movieDescription = txtMovieDescription.getText();

                if (movieToEdit == null){
                    Movie movie = new Movie(movieTitle, movieGenre, movieDescription);

                    try {
                        movieRental.addMovie(movie);
                        movieRentalWindow.showMovies();

                        JOptionPane.showMessageDialog(button, "Udało się dodać film!");
                    } catch (NullMovieException e1) {
                        e1.printStackTrace();
                    } catch (MovieAlreadyExistsException e1) {
                        e1.printStackTrace();
                    }
                }else{
                    movieToEdit.setTitle(movieTitle);
                    movieToEdit.setGenre(movieGenre);
                    movieToEdit.setDescription(movieDescription);
                    JOptionPane.showMessageDialog(button,"Udało się edytowac film!");
                }


                // Zamknięcie okna
                setVisible(false);
                dispose();

                movieRental.printAllData();
            }
        });
    }

}

