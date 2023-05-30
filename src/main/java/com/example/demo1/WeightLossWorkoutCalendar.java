package com.example.demo1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class WeightLossWorkoutCalendar {
    private static final String[] WORKOUTS = {"Разминка", "Кардио", "Силовая", "Растяжка", "Силовая", "Кардио", "Отдых"};
    private static final int CALENDAR_WIDTH = 1000;
    private static final int CALENDAR_HEIGHT = 700;


    public static void show() {

        GridPane calendarPane = new GridPane();
        calendarPane.setHgap(10);
        calendarPane.setVgap(10);
        calendarPane.setAlignment(Pos.CENTER);

        // Create title label
        Label titleLabel = new Label("Программа тренировок для потери массы тела подобрана!\n");
        titleLabel.setFont(Font.font("Arial", 24));
        StackPane titlePane = new StackPane(titleLabel);
        titlePane.setAlignment(Pos.CENTER);

        // Create instruction label
        Label instructionLabel = new Label("\nИнструкция:\n1. Необходимо проконсультироваться с врачом перед занятиями.\n2. Программа тренировок рассчитана для начинающих.\n3. С каждой неделей растет интенсивность тренировок.\n4. Рекомендуется заниматься через 2 часа после приема пищи.\n5. Для достижения лучшего результата желательно подключить правильное питание вместе с тренировками.\n ");
        instructionLabel.setFont(Font.font("Arial", 16));
        StackPane instructionPane = new StackPane(instructionLabel);
        instructionPane.setAlignment(Pos.CENTER);



        // Create calendar cells
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col <7; col++) {
                // Calculate day number
                int day = col + 1 + row * 7;

                // Create day label
                String dayNumber = "День " + day;
                Label dayLabel = new Label(dayNumber + "\n" + WORKOUTS[(day - 1) % 7]);
                dayLabel.setAlignment(Pos.CENTER);
                dayLabel.setMinWidth(100);
                dayLabel.setMinHeight(80);
                dayLabel.setStyle("-fx-background-color: #ffffff; -fx-border-color: #cccccc; -fx-border-width: 2px;");
                StackPane dayPane = new StackPane(dayLabel);
                dayPane.setAlignment(Pos.CENTER);
                dayPane.setOnMouseClicked(event -> {
                    String workout = WORKOUTS[(day - 1) % 7];
                    if (workout.equals("Отдых")) {
                        Stage popupStage = new Stage();
                        popupStage.setTitle("Рекомендации на день отдыха");
                        Label popupLabel1 = new Label("Рекомендации на этот день:\n1. Рекомендуется прогуляться на свежем воздухе.\n2. Хоть и день отдыха предполагает cheat meal, \nвсе равно желательно не переедать. \n3. Соблюдайте водный баланс.");

                        popupLabel1.setFont(Font.font("Arial", 16));
                        StackPane popupPane = new StackPane();
                        popupPane.getChildren().addAll(popupLabel1);
                        popupPane.setAlignment(Pos.TOP_CENTER);
                        Scene popupScene = new Scene(popupPane, 400, 200);
                        popupStage.setScene(popupScene);
                        popupStage.show();
                    } else if (WORKOUTS[(day - 1) % 7].equals("Силовая")) {

                        Label title = new Label("Тренировка, укрепляющая мышцы,состоящая из 10 упражнений. \n ");
                        title.setFont(Font.font("Arial", FontWeight.BOLD, 16));
                        title.setAlignment(Pos.CENTER);

                        Label recommendLabel = new Label("Рекомендации: \n1. Перед данной тренировкой желательно разогреть мышцы упражнениями из блока разминки.\n" +
                                "2.За 2 часа до силовой тренировки необходимо дать организму углеводы и белки. \n" +
                                "3.Слушайте свое тело!\n" +
                                "4.Занимайтесь в кроссовках.\n" +
                                "5.Если какое-то упражнение доставляет вам\n сильный дискомфорт, то лучше остановить выполнение данного упражнения.\n" +
                                "6.Каждое упражнение выполнять 30-45 секунд \n");
                        recommendLabel.setFont(Font.font("Arial", 14));
                        recommendLabel.setAlignment(Pos.CENTER);
                        // Display cardio workout
                        Stage popupStage = new Stage();
                        popupStage.setTitle("Силовая тренировка");
                        GridPane popupPane = new GridPane();
                        popupPane.setHgap(10);
                        popupPane.setVgap(10);
                        popupPane.setAlignment(Pos.CENTER);

                        popupPane.add(title, 0, 0, 3, 1);
                        popupPane.add(recommendLabel, 0, 1, 3, 1);


                        // Create GIF views
                        String[] gifNames = {"C:\\Users\\Мадина\\IdeaProjects\\demo1\\src\\main\\resources\\Strength\\1.gif",
                                "C:\\Users\\Мадина\\IdeaProjects\\demo1\\src\\main\\resources\\Strength\\2.gif",
                                "C:\\Users\\Мадина\\IdeaProjects\\demo1\\src\\main\\resources\\Strength\\3.gif",
                                "C:\\Users\\Мадина\\IdeaProjects\\demo1\\src\\main\\resources\\Strength\\4.gif",
                                "C:\\Users\\Мадина\\IdeaProjects\\demo1\\src\\main\\resources\\Strength\\5.gif",
                                "C:\\Users\\Мадина\\IdeaProjects\\demo1\\src\\main\\resources\\Strength\\6.gif",
                                "C:\\Users\\Мадина\\IdeaProjects\\demo1\\src\\main\\resources\\Strength\\7.gif",
                                "C:\\Users\\Мадина\\IdeaProjects\\demo1\\src\\main\\resources\\Strength\\8.gif",
                                "C:\\Users\\Мадина\\IdeaProjects\\demo1\\src\\main\\resources\\Strength\\9.gif",
                                "C:\\Users\\Мадина\\IdeaProjects\\demo1\\src\\main\\resources\\Strength\\10.gif"};
                        String[] descriptions = {
                                "Приседание со скрестным\n махом ногой",
                                "Подпрыжки ладони \nк колену",
                                "Подъемы с колен в\n присед",
                                "Лодочка на животе \nс работой рук",
                                "Мах ногой в сторону и\n боковой выпад",
                                "Перекрест и вынос рук\n вперед в планке",
                                "Выпад назад с выносом\n бедра",
                                "Обратные отжимания \nс подъемом рук",
                                "Вертикальные и горизонтальные\n ножницы",
                                "Развороты корпуса в\n боковую планку"

                        };

                        for (int i = 0; i < 10; i++) {
                            // Load GIF file
                            ImageView gifView = new ImageView(new Image(gifNames[i]));
                            gifView.setFitWidth(200);
                            gifView.setFitHeight(200);

                            // Create name and description labels
                            Label nameLabel = new Label("Упражнение " + (i+1));
                            nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
                            nameLabel.setAlignment(Pos.CENTER);

                            Label descLabel = new Label(descriptions[i]);
                            descLabel.setFont(Font.font("Arial", 12));
                            descLabel.setAlignment(Pos.CENTER);

                            // Add views to grid pane
                            GridPane gifPane = new GridPane();
                            gifPane.setHgap(10);
                            gifPane.setAlignment(Pos.CENTER);
                            gifPane.add(gifView, 0, 0);
                            gifPane.add(nameLabel, 0, 1);
                            gifPane.add(descLabel, 0, 2);

                            // Add grid pane to popup pane
                            popupPane.add(gifPane, i % 5, i / 5+2);
                        }

                        // Show popup
                        Scene popupScene = new Scene(popupPane, 1100, 750);
                        popupStage.setScene(popupScene);
                        popupStage.show();



                    } else if (WORKOUTS[(day - 1) % 7].equals("Разминка")) {

                        Label title = new Label("Готовый комплекс упражнений на разминку, состоящий из 10 упражнений, \nкоторый поможет хорошо разогреться перед любой тренировкой. \nКаждое упражнение рекомендуется выполнять на протяжении 30-45 секунд.");
                        title.setFont(Font.font("Arial", FontWeight.BOLD, 16));
                        title.setAlignment(Pos.CENTER);


                        // Display cardio workout
                        Stage popupStage = new Stage();
                        popupStage.setTitle("Разминка");
                        GridPane popupPane = new GridPane();
                        popupPane.setHgap(10);
                        popupPane.setVgap(10);
                        popupPane.setAlignment(Pos.CENTER);

                        popupPane.add(title, 0, 0, 3, 1);



                        // Create GIF views
                        String[] gifNames = {"C:\\Users\\Мадина\\IdeaProjects\\demo1\\src\\main\\resources\\stretching\\1.gif",
                                "C:\\Users\\Мадина\\IdeaProjects\\demo1\\src\\main\\resources\\stretching\\2.gif",
                                "C:\\Users\\Мадина\\IdeaProjects\\demo1\\src\\main\\resources\\stretching\\3.gif",
                                "C:\\Users\\Мадина\\IdeaProjects\\demo1\\src\\main\\resources\\stretching\\4.gif",
                                "C:\\Users\\Мадина\\IdeaProjects\\demo1\\src\\main\\resources\\stretching\\5.gif",
                                "C:\\Users\\Мадина\\IdeaProjects\\demo1\\src\\main\\resources\\stretching\\6.gif",
                                "C:\\Users\\Мадина\\IdeaProjects\\demo1\\src\\main\\resources\\stretching\\7.gif",
                                "C:\\Users\\Мадина\\IdeaProjects\\demo1\\src\\main\\resources\\stretching\\8.gif",
                                "C:\\Users\\Мадина\\IdeaProjects\\demo1\\src\\main\\resources\\stretching\\9.gif",
                                "C:\\Users\\Мадина\\IdeaProjects\\demo1\\src\\main\\resources\\stretching\\10.gif"};
                        String[] descriptions = {
                                "Повороты головы",
                                "Вращение запястий",
                                "Вращение локтей",
                                "Вращение плечами",
                                "Вращение руками",
                                "Наклоны корпуса",
                                "Вращение тазом",
                                "Вращение бедрами",
                                "Вращение коленями",
                                "Вращение стопами"

                        };

                        for (int i = 0; i < 10; i++) {
                            // Load GIF file
                            ImageView gifView = new ImageView(new Image(gifNames[i]));
                            gifView.setFitWidth(200);
                            gifView.setFitHeight(200);

                            // Create name and description labels
                            Label nameLabel = new Label("Упражнение " + (i+1));
                            nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
                            nameLabel.setAlignment(Pos.CENTER);

                            Label descLabel = new Label(descriptions[i]);
                            descLabel.setFont(Font.font("Arial", 12));
                            descLabel.setAlignment(Pos.CENTER);

                            // Add views to grid pane
                            GridPane gifPane = new GridPane();
                            gifPane.setHgap(10);
                            gifPane.setAlignment(Pos.CENTER);
                            gifPane.add(gifView, 0, 0);
                            gifPane.add(nameLabel, 0, 1);
                            gifPane.add(descLabel, 0, 2);

                            // Add grid pane to popup pane
                            popupPane.add(gifPane, i % 5, i / 5+2);
                        }

                        // Show popup
                        Scene popupScene = new Scene(popupPane, 1100, 600);
                        popupStage.setScene(popupScene);
                        popupStage.show();


                    }
                    else if (WORKOUTS[(day - 1) % 7].equals("Растяжка")) {

                        Label title = new Label("Готовый комплекс упражнений на растяжку, состоящий из 10 упражнений, \nкоторый нужно выполнять 1-2 раза в неделю, \nесли вы хотите сохранить свое тело здоровым и мобильным.");
                        title.setFont(Font.font("Arial", FontWeight.BOLD, 16));
                        title.setAlignment(Pos.CENTER);

                        Label recommendLabel = new Label("Рекомендации: \n1. Все предложенные упражнения на растяжку – динамические.\n" +
                                "2.Не забывайте выполнять упражнения на растяжку как на правую, так и на левую сторону.\n" +
                                "3.Вы всегда можете углубить положение или, наоборот, немного упростить \nупражнение на растяжку, выбирая более комфортную позу. Слушайте свое тело!\n" +
                                "4. Желательно заниматься в кроссовках.\n" +
                                "5.Если какое-то упражнение на растяжку доставляет вам\n сильный дискомфорт, то лучше остановить выполнение данного упражнения.\n" +
                                "6. Выполняйте каждое упражнение на протяжении 30-45 секунд на каждую сторону" );
                        recommendLabel.setFont(Font.font("Arial", 14));
                        recommendLabel.setAlignment(Pos.CENTER);
                        // Display cardio workout
                        Stage popupStage = new Stage();
                        popupStage.setTitle("Растяжка");
                        GridPane popupPane = new GridPane();
                        popupPane.setHgap(10);
                        popupPane.setVgap(10);
                        popupPane.setAlignment(Pos.CENTER);

                        popupPane.add(title, 0, 0, 3, 1);
                        popupPane.add(recommendLabel, 0, 1, 3, 1);


                        // Create GIF views
                        String[] gifNames = {"C:\\Users\\Мадина\\IdeaProjects\\demo1\\src\\main\\resources\\stretching\\10(2).gif",
                                "C:\\Users\\Мадина\\IdeaProjects\\demo1\\src\\main\\resources\\stretching\\11.gif",
                                "C:\\Users\\Мадина\\IdeaProjects\\demo1\\src\\main\\resources\\stretching\\12.gif",
                                "C:\\Users\\Мадина\\IdeaProjects\\demo1\\src\\main\\resources\\stretching\\13.gif",
                                "C:\\Users\\Мадина\\IdeaProjects\\demo1\\src\\main\\resources\\stretching\\14.gif",
                                "C:\\Users\\Мадина\\IdeaProjects\\demo1\\src\\main\\resources\\stretching\\15.gif",
                                "C:\\Users\\Мадина\\IdeaProjects\\demo1\\src\\main\\resources\\stretching\\16.gif",
                                "C:\\Users\\Мадина\\IdeaProjects\\demo1\\src\\main\\resources\\stretching\\17.gif",
                                "C:\\Users\\Мадина\\IdeaProjects\\demo1\\src\\main\\resources\\stretching\\18.gif",
                                "C:\\Users\\Мадина\\IdeaProjects\\demo1\\src\\main\\resources\\stretching\\19.gif"};
                        String[] descriptions = {
                                "Разведение рук для плеч, \nспины и груди",
                                "Разведение локтей для \nдельт и плечевых суставов",
                                "Сгибание рук для бицепсов\n и трицепса",
                                "Повороты для пресса и \nкосых мышц",
                                "Наклоны в сторону для \nпресса и косых мышц",
                                "Выгибания для спины и \nпозвоночника",
                                "Наклон в приседе для \nспины и плеч",
                                "Наклоны к полу \nс разворотом",
                                "Боковые выпады для \nразминки ног",
                                "Наклоны к стопе для задней\n поверхности бедра"

                        };

                        for (int i = 0; i < 10; i++) {
                            // Load GIF file
                            ImageView gifView = new ImageView(new Image(gifNames[i]));
                            gifView.setFitWidth(200);
                            gifView.setFitHeight(200);

                            // Create name and description labels
                            Label nameLabel = new Label("Упражнение " + (i+1));
                            nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
                            nameLabel.setAlignment(Pos.CENTER);

                            Label descLabel = new Label(descriptions[i]);
                            descLabel.setFont(Font.font("Arial", 12));
                            descLabel.setAlignment(Pos.CENTER);

                            // Add views to grid pane
                            GridPane gifPane = new GridPane();
                            gifPane.setHgap(10);
                            gifPane.setAlignment(Pos.CENTER);
                            gifPane.add(gifView, 0, 0);
                            gifPane.add(nameLabel, 0, 1);
                            gifPane.add(descLabel, 0, 2);

                            // Add grid pane to popup pane
                            popupPane.add(gifPane, i % 5, i / 5+2);
                        }

                        // Show popup
                        Scene popupScene = new Scene(popupPane, 1100, 750);
                        popupStage.setScene(popupScene);
                        popupStage.show();


                    }
                    else if (WORKOUTS[(day - 1) % 7].equals("Кардио")) {

                        Label title = new Label("Кардио тренировка, состоящая из 6 упражнений. \n");
                        title.setFont(Font.font("Arial", FontWeight.BOLD, 16));
                        title.setAlignment(Pos.CENTER);

                        Label recommendLabel = new Label("Рекомендации: \n1. Выполняйте каждое упражнение в течение 30-60 секунд. \n2. Отдыхайте 10-15 секунд между упражнениями.\n3. Рекомендуется выполнять от 1 до 3-4 кругов упражнений в зависимости\n от вашей физической подготовки и состояния. \n4. Слушайте свое тело и не перенапрягайтесь.");
                        recommendLabel.setFont(Font.font("Arial", 14));
                        recommendLabel.setAlignment(Pos.CENTER);
                        // Display cardio workout
                        Stage popupStage = new Stage();
                        popupStage.setTitle("Кардио");
                        GridPane popupPane = new GridPane();
                        popupPane.setHgap(10);
                        popupPane.setVgap(10);
                        popupPane.setAlignment(Pos.CENTER);

                        popupPane.add(title, 0, 0, 3, 1);
                        popupPane.add(recommendLabel, 0, 1, 3, 1);


                        // Create GIF views
                        String[] gifNames = {"C:\\Users\\Мадина\\IdeaProjects\\demo1\\src\\main\\resources\\cardio\\1card.gif",
                                "C:\\Users\\Мадина\\IdeaProjects\\demo1\\src\\main\\resources\\cardio\\2card.gif",
                                "C:\\Users\\Мадина\\IdeaProjects\\demo1\\src\\main\\resources\\cardio\\лыжник.gif",
                                "C:\\Users\\Мадина\\IdeaProjects\\demo1\\src\\main\\resources\\cardio\\выпады.gif",
                                "C:\\Users\\Мадина\\IdeaProjects\\demo1\\src\\main\\resources\\cardio\\выпады в планке.gif",
                                "C:\\Users\\Мадина\\IdeaProjects\\demo1\\src\\main\\resources\\cardio\\берпи.gif"};
                        String[] descriptions = {
                                "Бег на месте с \nзахлестом голени",
                                "Прыжки с разведением\n рук и ног",
                                "Лыжник",
                                "Выпады",
                                "Выпады в планке",
                                "Берпи"
                        };

                        for (int i = 0; i < 6; i++) {
                            // Load GIF file
                            ImageView gifView = new ImageView(new Image(gifNames[i]));
                            gifView.setFitWidth(200);
                            gifView.setFitHeight(200);

                            // Create name and description labels
                            Label nameLabel = new Label("Упражнение " + (i+1));
                            nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
                            nameLabel.setAlignment(Pos.CENTER);

                            Label descLabel = new Label(descriptions[i]);
                            descLabel.setFont(Font.font("Arial", 12));
                            descLabel.setAlignment(Pos.CENTER);

                            // Add views to grid pane
                            GridPane gifPane = new GridPane();
                            gifPane.setHgap(10);
                            gifPane.setAlignment(Pos.CENTER);
                            gifPane.add(gifView, 0, 0);
                            gifPane.add(nameLabel, 0, 1);
                            gifPane.add(descLabel, 0, 2);

                            // Add grid pane to popup pane
                            popupPane.add(gifPane, i % 3, i / 3+2);
                        }

                        // Show popup
                        Scene popupScene = new Scene(popupPane, 700, 700);
                        popupStage.setScene(popupScene);
                        popupStage.show();


                    }
                });

                calendarPane.add(dayPane, col, row + 2);
            }
        }

        // Add labels to scene
        GridPane mainPane = new GridPane();
        mainPane.setAlignment(Pos.CENTER);
        mainPane.add(titlePane, 0, 0);
        mainPane.add(instructionPane, 0, 1);
        mainPane.add(calendarPane, 0, 2);

        // Create scene and show stage
        Scene scene = new Scene(mainPane, CALENDAR_WIDTH, CALENDAR_HEIGHT);
        Stage stage = new Stage();
        stage.setTitle("Программа тренировок для потери массы тела");
        stage.setScene(scene);
        stage.show();

    }

}
