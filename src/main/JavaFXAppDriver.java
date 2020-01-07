package main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXAppDriver extends Application {

    TextArea textArea = null;
    TextField individualTypeTF = null;
    TextField targetSolutionTF = null;
    TextField populationSizeTF = null;
    TextField mutationRateTF = null;
    TextField crossoverRateTF = null;
    TextField numberOfEliteIndividualsTF = null;
    TextField tournamentSelectionSizeTF = null;
    Button runButton = null;
    Population population;
    GeneticAlgorithm geneticAlgorithm;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        initializeControls(primaryStage);
        runButton.setOnAction(e -> {
            IIndividual individual = IndividualFactory.createIndividual(individualTypeTF.getText(), targetSolutionTF.getText());
            population = new Population(individual, new Integer(populationSizeTF.getText())).initializePopulation(individualTypeTF.getText());
            geneticAlgorithm = new GeneticAlgorithm(individual,
                    new Double(crossoverRateTF.getText()),
                    new Double(mutationRateTF.getText()),
                    new Integer(numberOfEliteIndividualsTF.getText()),
                    new Integer(tournamentSelectionSizeTF.getText()),
                    population);
            Platform.runLater(() -> {
                textArea.clear();
                textArea.appendText("--------------------------------------------------\n");
                textArea.appendText("Generation # 0 " + " | Fittest individual fitness: " + "TODO OBLICZYC" + "\n");
            });
        });
        primaryStage.show();
    }

    private void initializeControls(Stage primaryStage) {
        primaryStage.setTitle("Generic Algorithm Implementation");
        textArea = new TextArea();
        textArea.setMinSize(500, 500);
        individualTypeTF = new TextField();
        individualTypeTF.setPromptText("individual type...");
        targetSolutionTF = new TextField();
        targetSolutionTF.setPromptText("target solution...");
        populationSizeTF = new TextField();
        populationSizeTF.setPromptText("population size...");
        crossoverRateTF = new TextField();
        crossoverRateTF.setPromptText("crossover rate...");
        mutationRateTF = new TextField();
        mutationRateTF.setPromptText("mutation rate...");
        numberOfEliteIndividualsTF = new TextField();
        numberOfEliteIndividualsTF.setPromptText("# of elite individuals...");
        tournamentSelectionSizeTF = new TextField();
        tournamentSelectionSizeTF.setPromptText("selection size...");
        runButton = new Button("Run");
        HBox hBox = new HBox();
        hBox.getChildren().addAll(individualTypeTF, targetSolutionTF, populationSizeTF, crossoverRateTF, mutationRateTF,
                numberOfEliteIndividualsTF, tournamentSelectionSizeTF, runButton);
        textArea.setEditable(false);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(textArea, hBox);
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(vBox);
        primaryStage.setScene(new Scene(stackPane, 1300, 530));
    }
}
