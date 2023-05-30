package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import java.io.IOException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Tab;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Image logo = new Image("file:C:\\Users\\Мадина\\IdeaProjects\\demo1\\src\\logo-removebg-preview.png");
        ImageView logoView = new ImageView(logo);
        logoView.setFitHeight(100);
        logoView.setPreserveRatio(true);


        logoView.setOnMouseClicked(event -> {
            // create a new stage for author information
            Stage authorStage = new Stage();
            authorStage.setTitle("Об авторе");

            // create and format text for author information
            Text text1 = new Text("Данное фитнес приложение подбирает для вас план тренировок на месяц \nв зависимости от вашей цели: набор веса, потеря веса или поддержание веса. \nПеред тем как подбирать план тренировок, рекомендуется рассчитать индекс\n массы тела (ИМТ) для того, чтобы определиться с конечной целью тренировок\n и получить некоторые рекомендации по питанию и тренировкам.");
            Text text2 = new Text("Об авторе");
            text1.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
            text2.setFont(Font.font("Arial", FontWeight.BOLD, 20));
            VBox textLayout = new VBox(10, text1, text2);
            textLayout.setAlignment(Pos.CENTER);

            // create and format image for author information
            Image authorImage = new Image("file:C:\\Users\\Мадина\\IdeaProjects\\demo1\\src\\main\\resources\\author_photo.jpg");
            ImageView authorImageView = new ImageView(authorImage);
            authorImageView.setFitHeight(150);
            authorImageView.setPreserveRatio(true);
            
            HBox imageLayout = new HBox(authorImageView);
            imageLayout.setAlignment(Pos.CENTER);

            // create and format name label for author information
            Label nameLabel = new Label("\nМадина Турганбаева\nКазНУ им.Аль-Фараби\n3 курс\nИнформационные системы");
            nameLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 14));

            // create and format layout for author information
            VBox layout = new VBox(20, textLayout, imageLayout, nameLabel);
            layout.setAlignment(Pos.CENTER);
            Scene authorScene = new Scene(layout, 500, 400);
            authorStage.setScene(authorScene);

            // show the author information stage
            authorStage.show();
        });


        Label nameLabel = new Label("Имя:");
        TextField nameField = new TextField();
        Label ageLabel = new Label("Возраст:");
        TextField ageField = new TextField();
        Label weightLabel = new Label("Вес (кг):");
        TextField weightField = new TextField();
        Label heightLabel = new Label("Рост (cм):");
        TextField heightField = new TextField();
        Label goalLabel = new Label("Цель:");
        ChoiceBox<String> goalBox = new ChoiceBox<>();
        goalBox.getItems().addAll("Набор веса", "Потеря веса", "Сохранение веса и накачка мышц");

        Button submitButton = new Button("Подобрать тренировку");
        submitButton.setOnAction(event -> {
            String name = nameField.getText();
            String ageStr = ageField.getText();
            String weightStr = weightField.getText();
            String heightStr = heightField.getText();
            String goal = goalBox.getValue();


            if (goal == null || goal.isEmpty()) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Предупреждение");
                alert.setHeaderText(null);
                alert.setContentText("Пожалуйста, выберите цель");
                alert.showAndWait();
            }

            if (name.isEmpty() || ageStr.isEmpty() || weightStr.isEmpty() || heightStr.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Предупреждение");
                alert.setHeaderText("Пожалуйста, заполните все поля!");
                alert.showAndWait();
                return;
            }
            try {
                int age = Integer.parseInt(ageStr);
                double weight = Double.parseDouble(weightStr);
                double height = Double.parseDouble(heightStr);
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Предупреждение");
                alert.setHeaderText("Пожалуйста, введите корректные данные!");
                alert.showAndWait();
                return;
            }

            switch (goal) {
                case "Набор веса":
                    WeightGainWorkoutCalendar.show();
                    break;
                case "Потеря веса":
                    WeightLossWorkoutCalendar.show();
                    break;
                case "Сохранение веса и накачка мышц":
                    WeightSaveWorkoutCalendar.show();
                    break;
            }

        });

        Button nutritionButton = new Button("Рассчитать ИМТ");

        nutritionButton.setOnAction(event -> {
            String name = nameField.getText();
            String ageStr = ageField.getText();
            String weightStr = weightField.getText();
            String heightStr = heightField.getText();
            String goal = goalBox.getValue();

            if (name.isEmpty() || ageStr.isEmpty() || weightStr.isEmpty() || heightStr.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Предупреждение");
                alert.setHeaderText("Пожалуйста, заполните все поля!");
                alert.showAndWait();
                return;
            }
            try {
                int age = Integer.parseInt(ageStr);
                double weight = Double.parseDouble(weightStr);
                double height = Double.parseDouble(heightStr);
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Предупреждение");
                alert.setHeaderText("Пожалуйста, введите корректные данные!");
                alert.showAndWait();
                return;
            }

            double weight = Double.parseDouble(weightStr);
            double height = Double.parseDouble(heightStr) / 100.0;
            double bmi = weight / (height * height);
            String bmiStr = String.format("%.1f", bmi);

            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
            alert2.setTitle("Индекс массы тела (ИМТ)");
            alert2.setHeaderText("Здравствуйте, " + name + "!"+ "\nВаш Индекс массы тела равен " + bmiStr);


            if (bmi < 18.5) {
                alert2.setContentText("У вас дефицит массы тела\n\nРекомендации:\n1. Рекомендуется сдать анализы на гормоны, пройти обследование органов ЖКТ.\n2. Избегать стрессов.\n3. Питаться сбалансированно и регулярно.\n4. Постепенно увеличить калораж рациона. \n5. Принимать витамины по назначению врача. Для стимуляции аппетита и лучшего роста мышечной массы применять пищевые добавки с левокарнитином.\n7. Рекомендуется выбрать план тренировок для набора массы тела.");
            } else if (bmi >= 18.5 && bmi < 25){
                alert2.setContentText("У вас нормальная масса тела.\n\nРекомендации:\n1. Поддерживайте свой калораж рациона.\n2. Принимайте необходимые витамины по назначению врача.\n3. Пейте достаточно воды.\n4. Рекомендуется заниматься по плану тренировок для сохранения массы тела и тонуса мышц.\n5. Питайтесь сбалансированно и регулярно, но не злоупотребляйте вредной едой.");

            } else if (bmi >= 25 && bmi < 30) {
                alert2.setContentText("У вас избыток массы тела.\n\nРекомендации:\n1. Создайте дефицит калорий.\n2. Необходимо сдать анализы и проконсультироваться у врача.\n3.Принимайте необходимые витамины по назначению врача.\n4.Пейте достаточно воды.\n5.Рекомендуется заниматься по плану тренировок для потери веса.\n6.Питайтесь сбалансированно и регулярно");
            } else if (bmi>=30)    {

                alert2.setContentText("У вас ожирение.\nРекомендации:\n1. Обратитесь за помощью для подбора меню к диетологу.\n2. Необходимо сдать анализы и проконсультироваться у врача.\n3.Принимайте необходимые витамины по назначению врача.\n4.Пейте достаточно воды.\n5.Рекомендуется заниматься по плану тренировок для потери веса.\n6.Питайтесь сбалансированно и регулярно");
            }
            alert2.showAndWait();
        });

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        gridPane.add(logoView, 1, 0 );

        gridPane.add(nameLabel, 0, 2);
        gridPane.add(nameField, 1, 2);
        gridPane.add(ageLabel, 0, 3);
        gridPane.add(ageField, 1, 3);
        gridPane.add(weightLabel, 0, 4);
        gridPane.add(weightField, 1, 4);
        gridPane.add(heightLabel, 0, 5);
        gridPane.add(heightField, 1, 5);
        gridPane.add(goalLabel, 0, 6);
        gridPane.add(goalBox, 1, 6);
        gridPane.add(submitButton, 1, 8);
        gridPane.add(nutritionButton, 1, 7);


        Scene scene = new Scene(gridPane, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setTitle("FitnessApp");

        String css = "-fx-background-color: white;";
        primaryStage.getScene().getRoot().setStyle(css);
        submitButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 8pt;");
        nutritionButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 8pt;");

    }

    public static void main(String[] args) {
        launch(args);
    }
}

