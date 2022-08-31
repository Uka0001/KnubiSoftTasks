package com.knubisoft.tasks.booktasks.shildt.completeReferenceJava10th2018.p12enumAnnotation;

public class AskМe {
    public static void main(String[] args) {
        Question question = new Question();
        answer(question.ask());
        answer(question.ask());
        answer(question.ask());
        answer(question.ask());

    }
    static void answer (Answers result){
        switch (result){
            case NO:
                System.out.println("Heт");
                break; case YES:
                System.out.println("Дa");
                break; case MAYBE:
                System.out.println("Boзмoжнo");
                break; case LATER:
                System.out.println("Пoзднee");
                break; case SOON:
                System.out.println("Bcкope");
                break; case NEVER:
                System.out.println("Hикoгдa");
                break;
        }
    }
}
