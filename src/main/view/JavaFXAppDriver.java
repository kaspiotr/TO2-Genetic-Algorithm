package main.view;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.*;
import main.individuals.IIndividual;
import main.individuals.IndividualFactory;
import main.operations.BitStringMutation;
import main.operations.IOperation;
import main.operations.SinglePointCrossover;
import main.utils.GeneticAlgorithmUtilsService;

import java.util.ArrayList;
import java.util.List;

public class JavaFXAppDriver extends Application {

    TextArea textArea = null;
    private ObservableList<String> options = FXCollections.observableArrayList(
            "Integer",
            "Double"
    );
    final ComboBox<String> individualTypeCB = new ComboBox<>(options);
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

    public void testBinary(){
        targetSolutionTF.setText("1,1,1,1,0,0,0,0");
        populationSizeTF.setText("10");
        crossoverRateTF.setText("0.75");
        mutationRateTF.setText("0.2");
        numberOfEliteIndividualsTF.setText("3");
        tournamentSelectionSizeTF.setText("2");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        initializeControls(primaryStage);
        runButton.setOnAction(e -> {
            testBinary();
            IIndividual individual = IndividualFactory.createIndividual(individualTypeCB.getSelectionModel().getSelectedItem(), targetSolutionTF.getText());
            population = new Population(individual, new Integer(populationSizeTF.getText()), individualTypeCB.getSelectionModel().getSelectedItem());
            geneticAlgorithm = new GeneticAlgorithm(individual,
                    new Double(crossoverRateTF.getText()),
                    new Double(mutationRateTF.getText()),
                    new Integer(numberOfEliteIndividualsTF.getText()),
                    new Integer(tournamentSelectionSizeTF.getText()),
                    population);
            Platform.runLater(() -> {
                textArea.clear();
                textArea.appendText("----------------------------------------------------------------------------------------------------\n");
                textArea.appendText("Generation # 0 " + " | Fittest individual fitness: " + population.getIndividuals().get(0).getFitness() + "\n");
                printPopulation(population, "Target Individual: " + population.getTargetIndividual().getGenes() + "\n");
                int generationNumber = 0;
                IOperation crossover = new SinglePointCrossover(population, geneticAlgorithm.getNumbOfEliteIndividuals(), geneticAlgorithm.getCrossoverRate(), individualTypeCB.getSelectionModel().getSelectedItem(), geneticAlgorithm.getTournamentSelectionSize());
                IOperation mutation = new BitStringMutation(population, geneticAlgorithm.getNumbOfEliteIndividuals(), geneticAlgorithm.getMutationRate(), individualTypeCB.getSelectionModel().getSelectedItem());
                List<IOperation> operationsOnPopulation = new ArrayList<>();
                operationsOnPopulation.add(crossover);
                operationsOnPopulation.add(mutation);
                while (population.getIndividuals().get(0).getFitness() < population.getTargetIndividual().getGenes().size()) {
                    generationNumber++;
                    textArea.appendText("----------------------------------------------------------------------------------------------------\n");
                    population = geneticAlgorithm.createGeneration(population, operationsOnPopulation);
                    population.sortIndividualByChromosomeFitness();
                    textArea.appendText("Generation # " + generationNumber + " | Fittest individual fitness: " + population.getIndividuals().get(0).getFitness() + "\n");
                    printPopulation(population, "Target Individual: "  + population.getTargetIndividual().getGenes());
                }
                textArea.appendText("Algorithm has finished");
            });
        });
        primaryStage.show();
    }

    private void initializeControls(Stage primaryStage) {
        primaryStage.setTitle("Generic Algorithm Implementation");
        textArea = new TextArea();
        textArea.setMinSize(500, 500);
        individualTypeCB.getSelectionModel().selectFirst();
        individualTypeCB.setPromptText("individual type...");
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
        hBox.getChildren().addAll(individualTypeCB, targetSolutionTF, populationSizeTF, crossoverRateTF, mutationRateTF,
                numberOfEliteIndividualsTF, tournamentSelectionSizeTF, runButton);
        textArea.setEditable(false);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(textArea, hBox);
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(vBox);
        primaryStage.setScene(new Scene(stackPane, 1300, 530));
    }

    private void printPopulation(Population population, String heading) {
        textArea.appendText(heading + "\n");
        textArea.appendText("----------------------------------------------------------------------------------------------------\n");
        for (int i = 0; i < population.getPopulationSize(); i++) {
            textArea.appendText("Individual # " + i + " : " + population.getIndividuals().get(i).getGenes() + " | Fitness: " + population.getIndividuals().get(i).getFitness() + "\n");
        }
    }

}
