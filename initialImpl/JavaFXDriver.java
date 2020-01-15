package initialImpl;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;

import java.util.Arrays;

public class JavaFXDriver extends Application {

    TextArea textArea = null;
    TextField chromosomeTypeTF = null;
    TextField targetSolutionTF = null;
    TextField populationSizeTF = null;
    TextField mutationRateTF = null;
    TextField crossoverRateTF = null;
    TextField numberOfEliteChromosomesTF = null;
    TextField tournamentSelectionSizeTF = null;
    Button sendButton = null;
    Population population;
    GeneticAlgorithm geneticAlgorithm;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        initializeControls(primaryStage);
        sendButton.setOnAction(e -> {
            geneticAlgorithm = new GeneticAlgorithm(getGenesArray(targetSolutionTF.getText()),
                    new Double(crossoverRateTF.getText()),
                    new Double(mutationRateTF.getText()),
                    new Integer(numberOfEliteChromosomesTF.getText()),
                    new Integer(tournamentSelectionSizeTF.getText()));
            Platform.runLater(() -> {
                textArea.clear();
                population = new Population(new Integer(populationSizeTF.getText()), geneticAlgorithm).initializePopulation();
                textArea.appendText("---------------------------------------------\n");
                textArea.appendText("Generation # 0 " + " | Fittest chromosome fitness: " + population.getChromosomes()[0].getFitness() + "\n");
                printPopulation(population, "Target Chromosome: " + Arrays.toString(geneticAlgorithm.getTargetChromosomeGenes()));
                int generationNumber = 0;
                while (population.getChromosomes()[0].getFitness() < geneticAlgorithm.getTargetChromosomeGenes().length) {
                    generationNumber++;
                    textArea.appendText("------------------------------------------\n");
                    population = geneticAlgorithm.evolve(population);
                    population.sortChromosomesByFitness();
                    textArea.appendText("Generation # " + generationNumber + " | Fittest chromosome fitness: " + population.getChromosomes()[0].getFitness() + "\n");
                    printPopulation(population, "Target Chromosome: " + Arrays.toString(geneticAlgorithm.getTargetChromosomeGenes()));
                }
            });
        });
        primaryStage.show();
    }

    private void initializeControls(Stage primaryStage) {
        primaryStage.setTitle("Generic Algorithm Initial Implementation");
        textArea = new TextArea();
        textArea.setMinSize(500, 500);
        chromosomeTypeTF = new TextField();
        chromosomeTypeTF.setPromptText("chromosome type...");
        targetSolutionTF = new TextField();
        targetSolutionTF.setPromptText("target solution...");
        populationSizeTF = new TextField();
        populationSizeTF.setPromptText("population size...");
        crossoverRateTF = new TextField();
        crossoverRateTF.setPromptText("crossover rate...");
        mutationRateTF = new TextField();
        mutationRateTF.setPromptText("mutation rate...");
        numberOfEliteChromosomesTF = new TextField();
        numberOfEliteChromosomesTF.setPromptText("# of elite chromosomes...");
        tournamentSelectionSizeTF = new TextField();
        tournamentSelectionSizeTF.setPromptText("tournament size...");
        sendButton = new Button("Run");
        HBox hBox = new HBox();
        hBox.getChildren().addAll(chromosomeTypeTF, targetSolutionTF, populationSizeTF, crossoverRateTF, mutationRateTF,
                numberOfEliteChromosomesTF, tournamentSelectionSizeTF, sendButton);
        textArea.setEditable(false);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(textArea, hBox);
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(vBox);
        primaryStage.setScene(new Scene(stackPane, 1300, 530));
    }

    public void printPopulation(Population population, String heading) {
        textArea.appendText(heading + "\n");
        textArea.appendText("------------------------------------------------------\n");
        for (int x = 0; x < population.getChromosomes().length; x++) {
            textArea.appendText("Chromosome # " + x + "   :   " + Arrays.toString(population.getChromosomes()[x].getGenes()) + " | Fitness: " + population.getChromosomes()[x].getFitness() + "\n");
        }
    }

    public int[] getGenesArray(String genesString) {
        return Arrays.stream(genesString.split(",")).map(x->x.trim()).mapToInt(x -> Integer.parseInt(x)).toArray();
    }
}
