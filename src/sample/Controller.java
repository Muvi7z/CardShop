package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.text.html.parser.Parser;
import java.util.Arrays;

public class Controller {
    @FXML
    private Label typeCardLabel;

    @FXML
    private Label discountLabel;

    @FXML
    private Label globalSumLabel;

    @FXML
    private Button buyBtn;

    @FXML
    private Button useCardBtn;

    @FXML
    private TextField sumBuyField;

    @FXML
    private Label resultSumLabel;

    @FXML
    private Label thxLabel;

    @FXML
    private TextField sumCreatedField;

    @FXML
    private ChoiceBox<Card.CardType> choiceCard;

    @FXML
    private Button createdBtn;

    private Card userCard=new Card();
    private int result=0;
    private boolean isUseCard=false;
    @FXML
    void initialize() {
        ObservableList<Card.CardType> cards = FXCollections.observableList(Arrays.stream(Card.CardType.values()).toList());
        choiceCard.setItems(cards);
        choiceCard.setValue(Card.CardType.STANDARD);
        createdBtn.setOnAction(actionEvent -> {
            userCard.setCardType(choiceCard.getValue());
            if(!sumCreatedField.getText().equals(""))
                userCard.setBalance( Double.parseDouble(sumCreatedField.getText()));
            UpdateCardInfo();
        });
        buyBtn.setOnAction(actionEvent -> {
            if(isUseCard){
                isUseCard=false;
                userCard.sumBalance(result);
            }
            thxLabel.setVisible(true);
            UpdateCardInfo();
        });
        useCardBtn.setOnAction(actionEvent -> {
            thxLabel.setVisible(false);
            int sum = Integer.parseInt(sumBuyField.getText());

            result = sum;
            isUseCard=true;
            if(userCard.getDiscount()>0){
                result= (int) (sum*((float)(100-userCard.getDiscount())/100));
            }
            resultSumLabel.setText(Double.toString(result)+" руб");
        });
    }
    public void UpdateCardInfo(){
        typeCardLabel.setText(userCard.getCardType().getName());
        discountLabel.setText(Integer.toString(userCard.getDiscount())+ "%");
        globalSumLabel.setText(Double.toString(userCard.getBalance()) + " руб");
    }
}
