package Interperter;

public class Interpreter {

    Parser parser;
    public SharedMemory sharedMemory;

    public Interpreter() {
        this.sharedMemory = new SharedMemory();
        this.parser = new Parser(this.sharedMemory);
    }

    public void run(String code){
        this.parser.parse(Lexer.lexer(code));
    }
}
