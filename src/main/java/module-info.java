module grand_prix.suporte_monitoramento_agecare {
    requires javafx.controls;
    requires javafx.fxml;


    opens grand_prix.suporte_monitoramento_agecare to javafx.fxml;
    exports grand_prix.suporte_monitoramento_agecare;
}