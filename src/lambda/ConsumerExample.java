package lambda;

import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String[] args) {

        ButtonFactory<Button> factory=Button::new;
        ///:: ссылка на конструктор через нотацию
        // ClassName:: new где ClassName не может быть абстрактным классом или интерфейсом
        Button button=factory.set("grey","Cancel");
        Button button1=factory.set("red","Esc");
        Button button2=factory.set("green","F12");
        System.out.println("button = " + button);
        System.out.println("button1 = " + button1);

        Consumer<Button> makeBtn=(button5->{
                button5.setColor("blue");
        button5.setValue("Z");
        });
        makeBtn.accept(button1);///изменили кнопку
        System.out.println("makeBtn = " + makeBtn);


    }


}


interface ButtonFactory<T extends Button>
{T set(String value,String color);}



class Button
{
    private String color;
    private String  value;

    public Button(String color, String value) {
        this.color = color;
        this.value = value;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Button{" +
                "color='" + color + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}